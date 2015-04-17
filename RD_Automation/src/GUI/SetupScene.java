package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import testCases.Setup;
import testCases.TestCase;
import testCases.test;

public class SetupScene{
	VBox calenderBox = new VBox();
	 BorderPane root = new BorderPane();
     HBox menuBox = new HBox();
     TestCase c;
     
     MenuBar menu = new MenuBar();
	public Scene getScene(TestCase c, Stage primaryStage){
		this.c = c;
		// Button Logics /////////////////////
		// Load button
		Button loadBtn = new Button();
        loadBtn.setText("Load File");
        loadBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("LOAD BUTTON");
            }
        });
        // Save button
        Button saveBtn = new Button();
        saveBtn.setText("Save File");
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("SAVE BUTTON");
            }
        });
        
       
        menu.prefWidthProperty().bind(primaryStage.widthProperty());
     // --- Menu File
        Menu menuFile = new Menu("Load");
        MenuItem add = new MenuItem("Setup");
            add.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent t) {
                	prop(new Setup());
                    //shuffle();
                    //vbox.setVisible(true);
                }
            });
            MenuItem add2 = new MenuItem("XMLtest");
            add2.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent t) {
                	prop(new test());
                    //shuffle();
                    //vbox.setVisible(true);
                }
            });        
     
            menuFile.getItems().addAll(add, add2);
 
        // --- Menu Edit
        Menu menuEdit = new Menu("Save");
 
        // --- Menu View
        Menu menuView = new Menu("Test Case");
 
        menu.getMenus().addAll(menuFile, menuEdit, menuView);
        root.setTop(menuBox);
        
        //menuBox.getChildren().add(loadBtn);
        //menuBox.getChildren().add(saveBtn);
        menuBox.getChildren().add(menu);
       
        //calenderBox.getChildren().add(calender);
        //root.setCenter(htmlE);
        
        Scene scene = new Scene(root, 600, 600);
		return scene;
	}
	
	public void prop(TestCase c){
		 root.setLeft(calenderBox);
	        for (int i = 0; i < c.getPropertiesCount(); i++){
	        	Label userName = new Label(c.getProperties()[i].getName());
	        	calenderBox.getChildren().add(userName);

	        	TextField userTextField = new TextField();
	        	calenderBox.getChildren().add(userTextField);
	        }
		
	}

}
