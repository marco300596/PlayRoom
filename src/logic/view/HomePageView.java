package logic.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomePageView extends Application {
   
	@Override
    public void start(Stage primaryStage) {
    	
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("/logic/samples/homepage.fxml"));
    		primaryStage.setScene(new Scene(root));
    		primaryStage.setResizable(false);
            primaryStage.show();
    	} catch (IOException e) {
    	
    		Logger.getLogger(HomePageView.class.getName()).log(Level.SEVERE, null, e);
    	}
    	
}

    public static void main(String[] args) {
        launch(args);
    }
}

