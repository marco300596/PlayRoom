package logic.view;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import logic.bean.ReservationBean;
import logic.controller.CheckBookingController;
import logic.exception.MyRuntimeException;

public class CheckBookingViewController {

    @FXML
    private VBox vBox;

    @FXML
    private TableView<ReservationBean> chkTable;

    @FXML
    private TableColumn<ReservationBean, String> usCol;

    @FXML
    private TableColumn<ReservationBean, Integer> dtCol;

    @FXML
    private TableColumn<ReservationBean, Integer> hCol;

    @FXML
    private TableColumn<ReservationBean, Integer> numCol;
    
    @FXML
    private TableColumn<ReservationBean, String>  roomCol;

    @FXML
    private Button upBtn;

    @FXML
    void checkList(MouseEvent event) throws MyRuntimeException, SQLException {
    	CheckBookingController controller = CheckBookingController.getInstance();
    	ObservableList<ReservationBean> reservations = controller.updateReservation();
    	if(reservations.isEmpty())	{
    		new Thread(() ->JOptionPane.showMessageDialog(null, "No room registered! Please go to room registration page!","Error", JOptionPane.INFORMATION_MESSAGE)).start();
    		return;
    	}
    	chkTable.setItems(reservations);
    	usCol.setCellValueFactory(new PropertyValueFactory<>("username"));
    	dtCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    	hCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
    	numCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
    	roomCol.setCellValueFactory(new PropertyValueFactory<>("roomname"));
    	

    	controller.getResBean().setPlayerUsername(chkTable.getSelectionModel().getSelectedItems().get(0).getPlayerUsername());
    	//TODO aggiungi metodo per confermare la prenotazione.
    }

}

