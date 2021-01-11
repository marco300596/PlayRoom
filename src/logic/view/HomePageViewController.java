package logic.view;

import java.awt.Button;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomePageViewController {

    @FXML
    private BorderPane bp;
    
    @FXML
    private CheckBox cbp;
    
    @FXML
    private CheckBox cbeo;
    
    @FXML
    private Button btn;
    
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
    void pression(MouseEvent event){
    	 if (cbp.isSelected() && cbeo.isSelected()){
     		JOptionPane.showMessageDialog(null, "you cannot select both user type simultaneously", "alert", JOptionPane.ERROR_MESSAGE);
     	}else if(cbp.isSelected()){
    		showPlayerPage();
    	} else if(cbeo.isSelected()){
    		showOrganizerPage();
    	}
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
}