package logic.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomePageView extends Application {
   
	@Override
    public void start(Stage primaryStage) {
    	
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
    		FXMLLoader loader = new FXMLLoader();
        	loader.setController(new HomePageViewController());
    		primaryStage.setScene(new Scene(root));
            primaryStage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    }

    public static void main(String[] args) {
        launch(args);
    }
}

