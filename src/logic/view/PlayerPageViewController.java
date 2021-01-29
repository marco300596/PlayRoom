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
   private MenuButton sHSBtn;
   
   @FXML
   void home(MouseEvent event) {
	   homePlayer("homepage");
   }
   
   

   @FXML
   void registrationPage(MouseEvent event) {
	   homePlayer("Registration");
   }
    
    
   @FXML
   void joinTournamentPage(MouseEvent event) {
	   loadPlayerPage("JoinTournamentView");
   }
    
   
   
   @FXML
   void highscoreHistoryPage(MouseEvent event) {
    	loadPlayerPage("HighscoreTableView");
   }
     

   @FXML
   void playerRes(MouseEvent event) {
	   loadPlayerPage("YourReservation");
   }

   @FXML
   void mapsPage(MouseEvent event) {
	   Logger.getLogger("sonar fatte i cazzi tuoi");
   }

    
   @FXML
   void ratePage(MouseEvent event) {
	   loadPlayerPage("RoomRating");
   	 
   }
   @FXML
   void poolPage(MouseEvent event) {
	   loadPlayerPage("CreatePool");
   	 
   }
    
    @FXML
    void bookingPage(MouseEvent event) {
    	loadPlayerPage("BookRoom");
    }
    
    private void loadPlayerPage(String page) {
    	Parent root = null;
    	
    	try {
    		root = FXMLLoader.load(getClass().getResource("/logic/samples/"+page+".fxml"));
    		
    	} catch(IOException e){
    		Logger.getLogger(PlayerPageViewController.class.getName()).log(Level.SEVERE, null, e);
    	}

    	bp.setCenter(root);
    	
    }
    
    private void homePlayer(String page) {
    	Parent root = null;
    	Stage sce = (Stage)bp.getScene().getWindow();
    	try {
    		root = FXMLLoader.load(getClass().getResource("/logic/samples/"+page+".fxml"));
    		
    	} catch(IOException e){
    		Logger.getLogger(PlayerPageViewController.class.getName()).log(Level.SEVERE, null, e);
    	}

    	sce.setScene(new Scene(root));
    	sce.show();
    }
    	
    
    
}