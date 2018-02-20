package application;

//import java.awt.RenderingHints.Key;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

//import javafx.event.EventHandler;
import characters.Character;
import javafx.animation.AnimationTimer;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import maps.MapData;

public class SceneSwitcher {

	MapData loc = new MapData(); // добавление карт в maps; loc.maps[i]
	public ArrayList<Node> platformNodes = new ArrayList<Node>();
	private ArrayList<Node> switchMapNodesF = new ArrayList<Node>();
	private ArrayList<Node> switchMapNodesB = new ArrayList<Node>(); 
	private ArrayList<Node> switchMapNodesE = new ArrayList<Node>(); 
	private int currMap = 0;
	private Pane currRoot = new Pane();
	Group group = new Group();

	InputStream as = Files.newInputStream(Paths.get("pictures/pGGbv.png"));
	Image image = new Image(as);
	ImageView imageView = new ImageView(image);
	Character player = new Character(imageView);
	Stage stage = new Stage();

	///////////////////////////////
	HashMap<KeyCode, Boolean> keys = new HashMap<>();
	AnimationTimer timer = new AnimationTimer() {
		@Override
		public void handle(long now) {
			update();
		}
	};

	public void update() {
		if (isPressed(KeyCode.W)) {
			player.animation.play();
			player.animation.setOffsetY(477);
			moveY(-11);
		} else if (isPressed(KeyCode.S)) {
			player.animation.play();
			player.animation.setOffsetY(0);
			moveY(11);
		} else if (isPressed(KeyCode.D)) {
			player.animation.play();
			player.animation.setOffsetY(318);
			moveX(11);
		} else if (isPressed(KeyCode.A)) {
			player.animation.play();
			player.animation.setOffsetY(159);
			moveX(-11);
		} else {
			player.animation.stop();
		}

	}


	private boolean isPressed(KeyCode key) {

		return keys.getOrDefault(key, false);
	}
	///////////////////////////////////////////////
	

	int locationWidth;

	

	private void mapHandler(int k) {
		group.getChildren().clear();
		platformNodes.clear();
		switchMapNodesF.clear();
		
		Rectangle bg = new Rectangle(800, 600);
		String[] currMap = loc.maps.get(k);
		locationWidth = currMap[0].length() * 32;

		for (int i = 0; i < currMap.length; i++) {

			String line = currMap[i];
			for (int j = 0; j < line.length(); j++) {
				switch (line.charAt(j)) {
				case '0':
					break;
				case '1':
					Node platformNode = createEntity(j * 16, i * 16, 16, 16, Color.GREEN);
					platformNodes.add(platformNode);
					break;
				 case '*' :
					Node back = createEntity(j*16, i*16, 16, 16, Color.BROWN);
					platformNodes.add(back);
					switchMapNodesB.add(back);				 
					break;
				 case '!':
					Node forward = createEntity(j * 16, i * 16, 16, 16, Color.RED);
					platformNodes.add(forward);
					switchMapNodesF.add(forward);
					break;
				 case '8':
					Node exit = createEntity(j * 16, i * 16, 16, 16, Color.GREY);
					platformNodes.add(exit);
					switchMapNodesE.add(exit);
					break;
					
				}
			}
		}
	}

	private Node createEntity(int x, int y, int w, int h, Color color) {
		Rectangle wall = new Rectangle(w, h);
		wall.setTranslateX(x);
		wall.setTranslateY(y);
		wall.setFill(color);

		group.getChildren().add(wall);
		return wall;
	}

	
	//////////////////////////////////////////////////////

	public void start(Stage stage) throws Exception {

		currRoot.setPrefSize(800, 600);
		
		InputStream is = Files.newInputStream(Paths.get("pictures/background.jpg"));
		Image img = new Image(is);
		is.close();

		ImageView imgView = new ImageView(img);

		currRoot.getChildren().addAll(imgView, player,group);
		
		mapHandler(currMap);
		Scene scene0 = new Scene(currRoot);

		stage.setScene(scene0);
		stage.show();

		scene0.setOnKeyPressed(event -> keys.put(event.getCode(), true));
		scene0.setOnKeyReleased(event -> keys.put(event.getCode(), false));

	}
	
	public void moveX(int x){
		boolean right = x > 0 ? true: false;
		for(int i = 0; i < Math.abs(x); i++){
			
			for(Node bridge: switchMapNodesF){
				if(player.getBoundsInParent().intersects(bridge.getBoundsInParent())){
					System.out.println("Wahahaha"+ currMap);
					if(currMap<6){
						mapHandler(++currMap);
						player.setTranslateX(player.getTranslateX() - 500);
						return;
					}
				}
			}
			
			
			for(Node bridge: switchMapNodesB){
				if(player.getBoundsInParent().intersects(bridge.getBoundsInParent())){
					System.out.println("Wahahaha"+ currMap);
					if(currMap>0 ){
						mapHandler(--currMap);
						player.setTranslateX(player.getTranslateX() + 500);
						return;
					}
				}
			}		
			
			for(Node exit: switchMapNodesE){
				if(player.getBoundsInParent().intersects(exit.getBoundsInParent())){
					currRoot.getChildren().clear();
					currRoot.getChildren().addAll(new GameMenu(stage));
						return;
					
				}
			}		
			
			
			for (Node platform : platformNodes){
					if (player.getBoundsInParent().intersects(platform.getBoundsInParent())){
					  
						if(right) {
								if(player.getTranslateX() + 95 == platform.getTranslateX()){
									return;
									}
						}else {
							if (player.getTranslateX() == platform.getTranslateX() + 16){
								return;
							}
						}
					}
			}

			player.setTranslateX(player.getTranslateX() + (right ? 0.5 : -0.5));
		}
		
	}
	
	public void moveY(int y){
		boolean down = y > 0 ? true: false;
		for(int i = 0; i < Math.abs(y); i++){
			for (Node platform : platformNodes){
				if (player.getBoundsInParent().intersects(platform.getBoundsInParent())){
					if(down) {
						if(player.getTranslateY() + 159 == platform.getTranslateY()){
							player.setTranslateY(player.getTranslateY() - 1);
							return;
						}
					}
					else {
						if (player.getTranslateY() == platform.getTranslateY() + 16){
							return;
						}
					}
				}
			}
			player.setTranslateY(player.getTranslateY() + (down ? 0.5 : -0.5));
		}
	}	
	

	SceneSwitcher(Stage stage0) throws Exception {

		start(stage0);
		timer.start();

	}

}
