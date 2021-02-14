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
import logic.controller.CheckReservationController;
import logic.exception.MyRuntimeException;

public class CheckReservationViewController {

    @FXML
    private VBox vBox;

    @FXML
    private TableView<ReservationBean> chkTable;

    @FXML
    private TableColumn<ReservationBean, String> usCol;

    @FXML
    private TableColumn<ReservationBean, String> dtCol;

    @FXML
    private TableColumn<ReservationBean, String> hCol;

    @FXML
    private TableColumn<ReservationBean, Integer> numCol;
    
    @FXML
    private TableColumn<ReservationBean, String>  roomCol;

    @FXML
    private Button upBtn;
    
    @FXML
    private Button okBtn;
    
    public static final String ERROR = "Error";
    public static final String NORES = "No reservation found! Please refresh the page!";
    public static final String PLAYER = "playerUsername";
    public static final String NUM = "numberOfPlayer";
    public static final String ROOM = "reservationRoom";
    public static final String DATE = "date";
    public static final String HOUR = "hour";
    

    @FXML
    void checkList(MouseEvent event) throws MyRuntimeException, SQLException {
    	CheckReservationController controller = CheckReservationController.getInstance();
    	ObservableList<ReservationBean> reservations = controller.updateReservation();
    	if(reservations.isEmpty())	{
    		new Thread(() ->JOptionPane.showMessageDialog(null, NORES,ERROR, JOptionPane.INFORMATION_MESSAGE)).start();
    		return;
    	}
    	chkTable.setItems(reservations);
    	usCol.setCellValueFactory(new PropertyValueFactory<>(PLAYER));
    	dtCol.setCellValueFactory(new PropertyValueFactory<>(DATE));
    	hCol.setCellValueFactory(new PropertyValueFactory<>(HOUR));
    	numCol.setCellValueFactory(new PropertyValueFactory<>(NUM));
    	roomCol.setCellValueFactory(new PropertyValueFactory<>(ROOM));
    }
    
    @FXML
    void confirm(MouseEvent event) throws MyRuntimeException, SQLException {
    	
    	CheckReservationController controller = CheckReservationController.getInstance();
    	
    	controller.getResBean().setPlayerUsername(chkTable.getSelectionModel().getSelectedItems().get(0).getPlayerUsername());
    	controller.getResBean().setDate(chkTable.getSelectionModel().getSelectedItems().get(0).getDate());
    	controller.getResBean().setHour(chkTable.getSelectionModel().getSelectedItems().get(0).getHour());
    	
    	if(controller.confirmReservation()) {
    		new Thread(() ->
    		JOptionPane.showMessageDialog(null, "Reservation confirmed! Please refresh the page!","Success", JOptionPane.INFORMATION_MESSAGE)).start();  
    	} else {
    		new Thread(() ->
    		JOptionPane.showMessageDialog(null, NORES ,ERROR, JOptionPane.INFORMATION_MESSAGE)).start();
    	}
    }
    
    @FXML
    void confirmedRes(MouseEvent event) throws MyRuntimeException, SQLException {
    	CheckReservationController controller = CheckReservationController.getInstance();
    	ObservableList<ReservationBean> res = controller.confirmed();
    	if(res.isEmpty())	{
    		new Thread(() ->JOptionPane.showMessageDialog(null, NORES,ERROR, JOptionPane.INFORMATION_MESSAGE)).start();
    		return;
    	}
    	chkTable.setItems(res);
    	usCol.setCellValueFactory(new PropertyValueFactory<>(PLAYER));
    	dtCol.setCellValueFactory(new PropertyValueFactory<>(DATE));
    	hCol.setCellValueFactory(new PropertyValueFactory<>(HOUR));
    	numCol.setCellValueFactory(new PropertyValueFactory<>(NUM));
    	roomCol.setCellValueFactory(new PropertyValueFactory<>(ROOM));
    }
    
    @FXML
    void confirmedResP(MouseEvent event) throws MyRuntimeException, SQLException {
    	CheckReservationController controller = CheckReservationController.getInstance();
    	ObservableList<ReservationBean> reservations = controller.playerConfirmed();
    	if(reservations.isEmpty())	{
    		new Thread(() ->JOptionPane.showMessageDialog(null, NORES,ERROR, JOptionPane.INFORMATION_MESSAGE)).start();
    		return;
    	}
    	chkTable.setItems(reservations);
    	usCol.setCellValueFactory(new PropertyValueFactory<>(PLAYER));
    	dtCol.setCellValueFactory(new PropertyValueFactory<>(DATE));
    	hCol.setCellValueFactory(new PropertyValueFactory<>(HOUR));
    	numCol.setCellValueFactory(new PropertyValueFactory<>(NUM));
    	roomCol.setCellValueFactory(new PropertyValueFactory<>(ROOM));
    }
}

