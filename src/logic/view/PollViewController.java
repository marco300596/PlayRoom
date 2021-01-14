package logic.view;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import logic.controller.PollController;
import logic.controller.RegisterRoomController;
import logic.exception.MyRuntimeException;
import logic.exception.UserDoesNotExist;

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
	  private void PollPression(ActionEvent event) throws MyRuntimeException, SQLException, UserDoesNotExist{
	    	
	    	PollController controller = PollController.getInstance();
	    	controller.getBean().setPollName(nametxt.getText());
	    	controller.getBean().setQuestion(qsttxt.getText());
	    	controller.getBean().setTournamentName(tntxt.getText());
	    	if (nametxt.getText().isEmpty()||qsttxt.getText().isEmpty()||tntxt.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "you have to fill the text fields!", "alert", JOptionPane.ERROR_MESSAGE);
			
			
	    	}
			}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	}


