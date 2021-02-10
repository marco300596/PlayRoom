package logic.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import logic.controller.RegisterRoomController;
import logic.exception.MyRuntimeException;
import javafx.scene.control.TextField;
public class RegisterRoomViewController {
	
	
	
	@FXML
    private TextField nametxt;

    @FXML
    private TextField nstxt;

    @FXML
    private TextArea desctxt;

    @FXML
    private TextField cTxt;

    @FXML
    private TextField addrTxt;

    @FXML
    private TextField pTxt;

    @FXML
    private Button regroombtn;
    
    
   

    @FXML
    private void registerPression(MouseEvent event) throws MyRuntimeException, SQLException{
    	
    	if(verifyFields()) {
    	RegisterRoomController controller = RegisterRoomController.getInstance();
    	int numSeat=Integer.parseInt(nstxt.getText());
    	controller.getBean().setNumSeat(numSeat);
    	controller.getBean().setRoomName(nametxt.getText());
    	controller.getBean().setDescription(desctxt.getText());
    	controller.getBean().setLocation(addrTxt.getText().toLowerCase());	
    	controller.getBean().setCity(cTxt.getText().toLowerCase());
    	controller.getBean().setPrice(Integer.parseInt(pTxt.getText()));
    	
    	try {
    		controller.insertnewRoom(controller.getBean());
    		new Thread(() ->
    		JOptionPane.showMessageDialog(null, "You have added your room!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
    	} catch(Exception e){
    		Logger.getLogger(RegisterRoomController.class.getName()).log(Level.SEVERE, null, e);
    	}
	} else {
		new Thread(() ->
		JOptionPane.showMessageDialog(null, "fill all textfield please!","Error", JOptionPane.INFORMATION_MESSAGE)).start();
		
	}
    	
		}
    
    private boolean verifyFields() {
    	return !(nstxt.getText().equals("") || nametxt.getText().equals("") || desctxt.getText().equals("") || cTxt.getText().equals("") || addrTxt.getText().equals(""));
    }

    
    
    
    
    
    
}
   
    
    
    
    
    
    
    

   


