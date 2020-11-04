package com.yiyonglim.Platform;

import com.yiyonglim.Actor.Actor;

import javafx.scene.image.Image ;

// Handle log
public class Log extends Actor {
	// Initialize log movement speed
	private double speed ;
	@Override
	// An "act" method is needed to keep log moving constantly with time
	public void act(long now) {
		// Set log movement speed
		move(speed , 0) ;
		// When whole log exits left or right boundary , reset the position of log to starting point
		if (getX() > 600 && speed > 0)
			setX(-180) ;
		if (getX() < -300 && speed < 0)
			setX(700) ;
	}
	
	// Initialize log
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		// Set log image
		setImage(new Image(imageLink, size, size, true, true)) ;
		// Set log starting point
		setX(xpos) ;
		setY(ypos) ;
		// Set log movement speed
		speed = s ;
	}
	
	// Return state of log
	public boolean getLeft() {
		return speed < 0 ;
	}
}
