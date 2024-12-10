package application;
	
import java.awt.*;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.jar.JarOutputStream;

import event.lib.DataHandler;
import event.lib.EventPlanner;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	public static EventPlanner evp1=new EventPlanner("evp1");
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root =FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setMaximized(true);
			primaryStage.setOnCloseRequest(event-> {
				event.consume();
				try {
					logOut(primaryStage);
					DataHandler.saveData(evp1);
					System.out.println(evp1.getEvents().toString());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			});
			
		} catch(Exception e) {
			System.out.println();
		}
	}
	public void logOut(Stage stage) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Exit");
		alert.setContentText("Are you sure you want to exit?");
		if(alert.showAndWait().get() == ButtonType.OK) {
			stage.close();
		}
	}

	public static void main(String[] args) {
		try {
			evp1=DataHandler.loadData();
			System.out.println(evp1.getEvents().toString());
		}catch(Exception e){
			System.out.println(e);
		}
		launch(args);

	}
}
