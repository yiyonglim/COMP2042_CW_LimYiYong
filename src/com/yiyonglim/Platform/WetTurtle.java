package com.yiyonglim.Platform ;

import com.yiyonglim.Actor.Actor;

import javafx.scene.image.Image ;

// Handle all action done by wet turtle
public class WetTurtle extends Actor{
	// Initialize wet turtle image
	Image turtle1 ;
	Image turtle2 ;
	Image turtle3 ;
	Image turtle4 ;
	// Initialize wet turtle movement speed
	private int speed ;
	// Initialize wet turtle state
	// true -> sunk into water , false -> float on water
	boolean sunk = false ;
	@Override
	// An "act" method is needed to keep wet turtle moving constantly with time
	// Wet turtle image keep changing constantly with time to mimic sinking
	public void act(long now) {
				if (now/900000000  % 4 == 0) {
					setImage(turtle2) ;
					sunk = false ;
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1) ;
					sunk = false ;
				}
				else if (now/900000000 % 4 == 2) {
					setImage(turtle3) ;
					sunk = false ;
				}
				else if (now/900000000 % 4 == 3) {
					setImage(turtle4) ;
					sunk = true ;
				}
		// Set wet turtle movement speed
		move(speed , 0) ;
		// When whole wet turtle exits left or right boundary , reset position of wet turtle to starting point
		if (getX() > 600 && speed > 0)
			setX(-200) ;
		if (getX() < -75 && speed < 0)
			setX(600) ;
	}
	
	// Initialize wet turtle
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		// Set wet turtle image
		turtle1 = new Image("file:Resources/Turtle/TurtleAnimation1.png", w, h, true, true) ;
		turtle2 = new Image("file:Resources/Turtle/TurtleAnimation2Wet.png", w, h, true, true) ;
		turtle3 = new Image("file:Resources/Turtle/TurtleAnimation3Wet.png", w, h, true, true) ;
		turtle4 = new Image("file:Resources/Turtle/TurtleAnimation4Wet.png", w, h, true, true) ;
		// Set wet turtle starting point
		setX(xpos) ;
		setY(ypos) ;
		// Set wet turtle movement speed
		speed = s ;
		// Set initial image of wet turtle (when wet turtle starting to sink)
		setImage(turtle2) ;
	}
	
	// Return state of wet turtle (float or sunk)
	public boolean isSunk() {
		return sunk ;
	}
}
