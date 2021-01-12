package logic.view;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.controller.LoginController;
import logic.exception.MyRuntimeException;
import logic.exception.UserDoesNotExist;
public class RegisterRoomViewController {
	
	
	@FXML
	private AnchorPane ap;
	
	@FXML
    private TextArea Nametxt;

    @FXML
    private TextArea Gametxt;

    @FXML
    private TextArea Hardwaretxt;

    @FXML
    private TextArea desctxt;

    @FXML
    private Button regroombtn;

    @FXML
    private ImageView phfield;

    @FXML
    private Button phbtn;
    
    
 /*   
    @FXML
    void loginPression(ActionEvent event) throws MyRuntimeException, SQLException, UserDoesNotExist{
    	
    	LoginController controller = LoginController.getInstance();
    	controller.getBean().setUsername(usTxt.getText());
    	controller.getBean().setPassword(pwdTxt.getText());
    	
    	if (cbp.isSelected() && cbeo.isSelected()){
			JOptionPane.showMessageDialog(null, "you cannot select both user type simultaneously", "alert", JOptionPane.ERROR_MESSAGE);
		}
    	if(cbp.isSelected() && controller.findPlayerIdentity()) {
			showPlayerPage();
		}
    	if (cbeo.isSelected() && controller.findOrgIdentity()) {
			showOrganizerPage();
		}
    
   */ 
    
    
    
    
    
    
    }

   


