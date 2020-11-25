package com.yiyonglim.Platform ;

import com.yiyonglim.Actor.Actor;

import javafx.scene.image.Image ;

/**
 * Handle turtle (platform)
 * If frog step on turtle , move with it
 * @author yiyonglim
 */
public class Turtle extends Actor{

	Image turtleSwim1 ;
	Image turtleSwim2 ;
	Image turtleSwim3 ;
	
	private int turtleSpeed ;
	
	/**
	 * Set up a turtle
	 * @param xpos Turtle's X coordinate
	 * @param ypos Turtle's Y coordinate
	 * @param speed Turtle's speed
	 * @param width Turtle's width
	 * @param height Turtle's height
	 */
	public Turtle(int xpos, int ypos, int speed, int width, int height) {

		turtleSwim1 = new Image("file:Resources/Turtle/turtleSwim1.png", width, height, true, true) ;
		turtleSwim2 = new Image("file:Resources/Turtle/turtleSwim2.png", width, height, true, true) ;
		turtleSwim3 = new Image("file:Resources/Turtle/turtleSwim3.png", width, height, true, true) ;
		
		setX(xpos) ;
		setY(ypos) ;

		turtleSpeed = speed ;
		
		setImage(turtleSwim2) ;
	}
	
	/**
	 * Set turtle into action
	 */
	@Override
	public void act(long now) {

		// Turtle swimming
		if (now/900000000  % 3 == 0) {
			
			setImage(turtleSwim2) ;
		}
		else if (now/900000000 % 3 == 1) {
			
			setImage(turtleSwim1) ;
		}
		else if (now/900000000 % 3 == 2) {
			
			setImage(turtleSwim3) ;
		}
		
		move(turtleSpeed , 0);
		
		// When whole turtle exits left or right boundary , reset position of turtle to its starting point
		if (getX() > 600 && turtleSpeed > 0)
			setX(-200) ;
		if (getX() < -75 && turtleSpeed < 0)
			setX(600) ;
	}
}
