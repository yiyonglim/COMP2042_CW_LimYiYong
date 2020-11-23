package com.yiyonglim.Obstacle ;

import com.yiyonglim.Actor.Actor ;

import javafx.scene.image.Image ;

/**
 * Handle vehicle (obstacle)
 * If frog had collision with vehicle , frog will die
 * @author yiyonglim
 */
public class Vehicle extends Actor {

	private int vehicleSpeed ;
	
	/**
	 * Set up a vehicle
	 * @param image Vehicle's image
	 * @param xpos Vehicle's X coordinate
	 * @param ypos Vehicle's Y coordinate
	 * @param speed Vehicle's speed
	 * @param width Vehicle's width
	 * @param height Vehicle's height
	 */
	public Vehicle(String image, int xpos, int ypos, int speed, int width, int height) {
		
		setImage(new Image(image, width, height, true, true)) ;
		
		setX(xpos) ;
		setY(ypos) ;
		
		vehicleSpeed = speed ;
	}
	
	/**
	 * Set vehicle into action
	 */
	@Override
	public void act(long now) {
		
		move(vehicleSpeed , 0) ;
		
		// When whole vehicle exits left or right boundary , reset position of vehicle to its starting point
		if (getX() > 600 && vehicleSpeed > 0)
			setX(-200) ;
		if (getX() < -50 && vehicleSpeed < 0)
			setX(600) ;
	}
}
