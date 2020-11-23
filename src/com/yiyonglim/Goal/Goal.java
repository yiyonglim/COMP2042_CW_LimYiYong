package com.yiyonglim.Goal ;

import com.yiyonglim.Actor.Actor ;

import javafx.scene.image.Image ;

/**
 * Handle goal
 * A goal must be completed in each stage to proceed to new stage
 * @author yiyonglim
 */
public class Goal extends Actor{

	private boolean goalCompleted = false ;
	
	/**
	 * Set goal's position
	 * @param x Goal's X coordinate
	 * @param y Goal's Y coordinate
	 */
	public Goal(int x, int y) {
		
		setX(x) ;
		setY(y) ;
		
		setImage(new Image("file:Resources/Goal/end1.png", 60, 60, true, true)) ;
	}
	
	/**
	 * Set completed goal image
	 */
	public void setGoal() {

		setImage(new Image("file:Resources/Goal/end2.png", 70, 70, true, true)) ;
		
		goalCompleted = true ;
	}
	
	/**
	 * Check if the goal is completed
	 * @return Is the goal completed or not
	 */
	public boolean isCompleted() {
		
		return goalCompleted ;
	}
	
	@Override
	public void act(long now) {

	}
}
