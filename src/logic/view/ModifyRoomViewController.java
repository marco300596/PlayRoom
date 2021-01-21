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
    private TextField desctxt;

    @FXML
    private Button addbtn;

    
    
    
    @FXML
    void addComponent(MouseEvent event) throws MyRuntimeException, SQLException {
    	
    	if(cbeo1.isSelected()) {
    	if (verifyFields()){
			ModifyRoomController controller = ModifyRoomController.getInstance();
			controller.getHVBean().setOrgUserName(orgustxt.getText());
			controller.getHVBean().setHardwareName(nametxt.getText());
	    	controller.getHVBean().setHardwareGenre(genretxt.getText());
	    	int hardwareQuantity=Integer.parseInt(quantxt.getText());
	    	controller.getHVBean().setHardwareQuantity(hardwareQuantity);
	  		controller.getHVBean().setHardwareDescription(desctxt.getText());
	    	
	    	try {
	    		controller.addComponentH(controller.getHVBean());
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
    			controller.getHVBean().setOrgUserName(orgustxt.getText());
    			controller.getHVBean().setGameGenre(genretxt.getText());
    			int gameQuantity=Integer.parseInt(quantxt.getText());
    	  		controller.getHVBean().setGameQuantity(gameQuantity);
    	  		controller.getHVBean().setGameDescription(desctxt.getText());
    	  		
    	    	try {
    	    		controller.addComponentV(controller.getHVBean());
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
    	return !(orgustxt.getText().equals("") ||nametxt.getText().equals("") || genretxt.getText().equals("") || quantxt.getText().equals("") || desctxt.getText().equals("") );
    }

}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

