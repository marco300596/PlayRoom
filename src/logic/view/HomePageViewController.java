package logic.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class HomePageViewController {

    @FXML
    private BorderPane bp;
    
    @FXML
    void home(MouseEvent event) {
    	loadPage("homepage");
    }

    @FXML
    void loginPage(MouseEvent event) {
    	loadPage("logpage");
    }

    @FXML
    void showOrganizerPage(MouseEvent event) {
    	loadPage("PlainEOModelPage");
    	FXMLLoader loader = new FXMLLoader();
    	loader.setController(new PlayerPageViewController());
    }

    @FXML
    void showPlayerPage(MouseEvent event) {
    	loadPage("PlainPModelPage");
    	FXMLLoader loader = new FXMLLoader();
    	loader.setController(new OrganizerPageViewController());
    }
    
    private void loadPage(String page) {
    	Parent root = null;
    	
    	try {
    		root = FXMLLoader.load(getClass().getResource(page+".fxml"));
    		
    	} catch(IOException e){
    		Logger.getLogger(HomePageViewController.class.getName()).log(Level.SEVERE, null, e);
    	}
   	
   	
    	bp.setCenter(root);
    }

}

