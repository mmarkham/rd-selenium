package GUI;
 
import testCases.Setup;
import testCases.test;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.*;
 
public class Start_GUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Rapid Discovery Automation");
        
        SetupScene s = new SetupScene();
        Scene scene = s.getScene(new test(), primaryStage);
        		
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}