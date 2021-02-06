package logic.view;

import java.io.FileInputStream;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.bean.RoomBean;
import logic.bean.GameHardwareBean;
import logic.controller.BookRoomController;
import logic.controller.LoginController;
import logic.exception.MyRuntimeException;
import logic.exception.StringIsEmptyException;
import logic.exception.TimeException;
import logic.exception.UserDoesNotExist;
import logic.exception.WrongInputException;
import logic.model.Room;
import logic.model.VideoGame;
import logic.model.Hardware;

public class BookRoomViewController {

	Stage primaryStage = new Stage();
	//pagina2
	@FXML
	private TableView<GameHardwareBean> vgTab;
	@FXML
	private TableColumn<VideoGame, String> vgNCol;
	@FXML
	private TableColumn<VideoGame, Integer> vgNumCol;
	@FXML
	private TableColumn<VideoGame, String> vgGenCol;
	@FXML
	private TableView<GameHardwareBean> hwTab;
	@FXML
	private TableColumn<Hardware, String> hwNCol;
	@FXML
	private TableColumn<Hardware, Integer> hwNumCol;
	@FXML
	private TableColumn<Hardware, String> hwGenCol;
	@FXML
	private ImageView rPh;
	@FXML
	private Button confBtn;
	@FXML
	private Button decBtn;
	//pagina 1
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
    void showRooms(MouseEvent event) throws MyRuntimeException, SQLException, WrongInputException{
    	String comment="Fill all textfield please";
    	BookRoomController controller = BookRoomController.getInstance();
    	ObservableList<RoomBean> room = FXCollections.observableArrayList();
    	try {
    			verifyTxtFields();
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
    				controller.getReservationBean().setNumberOfPlayer(Integer.parseInt(gsTxt.getText().toLowerCase()));
    				if(!hSB.getText().equals("HH:")) {
    					controller.getReservationBean().setHour(hSB.getText().toLowerCase());
    				}else {
    					throw new WrongInputException("No Hour Selected");
    				}
    				controller.getReservationBean().setCity(sprTxt.getText().toLowerCase());

    				//PORCA EVA
    				if(!gameTxt.getText().isEmpty() && !hwTxt.getText().isEmpty()) {
    					controller.getGHBean().setGameName(gameTxt.getText().toLowerCase());
    					controller.getGHBean().setHardwareName(hwTxt.getText().toLowerCase());
    					room = controller.findRoomForPrenoByGameandHardware();
    					
    				}else if(!gameTxt.getText().isEmpty()) {
    					controller.getGHBean().setGameName(gameTxt.getText().toLowerCase());
    		    		room = controller.findRoomForPrenoByVideoGame();
    				
    				}else if (!hwTxt.getText().isEmpty()) {
    					controller.getGHBean().setHardwareName(hwTxt.getText().toLowerCase());
    					room = controller.findRoomForPrenoByHardware();
    				
    				}else if (!sprTxt.getText().isEmpty()) {
    					room = controller.findRoomForPreno();
    					
    				}
    				if(room.isEmpty()) {
    					new Thread(()-> JOptionPane.showMessageDialog(null, "seems like your criteria didn't provide any room available, try to change this criteria or check your spelling","information!", JOptionPane.INFORMATION_MESSAGE)).start();
    		    		dpField.setValue(null);
    		    		gsTxt.setText(null);
    		    		sprTxt.setText(null);
    		    		hSB.setText("HH:");
    		    		gameTxt.setText(null);
    		    		hwTxt.setText(null);
    		    		
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
    	}catch(TimeException t) {
    		Logger.getLogger(BookRoomViewController.class.getName()).log(Level.SEVERE, null, t);
    		new Thread(()-> JOptionPane.showMessageDialog(null, "you inserted an invalid date","Alert!", JOptionPane.INFORMATION_MESSAGE)).start();
    		dpField.setValue(null);
    		
    	}catch(StringIsEmptyException s) {
    		Logger.getLogger(BookRoomViewController.class.getName()).log(Level.SEVERE, null, s);
    		new Thread(()-> JOptionPane.showMessageDialog(null, "Please fill at least one textfield!",comment, JOptionPane.INFORMATION_MESSAGE)).start();
           		
    	}catch(NumberFormatException n) {
    		Logger.getLogger(BookRoomViewController.class.getName()).log(Level.SEVERE, null, n);
    		new Thread(()-> JOptionPane.showMessageDialog(null, "Seems like you tried to insert some invad data! Please fill the format in the correct way","Fill Text Field", JOptionPane.INFORMATION_MESSAGE)).start();
           	gsTxt.setText(null);
           	
    	}catch(WrongInputException w) {
    		Logger.getLogger(BookRoomViewController.class.getName()).log(Level.SEVERE, null, w);
    		new Thread(()-> JOptionPane.showMessageDialog(null, "Seems like you tried to insert some invad data! Please fill the format in the correct way","Fill Text Field", JOptionPane.INFORMATION_MESSAGE)).start();
    	
    	}
    }
    
    @FXML
    void showRoom() throws MyRuntimeException, SQLException{
    	
    	vgTab = new TableView<>();
    	hwTab = new TableView<>();
    	vgNCol = new TableColumn<>();
    	vgNumCol = new TableColumn<>();
    	vgGenCol = new TableColumn<>();
    	hwNCol = new TableColumn<>();
    	hwNumCol = new TableColumn<>();
    	hwGenCol = new TableColumn<>();
    	rPh = new ImageView();
    	confBtn = new Button();
    	decBtn = new Button();
    	
    	BookRoomController controller = BookRoomController.getInstance();
    	LoginController lcontroller = LoginController.getInstance();
    	ObservableList<GameHardwareBean> hw = FXCollections.observableArrayList();
    	ObservableList<GameHardwareBean> vg = FXCollections.observableArrayList();
    	
    	try {
    		
    		if (lcontroller.checkPlayer(lcontroller.getBean().getUsername())) {
    		
    			controller.getRoomBean().setRoomName(frhTab.getSelectionModel().getSelectedItems().get(0).getRoomName());
    			controller.getRoomBean().setLocation(frhTab.getSelectionModel().getSelectedItems().get(0).getLocation().toLowerCase());
    	    	Parent root = FXMLLoader.load(getClass().getResource("/logic/samples/BookRoomPage.fxml"));
    	    	primaryStage.setScene(new Scene(root));
    	    	primaryStage.setResizable(false);
    	        primaryStage.show();
    	        
    	        hw = controller.populateHardware();
    	        vg = controller.populateGame();
    	        if(vg.isEmpty()) {
    	        	new Thread(()-> JOptionPane.showMessageDialog(null, "this room didn't provide any game from the research: be careful!","ATTENTION!", JOptionPane.INFORMATION_MESSAGE)).start();
        	        
    	        }
	        	vgTab.setItems(vg);
    			/*script di popolazione delle celle 
    			ATTENZIONE: per popolare le celle in modo giusto vanno messe tra () gli attributi della classe a cui si riferisce la tabella*/
	        	vgNCol.setCellValueFactory(new PropertyValueFactory<>("gameName"));
	        	vgNumCol.setCellValueFactory(new PropertyValueFactory<>("gameQuantity"));
	        	vgGenCol.setCellValueFactory(new PropertyValueFactory<>("gameGenre"));
	        
    	        if(hw.isEmpty()) {
    	        	new Thread(()-> JOptionPane.showMessageDialog(null, "this room didn't provide any hardware from the research: be careful!","ATTENTION!", JOptionPane.INFORMATION_MESSAGE)).start();

    	        }
    	        hwTab.setItems(hw);    	
    	        /*script di popolazione delle celle 
	    		ATTENZIONE: per popolare le celle in modo giusto vanno messe tra () gli attributi della classe a cui si riferisce la tabella*/
    	        hwNCol.setCellValueFactory(new PropertyValueFactory<>("hardwareName"));
    	        hwNumCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    	        hwGenCol.setCellValueFactory(new PropertyValueFactory<>("genre"));
    	        //rPh.setImage(new Image(new FileInputStream("/logic/image/"+controller.populateImage())));
    		}
    		
    	} catch (IOException e) {    	
    		
    	    	Logger.getLogger(HomePageView.class.getName()).log(Level.SEVERE, null, e);
    	}catch(UserDoesNotExist u){
		
		new Thread(()-> JOptionPane.showMessageDialog(null, "you are no longer registrated in the system;/n you have been deleted!","Deleted", JOptionPane.INFORMATION_MESSAGE)).start();
		reload("Registration");
		}
    	    	
}

    @FXML
    void bookRoom() throws MyRuntimeException, SQLException{
    	
    	BookRoomController controller = BookRoomController.getInstance();
    	boolean val = controller.createReservation();	
    	if (val) {
    			
    			String d = controller.getReservationBean().getDate();
    			String h = controller.getReservationBean().getHour();
    			new Thread(()-> JOptionPane.showMessageDialog(null, "you PRENO! for: " + d + ", at: " + h + ":00 !","Success", JOptionPane.INFORMATION_MESSAGE)).start();
    			reload("PlainPModelPage");
    	}else {
    			new Thread(()-> JOptionPane.showMessageDialog(null, "you didn't PRENO","Failed", JOptionPane.INFORMATION_MESSAGE)).start();
    	}
    }
    
    @FXML
    private void close() {
		Stage sce = (Stage)rPh.getScene().getWindow();
		sce.close();
    }
    
	private boolean verifyTxtFields() throws StringIsEmptyException {
    	if(sprTxt.getText().equals("") && (gameTxt.getText().equals("") && hwTxt.getText().equals(""))&&(dpField.getValue() == null || hSB.getText().equals("HH") || gsTxt.getText().isEmpty())) {
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