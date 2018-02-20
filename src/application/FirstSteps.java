package application;

//import java.awt.RenderingHints.Key;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import javafx.event.EventHandler;
//import characters.Character;
//import javafx.animation.AnimationTimer;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyCode;
//
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//import maps.Locations;


public class FirstSteps {
	
//	public  Pane root0 = new Pane();
//	private Pane root0_1 = new Pane();
//	
//	
//	HashMap<KeyCode, Boolean> keys = new HashMap<>();
//	
//	InputStream as = Files.newInputStream(Paths.get("pictures/pGGbv.png"));
//	Image image = new Image(as);
//	ImageView imageView = new ImageView(image);
//	Character player = new Character(imageView);
	
//	AnimationTimer timer = new AnimationTimer(){
//		@Override
//		public void handle(long now){
//			update();
//		}
//	};
//	
//	public void update(){
//		if(isPressed(KeyCode.W)){
//			player.animation.play();
//			player.animation.setOffsetY(477);
//			player.moveY(-11);
//		}else if(isPressed(KeyCode.S)){
//			player.animation.play();
//			player.animation.setOffsetY(0);
//			player.moveY(11);
//		}else if(isPressed(KeyCode.D)){
//			player.animation.play();
//			player.animation.setOffsetY(318);
//			player.moveX(11);
//		}else if(isPressed(KeyCode.A)){
//			player.animation.play();
//			player.animation.setOffsetY(159);
//			player.moveX(-11);
//		}
//		else{player.animation.stop(); }
//
//	}
//	
//	
//	public boolean isPressed(KeyCode key){
//	
//		return  keys.getOrDefault(key, false);   
//	}
	
	/////////////////////////////////////////////
//	int locationWidth;
//	public static ArrayList<Node> platformNodes = new ArrayList<Node>();
//	public void initContent(){
//		
//		Rectangle bg = new Rectangle(800,600);
//		locationWidth = Locations.MAP1[0].length() * 32;
//		
//		for(int i = 0; i < Locations.MAP1.length; i++){
//			
//			String line = Locations.MAP1[i];
//			for(int j = 0;j < line.length(); j++){
//				switch(line.charAt(j)){
//				case '0' : break;
//				case '1' : 
//					Node platformNode = createEntity(j*32, i*32, 32, 32, Color.GREY);
//					platformNodes.add(platformNode);
//					break;
//				case '2' : 
//					Node things = createEntity(j*32, i*32, 32, 32, Color.BROWN);
//				    platformNodes.add(things);
//				    break;
//				case '!': 
//				
//				}
//			}
//		}
//	}
//	
//	public Node createEntity(int x, int y, int w, int h, Color color){
//		Rectangle wall =  new Rectangle(w,h);
//		wall.setTranslateX(x);
//		wall.setTranslateY(y);
//		wall.setFill(color); 
//		
//		root0.getChildren().add(wall);
//		return wall;
//	}

	
	
	/////////////////////////////////////
	
	
//	public void start(Stage stage) throws Exception{
//		
//		
//		root0.setPrefSize(800, 600);
//		
//
//		InputStream is = Files.newInputStream(Paths.get("pictures/background.jpg"));
//		Image img = new Image(is);
//		is.close();
//
//		ImageView imgView = new ImageView(img);
//		
//		root0.getChildren().addAll(imgView, player);
////		new SceneSwitcher(player,root0,1);
//		new SceneSwitcher();
//		
//		Scene scene0 = new Scene(root0);
//		
//		stage.setScene(scene0);
//		stage.show();
//		
//		scene0.setOnKeyPressed(event -> keys.put(event.getCode(), true));
//		scene0.setOnKeyReleased(event -> keys.put(event.getCode(), false));
//		
//		}
//	
//	
//	
//
//	FirstSteps(Stage stage0) throws Exception{
//		
//		start(stage0);
//		timer.start();
//		
//		
//	}
	
	
}
