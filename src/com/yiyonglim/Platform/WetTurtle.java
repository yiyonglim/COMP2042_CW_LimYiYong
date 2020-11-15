package com.yiyonglim.Platform ;

import com.yiyonglim.Actor.Actor;

import javafx.scene.image.Image ;

/**
 * Handle wet turtle (platform)
 * If frog step on wet turtle , move with it when it is floating , fall into water when it sink
 * @author yiyonglim
 */
public class WetTurtle extends Actor{
	// Initialize wet turtle's image
	Image turtle1 ;
	Image turtle2 ;
	Image turtle3 ;
	Image turtle4 ;
	// Initialize wet turtle's movement speed
	private int speed ;
	// Initialize wet turtle's state
	// true -> sunk into water , false -> float on water
	boolean sunk = false ;
	
	/**
	 * Set up a wet turtle
	 * @param xpos Wet turtle's X coordinate
	 * @param ypos Wet turtle's Y coordinate
	 * @param s Wet turtle's speed
	 * @param w Wet turtle's width
	 * @param h Wet turtle's height
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		// Set wet turtle's image
		turtle1 = new Image("file:Resources/Turtle/turtleAnimation1.png", w, h, true, true) ;
		turtle2 = new Image("file:Resources/Turtle/turtleAnimation2Wet.png", w, h, true, true) ;
		turtle3 = new Image("file:Resources/Turtle/turtleAnimation3Wet.png", w, h, true, true) ;
		turtle4 = new Image("file:Resources/Turtle/turtleAnimation4Wet.png", w, h, true, true) ;
		
		// Set wet turtle's starting point
		setX(xpos) ;
		setY(ypos) ;
		
		// Set wet turtle's movement speed
		speed = s ;
		
		// Set initial image of wet turtle (when wet turtle starting to sink)
		setImage(turtle2) ;
	}
	
	/**
	 * Return wet turtle floating or sinking
	 * @return State of wet turtle (true when sunk or false when float)
	 */
	public boolean isSunk() {
		return sunk ;
	}
	
	/**
	 * Set wet turtle into action
	 * Wet turtle's image will keep changing because it will float and sink
	 */
	@Override
	public void act(long now) {
		// Turtle swimming and sinking
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
		
		// Set wet turtle's movement speed
		move(speed , 0) ;
		
		// When whole wet turtle exits left or right boundary , reset position of wet turtle to starting point
		if (getX() > 600 && speed > 0)
			setX(-200) ;
		if (getX() < -75 && speed < 0)
			setX(600) ;
	}
}
