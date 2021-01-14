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
import logic.controller.RegisterRoomController;
import logic.exception.MyRuntimeException;
import logic.exception.UserDoesNotExist;
public class RegisterRoomViewController {
	
	
	
	@FXML
	private TextArea nstxt;

	
	@FXML
    private TextArea Nametxt;

    

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
    	
    	Image image=new Image("");//da mettere il percorso della foto
    	
    	phfield.setImage(image);
    	
    	
    }
    
    
    
    
    
    
    @FXML
    private void RegisterPression(ActionEvent event) throws MyRuntimeException, SQLException, UserDoesNotExist{
    	
    	if(verifyFields()) {
    	RegisterRoomController controller = RegisterRoomController.getInstance();
    	int numSeat=Integer.parseInt(nstxt.getText());
    	controller.getBean().setNumSeat(numSeat);
    	controller.getBean().setRoomName(Nametxt.getText());
    	controller.getBean().setDescription(desctxt.getText());
    	
        //controller.getBean().setLocation(?.getText());  
    //	controller.getBean().setPhoto(phfield.getText());//da vedere
    	try {
    		controller.insertnewRoom(controller.getBean());
    		new Thread(() ->
    		JOptionPane.showConfirmDialog(null,"GZ! new Room created!", "Success", JOptionPane.INFORMATION_MESSAGE));
    	} catch(Exception e){
    		Logger.getLogger(RegisterRoomController.class.getName()).log(Level.SEVERE, null, e);
    	}
	} else {
		new Thread(() ->
		JOptionPane.showMessageDialog(null, "fill all textfield please!","Error", JOptionPane.INFORMATION_MESSAGE));
		
	}
    	
		}		
		
    	
		
    
    
    
    
    
    
    
    private boolean verifyFields() {
    	return !(nstxt.getText().equals("") || Nametxt.getText().equals("") || desctxt.getText().equals("") || Nametxt.getText().equals(""));
    }

    
    
    
    
    
    
}
   
    
    
    
    
    
    
    

   


