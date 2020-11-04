package com.yiyonglim.Scene ;

import com.yiyonglim.Actor.Actor;

import javafx.scene.image.Image ;

// Handle background image
public class BackgroundImage extends Actor {

	@Override
	// Once map is set , it wont change with time , "act" method is empty
	public void act(long now) {
		
	}
	
	// Set map
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 900, true, true)) ;
	}
}
