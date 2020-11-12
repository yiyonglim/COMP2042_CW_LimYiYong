package com.yiyonglim.Platform;

import com.yiyonglim.Actor.Actor;

import javafx.scene.image.Image ;

/**
 * Handle log (platform)
 * If frog step on log , move with it
 * @author yiyonglim
 */
public class Log extends Actor {
	// Initialize log's movement speed
	private double speed ;
	
	/**
	 * Set up a log
	 * @param imageLink Log's image
	 * @param size Log's size
	 * @param xpos Log's X coordinate
	 * @param ypos Log's Y coordinate
	 * @param s Log's speed
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		// Set log's image
		setImage(new Image(imageLink, size, size, true, true)) ;
		// Set log's starting point
		setX(xpos) ;
		setY(ypos) ;
		// Set log's movement speed
		speed = s ;
	}
	
	/**
	 * Set log into action
	 */
	@Override
	public void act(long now) {
		// Set log's movement speed
		move(speed , 0) ;
		// When whole log exits left or right boundary , reset position of log to its starting point
		if (getX() > 600 && speed > 0)
			setX(-180) ;
		if (getX() < -300 && speed < 0)
			setX(700) ;
	}
	
	/**
	 * Check log's status
	 * @return True when log's movement speed less than 0 , False when log's movement speed equals or more than 0
	 */
	public boolean getLeft() {
		return speed < 0 ;
	}
}
