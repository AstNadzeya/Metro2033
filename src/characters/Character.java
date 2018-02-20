package characters;

import com.sun.prism.paint.Color;

import animation.SpriteAnimation;
import application.SceneSwitcher;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Character extends Pane{
	
//	int healthPoint;
//	int stamina;
//	int movingSpeed;
	
	//Image mainCharacter = new Image(getClass().getResourceAsStream("pGGbv.png"));
	ImageView imageView;
	int columns = 12;
	int count = 12;
	int offsetX = 0;
	int offsetY = 0;
	int width = 95;
	int height = 159;
	private boolean needPr = false;
	
	public boolean getNeedPr(){
		return needPr;
	}
	
	public void setNeedPr(boolean need){
		needPr = need;
	}
	
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
	
	

	
//	public void moveX(int x){
//		boolean right = x > 0 ? true: false;
//		for(int i = 0; i < Math.abs(x); i++){
//			
////			for(Node bridge: SceneSwitcher.switchMapNodes){
////				if(this.getBoundsInParent().intersects(bridge.getBoundsInParent())){
////					System.out.println("Wahahaha"+ SceneSwitcher.currMap);
////					if(SceneSwitcher.currMap<6){
////						SceneSwitcher.currMap++;
////						return;
////					}
////					
////					
////				}
////			}
//			
//			for (Node platform : SceneSwitcher.platformNodes){
//					
//				
//					if (this.getBoundsInParent().intersects(platform.getBoundsInParent())){
//					  
//						
//						if(right) {
//							
//								if(this.getTranslateX() + 95 == platform.getTranslateX()){
//									return;
//									}
//							
//						}else {
//							if (this.getTranslateX() == platform.getTranslateX() + 16){
//								return;
//							}
//						}
//					}
//					
//				
//			}
//			
//		
////			if (SceneSwitcher.param.equals(Color.RED)){
////				System.out.println("here");
////				SceneSwitcher.currMap++;
////				needPr = true;						
//			
////			}else{}
//				this.setTranslateX(this.getTranslateX() + (right ? 0.5 : -0.5));
//		}
//		
//	}
//	
//	public void moveY(int y){
//		boolean down = y > 0 ? true: false;
//		for(int i = 0; i < Math.abs(y); i++){
//			for (Node platform : SceneSwitcher.platformNodes){
//				if (this.getBoundsInParent().intersects(platform.getBoundsInParent())){
//					if(down) {
//						if(this.getTranslateY() + 159 == platform.getTranslateY()){
//							this.setTranslateY(this.getTranslateY() - 1);
//							return;
//						}
//					}
//					else {
//						if (this.getTranslateY() == platform.getTranslateY() + 16){
//							return;
//						}
//					}
//				}
//			}
//				this.setTranslateY(this.getTranslateY() + (down ? 0.5 : -0.5));
//		}
//	}	
//	
	


}


