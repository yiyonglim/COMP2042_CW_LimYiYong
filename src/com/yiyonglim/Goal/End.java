package com.yiyonglim.Goal ;

import com.yiyonglim.Actor.Actor ;

import javafx.scene.image.Image ;

/**
 * Handle goal
 * A goal must be completed to proceed to new stage
 * @author yiyonglim
 */
public class End extends Actor{
	/**
	 * Set goal position
	 * @param x Goal's X coordinate
	 * @param y Goal's Y coordinate
	 */
	public End(int x, int y) {
		// Set goal position
		setX(x) ;
		setY(y) ;
		// Set goal image
		setImage(new Image("file:Resources/Goal/end1.png", 60, 60, true, true)) ;
	}
	
	/**
	 * Set completed goal image
	 */
	public void setEnd() {
		// Image changed after frog has completed the goal
		setImage(new Image("file:Resources/Goal/end2.png", 70, 70, true, true)) ;
	}
	
	@Override
	public void act(long now) {

	}
}
