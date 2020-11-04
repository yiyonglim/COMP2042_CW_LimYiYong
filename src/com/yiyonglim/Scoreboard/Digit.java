package com.yiyonglim.Scoreboard;

import com.yiyonglim.Actor.Actor;

import javafx.scene.image.Image ;

// Handle score board
public class Digit extends Actor {
	// Initialize size (square , 2D) of score board
	int dim ;
	// Initialize score board image
	Image im1 ;
	@Override
	// Score wont be changing constantly with time , "act" method is empty
	public void act(long now) {
		
	}
	
	// Initialize score board
	public Digit(int n, int dim, int x, int y) {
		// Set score board image
		im1 = new Image("file:Resources/Score/"+n+".png", dim, dim, true, true) ;
		setImage(im1) ;
		// Set score board position
		setX(x) ;
		setY(y) ;
	}
}
