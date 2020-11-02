package Obstacle ;

import Actor.Actor;
import javafx.scene.image.Image ;

// Handle obstacles (car , truck)
public class Obstacle extends Actor {
	// Initialize obstacle speed
	private int speed ;
	@Override
	// An "act" method is needed to keep obstacle moving constantly with time
	public void act(long now) {
		// Set obstacle speed
		move(speed , 0) ;
		// When whole obstacle exits left or right boundary , reset position of obstacle to starting point
		if (getX() > 600 && speed > 0)
			setX(-200) ;
		if (getX() < -50 && speed < 0)
			setX(600) ;
	}
	
	// Initialize obstacle
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		// Set obstacle image
		setImage(new Image(imageLink, w, h, true, true)) ;
		// Set obstacle starting point
		setX(xpos) ;
		setY(ypos) ;
		// Set obstacle speed
		speed = s ;
	}
}
