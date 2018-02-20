package application;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.InputStream;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	
	
	private GameMenu gameMenu;
	
	
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Metro 20??");
		
		Pane root = new Pane();
		root.setPrefSize(800, 600);
		
		InputStream is = Files.newInputStream(Paths.get("pictures/Metro-Exodus.jpg"));
		Image img = new Image(is);
		is.close();
		
		ImageView imgView = new ImageView(img);
		imgView.setFitWidth(800);
		imgView.setFitHeight(600);
		
		gameMenu = new GameMenu(primaryStage);

		root.getChildren().addAll(imgView, gameMenu);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	
	
	public static void main(String[] args){
		
			launch(args);
			
		}
	
	
	
}


