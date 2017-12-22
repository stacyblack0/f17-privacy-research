import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
		Scene scene = new Scene(root, 680, 620);
		//scene.getStylesheets().add(Main.class.getResource("../view/application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Privacy Rule Creator");
		primaryStage.show();
	}
}
