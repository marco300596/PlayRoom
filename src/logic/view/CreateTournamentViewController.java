package logic.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    @FXML
    void createTournament(MouseEvent event) throws MyRuntimeException, SQLException {
    	
    	CreateTournamentController controller = CreateTournamentController.getInstance();
    	controller.getBean().setTournamentName(nameTxt.getText());
    	controller.getBean().setTournamentGame(catTxt.getText());
    	int num = Integer.parseInt(partTxt.getText());
    	controller.getBean().setTournamentPartecipants(num);
    	try {
    		controller.insertNewTournament(controller.getBean());
    		JOptionPane.showMessageDialog(null,"GZ! new tournament created!", "Success", JOptionPane.INFORMATION_MESSAGE);
    		
    	} catch(Exception e){
    		Logger.getLogger(CreateTournamentController.class.getName()).log(Level.SEVERE, null, e);
    	}
    }

}
