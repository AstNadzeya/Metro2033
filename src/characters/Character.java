package characters;


import animation.SpriteAnimation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Character extends Pane{
	
	ImageView imageView;
	int columns = 12;
	int count = 12;
	int offsetX = 0;
	int offsetY = 0;
	int width = 95;
	int height = 159;
	
	
	Rectangle removeRect = null;
	public SpriteAnimation animation;

	
	public Character(ImageView imageView){
		this.imageView = imageView;
		this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
		animation = new SpriteAnimation(imageView, Duration.millis(1800), 
				                        count, columns,
				                        offsetX, offsetY,
				                        width, height);
		this.setTranslateX(100);
		this.setTranslateY(100);
		getChildren().addAll(imageView);
		
	}


}


