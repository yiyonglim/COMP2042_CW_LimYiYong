package com.yiyonglim.StageBackgroundImage ;

import com.yiyonglim.Actor.Actor;

import javafx.scene.image.Image ;

/**
 * Handle every stage's background image
 * @author yiyonglim
 */
public class StageBackgroundImage extends Actor {
	// Track is stage's background image is set
	boolean isSet = false ;
	/**
	 * Set every stage's background image (Stage1 , Stage2 , Stage3 , Stage4 , Stage5)
	 * @param imageLink Stage's background image
	 */
	public StageBackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 900, true, true)) ;
		isSet = true ;
	}
		
	@Override
	public void act(long now) {
		
	}
	
	public boolean isSet() {
		return isSet ;
	}
}
