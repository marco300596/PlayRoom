package logic.view;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import logic.bean.RegistrationBean;
import logic.bean.ReservationBean;
import logic.controller.CheckBookingController;
import logic.controller.ManagementController;
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
    private Button upBtn;

    @FXML
    void checkList(MouseEvent event) throws MyRuntimeException, SQLException {
    	CheckBookingController controller = CheckBookingController.getInstance();
    	ObservableList<ReservationBean> reservations = controller.updateReservation();
    	chkTable.setItems(reservations);
    	usCol.setCellValueFactory(new PropertyValueFactory<>("username"));
    	dtCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    	hCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
    	numCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
    	
    	//TODO aggiungi metodo per confermare la prenotazione.
    }

}

