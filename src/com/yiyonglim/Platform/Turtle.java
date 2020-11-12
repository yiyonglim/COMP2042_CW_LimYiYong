package com.yiyonglim.Platform ;

import com.yiyonglim.Actor.Actor;

import javafx.scene.image.Image ;

/**
 * Handle turtle (platform)
 * If frog step on turtle , move with it
 * @author yiyonglim
 *
 */
public class Turtle extends Actor{
	// Initialize turtle's image
	Image turtle1 ;
	Image turtle2 ;
	Image turtle3 ;
	// Initialize turtle's movement speed
	private int speed ;
	
	/**
	 * Set up a turtle
	 * @param xpos Turtle's X coordinate
	 * @param ypos Turtle's Y coordinate
	 * @param s Turtle's speed
	 * @param w Turtle's width
	 * @param h Turtle's height
	 */
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		// Set turtle's image
		turtle1 = new Image("file:Resources/Turtle/TurtleAnimation1.png", w, h, true, true) ;
		turtle2 = new Image("file:Resources/Turtle/TurtleAnimation2.png", w, h, true, true) ;
		turtle3 = new Image("file:Resources/Turtle/TurtleAnimation3.png", w, h, true, true) ;
		
		// Set turtle's starting point
		setX(xpos) ;
		setY(ypos) ;
		
		// Set turtle's movement speed
		speed = s ;
		
		// Set initial image of turtle (when turtle starting to swim)
		setImage(turtle2) ;
	}
	
	/**
	 * Set turtle into action
	 * Turtle's image will keep changing because it is swimming
	 */
	@Override
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
				
		// Set turtle's movement speed				
		move(speed , 0);
		
		// When whole turtle exits left or right boundary , reset position of turtle to its starting point
		if (getX() > 600 && speed > 0)
			setX(-200) ;
		if (getX() < -75 && speed < 0)
			setX(600) ;
	}
}
