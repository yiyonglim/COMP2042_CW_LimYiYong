package com.yiyonglim.Scoreboard;

import com.yiyonglim.Actor.Actor;

import javafx.scene.image.Image ;

/**
 * Handle digit
 * Digit together will form score board
 * @author yiyonglim
 *
 */
public class Digit extends Actor {
	// Initialize size (square , 2D) of digit
	int dim ;
	// Initialize digit
	Image im1 ;
	
	/**
	 * Initialize digit
	 * @param n Number of digit
	 * @param dim Digit's size
	 * @param x Digit's X coordinate
	 * @param y Digit's Y coordinate
	 */
	public Digit(int n, int dim, int x, int y) {
		// Set digit's image
		im1 = new Image("file:Resources/Score/"+n+".png", dim, dim, true, true) ;
		setImage(im1) ;
		
		// Set digit position in score board
		setX(x) ;
		setY(y) ;
	}
	
	@Override
	public void act(long now) {
		
	}
}
