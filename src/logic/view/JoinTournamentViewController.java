package logic.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import logic.bean.RoomBean;
import logic.bean.TournamentBean;
import logic.controller.JoinTournamentController;
import logic.controller.LoginController;
import logic.controller.ModifyRoomController;
import logic.controller.RegisterRoomController;
import logic.exception.MyRuntimeException;
import logic.model.Hardware;
import logic.model.Room;
import logic.model.Tournament;
import logic.model.VideoGame;

public class JoinTournamentViewController {

	private JoinTournamentController jtournament= JoinTournamentController.getInstance();
	
	
    @FXML
    private TextField citytxt;

    @FXML
    private Button joinbtn;

    @FXML
    private TableView<TournamentBean> hTab;

    @FXML
    private TableColumn<Tournament,String> tournamentCol;

    @FXML
    private TableColumn<Room, String> roomCol;

    @FXML
    private TableColumn<VideoGame,String> gameCol;

    @FXML
    private TableColumn<Hardware,String> hardCol;
    
    RoomBean bean =new RoomBean();

    
    
    public void initialize() {
    	
    	ObservableList<TournamentBean> tournament = FXCollections.observableArrayList();
    				
    				JoinTournamentController controller = JoinTournamentController.getInstance();
    				controller.getrBean().setCity(citytxt.getText());
        			tournamentCol.setCellValueFactory(new PropertyValueFactory<>("tournamentName"));
        			roomCol.setCellValueFactory(new PropertyValueFactory<>("roomName"));
        			gameCol.setCellValueFactory(new PropertyValueFactory<>("gameName"));
        			gameCol.setCellValueFactory(new PropertyValueFactory<>("hardwareName"));
    			}
    			
    	
    		
    	}

    

		
