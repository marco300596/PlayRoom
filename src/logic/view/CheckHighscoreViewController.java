package logic.view;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import logic.bean.HighscoreBean;
import logic.controller.CheckHighscoreController;
import logic.exception.MyRuntimeException;

public class CheckHighscoreViewController {

	CheckHighscoreController controller = CheckHighscoreController.getInstance();
	
    @FXML
    private TableView<HighscoreBean> hscTbl;

    @FXML
    private TableColumn<HighscoreBean, String> usrNC;

    @FXML
    private TableColumn<HighscoreBean, Integer> hScC;

    @FXML
    private Button updBtn;

    @FXML
    private Button confBtn;
    

    @FXML
    private TextField tournTxt;

    @FXML
    void confirmHighscore(MouseEvent event) throws MyRuntimeException, SQLException {
    	
    	controller.getHighscoreBean().setPlayerUN(hscTbl.getSelectionModel().getSelectedItems().get(0).getPlayerUN());
    	controller.getHighscoreBean().setTournament(hscTbl.getSelectionModel().getSelectedItems().get(0).getTournament());
    	boolean val = controller.confirmHighscore();
    		
    	if (val) {
    		new Thread(()-> JOptionPane.showMessageDialog(null, "Highscore Confirmed!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
    	}else {
    		new Thread(()-> JOptionPane.showMessageDialog(null, "Highscore non-acceptable!","Failed", JOptionPane.INFORMATION_MESSAGE)).start();
    	}
    }

    @FXML
    void initialize(MouseEvent event) throws MyRuntimeException, SQLException {
    	
    	ObservableList<HighscoreBean> highscore = FXCollections.observableArrayList();
    	controller.getHighscoreBean().setTournament(tournTxt.getText());
    	highscore = controller.findPendingHighscoreForTournament();
    	hscTbl.setItems(highscore);
		usrNC.setCellValueFactory(new PropertyValueFactory<>("playerUN"));
		hScC.setCellValueFactory(new PropertyValueFactory<>("highscore"));
		
    }
}