package logic.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import logic.controller.PollController;
import logic.controller.RoomRatingController;
import logic.exception.MyRuntimeException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.controlsfx.control.Rating;

public class RatingRoomViewController {

    @FXML
    private TextArea nametxt;

    @FXML
    private Rating ratefield;

    @FXML
    private TextArea commenttxt;

    @FXML
    private Button subbtn;
    
    
    
    @FXML
	  private void ratingPression(ActionEvent event) throws MyRuntimeException, SQLException{
	    	
		  	if(verifyFields()) {
	    	RoomRatingController controller = RoomRatingController.getInstance();
	    	
	    	controller.getBean().setRoomName(nametxt.getText());
	    	controller.getBean().setRate(ratefield.getRating());
	    	controller.getBean().setComment(commenttxt.getText());
	    	
	    	
	    	try {
	    		controller.insertnewRating(controller.getBean());
	    		new Thread(() ->
	    		JOptionPane.showConfirmDialog(null,"GZ! new Rating created!", "Success", JOptionPane.INFORMATION_MESSAGE));
	    	} catch(Exception e){
	    		Logger.getLogger(PollController.class.getName()).log(Level.SEVERE, null, e);
	    	}
		} else {
			new Thread(() ->
			JOptionPane.showMessageDialog(null, "fill all textfield please!","Error", JOptionPane.INFORMATION_MESSAGE));
			
		}
	    	
			}
	  
	  
	  

	  
	  
	  
	  private boolean verifyFields() {
	    	return !(nametxt.getText().equals("") || commenttxt.getText().equals(""));
	    }
	  
	  
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
