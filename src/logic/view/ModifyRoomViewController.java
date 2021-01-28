package logic.view;


import java.sql.SQLException;
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
import logic.controller.ModifyRoomController;
import logic.exception.MyRuntimeException;
import logic.exception.WrongInputException;

public class ModifyRoomViewController {

	@FXML
    private TextField orgustxt;
	
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
    void addComponent(MouseEvent event) throws MyRuntimeException, SQLException,WrongInputException {
    	
    	if(!cbeo1.isSelected() && !cbeo2.isSelected()) {
    		JOptionPane.showMessageDialog(null, "you have to select one  between hardware and videogame type ", "alert", JOptionPane.ERROR_MESSAGE);
    	
    	}
    	
    	if(cbeo1.isSelected() && cbeo2.isSelected()) {
    		JOptionPane.showMessageDialog(null, "you cannot select both hardware and videogame type simultaneously", "alert", JOptionPane.ERROR_MESSAGE);
    	
    	}
    
    	if(cbeo1.isSelected() && verifyFields()){
			
    			ModifyRoomController controller = ModifyRoomController.getInstance();
    			controller.getHVBean().setOrgUserName(orgustxt.getText());
    			controller.getHVBean().setHardwareName(nametxt.getText());
    			controller.getHVBean().setHardwareGenre(genretxt.getText());
    			int hardwareQuantity = Integer.parseInt(quantxt.getText());
    			controller.getHVBean().setHardwareQuantity(hardwareQuantity);
    			controller.getHVBean().setHardwareDescription(desctxt.getText());
	    	
	    	try {
	    		
	    		controller.addComponentH(controller.getHVBean());
	    		new Thread(() ->
            	JOptionPane.showMessageDialog(null, "You have modified correctly your room!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
	    		
	    	} 
	    		catch(Exception e){
	    			Logger.getLogger(CreateTournamentController.class.getName()).log(Level.SEVERE, null, e);
	    	}
	    	
	    		
		}
    	
    	
    		
    	
    	if(cbeo2.isSelected() && verifyFields()){
    			
    			ModifyRoomController controller = ModifyRoomController.getInstance();
    			controller.getHVBean().setOrgUserName(orgustxt.getText());
    			controller.getHVBean().setGameName(nametxt.getText());
    			controller.getHVBean().setGameGenre(genretxt.getText());
    			int gameQuantity = Integer.parseInt(quantxt.getText());
    	  		controller.getHVBean().setGameQuantity(gameQuantity);
    	  		controller.getHVBean().setGameDescription(desctxt.getText());
    	  		
    	    	try {
    	    		
    	    		controller.addComponentV(controller.getHVBean());
    	    		new Thread(() ->
                	JOptionPane.showMessageDialog(null, "You have modified correctly your room!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
    	    	}
    	    	catch(Exception e) {
    	    		Logger.getLogger(CreateTournamentController.class.getName()).log(Level.SEVERE, null, e);
    	    	}
    	    	
    	    	
    		} 
    	
    	else  {
			
			new Thread(() ->
        	JOptionPane.showMessageDialog(null, "Fill all textfield please!","Error", JOptionPane.INFORMATION_MESSAGE)).start();
		}
    		
    }
    
    private boolean verifyFields() {
    	return !(orgustxt.getText().equals("") || nametxt.getText().equals("") || genretxt.getText().equals("") || quantxt.getText().equals("") || desctxt.getText().equals("") );
    }

}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

