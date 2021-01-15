package logic.view;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import logic.controller.PollController;
import logic.exception.MyRuntimeException;

public class PollViewController {
	
	 @FXML
	  private TextArea nametxt;

	  @FXML
	  private TextArea qsttxt;

	  @FXML
	  private TextArea tntxt;

	  @FXML
	  private Button cpbtn;

	  
	  
	  
	  
	  @FXML
	  private void pollPression(ActionEvent event) throws MyRuntimeException, SQLException{
	    	
		  	if(verifyFields()) {
	    	PollController controller = PollController.getInstance();
	    	controller.getBean().setPollName(nametxt.getText());
	    	controller.getBean().setQuestion(qsttxt.getText());
	    	controller.getBean().setTournamentName(tntxt.getText());
	    	
	    	try {
	    		controller.insertnewPoll(controller.getBean());
	    		new Thread(() ->
	    		JOptionPane.showConfirmDialog(null,"GZ! new Poll created!", "Success", JOptionPane.INFORMATION_MESSAGE));
	    	} catch(Exception e){
	    		Logger.getLogger(PollController.class.getName()).log(Level.SEVERE, null, e);
	    	}
		} else {
			new Thread(() ->
			JOptionPane.showMessageDialog(null, "fill all textfield please!","Error", JOptionPane.INFORMATION_MESSAGE));
			
		}
	    	
			}
	  
	  
	  

	  
	  
	  
	  private boolean verifyFields() {
	    	return !(nametxt.getText().equals("") || qsttxt.getText().equals("") || tntxt.getText().equals(""));
	    }
	  
	  
	}


