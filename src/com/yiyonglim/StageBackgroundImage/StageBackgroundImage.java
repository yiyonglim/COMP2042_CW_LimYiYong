package com.yiyonglim.StageBackgroundImage ;

import com.yiyonglim.Actor.Actor;

import javafx.scene.image.Image ;

/**
 * Handle every stage's background image
 * @author yiyonglim
 */
public class StageBackgroundImage extends Actor {

	boolean isStageBackgroundImageSet = false ;
	
	/**
	 * Set up every stage's background image
	 * @param image Stage's background image
	 */
	public StageBackgroundImage(String image) {
		
		setImage(new Image(image, 600, 900, true, true)) ;
		
		isStageBackgroundImageSet = true ;
	}
	
	/**
	 * Return is stage's background image set
	 * @return Is stage's background image set
	 */
	public boolean isStageBackgroundImageSet() {
		
		return isStageBackgroundImageSet ;
	}
	
	@Override
	public void act(long now) {
		
	}
	
	
}
