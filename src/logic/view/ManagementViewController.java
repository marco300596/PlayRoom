package logic.view;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
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
    private TableColumn<RegistrationBean, String> fnameCol;
    
    @FXML
    private TableColumn<RegistrationBean, String> lnameCol;
    
    @FXML
    private VBox vBox;

    @FXML
    private Button upBtn;
    
   // private static final String GREY = "-fx-background-color: #48484a;";

    @FXML
    void updateList(MouseEvent event) throws MyRuntimeException, SQLException {
    	ManagementController controller = ManagementController.getInstance();
    	ObservableList<RegistrationBean> player = controller.updatePlayers();
    	usTable.setItems(player);
    	nameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
    	emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
    	fnameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
    	lnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
    	
    	/*nameCol.setStyle(GREY);	 	per adesso lo tolgo perche' non si vede una minchia
    	 *emailCol.setStyle(GREY);
    	 *
    	 * potremmo usare il pattern decorator per aggiungere questa 
    	 * funzionalita', visto che viene aggiunta dinamicamente?
    	 */
    	
    	TextField nameInput = new TextField();
    	nameInput.setPromptText("username");
    	Button blockBtn = new Button("Block");
    	Button delBtn = new Button("Delete");
    	
    	HBox hBox = new HBox();
    	hBox.setPadding(new Insets(10,10,10,50));
    	hBox.setSpacing(10);
    	hBox.getChildren().addAll(nameInput,delBtn,blockBtn);
    	vBox.getChildren().add(hBox);
    	/* come faccio ad aggiungere il block e il delete se non posso aggiungere tasti nella cella?*/
    	
    	delBtn.setOnAction(e -> {
    		controller.getRegBean().setFirstname(nameInput.getText());
			try {
				//TODO
				controller.delPlayer(controller.getRegBean());
			} catch (MyRuntimeException | SQLException e1) {
				e1.printStackTrace();
			}
		});
    }

}

