package com.yiyonglim.Scoreboard;

import com.yiyonglim.Actor.Actor;

import javafx.scene.image.Image ;

/**
 * Handle digit . 
 * Digits together will form score board
 * @author yiyonglim
 */
public class Digit extends Actor {

	Image digit ;
	
	/**
	 * Set up a digit
	 * @param num Number of digit
	 * @param size Digit's size
	 * @param xpos Digit's X coordinate
	 * @param ypos Digit's Y coordinate
	 */
	public Digit(int num, int size, int xpos, int ypos) {

		digit = new Image("file:Resources/Score/"+num+".png", size, size, true, true) ;
		
		setImage(digit) ;
		
		setX(xpos) ;
		setY(ypos) ;
	}
	
	@Override
	public void act(long now) {
		
	}
}
