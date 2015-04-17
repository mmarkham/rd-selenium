package GUI;

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
import testCases.test;

public class TestCase_GUI extends Application {

	public TestCase_GUI() {
		// TODO Auto-generated constructor stub
	}
	
	public void TestCaseStage(){
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        BorderPane root = new BorderPane();
        HBox menuBox = new HBox();
        VBox calenderBox = new VBox();
        root.setTop(menuBox);
        root.setRight(calenderBox);
        menuBox.getChildren().add(btn);
        test t = new test();
        for (int i = 0; i < t.getPropertiesCount(); i++){
        	Label userName = new Label(t.getProperties()[i].getName());
        	calenderBox.getChildren().add(userName);

        	TextField userTextField = new TextField();
        	calenderBox.getChildren().add(userTextField);
        }
        //calenderBox.getChildren().add(calender);
        //root.setCenter(htmlE);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}

}
