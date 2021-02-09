package logic.view;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logic.controller.CreateTournamentController;
import logic.controller.LoginController;
import logic.controller.ModifyRoomController;


import logic.exception.WrongInputException;

public class ModifyRoomViewController {

	
	
	@FXML
    private CheckBox cbeo1;

    @FXML
    private CheckBox cbeo2;

    @FXML
    private TextField nametxt;

    @FXML
    private TextField genretxt;

    @FXML
    private TextField quantxt;

    @FXML
    private TextArea desctxt;

    @FXML
    private Button addbtn;

    
    
    
    @FXML
    void addComponent(MouseEvent event) {
    	
    	String error="Error";
    	


    	if(!cbeo1.isSelected() && !cbeo2.isSelected() ) {
    		new Thread(() ->
        	JOptionPane.showMessageDialog(null, "You have to select one between hardware and game!",error, JOptionPane.ERROR_MESSAGE)).start();


    	if(cbeo1.isSelected() && cbeo2.isSelected()) {
    		new Thread(() ->
    		JOptionPane.showMessageDialog(null, "you cannot select both hardware and videogame type simultaneously", "alert", JOptionPane.ERROR_MESSAGE)).start();

    	
    	}
    	
    	
    	if(cbeo1.isSelected() && verifyFields() && !cbeo2.isSelected()){
			
    		hardware();
    		
    		
    	}
    			
    	
    	
    	
    
    	if(cbeo2.isSelected() && verifyFields() && !cbeo1.isSelected()){
    			
    		videogame();
    		
    	}
    	
    	if(!verifyFields()){
			
			new Thread(() ->
        	JOptionPane.showMessageDialog(null, "Fill all textfield please!","Error", JOptionPane.INFORMATION_MESSAGE)).start();
		}
    	}
    }
    
    	
   
    	
    		
    
    
    private boolean verifyFields() {
    	return !(nametxt.getText().equals("") || genretxt.getText().equals("") || quantxt.getText().equals("") || desctxt.getText().equals("") );
    }
    
    private void hardware() {
    	try {
    		LoginController logc=LoginController.getInstance();
			ModifyRoomController controller = ModifyRoomController.getInstance();
			controller.getHVBean().setOrgUserName(logc.getBean().getUsername());
			controller.getHVBean().setHardwareName(nametxt.getText());
			controller.getHVBean().setHardwareGenre(genretxt.getText());
			int hardwareQuantity = Integer.parseInt(quantxt.getText());
			controller.getHVBean().setHardwareQuantity(hardwareQuantity);
			controller.getHVBean().setHardwareDescription(desctxt.getText());
			if(hardwareQuantity==0) {
				throw new WrongInputException("Quantity must be at least 1");
			}
			
			
    		if(controller.addComponentH(controller.getHVBean())) {
    			new Thread(() ->
    			JOptionPane.showMessageDialog(null, "You have modified correctly your room!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
    			}
			}catch(Exception e){
    			Logger.getLogger(CreateTournamentController.class.getName()).log(Level.SEVERE, null, e);
    		}
    }
    
    private void videogame() {
    	try {
    		LoginController logc=LoginController.getInstance();
			ModifyRoomController controller = ModifyRoomController.getInstance();
			controller.getHVBean().setOrgUserName(logc.getBean().getUsername());
			controller.getHVBean().setGameName(nametxt.getText());
			controller.getHVBean().setGameGenre(genretxt.getText());
			int gameQuantity = Integer.parseInt(quantxt.getText());
	  		controller.getHVBean().setGameQuantity(gameQuantity);
	  		controller.getHVBean().setGameDescription(desctxt.getText());
	  		if(gameQuantity==0) {
				throw new WrongInputException("Quantity must be at least 1");
			}
	  		
	    
	    		
	    		if(controller.addComponentV(controller.getHVBean())) {
		    		new Thread(() ->
	            	JOptionPane.showMessageDialog(null, "You have modified correctly your room!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
		    	
	    		}
	    	}catch(Exception e) {
	    		Logger.getLogger(CreateTournamentController.class.getName()).log(Level.SEVERE, null, e);
	    	}
    }
    
    
    
    

}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

