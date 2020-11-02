package Platform ;

import Actor.Actor;
import javafx.scene.image.Image ;

// Handle turtle
public class Turtle extends Actor{
	// Initialize turtle image
	Image turtle1 ;
	Image turtle2 ;
	Image turtle3 ;
	// Initialize turtle movement speed
	private int speed ;
	
	@Override
	// An "act" method is needed to keep turtle moving constantly with the time
	// Turtle image keep changing constantly with time to mimic swimming
	public void act(long now) {
				if (now/900000000  % 3 == 0) {
					setImage(turtle2) ;
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1) ;
				}
				else if (now/900000000 % 3 == 2) {
					setImage(turtle3) ;
				}
		// Set turtle movement speed				
		move(speed , 0);
		// When whole turtle exits left or right boundary , reset position of turtle to starting point
		if (getX() > 600 && speed > 0)
			setX(-200) ;
		if (getX() < -75 && speed < 0)
			setX(600) ;
	}
	
	// Initialize turtle
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		// Set turtle image
		turtle1 = new Image("file:Resources/Turtle/TurtleAnimation1.png", w, h, true, true) ;
		turtle2 = new Image("file:Resources/Turtle/TurtleAnimation2.png", w, h, true, true) ;
		turtle3 = new Image("file:Resources/Turtle/TurtleAnimation3.png", w, h, true, true) ;
		// Set turtle starting point
		setX(xpos) ;
		setY(ypos) ;
		// Set turtle movement speed
		speed = s ;
		// Set initial image of turtle (when turtle starting to swim)
		setImage(turtle2) ;
	}
}
