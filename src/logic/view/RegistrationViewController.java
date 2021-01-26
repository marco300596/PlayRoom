package logic.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.controller.CreateTournamentController;
import logic.controller.LoginController;
import logic.controller.RegistrationController;

public class RegistrationViewController {

    @FXML
    private BorderPane bp;

    @FXML
    private CheckBox cbeo;

    @FXML
    private CheckBox cbp;

    @FXML
    private TextField fnameTxt;

    @FXML
    private TextField lnameTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField usTxt;

    @FXML
    private TextField pwdTxt;

    @FXML
    private TextField cpwdTxt;

    @FXML
    private Button log;
    
    private static final String ERROR = "Error";

    @FXML
    void home(MouseEvent event) {
    	loadRegPage("homepage");
    }
    
    @FXML
    void registrationPage(MouseEvent event) {
    	loadRegPage("Registration");
    }

    @FXML
    void regPression(MouseEvent event) {
    	
    	if (verifyRegFields() && verifyPassword()){
			
			if (cbp.isSelected() && cbeo.isSelected()){
				new Thread(()->JOptionPane.showMessageDialog(null, "you cannot select both user type simultaneously", "alert", JOptionPane.ERROR_MESSAGE)).start();
				return;
			}
			if(cbp.isSelected()) {
				player();
			}
			if(cbeo.isSelected()) {
				organizer();			
			}	
		}	
    }
    
    private void loadRegPage(String page) {
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
    
    private boolean verifyRegFields() {
    	if(fnameTxt.getText().equals("") || lnameTxt.getText().equals("") || emailTxt.getText().equals("")
    			|| usTxt.getText().equals("") || pwdTxt.getText().equals("") || cpwdTxt.getText().equals("")) {
    		new Thread(() ->
        	JOptionPane.showMessageDialog(null, "Fill all textfield please!",ERROR, JOptionPane.INFORMATION_MESSAGE)).start();
    		verifyPassword();
    		return false;
    	}
    	return true;
   	}
    
    private boolean verifyPassword() {
    	if (pwdTxt.getText().equals(cpwdTxt.getText())) {
    		return true;
    	}
    	new Thread(() ->
    	JOptionPane.showMessageDialog(null, "Password does not match!","Error", JOptionPane.INFORMATION_MESSAGE)).start();
		return false;
    }
    
    private void player() {
    	RegistrationController controller = RegistrationController.getInstance();
    	controller.getBean().setFirstname(fnameTxt.getText());
		controller.getBean().setLastname(lnameTxt.getText());
		controller.getBean().setUsername(usTxt.getText());
		controller.getBean().setPassword(pwdTxt.getText());
		controller.getBean().setEmail(emailTxt.getText());
		try {
			if(LoginController.getInstance().findPlayerIdentity()) {
				new Thread(() ->
            	JOptionPane.showMessageDialog(null, "This username already exist! Please choose another one",ERROR, JOptionPane.INFORMATION_MESSAGE)).start();
			}else {
				controller.insertNewPlayer(controller.getBean());
	    		new Thread(() ->
            	JOptionPane.showMessageDialog(null, "Registration complete! go to login page!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
	    	} 
	    }catch(Exception e){
	    	Logger.getLogger(RegistrationViewController.class.getName()).log(Level.SEVERE, null, e);
		}
    }
    
    private void organizer() {
    	RegistrationController controller = RegistrationController.getInstance();
    	controller.getBean().setOrgFirstname(fnameTxt.getText());
		controller.getBean().setOrgLastname(lnameTxt.getText());
		controller.getBean().setOrgUsername(usTxt.getText());
		controller.getBean().setOrgPassword(pwdTxt.getText());
		controller.getBean().setOrgEmail(emailTxt.getText());
		try {
			if(LoginController.getInstance().findOrgIdentity()) {
				new Thread(() ->
            	JOptionPane.showMessageDialog(null, "This username already exist! Please choose another one",ERROR, JOptionPane.INFORMATION_MESSAGE)).start();
			}else {
				controller.insertNewOrganizer(controller.getBean());
	    		new Thread(() ->
            	JOptionPane.showMessageDialog(null, "Registration complete! go to login page!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
	    	} 
	    }catch(Exception e){
	    	Logger.getLogger(RegistrationViewController.class.getName()).log(Level.SEVERE, null, e);
		}
    }
}

