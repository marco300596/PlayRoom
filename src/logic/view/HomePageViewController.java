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

public class HomePageViewController {
	
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
    void HighscorePage(MouseEvent event) {
    	loadPage("HighscoreTableView");
    }
    
    @FXML
    void HighscoreHistoryPage(MouseEvent event) {
    	loadPage("HighscoreProgressionView");
    }
    
    @FXML
    void loginPage(MouseEvent event) {
    	loadPage("logpage");
    }
    
    @FXML
    void homePage(MouseEvent event) {
    	loadPage("homepage");
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
    void roomPage(MouseEvent event) {
    	
    	
    	 loadPage("RegisterRoomView");
    	 
    	
    }
    
    void ratePage(MouseEvent event) {
    	
    	
   	 loadPage("RoomRating");
   	 
   	
   }
    
    @FXML
    void bookingPage(MouseEvent event) {
    	loadPage("BookRoom");
    }

    @FXML
    void tournamentPage(MouseEvent event) {
    	loadPage("CreateTournamentView");
    }
    
    @FXML
    void managementPage(MouseEvent event) {
    	loadPage("Management");
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
