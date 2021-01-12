package logic.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logic.controller.CreateTournamentController;

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
    void createTournament(MouseEvent event) {
    	CreateTournamentController controller = CreateTournamentController.getInstance();
    	controller.getBean().setTournamentName(nameTxt.getText());
    	controller.getBean().setTournamentGame(catTxt.getText());
    	//controller.getBean().setTournamentPartecipants(partTxt.getText());
    	//da completare
    }

}
