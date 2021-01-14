package logic.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import logic.controller.CreateTournamentController;
import logic.exception.MyRuntimeException;

public class CreateTournamentViewController {

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField partTxt;

    @FXML
    private TextField catTxt;

    @FXML
    private Button createBtn;
    
    @FXML
    private HBox hbox;
    

    @FXML
    void createTournament(MouseEvent event) throws MyRuntimeException, SQLException {
    	
    	if (verifyFields()){
			CreateTournamentController controller = CreateTournamentController.getInstance();
	    	controller.getBean().setTournamentName(nameTxt.getText());
	    	controller.getBean().setTournamentGame(catTxt.getText());
	    	int num = Integer.parseInt(partTxt.getText());
	    	controller.getBean().setTournamentPartecipants(num);
	    	
	    	try {
	    		controller.insertNewTournament(controller.getBean());
	    		new Thread(() ->
            	JOptionPane.showMessageDialog(null, "Your tournament has been created!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
	    	} catch(Exception e){
	    		Logger.getLogger(CreateTournamentController.class.getName()).log(Level.SEVERE, null, e);
	    	}
		} else {
			new Thread(() ->
        	JOptionPane.showMessageDialog(null, "Fill all textfield please!","Error", JOptionPane.INFORMATION_MESSAGE)).start();
		}	
    }
    
    private boolean verifyFields() {
    	return !(nameTxt.getText().equals("") || catTxt.getText().equals("") || partTxt.getText().equals(""));
    }

}
