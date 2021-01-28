package logic.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import logic.bean.HighscoreBean;
import logic.controller.LoginController;
import logic.controller.SubmitHighscoreController;
import logic.exception.MyRuntimeException;
import logic.exception.UserDoesNotExist;
import logic.model.Highscore;

public class SubmitHighscoreViewController {
		
   
	private SubmitHighscoreController controller = SubmitHighscoreController.getInstance();
    private LoginController logc = LoginController.getInstance();
  
	@FXML
    private TextField scoreTxt;

    @FXML
    private Button subBtn;

    @FXML
    private TableView<HighscoreBean> hTab;

    @FXML
    private TableColumn<Highscore, String> plNCol;

    @FXML
    private TableColumn<Highscore, Integer> highValCol;
    
    @FXML
    void initialize() throws MyRuntimeException, SQLException {
    	controller.showHighscore();
    }
    
    @FXML
    void show(MouseEvent event) throws MyRuntimeException, SQLException, UserDoesNotExist {
    
    	ObservableList<HighscoreBean> highscore = FXCollections.observableArrayList();
		controller.getHighscoreBean().setHighscore(Integer.parseInt(scoreTxt.getText()));
			
		try {
			if (logc.findPlayerIdentity()) {
				if (controller.checkTournamentAdehesion()) {
					highscore = controller.submitHighscoreAndShow();
					hTab.setItems(highscore);
					plNCol.setCellValueFactory(new PropertyValueFactory<>("username"));
					highValCol.setCellValueFactory(new PropertyValueFactory<>("highscore"));
				}else {
					new Thread(()-> JOptionPane.showMessageDialog(null, "you are not registered in this tournament!/n please register","Failed", JOptionPane.INFORMATION_MESSAGE)).start();
				}
			}
		}catch(UserDoesNotExist u) {
				new Thread(()-> JOptionPane.showMessageDialog(null, "you are no longer registrated in the sistem;/n you have been deleted!","Deleted", JOptionPane.INFORMATION_MESSAGE)).start();
				Parent root = null;
				Stage sce = (Stage)scoreTxt.getScene().getWindow();
				try {
					root = FXMLLoader.load(getClass().getResource("/logic/samples/registration.fxml"));
		   		
				} catch(IOException e){
					Logger.getLogger(HomePageViewController.class.getName()).log(Level.SEVERE, null, e);
				}
		  
				sce.setScene(new Scene(root));
				sce.show();
		}
    }
}
