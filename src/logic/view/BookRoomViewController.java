package logic.view;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.bean.RoomBean;
import logic.controller.BookRoomController;
import logic.exception.MyRuntimeException;
import logic.model.Room;

public class BookRoomViewController {

    @FXML
    private Button bkBtn1;
    @FXML
    private TextField hTxt;
    @FXML
    private CheckBox gCBox;
    @FXML
    private CheckBox lCBox;
    @FXML
    private CheckBox hCBox;
    @FXML
    private ImageView locBtn;
    @FXML
    private TextField sprTxt;
    @FXML
    private TextField gameTxt;
    @FXML
    private TextField hwTxt;
    @FXML
    private TextField gsTxt;
    @FXML
    private TableView<RoomBean> frhTab;
    @FXML
    private TableColumn<Room, String> rName;
    @FXML
    private TableColumn<Room, Integer> maxGS;
    @FXML
    private TableColumn<Room, Integer> price;
    @FXML
    private TableColumn<Room, String> loc;
    @FXML
    private Button fBtn;
    @FXML
    private Button bkBtn;
    @FXML
    private Button h1;
    @FXML
    private Button h2;
    @FXML
    private Button h3;
    @FXML
    private Button h4;
    @FXML
    private Button h5;
    @FXML
    private Button h6;
    @FXML
    private Button h7;
    @FXML
    private Button h8;
    @FXML
    private DatePicker dpField;
    @FXML
    private MenuButton hSB;

    @FXML
    void settingHour(MouseEvent event){
    	if(h1.isPressed()){
    		hSB.setText(h1.getText());
    	}
    	if(h2.isPressed()){
    		hSB.setText(h2.getText());
    	}
    	if(h3.isPressed()){
    		hSB.setText(h3.getText());
    	}
    	if(h4.isPressed()){
    		hSB.setText(h4.getText());
    	}
    	if(h5.isPressed()){
    		hSB.setText(h5.getText());
    	}
    	if(h6.isPressed()){
    		hSB.setText(h6.getText());
    	}
    	if(h7.isPressed()){
    		hSB.setText(h7.getText());
    	}    	
    	if(h8.isPressed()){
    		hSB.setText(h8.getText());
    	}    	
    }
    
    @FXML
    void showRooms(MouseEvent event) throws MyRuntimeException, SQLException{
    	
    	BookRoomController controller = BookRoomController.getInstance();
    	ObservableList<RoomBean> room = FXCollections.observableArrayList();
    	if(verifyTxtFields()) {
    		LocalDate localDate = dpField.getValue();//For reference
    		Calendar cal = Calendar.getInstance();
    		cal.setLenient(false);
    		cal.setTime(localDate);
    		try{
    			cal.getTime();
    		}catch() {
    			
    		}
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
			String formattedString = localDate.format(formatter);
			controller.getReservationBean().setDate(formattedString);
			controller.getReservationBean().setNumberOfPlayer(Integer.parseInt(gsTxt.getText()));
			controller.getReservationBean().setHour(hSB.getText());
			controller.getReservationBean().setCity(sprTxt.getText());

    		if (gCBox.isSelected()) {
				controller.getGHBean().setGameName(gameTxt.getText());
	    		room = controller.findRoomForPrenoByVideoGame();
    			

			} else if (hCBox.isSelected()) {
				controller.getGHBean().setHardwareName(hwTxt.getText());
				room = controller.findRoomForPrenoByHardware();
			}
    		
			 else if (lCBox.isSelected()) {
				room = controller.findRoomForPreno();

			}
    		
    		//creare un observablelist a quanto sembra è necessario per creare una tabella
    		
    		//set item è la funzione per settare un insieme di valori all'interno di una tabella
    		frhTab.setItems(room);
    		/*script di popolazione delle celle 
    		ATTENZIONE: per popolare le celle in modo giusto vanno messe tra () gli attributi della classe a cui si riferisce la tabella*/
    		rName.setCellValueFactory(new PropertyValueFactory<>("roomName"));
    		maxGS.setCellValueFactory(new PropertyValueFactory<>("numSeat"));
    		price.setCellValueFactory(new PropertyValueFactory<>("price"));
    		loc.setCellValueFactory(new PropertyValueFactory<>("location"));
    	}
}
	
    @FXML
    void bookRoom() throws MyRuntimeException, SQLException{
    	BookRoomController controller = BookRoomController.getInstance();
    	if (controller.checkPlayerExistance()) {
    		controller.getRoomBean().setRoomName(frhTab.getSelectionModel().getSelectedItems().get(0).getRoomName());
    		controller.getRoomBean().setCity(frhTab.getSelectionModel().getSelectedItems().get(0).getLocation());
    	
    		boolean val = controller.createReservation();
    		
    		if (val) {
    			LocalDate localDate = dpField.getValue();//For reference
    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
    			String formattedString = localDate.format(formatter);
    			new Thread(()-> JOptionPane.showMessageDialog(null, "you succesfully booked the room! for: " + formattedString + " at: " + hSB.getText() + "!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
    		}else {
    			new Thread(()-> JOptionPane.showMessageDialog(null, "you didn't PRENO","Failed", JOptionPane.INFORMATION_MESSAGE)).start();
    		}
    	}else {
    		new Thread(()-> JOptionPane.showMessageDialog(null, "you are no longer registrated in the sistem;/n you have been deleted!","Deleted", JOptionPane.INFORMATION_MESSAGE)).start();
    		Parent root = null;
	    	Stage sce = (Stage)hTxt.getScene().getWindow();
	    	try {
	    		root = FXMLLoader.load(getClass().getResource("/logic/samples/registration.fxml"));
	    		
	    	} catch(IOException e){
	    		Logger.getLogger(HomePageViewController.class.getName()).log(Level.SEVERE, null, e);
	    	}
	   
	    	sce.setScene(new Scene(root));
	    	sce.show();
    	}
    }
    
   
	private boolean verifyTxtFields() {
    	if((gameTxt.getText().equals("") && hwTxt.getText().equals("")) && sprTxt.getText().equals("")) {
       		  new Thread(()-> JOptionPane.showMessageDialog(null, "Please fill at least one textfield!","Fill Text Field", JOptionPane.INFORMATION_MESSAGE)).start();
       		  return false;
		}else{
			  return true;
		}
	}
}