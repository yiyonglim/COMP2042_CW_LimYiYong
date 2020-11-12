package com.yiyonglim.Stage ;

import com.yiyonglim.Character.Animal;
import com.yiyonglim.Goal.End;
import com.yiyonglim.Obstacle.Obstacle;
import com.yiyonglim.Platform.Log;
import com.yiyonglim.Platform.Turtle;
import com.yiyonglim.Scoreboard.Digit;
import com.yiyonglim.StageBackgroundImage.StageBackgroundImage;
import com.yiyonglim.StageScene.StageScene;

import javafx.application.Application ;

import javafx.scene.Scene ;

import javafx.stage.Stage ;

/**
 * Handle Stage 1 
 * @author yiyonglim
 *
 */
public class Stage1 extends Application {
	// Initialize stage scene 
	StageScene stageScene ;
	// Initialize frog, user control character
	Animal animal ;
	
	/**
	 * Start javafx program
	 * @param args It is not fixed and user can use any name in place of it
	 */
	public static void main(String[] args) {
		launch(args) ;
	}

	/**
	 * Set up Stage 1
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
	    
		// Create stage scene
		stageScene = new StageScene() ;

	    // Create default window size when game is started
	    Scene scene  = new Scene(stageScene,600,800) ;

	    // Initialize stage's background
		StageBackgroundImage froggerback = new StageBackgroundImage("file:Resources/StageBackground/Stage1Background.png") ;

		// Add to stage scene
		stageScene.add(froggerback) ;		
		
		// Create and add platform to stage scene
		stageScene.add(new Log("file:Resources/Log/log3.png", 150, 0, 166, 0.75)) ;
		stageScene.add(new Log("file:Resources/Log/log3.png", 150, 220, 166, 0.75)) ;
		stageScene.add(new Log("file:Resources/Log/log3.png", 150, 440, 166, 0.75)) ;
		stageScene.add(new Log("file:Resources/Log/log3.png", 150, 50, 329, 0.75)) ;
		stageScene.add(new Log("file:Resources/Log/log3.png", 150, 270, 329, 0.75)) ;
		stageScene.add(new Log("file:Resources/Log/log3.png", 150, 490, 329, 0.75)) ;
		stageScene.add(new Log("file:Resources/Log/logs.png", 300, 0, 276, -2)) ;
		stageScene.add(new Log("file:Resources/Log/logs.png", 300, 400, 276, -2)) ;

		stageScene.add(new Turtle(500, 376, -1, 130, 130)) ;
		stageScene.add(new Turtle(300, 376, -1, 130, 130)) ;
		stageScene.add(new Turtle(600, 217, -1, 130, 130)) ;
		stageScene.add(new Turtle(400, 217, -1, 130, 130)) ;
		stageScene.add(new Turtle(200, 217, -1, 130, 130)) ;
		stageScene.add(new Turtle(700, 376, -1, 130, 130)) ;
		
		// Set goal's position for frog to enter
		stageScene.add(new End(10,105));
		
		// Create frog (user control character)
		animal = new Animal("file:Resources/Frog/frogUp1.png") ;
		
		// Add frog to stage scene
		stageScene.add(animal) ;
		
		// Create and add obstacle to stage scene
		stageScene.add(new Obstacle("file:Resources/Truck/truck1Right.png", 600, 649, 1, 120, 120)) ;
		stageScene.add(new Obstacle("file:Resources/Truck/truck2Right.png", 300, 540, 1, 200, 200)) ;
		
		stageScene.add(new Obstacle("file:Resources/Car/carLeft.png", 150, 704, -1, 50, 50)) ;
		stageScene.add(new Obstacle("file:Resources/Car/carLeft.png", 500, 704, -1, 50, 50)) ;
		stageScene.add(new Obstacle("file:Resources/Car/carLeft.png", 100, 597, -1, 50, 50)) ;
		stageScene.add(new Obstacle("file:Resources/Car/carLeft.png", 550, 597, -1, 50, 50)) ;
		stageScene.add(new Obstacle("file:Resources/Car/carLeft.png", 500, 490, -5, 50, 50)) ;
		
		// Create and add score board to stage scene
		stageScene.add(new Digit(0, 30, 570, 25)) ;
		
		// Start stage scene
		stageScene.start() ;
		
		// Set up game window
		primaryStage.setScene(scene) ;
        primaryStage.setTitle("STAGE 1");
		primaryStage.setResizable(false);
		primaryStage.show() ;

		// Start current stage
		start() ;
	}
	
	/**
	 * Start current stage
	 */
	public void start() {
		// Create stage timer
    	stageScene.createStageTimer() ;
		// Play stage music
		stageScene.playStageMusic() ;
		
	}
}
