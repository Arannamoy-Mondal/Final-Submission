package application;
	
import java.time.LocalDate;
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
			primaryStage.setOnCloseRequest(event->{
				event.consume();
				logOut(primaryStage);
			});
			
		} catch(Exception e) {
			System.out.println();
		}
	}
	public void logOut(Stage stage) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Log Out");
		alert.setContentText("Are you sure you want to log out?");
		if(alert.showAndWait().get() == ButtonType.OK) {
			//            stage=(Stage)scene_pane.getScene().getWindow();
			System.out.println("LogOut");
			stage.close();
		}
	}

	public static void main(String[] args) {
		try {
			evp1=DataHandler.loadData();
			String id = Main.evp1.offerTourPackage("Tour Kaptai", LocalDate.now(), 20, 20, 2000);
//			Main.evp1.addEventTask(id, "Boarding", "DAC"); // given error when add task error type java.util.ArrayList.add(Object)
//			System.out.println(id);
//			Main.evp1.assignEventManager(id, "Manager1");
//			Main.evp1.requestEvent("Tour Ibliz","0123456789",LocalDate.now(),20,20);

		}catch(Exception e){
			System.out.println(e);
		}
		launch(args);

	}
}
