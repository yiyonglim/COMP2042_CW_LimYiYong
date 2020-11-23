package com.yiyonglim.Platform ;

import com.yiyonglim.Actor.Actor;

import javafx.scene.image.Image ;

/**
 * Handle wet turtle (platform)
 * If frog step on wet turtle , move with it when it is floating , fall into water when it sunk
 * @author yiyonglim
 */
public class WetTurtle extends Actor{

	Image wetTurtleSwim ;
	Image wetTurtleSink1 ;
	Image wetTurtleSink2 ;
	Image wetTurtleSink3 ;

	private int wetTurtleSpeed ;
	private boolean sunk = false ;
	
	/**
	 * Set up a wet turtle
	 * @param xpos Wet turtle's X coordinate
	 * @param ypos Wet turtle's Y coordinate
	 * @param speed Wet turtle's speed
	 * @param width Wet turtle's width
	 * @param height Wet turtle's height
	 */
	public WetTurtle(int xpos, int ypos, int speed, int width, int height) {

		wetTurtleSwim = new Image("file:Resources/Turtle/turtleSwim1.png", width, height, true, true) ;
		wetTurtleSink1 = new Image("file:Resources/Turtle/turtleSink1.png", width, height, true, true) ;
		wetTurtleSink2 = new Image("file:Resources/Turtle/turtleSink2.png", width, height, true, true) ;
		wetTurtleSink3 = new Image("file:Resources/Turtle/turtleSink3.png", width, height, true, true) ;
		
		setX(xpos) ;
		setY(ypos) ;
		
		wetTurtleSpeed = speed ;
		
		setImage(wetTurtleSink1) ;
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
	 */
	@Override
	public void act(long now) {
		
		// Turtle swimming and sinking
		if (now/900000000  % 4 == 0) {
			setImage(wetTurtleSink1) ;
			sunk = false ;
		}
		else if (now/900000000 % 4 == 1) {
			setImage(wetTurtleSwim) ;
			sunk = false ;
		}
		else if (now/900000000 % 4 == 2) {
			setImage(wetTurtleSink2) ;
			sunk = false ;
		}
		else if (now/900000000 % 4 == 3) {
			setImage(wetTurtleSink3) ;
			sunk = true ;
		}
		
		move(wetTurtleSpeed , 0) ;
		
		// When whole wet turtle exits left or right boundary , reset position of wet turtle to its starting point
		if (getX() > 600 && wetTurtleSpeed > 0)
			setX(-200) ;
		if (getX() < -75 && wetTurtleSpeed < 0)
			setX(600) ;
	}
}
