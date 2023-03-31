package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("IHM.fxml"));
			Scene scene = new Scene(root,500,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			// Titre de la fenêtre
			primaryStage.setTitle("Gestionnaire de couleurs");
			// Logo 3il de la fenêtre récupérable via le dossier Images
			primaryStage.getIcons().add(new Image(ClassLoader.getSystemResourceAsStream("Images/3ilLogo.jpg")));
			// Impossible à l'utilisateur de modifier la taille et le dimensions de la fenêtre
            primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
