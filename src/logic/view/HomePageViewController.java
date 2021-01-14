package logic.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.controller.LoginController;
import logic.exception.MyRuntimeException;
import logic.exception.UserDoesNotExist;

public class HomePageViewController {

    @FXML
    private BorderPane bp;
    
    @FXML
    private CheckBox cbp;
    
    @FXML
    private CheckBox cbeo;
    
    @FXML
    private TextField usTxt;

    @FXML
    private TextField pwdTxt;

    @FXML
    private Button logBtn;
    
    @FXML
    private Label msg;
    
    @FXML
    void home(MouseEvent event) {
    	loadMainPage("homepage");
    }
    
    @FXML
    void registrationPage(MouseEvent event) {
    	loadMainPage("Registration");
    }
    
    @FXML
    void showOrganizerPage() {
    	loadMainPage("PlainEOModelPage");
    }
    @FXML
    void showPlayerPage() {
    	loadMainPage("PlainPModelPage");
    }
    
    @FXML
    void loginPression(ActionEvent event) throws MyRuntimeException, SQLException, UserDoesNotExist{
    	
    	LoginController controller = LoginController.getInstance();
    	if(verifyLogFields()) {
        	controller.getBean().setUsername(usTxt.getText());
        	controller.getBean().setPassword(pwdTxt.getText());
    	}
    	if (cbp.isSelected() && cbeo.isSelected()){
			JOptionPane.showMessageDialog(null, "you cannot select both user type simultaneously", "alert", JOptionPane.ERROR_MESSAGE);
		}
    	if(cbp.isSelected() && controller.findPlayerIdentity()) {
			showPlayerPage();
		}
    	if (cbeo.isSelected() && controller.findOrgIdentity()) {
			showOrganizerPage();
		}
    	
    	/*inserire eccezione campi vuoti*/
    	
 
    }
    
    private void loadMainPage(String page) {
    	Parent root = null;
    	Stage sce = (Stage)bp.getScene().getWindow();
    	try {
    		root = FXMLLoader.load(getClass().getResource("/logic/samples/"+page+".fxml"));
    		
    	} catch(IOException e){
    		Logger.getLogger(HomePageViewController.class.getName()).log(Level.SEVERE, null, e);
    	}
   
    	sce.setScene(new Scene(root));
    	sce.show();
    }
    
	private boolean verifyLogFields() {
    	if(usTxt.getText().equals("") || pwdTxt.getText().equals("")) {
    		JOptionPane.showMessageDialog(null, "Please fill all textfield!","Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}else {
			return true;
		}    	
    }
		
}