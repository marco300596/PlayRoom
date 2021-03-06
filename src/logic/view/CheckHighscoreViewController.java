
package logic.view;
import java.sql.SQLException;
import javax.swing.JOptionPane;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableColumn<HighscoreBean, String> hScTC;

    @FXML
    private Button upBtn;
    
    @FXML
    private Button confBtn;


    @FXML
    void confirmHighscore(MouseEvent event) throws MyRuntimeException, SQLException {
    	
    	controller.getHighscoreBean().setPlayerUN(hscTbl.getSelectionModel().getSelectedItems().get(0).getPlayerUN());
    	controller.getHighscoreBean().setHighscore(hscTbl.getSelectionModel().getSelectedItems().get(0).getHighscore());
    	controller.getHighscoreBean().setTournament(hscTbl.getSelectionModel().getSelectedItems().get(0).getTournament());
    	
    	if(controller.confirmHighscore()) {
    		new Thread(()-> JOptionPane.showMessageDialog(null, "Highscore Confirmed!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
    	} else {
    		new Thread(()-> JOptionPane.showMessageDialog(null, "Highscore non-acceptable!","Failed", JOptionPane.INFORMATION_MESSAGE)).start();
    	} 		
    }

    @FXML
    void update() throws MyRuntimeException, SQLException {
    	
    	ObservableList<HighscoreBean> highscore;
    	highscore = controller.findPendingHighscoreForTournament();
    	hscTbl.setItems(highscore);
		usrNC.setCellValueFactory(new PropertyValueFactory<>("playerUN"));
		hScC.setCellValueFactory(new PropertyValueFactory<>("highscore"));
		hScTC.setCellValueFactory(new PropertyValueFactory<>("tournament"));
		
    }
}