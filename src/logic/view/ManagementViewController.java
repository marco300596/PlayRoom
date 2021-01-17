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
import logic.controller.ManagementController;
import logic.exception.MyRuntimeException;



public class ManagementViewController {

    @FXML
    private TableView<RegistrationBean> usTable;

    @FXML
    private TableColumn<RegistrationBean, String> nameCol;

    @FXML
    private TableColumn<RegistrationBean, String> emailCol;

    @FXML
    private TableColumn<?, ?> blockCol;

    @FXML
    private TableColumn<?, ?> delCol;
    
    @FXML
    private VBox vBox;

    @FXML
    private Button upBtn;
    
    private static final String GREY = "-fx-background-color: #262628;";

    @FXML
    void updateList(MouseEvent event) throws MyRuntimeException, SQLException {
    	ManagementController controller = ManagementController.getInstance();
    	ObservableList<RegistrationBean> player = controller.updatePlayers();
    	usTable.setItems(player);
    	nameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
    	emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
    	nameCol.setStyle(GREY);	 
    	emailCol.setStyle(GREY);
    	blockCol.setStyle(GREY);
    	delCol.setStyle(GREY);
    	/* come faccio ad aggiungere il block e il delete se non posso aggiungere tasti nella cella?*/
    }

}

