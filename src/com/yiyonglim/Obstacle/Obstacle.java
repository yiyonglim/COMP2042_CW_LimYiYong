package com.yiyonglim.Obstacle ;

import com.yiyonglim.Actor.Actor ;

import javafx.scene.image.Image ;

/**
 * Handle obstacle (car , truck)
 * If frog had collision with obstacle , frog will die
 * @author yiyonglim
 */
public class Obstacle extends Actor {
	// Initialize obstacle's speed
	private int speed ;
	
	/**
	 * Set up an obstacle
	 * @param imageLink Obstacle's image
	 * @param xpos Obstacle's X coordinate
	 * @param ypos Obstacle's Y coordinate
	 * @param s Obstacle's speed
	 * @param w Obstacle's width
	 * @param h Obstacle's height
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		// Set obstacle's image
		setImage(new Image(imageLink, w, h, true, true)) ;
		
		// Set obstacle's starting point
		setX(xpos) ;
		setY(ypos) ;
		
		// Set obstacle's speed
		speed = s ;
	}
	
	/**
	 * Set obstacle into action
	 */
	@Override
	public void act(long now) {
		// Set obstacle's speed
		move(speed , 0) ;
		
		// When whole obstacle exits left or right boundary , reset position of obstacle to its starting point
		if (getX() > 600 && speed > 0)
			setX(-200) ;
		if (getX() < -50 && speed < 0)
			setX(600) ;
	}
}
