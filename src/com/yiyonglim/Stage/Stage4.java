package com.yiyonglim.Stage ;

import com.yiyonglim.Character.Animal;
import com.yiyonglim.Goal.Goal;
import com.yiyonglim.Obstacle.Vehicle;
import com.yiyonglim.Platform.Log;
import com.yiyonglim.Platform.Turtle;
import com.yiyonglim.Platform.WetTurtle;
import com.yiyonglim.Scoreboard.Digit;
import com.yiyonglim.StageBackgroundImage.StageBackgroundImage;
import com.yiyonglim.StageScene.StageScene;

import javafx.application.Application ;

import javafx.scene.Scene ;

import javafx.stage.Stage ;

/**
 * Handle Stage 4
 * @author yiyonglim
 */
public class Stage4 extends Application {

	StageScene stageScene ;

	Animal frog ;

	/**
	 * Set up Stage 4
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
	    
		stageScene = new StageScene() ;

	    Scene scene  = new Scene(stageScene,600,800) ;

		StageBackgroundImage stage4Background = new StageBackgroundImage("file:Resources/StageBackground/stage4Background.png") ;
		stageScene.add(stage4Background) ;
		
		stageScene.add(new Log("file:Resources/Log/log3.png", 150, 220, 166, 0.75)) ;
		stageScene.add(new Log("file:Resources/Log/log3.png", 150, 440, 166, 0.75)) ;
		stageScene.add(new Log("file:Resources/Log/logs.png", 300, 0, 276, -2)) ;
		stageScene.add(new Log("file:Resources/Log/log3.png", 150, 50, 329, 0.75)) ;

		stageScene.add(new Turtle(500, 376, -1, 130, 130)) ;
		stageScene.add(new Turtle(300, 376, -1, 130, 130)) ;

		stageScene.add(new WetTurtle(600, 217, -1, 130, 130)) ;
		stageScene.add(new WetTurtle(200, 217, -1, 130, 130)) ;
		stageScene.add(new WetTurtle(700, 376, -1, 130, 130)) ;
		
		stageScene.add(new Goal(393,105));
		
		frog = new Animal("file:Resources/Frog/frogUp1.png") ;
		stageScene.add(frog) ;
		
		stageScene.add(new Vehicle("file:Resources/Truck/truck1Right.png", 600, 649, 5, 120, 120)) ;
		stageScene.add(new Vehicle("file:Resources/Truck/truck2Right.png", 300, 540, 8, 200, 200)) ;
		
		stageScene.add(new Vehicle("file:Resources/Car/carLeft.png", 150, 704, -5, 50, 50)) ;
		stageScene.add(new Vehicle("file:Resources/Car/carLeft.png", 500, 704, -5, 50, 50)) ;
		stageScene.add(new Vehicle("file:Resources/Car/carLeft.png", 100, 597, -5, 50, 50)) ;
		stageScene.add(new Vehicle("file:Resources/Car/carLeft.png", 550, 597, -5, 50, 50)) ;
		stageScene.add(new Vehicle("file:Resources/Car/carLeft.png", 500, 490, -5, 50, 50)) ;
		stageScene.add(new Vehicle("file:Resources/Car/carLeft.png", 700, 490, -5, 50, 50)) ;
		
		stageScene.add(new Digit(0, 30, 570, 25)) ;
		
		stageScene.start() ;
		
		primaryStage.setScene(scene) ;
        primaryStage.setTitle("STAGE 4");
		primaryStage.setResizable(false);
		primaryStage.show() ;

		start() ;  
	}
	
	/**
	 * Start current stage
	 */
	public void start() {

    	stageScene.createStageTimer() ;
		stageScene.playStageMusic() ;
    }
	
	/**
	 * Start javafx program
	 * @param args Arguments passed by command line while starting a program
	 */
	public static void main(String[] args) {
		
		launch(args) ;
	}
}