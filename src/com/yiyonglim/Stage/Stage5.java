package com.yiyonglim.Stage ;

import com.yiyonglim.Character.Animal;
import com.yiyonglim.Goal.End;
import com.yiyonglim.Obstacle.Obstacle;
import com.yiyonglim.Platform.Log;
import com.yiyonglim.Platform.WetTurtle;
import com.yiyonglim.Scoreboard.Digit;
import com.yiyonglim.StageBackgroundImage.StageBackgroundImage;
import com.yiyonglim.StageScene.StageScene;

import javafx.application.Application ;

import javafx.scene.Scene ;

import javafx.stage.Stage ;

/**
 * Handle Stage 5
 * @author yiyonglim
 */
public class Stage5 extends Application {
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
	 * Set up Stage 5
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
	    
		// Create stage scene
		stageScene = new StageScene() ;

	    // Create default window size when the game is started
	    Scene scene  = new Scene(stageScene,600,800) ;

	    // Initialize stage's background
		StageBackgroundImage froggerback = new StageBackgroundImage("file:Resources/StageBackground/Stage5Background.png") ;

		// Add to stage scene
		stageScene.add(froggerback) ;
		
		// Create and add platform to stage scene
		stageScene.add(new Log("file:Resources/Log/log3.png", 150, 0, 166, 0.75)) ;
		stageScene.add(new Log("file:Resources/Log/logs.png", 300, 150, 276, 0.75)) ;
		
		stageScene.add(new WetTurtle(200, 217, -1, 130, 130)) ;
		stageScene.add(new WetTurtle(425, 320, -1, 130, 130)) ;
		stageScene.add(new WetTurtle(225, 320, -1, 130, 130)) ;
		stageScene.add(new WetTurtle(25, 320, -1, 130, 130)) ;
		stageScene.add(new WetTurtle(515, 376, -1, 130, 130)) ;
		stageScene.add(new WetTurtle(315, 376, -1, 130, 130)) ;
		stageScene.add(new WetTurtle(115, 376, -1, 130, 130)) ;
		
		// Set goal's position for frog to enter
		stageScene.add(new End(520,105));
		
		// Create frog (user control character)
		animal = new Animal("file:Resources/Frog/frogUp1.png") ;
		
		// Add frog to stage scene
		stageScene.add(animal) ;
		
		// Create and add obstacle to stage scene
		stageScene.add(new Obstacle("file:Resources/Truck/truck2Right.png", 300, 435, 0, 200, 200)) ;
		stageScene.add(new Obstacle("file:Resources/Truck/truck2Right.png", 50, 435, 0, 200, 200)) ;
		stageScene.add(new Obstacle("file:Resources/Truck/truck2Right.png", 0, 649, 0, 200, 200)) ;
		stageScene.add(new Obstacle("file:Resources/Truck/truck2Right.png", 275, 649, 0, 200, 200)) ;
		stageScene.add(new Obstacle("file:Resources/Truck/truck2Right.png", 500, 540, 0, 200, 200)) ;
		stageScene.add(new Obstacle("file:Resources/Truck/truck2Right.png", 200, 540, 0, 200, 200)) ;
		stageScene.add(new Obstacle("file:Resources/Truck/truck2Right.png", 0, 540, 0, 200, 200)) ;
		
		stageScene.add(new Obstacle("file:Resources/Car/carLeft.png", 500, 490, -10, 50, 50)) ;
		stageScene.add(new Obstacle("file:Resources/Car/carLeft.png", 250, 597, -3, 50, 50)) ;
		stageScene.add(new Obstacle("file:Resources/Car/carLeft.png", 100, 704, -15, 50, 50)) ;
		stageScene.add(new Obstacle("file:Resources/Car/carLeft.png", 300, 704, -15, 50, 50)) ;
		
		// Create and add score board to stage scene
		stageScene.add(new Digit(0, 30, 570, 25)) ;
		
		// Start stage scene
		stageScene.start() ;
		
		// Set up game window
		primaryStage.setScene(scene) ;
        primaryStage.setTitle("STAGE 5");
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