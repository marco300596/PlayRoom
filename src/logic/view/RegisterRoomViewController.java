package logic.view;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import logic.controller.RegisterRoomController;
import logic.exception.MyRuntimeException;

public class RegisterRoomViewController {
	
	
	
	@FXML
	private TextArea nstxt;

	
	@FXML
    private TextArea nametxt;

	@FXML
    private TextArea cTxt;

    @FXML
    private TextArea addrTxt;

    @FXML
    private TextArea desctxt;

    @FXML
    private Button regroombtn;

    @FXML
    private ImageView phfield;

    @FXML
    private Button phbtn;
    
    
    
    @FXML
    private void handleButtonPhoto(ActionEvent event) {
    	
    	Image image=new Image("");
    	
    	phfield.setImage(image);
    	
    	
    }
    
    
    
    
    
    
    @FXML
    private void registerPression(MouseEvent event) throws MyRuntimeException, SQLException{
    	
    	if(verifyFields()) {
    	RegisterRoomController controller = RegisterRoomController.getInstance();
    	int numSeat=Integer.parseInt(nstxt.getText());
    	controller.getBean().setNumSeat(numSeat);
    	controller.getBean().setRoomName(nametxt.getText());
    	controller.getBean().setDescription(desctxt.getText());
    	controller.getBean().setLocation(addrTxt.getText());	
    	controller.getBean().setCity(cTxt.getText());
    	
        //controller.getBean().setLocation(?.getText());  
    //	controller.getBean().setPhoto(phfield.getText());
    	try {
    		controller.insertnewRoom(controller.getBean());
    		new Thread(() ->
    		JOptionPane.showConfirmDialog(null,"GZ! new Room created!", "Success", JOptionPane.INFORMATION_MESSAGE)).start();
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
   
    
    
    
    
    
    
    

   


