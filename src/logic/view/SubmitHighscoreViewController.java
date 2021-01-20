package logic.view;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.bean.HighscoreBean;
import logic.bean.RoomBean;
import logic.controller.BookRoomController;
import logic.controller.LoginController;
import logic.controller.SubmitHighscoreController;
import logic.model.Highscore;
import logic.model.Player;

public class SubmitHighscoreViewController {

    private LoginController logc = LoginController.getInstance();
	private SubmitHighscoreController controller = SubmitHighscoreController.getInstance();
  
	@FXML
    private TextField scoreTxt;

    @FXML
    private TextField tourTxt;

    @FXML
    private Button subBtn;

    @FXML
    private TableView<HighscoreBean> hTab;

    @FXML
    private TableColumn<Player, String> posCol;

    @FXML
    private TableColumn<Highscore, String> plNCol;

    @FXML
    private TableColumn<Highscore, Integer> highValCol;
    
    public void initialize() {
    
	ObservableList<HighscoreBean> highscore = FXCollections.observableArrayList();
			controller.getHighscoreBean().setHighscore(scoreTxt.getText());
			controller.getHighscoreBean().setPlayerUN(logc.getBean().getUsername());
			controller.getHighscoreBean().setTournament(tourTxt.getText());
			if (controller.checkTournamentAdehesion()) {
    			highscore = controller.submitHighscoreAndShow();
    			hTab.setItems(highscore);
    			posCol.setCellValueFactory(new PropertyValueFactory<>(""));
    			plNCol.setCellValueFactory(new PropertyValueFactory<>("username"));
    			highValCol.setCellValueFactory(new PropertyValueFactory<>("highscore"));
			}else {
				new Thread(()-> JOptionPane.showMessageDialog(null, "you are not registered in this tournament!\n please register","Failed", JOptionPane.INFORMATION_MESSAGE)).start();
			}
		
		
	}


    
    
}