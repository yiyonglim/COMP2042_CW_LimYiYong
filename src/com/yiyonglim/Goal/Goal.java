package com.yiyonglim.Goal ;

import com.yiyonglim.Actor.Actor ;

import javafx.scene.image.Image ;

/**
 * Handle goal
 * A goal must be completed to proceed to new stage
 * @author yiyonglim
 */
public class Goal extends Actor{
	// Check if goal is completed
	boolean complete = false ;
	/**
	 * Set goal's position
	 * @param x Goal's X coordinate
	 * @param y Goal's Y coordinate
	 */
	public Goal(int x, int y) {
		// Set goal position
		setX(x) ;
		setY(y) ;
		// Set goal image
		setImage(new Image("file:Resources/Goal/end1.png", 60, 60, true, true)) ;
		complete = false ;
	}
	
	/**
	 * Set completed goal image
	 */
	public void setGoal() {
		// Image changed after frog has completed the goal
		setImage(new Image("file:Resources/Goal/end2.png", 70, 70, true, true)) ;
		complete = true ;
	}
	
	public boolean isCompleted() {
		return complete ;
	}
	
	@Override
	public void act(long now) {

	}
}
