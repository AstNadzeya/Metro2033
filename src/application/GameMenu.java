package application;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import application.MenuButton;
import characters.Character;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class GameMenu extends Parent{
	
	public GameMenu(Stage primaryStage){
		
		VBox mainMenu = new VBox(10);
		VBox menu = new VBox(10);
		
		mainMenu.setTranslateX(100);
		mainMenu.setTranslateY(200);
		
		menu.setTranslateX(100);
		menu.setTranslateY(200);
		
		final int offset = 400;
		
		MenuButton btnStartGame = new MenuButton("START GAME");
		btnStartGame.setOnMouseClicked(event ->{
			FadeTransition ft = new FadeTransition(Duration.seconds(0.7),this);
			ft.setFromValue(1);
			ft.setToValue(0);
			ft.setOnFinished(evt -> {
				this.setVisible(false); 
				 try {
					 new SceneSwitcher(primaryStage);
					 
				
					 } catch (Exception e) {
					 // TODO Auto-generated catch block
					 e.printStackTrace();
					 }});
			ft.play();
			
		});
		
		MenuButton btnOptions = new MenuButton("OPTIONS");
		btnOptions.setOnMouseClicked(event -> {
			getChildren().add(menu);
			
			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25),mainMenu);
			tt.setToX(mainMenu.getTranslateX() - offset);
			
			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu);
			tt1.setToX(mainMenu.getTranslateX());
			
			tt.play();
			tt1.play();
			
			tt.setOnFinished(evt -> {
				getChildren().remove(mainMenu);
			});
		});
		
		MenuButton btnExit = new MenuButton("EXIT");
		btnExit.setOnMouseClicked(event -> {
			System.exit(0);
		});
		
		MenuButton btnBack = new MenuButton("BACK");
		btnBack.setOnMouseClicked(event -> {
			getChildren().add(mainMenu);
			
			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu);
			tt.setToX(menu.getTranslateX() + offset);		
			
			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), mainMenu);
			tt1.setToX(menu.getTranslateX());			
			
			tt.play();
			tt1.play();
			
			tt.setOnFinished(evt -> {
				getChildren().remove(menu);
			});
		});
		
		mainMenu.getChildren().addAll(btnStartGame,btnOptions,btnExit);
		menu.getChildren().addAll(btnBack);
		
		
		Rectangle bg = new Rectangle(800,600);
		bg.setFill(Color.GRAY);
		bg.setOpacity(0.4);
		
		getChildren().addAll(bg,mainMenu);

	}
}

