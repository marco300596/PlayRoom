package logic.view;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
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
import logic.controller.LoginController;
import logic.exception.MyRuntimeException;
import logic.exception.StringIsEmptyException;
import logic.exception.TimeException;
import logic.exception.UserDoesNotExist;
import logic.model.Room;

public class BookRoomViewController {

    @FXML
    private Button bkBtn1;
    @FXML
    private TextField hTxt;
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
    	try {
    		if(verifyTxtFields()) {
    		
    			LocalDate localDate = dpField.getValue();//For reference
    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    			String formattedString = localDate.format(formatter);
    			String[] parts = formattedString.split("-");
    			int year = Integer.parseInt(parts[2]);
    			int month = Integer.parseInt(parts[1])-1;
    			int day = Integer.parseInt(parts[0]);
    			Calendar cal = Calendar.getInstance();
    			cal.clear();
    			cal.setLenient(false);
    			cal.set(year, month, day, 0, 0,0);		

    			Calendar comp = Calendar.getInstance();
    			Date date = new Date();
    			comp.setTimeInMillis(date.getTime());
    			cal.getTime();

    			if(cal.getTime().after(comp.getTime())) {
    				
    				controller.getReservationBean().setDate(formattedString);
    				controller.getReservationBean().setNumberOfPlayer(Integer.parseInt(gsTxt.getText()));
    				controller.getReservationBean().setHour(hSB.getText());
    				controller.getReservationBean().setCity(sprTxt.getText());

    				if(!(gameTxt.getText().equals("") && hwTxt.getText().equals(""))) {
    					controller.getGHBean().setGameName(gameTxt.getText());
    					controller.getGHBean().setHardwareName(hwTxt.getText());
    					room = controller.findRoomForPrenoByGameandHardware();
    					
    				}else if(!gameTxt.getText().equals("") && hwTxt.getText().equals("") ) {
    					controller.getGHBean().setGameName(gameTxt.getText());
    		    		room = controller.findRoomForPrenoByVideoGame();
    				
    				}else if (!hwTxt.getText().equals("")) {
    					controller.getGHBean().setHardwareName(hwTxt.getText());
    					room = controller.findRoomForPrenoByHardware();
    				
    				}else if (!sprTxt.getText().equals("")) {
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
    	    	
    			}else {
    	    		throw new TimeException("invalid date selected");
    	    	}
    		}
    	}catch(TimeException t) {
    			
    		Logger.getLogger(BookRoomViewController.class.getName()).log(Level.SEVERE, null, t);
    		new Thread(()-> JOptionPane.showMessageDialog(null, "you are not allowed to time travel","Alert!", JOptionPane.INFORMATION_MESSAGE)).start();
    		dpField.setValue(null);
    		
    	}catch(StringIsEmptyException s) {
    		Logger.getLogger(BookRoomViewController.class.getName()).log(Level.SEVERE, null, s);
    		new Thread(()-> JOptionPane.showMessageDialog(null, "Please fill at least one textfield!","Fill Text Field", JOptionPane.INFORMATION_MESSAGE)).start();
           		
    	}
    }
    
    @FXML
    void bookRoom() throws MyRuntimeException, SQLException{
    	
    	BookRoomController controller = BookRoomController.getInstance();
    	LoginController lcontroller = LoginController.getInstance();
    	
    	try {
    		
    		if (lcontroller.findPlayerIdentity()) {
    		
    			controller.getRoomBean().setRoomName(frhTab.getSelectionModel().getSelectedItems().get(0).getRoomName());
    			controller.getRoomBean().setCity(frhTab.getSelectionModel().getSelectedItems().get(0).getLocation());
    			boolean val = controller.createReservation();
    		
    			if (val) {
    				
    				LocalDate localDate = dpField.getValue();//For reference
    				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    				String formattedString = localDate.format(formatter);
    				new Thread(()-> JOptionPane.showMessageDialog(null, "you succesfully booked the room! for: " + formattedString + " at: " + hSB.getText() + "!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
    			}else {
    				new Thread(()-> JOptionPane.showMessageDialog(null, "you didn't PRENO","Failed", JOptionPane.INFORMATION_MESSAGE)).start();
    			}
    		}
    	}catch(UserDoesNotExist u){
    			
    		new Thread(()-> JOptionPane.showMessageDialog(null, "you are no longer registrated in the system;/n you have been deleted!","Deleted", JOptionPane.INFORMATION_MESSAGE)).start();
    		reload("Registration");
    		}
    	}
    
   
	private boolean verifyTxtFields() throws StringIsEmptyException {
    	if(sprTxt.getText().equals("") && (gameTxt.getText().equals("") && hwTxt.getText().equals(""))) {
       		  if (dpField.getValue().)
    		throw new StringIsEmptyException();
		
    	}else{
			return true;
		}
	}
	
	private void reload(String loc) {
		Parent root = null;
		Stage sce = (Stage)fBtn.getScene().getWindow();
		try {
			root = FXMLLoader.load(getClass().getResource("/logic/samples/"+ loc +".fxml"));
		
		} catch(IOException e){
			Logger.getLogger(HomePageViewController.class.getName()).log(Level.SEVERE, null, e);
		}

		sce.setScene(new Scene(root));
		sce.show();
	}
}