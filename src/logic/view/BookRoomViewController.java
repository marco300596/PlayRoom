package logic.view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
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
    private Button bkBtn1;
    @FXML
    private TextField hTxt;
    @FXML
    private CheckBox gCBox;
    @FXML
    private CheckBox lCBox;
    @FXML
    private CheckBox hCBox;
    @FXML
    private ImageView locBtn;
    @FXML
    private TextField sprTxt;
    @FXML
    private TextField gameTxt;
    @FXML
    private TextField hwTxt;
    @FXML
    private TextField gsTxt;
    @FXML
    private TableView<RoomBean> frhTab;
    @FXML
    private TableColumn<Room, String> rName;
    @FXML
    private TableColumn<Room, Integer> maxGS;
    @FXML
    private TableColumn<Room, Integer> price;
    @FXML
    private TableColumn<Room, String> loc;
    @FXML
    private Button fBtn;
    @FXML
    private Button bkBtn;
    @FXML
    private Button h1;
    @FXML
    private Button h2;
    @FXML
    private Button h3;
    @FXML
    private Button h4;
    @FXML
    private Button h5;
    @FXML
    private Button h6;
    @FXML
    private Button h7;
    @FXML
    private Button h8;
    @FXML
    private Button d1;
    @FXML
    private Button d2;
    @FXML
    private Button d3;
    @FXML
    private Button d4;
    @FXML
    private Button d5;
    @FXML
    private Button d6;
    @FXML
    private DatePicker dpField;
    @FXML
    private MenuButton hSB;

    @FXML
    void settingHour(MouseEvent event){
    	if(h1.isPressed()){
    		hSB.setText(h1.getText());
    	}
    	if(h2.isPressed()){
    		hSB.setText(h2.getText());
    	}
    	if(h3.isPressed()){
    		hSB.setText(h3.getText());
    	}
    	if(h4.isPressed()){
    		hSB.setText(h4.getText());
    	}
    	if(h5.isPressed()){
    		hSB.setText(h5.getText());
    	}
    	if(h6.isPressed()){
    		hSB.setText(h6.getText());
    	}
    	if(h7.isPressed()){
    		hSB.setText(h7.getText());
    	}    	
    	if(h8.isPressed()){
    		hSB.setText(h8.getText());
    	}    	
    }
    
    @FXML
    void showRooms(MouseEvent event) throws MyRuntimeException, SQLException{
    	
    	BookRoomController controller = BookRoomController.getInstance();
    	ObservableList<RoomBean> room = FXCollections.observableArrayList();
    	//if(verifyTxtFields()) {
    		//if (gCBox.isSelected()) {

    			

			//} else if (hCBox.isSelected()) {

				

			 if (lCBox.isSelected()) {
				LocalDate localDate = dpField.getValue();//For reference
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
				String formattedString = localDate.format(formatter);
				controller.getReservationBean().setDate(formattedString);
				controller.getReservationBean().setNumberOfPlayer(Integer.parseInt(gsTxt.getText()));
				controller.getReservationBean().setHour(hSB.getText());
	    		room = controller.findRoomForPreno();

			}
    		
    		//creare un observablelist a quanto sembra è necessario per creare una tabella
    		
    		//set item è la funzione per settare un insieme di valori all'interno di una tabella
    		frhTab.setItems(room);
    		/*script di popolazione delle celle 
    		ATTENZIONE: per popolare le celle in modo giusto vanno messe tra () gli attributi della classe a cui si riferisce la tabella*/
    		rName.setCellValueFactory(new PropertyValueFactory<>("roomName"));
    		maxGS.setCellValueFactory(new PropertyValueFactory<>("numSeat"));
    		price.setCellValueFactory(new PropertyValueFactory<>("price"));
    		loc.setCellValueFactory(new PropertyValueFactory<>("location"));
    	}

    //}
	
    @FXML
    void bookRoom() throws MyRuntimeException, SQLException{
    	
    	BookRoomController controller = BookRoomController.getInstance();
    	controller.getRoomBean().setRoomName(frhTab.getSelectionModel().getSelectedItems().get(0).getRoomName());
    	controller.getRoomBean().setLocation(frhTab.getSelectionModel().getSelectedItems().get(0).getLocation());
    	System.out.println(controller.getRoomBean().getRoomName());
    	System.out.println(controller.getRoomBean().getLocation());
    	
    	boolean val = controller.createReservation();
    	if (val) {
    		LocalDate localDate = dpField.getValue();//For reference
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
			String formattedString = localDate.format(formatter);
    		new Thread(()-> JOptionPane.showMessageDialog(null, "you succesfully booked the room! for: " + formattedString + " at: " + hSB.getText() + "!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
    	}else {
    		new Thread(()-> JOptionPane.showMessageDialog(null, "you didn't PRENO","Failed", JOptionPane.INFORMATION_MESSAGE)).start();
    	}
    }
    
   
    //ObservableList selectedItems = taview.getSelectionModel().getSelectedItems(); per selezionare una riga
	
	/*private boolean verifyTxtFields() {
    	if(gameTxt.getText().equals("") && hwTxt.getText().equals("") && sprTxt.getText().equals("")) {
       		  new Thread(()-> JOptionPane.showMessageDialog(null, "Please fill at least one textfield!","Fill Text Field", JOptionPane.INFORMATION_MESSAGE)).start();
       		  return false;
		}else{
			  return true;
		}
	}*/
}