package logic.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class OrganizerPageViewController {

    @FXML
    private BorderPane bp;

    @FXML
    void highscorePage(MouseEvent event) {
    	loadOrgPage("HighscoreTableView");
    }
    
    @FXML
    void home(MouseEvent event) {
 	   homeOrg("homepage");
    }

    @FXML
    void loginPage(MouseEvent event) {
    	homeOrg("homepage");
    }

    @FXML
    void managementPage(MouseEvent event) {
    	loadOrgPage("Management");
    }

    @FXML
    void roomPage(MouseEvent event) {
    	loadOrgPage("RegisterRoomView");
    }

    @FXML
    void tournamentPage(MouseEvent event) {
    	loadOrgPage("CreateTournamentView");
    }
    
    private void loadOrgPage(String page) {
    	Parent root = null;
   
    	try {
    		root = FXMLLoader.load(getClass().getResource(page+".fxml"));
    		
    	} catch(IOException e){
    		Logger.getLogger(OrganizerPageViewController.class.getName()).log(Level.SEVERE, null, e);
    	}
 
    	bp.setCenter(root);
    	
    }
    
    private void homeOrg(String page) {
    	Parent root = null;
    	Stage sce = (Stage)bp.getScene().getWindow();
    	try {
    		root = FXMLLoader.load(getClass().getResource(page+".fxml"));
    		
    	} catch(IOException e){
    		Logger.getLogger(OrganizerPageViewController.class.getName()).log(Level.SEVERE, null, e);
    	}
    	//bp.setTop(root.getTop());
    //	bp.setLeft(root.getLeft());
    	//bp.setCenter(root);
    //	bp.setRight(root.getRight());
    //	bp.setBottom(root.getBottom());
    	
    	sce.setScene(new Scene(root));
    	sce.show();
    }

}
