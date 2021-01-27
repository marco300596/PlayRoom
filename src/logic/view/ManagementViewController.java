package logic.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

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
import logic.exception.StringIsEmptyException;
import logic.exception.UserDoesNotExist;



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
    
    private TextField nameInput;
    private Button blockBtn;
    private Button delBtn;
    private HBox hBox;
    private int click = 0;
    
    @FXML
    void updateList(MouseEvent event) throws MyRuntimeException, SQLException {
    	ManagementController controller = ManagementController.getInstance();
    	ObservableList<RegistrationBean> player = controller.updatePlayers();
    	usTable.setItems(player);
    	nameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
    	emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
    	fnameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
    	lnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
    	
    
    	if(nameInput == null)	nameInput 	= new TextField();
    	if(blockBtn == null) 	blockBtn 	= new Button("Block");
    	if(delBtn == null)		delBtn 		= new Button("Delete");
    	if(hBox == null) 		hBox 		= new HBox();
    		
    	
   		nameInput.setPromptText("username");
   		while(click<1) {
   			hBox.setPadding(new Insets(10,10,10,50));
   	   		hBox.setSpacing(10);
   	   		hBox.getChildren().addAll(nameInput,delBtn,blockBtn);
   	       	vBox.getChildren().add(hBox);
   	       	click++;
   		}
    	
    	delBtn.setOnAction(e -> {
    		try {
    			if(nameInput.getText().equals("")) {
    				controller.getRegBean().setUsername(nameInput.getText());
    				if(controller.delPlayer(controller.getRegBean())) {
    					new Thread(() ->
    					JOptionPane.showMessageDialog(null, "Deleted user. Please refresh the page!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
    				} else {
    					throw new UserDoesNotExist();
    				}
    			}else {
    				throw new StringIsEmptyException();
    			}
    		}  catch (MyRuntimeException | SQLException | UserDoesNotExist | StringIsEmptyException e1) {
				Logger.getLogger(ManagementViewController.class.getName()).log(Level.SEVERE, null, e);
			}
    		
		});
    }
}

