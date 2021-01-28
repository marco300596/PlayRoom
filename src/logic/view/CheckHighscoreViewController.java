package logic.view;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CheckHighscoreViewController {

    @FXML
    private TableView<?> hscTbl;

    @FXML
    private TableColumn<?, ?> usrNC;

    @FXML
    private TableColumn<?, ?> hScC;

    @FXML
    private Button updBtn;

    @FXML
    private Button confBtn;

    @FXML
    void confirmHighscore(MouseEvent event) {

    }

    @FXML
    void initialize(MouseEvent event) {
    	
    }
}