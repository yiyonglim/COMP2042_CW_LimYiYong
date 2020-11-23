package com.yiyonglim.Platform;

import com.yiyonglim.Actor.Actor;

import javafx.scene.image.Image ;

/**
 * Handle log (platform)
 * If frog step on log , move with it
 * @author yiyonglim
 */
public class Log extends Actor {

	private double logSpeed ;
	
	/**
	 * Set up a log
	 * @param image Log's image
	 * @param size Log's size
	 * @param xpos Log's X coordinate
	 * @param ypos Log's Y coordinate
	 * @param speed Log's speed
	 */
	public Log(String image, int size, int xpos, int ypos, double speed) {
		
		setImage(new Image(image, size, size, true, true)) ;
		
		setX(xpos) ;
		setY(ypos) ;
		
		logSpeed = speed ;
	}
	
	/**
	 * Set log into action
	 */
	@Override
	public void act(long now) {

		move(logSpeed , 0) ;
		
		// When whole log exits left or right boundary , reset position of log to its starting point
		if (getX() > 600 && logSpeed > 0)
			setX(-180) ;
		if (getX() < -300 && logSpeed < 0)
			setX(700) ;
	}
	
	/**
	 * Check log's status
	 * @return True when log's movement speed less than 0 , False when log's movement speed equals or more than 0
	 */
	public boolean getLeft() {
		return logSpeed < 0 ;
	}
}
