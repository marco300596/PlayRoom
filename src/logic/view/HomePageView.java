package logic.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomePageView extends Application {
    @Override
    public void start(Stage primaryStage) {
    	
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("PlainModelPage.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setController(new HomePageViewController());
    	
    }

    public static void main(String[] args) {
        launch(args);
    }
}

