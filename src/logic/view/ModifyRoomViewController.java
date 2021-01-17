package logic.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logic.controller.CreateTournamentController;
import logic.controller.ModifyRoomController;
import logic.exception.MyRuntimeException;

public class ModifyRoomViewController {

    @FXML
    private MenuButton menbtn;

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

    
    
    /*AGGIUNGERE NEL BEAN DI ROOM,LA DESCRIPTION,LA QUANTITà,IL GENERE E LA DESCRIZIONE DELL'HARDWARE(ANCHE NEL MODEL)
    @FXML
    void addComponent(MouseEvent event) throws MyRuntimeException, SQLException {
    	
    	if (verifyFields()){
			ModifyRoomController controller = ModifyRoomController.getInstance();
	    	controller.getBean().setRoomName(namext.getText());
	    	controller.getBean().setGenre(genretxt.getText());
	  		controller.getBean().setQuantity(quantxt.getText());
	  		controller.getBean().setDescription(desctxt.getText());
	    	
	    	try {
	    		controller.addComponent(controller.getBean());
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
    
    private boolean verifyFields() {
    	return !(nametxt.getText().equals("") || genretxt.getText().equals("") || quantxt.getText().equals("") || desctxt.getText().equals("") );
    }
*/
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

