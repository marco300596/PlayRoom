package logic.view;

import java.sql.SQLException;

import javax.swing.JOptionPane;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import logic.bean.TournamentBean;
import logic.controller.JoinTournamentController;
import logic.exception.MyRuntimeException;
import logic.model.Hardware;
import logic.model.Room;
import logic.model.Tournament;
import logic.model.VideoGame;

public class JoinTournamentViewController {
	
    @FXML
    private TextField citytxt;

    @FXML
    private Button joinbtn;
    
    @FXML
    private Button srcbtn;

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
    
    

    
    @FXML
    void initialize(MouseEvent event) throws MyRuntimeException, SQLException {
    	
    	
    	JoinTournamentController controller = JoinTournamentController.getInstance();
    	controller.getrBean().setCity(citytxt.getText());
    	ObservableList<TournamentBean> tournament = controller.searchTournament(controller.getrBean());
    	if(tournament.isEmpty())	{
    		new Thread(() ->JOptionPane.showMessageDialog(null, "No tournaments for the city selected! Please go to Create Tournament page!","Error", JOptionPane.INFORMATION_MESSAGE)).start();
    		return;
    	}
    	
    	hTab.setItems(tournament);
        tournamentCol.setCellValueFactory(new PropertyValueFactory<>("tournamentName"));
        roomCol.setCellValueFactory(new PropertyValueFactory<>("tournamentRoom"));
        gameCol.setCellValueFactory(new PropertyValueFactory<>("tournamentGame"));
        hardCol.setCellValueFactory(new PropertyValueFactory<>("tournamentHardware"));
   	}
    
    
    
    @FXML
    void joinTournament(MouseEvent event) throws MyRuntimeException, SQLException {
  

    	JoinTournamentController controller = JoinTournamentController.getInstance(); 
    	
    	if (hTab.getSelectionModel().getSelectedItem() != null) {
    		
    		TournamentBean tname = hTab.getSelectionModel().getSelectedItem();    
    		controller.joinTournament(tname.getTournamentName());
    		
    	
   	}
    
    	else {
    		new Thread(() ->JOptionPane.showMessageDialog(null, "No tournaments  selected! Please select a tournament","Error", JOptionPane.INFORMATION_MESSAGE)).start();
    		return;
    		
    	}
    }
}

    			
    	
    		
    	

    

		
