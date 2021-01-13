package logic.view;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.controller.LoginController;
import logic.controller.RegisterRoomController;
import logic.exception.MyRuntimeException;
import logic.exception.UserDoesNotExist;
import logic.model.VideoGame;
public class RegisterRoomViewController {
	
	
	
	@FXML
	private TextArea nstxt;

	
	@FXML
    private TextArea Nametxt;

    @FXML
    private TextArea Gametxt;

    @FXML
    private TextArea Hardwaretxt;

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
    	
    	RegisterRoomController controller = RegisterRoomController.getInstance();
    	int numSeat=Integer.parseInt(nstxt.getText());
    	controller.getBean().setNumSeat(numSeat);
    	controller.getBean().setRoomName(Nametxt.getText());
    	controller.getBean().setDescription(desctxt.getText());
    	
        //controller.getBean().setLocation(?.getText());  
    //	controller.getBean().setPhoto(phfield.getText());//da vedere
    	if (nstxt.getText().isEmpty()||Nametxt.getText().isEmpty()||desctxt.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "you have to fill the text fields!", "alert", JOptionPane.ERROR_MESSAGE);
		
		
    	}
		}
}
   
    
    
    
    
    
    
    

   


