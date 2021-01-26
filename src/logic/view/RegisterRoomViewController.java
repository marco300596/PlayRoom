package logic.view;
import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

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
    private void handleButtonPhoto(ActionEvent event) throws MalformedURLException {
    	if (phfield.getImage()!=null) {
        	
    		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    		int returnValue = chooser.showOpenDialog(null);
    		if (returnValue == JFileChooser.APPROVE_OPTION) {
    			try {
    				File file = new File(chooser.getSelectedFile().getAbsolutePath());
    				String localURL = file.toURI().toURL().toString();
    				phfield.setImage(new Image(localURL));
    			}catch(MalformedURLException m) {
    			new Thread(()-> JOptionPane.showMessageDialog(null, "choose a correct photo!","ATTENTION!", JOptionPane.INFORMATION_MESSAGE)).start();
    			}
    		}
    	}else {
    			phbtn.setDisable(true);
    		}
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
   
    
    
    
    
    
    
    

   


