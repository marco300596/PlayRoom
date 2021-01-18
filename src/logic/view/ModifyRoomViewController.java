package logic.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logic.controller.CreateTournamentController;
import logic.controller.ModifyRoomController;
import logic.exception.MyRuntimeException;

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
    private TextField desctxt;

    @FXML
    private Button addbtn;

    
    
    
    @FXML
    void addComponent(MouseEvent event) throws MyRuntimeException, SQLException {
    	
    	if(cbeo1.isSelected()) {
    	if (verifyFields()){
			ModifyRoomController controller = ModifyRoomController.getInstance();
			controller.getBean().setHardwareName(nametxt.getText());
	    	controller.getBean().setGenre(genretxt.getText());
	  		controller.getBean().setQuantity(quantxt.getText());
	  		controller.getBean().setHdescription(desctxt.getText());
	    	
	    	try {
	    		controller.addComponentH(controller.getBean());
	    		new Thread(() ->
            	JOptionPane.showMessageDialog(null, "You have modified correctly your room!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
	    	} catch(Exception e){
	    		Logger.getLogger(CreateTournamentController.class.getName()).log(Level.SEVERE, null, e);
	    	}
		} else {
			new Thread(() ->
        	JOptionPane.showMessageDialog(null, "Fill all textfield please!","Error", JOptionPane.INFORMATION_MESSAGE)).start();
		}	
    }
    	
    	if(cbeo2.isSelected()) {
        	if (verifyFields()){
    			ModifyRoomController controller = ModifyRoomController.getInstance();
    			
    			controller.getBean().setGameName(nametxt.getText());
    			controller.getBean().setGenre(genretxt.getText());
    	  		controller.getBean().setQuantity(quantxt.getText());
    	  		controller.getBean().setHdescription(desctxt.getText());
    	  		
    	    	try {
    	    		controller.addComponentV(controller.getBean());
    	    		new Thread(() ->
                	JOptionPane.showMessageDialog(null, "You have modified correctly your room!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
    	    	} catch(Exception e){
    	    		Logger.getLogger(CreateTournamentController.class.getName()).log(Level.SEVERE, null, e);
    	    	}
    		} else {
    			new Thread(() ->
            	JOptionPane.showMessageDialog(null, "Fill all textfield please!","Error", JOptionPane.INFORMATION_MESSAGE)).start();
    		}	
        }
    	
    	
    	
    }
    
    private boolean verifyFields() {
    	return !(nametxt.getText().equals("") || genretxt.getText().equals("") || quantxt.getText().equals("") || desctxt.getText().equals("") );
    }

}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

