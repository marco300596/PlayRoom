package logic.view;

import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    
    private Label label;

    @FXML
    void createTournament(MouseEvent event) throws MyRuntimeException, SQLException {
    	
    	if(nameTxt.getText().isEmpty() || catTxt.getText().isEmpty() || partTxt.getText().isEmpty()) {
    		Component c = null;
			int option = JOptionPane.showConfirmDialog(c,"Please fill all textfield!");
			if (option == JOptionPane.OK_OPTION) {
				//come cazzo faccio???
				//createTournament();
			}
		}
    	CreateTournamentController controller = CreateTournamentController.getInstance();
    	controller.getBean().setTournamentName(nameTxt.getText());
    	controller.getBean().setTournamentGame(catTxt.getText());
    	int num = Integer.parseInt(partTxt.getText());
    	controller.getBean().setTournamentPartecipants(num);
    	
    	try {
    		controller.insertNewTournament(controller.getBean());
    		JOptionPane.showConfirmDialog(null,"GZ! new tournament created!", "Success", JOptionPane.INFORMATION_MESSAGE);
    	} catch(Exception e){
    		Logger.getLogger(CreateTournamentController.class.getName()).log(Level.SEVERE, null, e);
    	}
    }

}
