package logic.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PlayerPageViewController {
	
   @FXML
   private BorderPane bp;
	
   @FXML
   private AnchorPane ap;
	
   @FXML
   private ImageView btnHome;
	
   @FXML
   private MenuButton roomBtn;

   @FXML
   private MenuButton btnTournament;

   @FXML
   private MenuButton btnContact;

   @FXML
   private MenuButton btnMaps;
    
    
   @FXML
   void highscoreHistoryPage(MouseEvent event) {
    	loadPlayerPage("HighscoreProgressionView");
   }
     

   @FXML
   void contactPage(MouseEvent event) {
    	//TODO
   }

   @FXML
   void mapsPage(MouseEvent event) {
    	//TODO
   }

    
   @FXML
   void ratePage(MouseEvent event) {
	   loadPlayerPage("RoomRating");
   	 
   }
    
    @FXML
    void bookingPage(MouseEvent event) {
    	loadPlayerPage("BookRoom");
    }
    
    private void loadPlayerPage(String page) {
    	 Parent root = null;
    	
    	try {
    		root = FXMLLoader.load(getClass().getResource(page+".fxml"));
    		
    	} catch(IOException e){
    		Logger.getLogger(PlayerPageViewController.class.getName()).log(Level.SEVERE, null, e);
    	}
    	
    	
    	bp.setCenter(root);
    }
    
   
    	
    
    
}