package logic.view;

import java.awt.Button;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

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
    void loginPage(MouseEvent event) {
    	loadMainPage("logpage");
    }
    @FXML
    void showOrganizerPage() {
    	loadMainPage("PlainEOModelPage");
    	FXMLLoader loader = new FXMLLoader();
    	loader.setController(new OrganizerPageViewController());
    }
    @FXML
    void showPlayerPage() {
    	loadMainPage("PlainPModelPage");
    	FXMLLoader loader = new FXMLLoader();
    	loader.setController(new PlayerPageViewController());
    }
    
    @FXML
    void pression(MouseEvent event) {
    	if(cbp.isSelected()) {
    		showPlayerPage();
    	} else if(cbeo.isSelected()){
    		showOrganizerPage();
    	}
    }
    
    
    private void loadMainPage(String page) {
    	BorderPane root = null;
    	
    	try {
    		root = FXMLLoader.load(getClass().getResource(page+".fxml"));
    		
    	} catch(IOException e){
    		Logger.getLogger(HomePageViewController.class.getName()).log(Level.SEVERE, null, e);
    	}

    	bp.setTop(root.getTop());
    	bp.setLeft(root.getLeft());
    	bp.setCenter(root.getCenter());
    	bp.setRight(root.getRight());
    	bp.setBottom(root.getBottom());
    	
    }
/*
	private void activateButton() {
		if (cbp.isSelected()==true || cbeo.isSelected()==true){
			log.setEnabled(true);
		}
		if(log.handleEvent(MouseEvent event)==true && cbeo.isSelected()==true) {
			showOrganizerPage();
		}
		if(log.getMouseListeners() && cbp.isSelected()==true) {
			showPlayerPage();
		}*/
}