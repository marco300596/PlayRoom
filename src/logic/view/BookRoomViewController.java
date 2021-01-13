package logic.view;

import java.sql.SQLException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.bean.RoomBean;
import logic.controller.BookRoomController;
import logic.exception.MyRuntimeException;
import logic.model.Room;

//non lo so altre due classi no?????

public class BookRoomViewController {

    @FXML
    private TextField gameTxt;

    @FXML
    private TextField hwTxt;

    @FXML
    private ImageView locBtn;

    @FXML
    private TextField sprTxt;

    @FXML
    private Button actBtn;

    @FXML
    private TableView<RoomBean> frhTab;

    @FXML
    private TableColumn<Room, String> rName;
    
    @FXML
    private TableColumn<Room, Integer> maxGS;

    @FXML
    private TableColumn<Room, Integer> price;

    @FXML
    private TableColumn<Room, String> location;

    @FXML
    private Button bkBtn;

    @FXML
    void showRooms(MouseEvent event) throws MyRuntimeException, SQLException{
    	
    	BookRoomController controller = BookRoomController.getInstance();
    	controller.getRoomBean().setRoomName(sprTxt.getText());
    	RoomBean rb = controller.findRoomForPreno();
    	//creare un observablelist a quanto sembra è necessario per creare una tabella
    	ObservableList<RoomBean> room = FXCollections.observableArrayList(rb);
    	//set item è la funzione per settare un insieme di valori all'interno di una tabella
    	frhTab.setItems(room);
    	/*script di popolazione delle celle 
    	 ATTENZIONE: per popolare le celle in modo giusto vanno messe tra () gli attributi della classe a cui si riferisce la tabella*/
    	rName.setCellValueFactory(new PropertyValueFactory<Room, String>("roomName"));
    	maxGS.setCellValueFactory(new PropertyValueFactory<Room, Integer>("numSeat"));
		price.setCellValueFactory(new PropertyValueFactory<Room, Integer>("price"));
		location.setCellValueFactory(new PropertyValueFactory<Room, String>("location"));
    }
	
    //ObservableList selectedItems = taview.getSelectionModel().getSelectedItems(); per selezionare una riga
	
}