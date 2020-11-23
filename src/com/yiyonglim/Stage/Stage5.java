package com.yiyonglim.Stage ;

import com.yiyonglim.Character.Animal;
import com.yiyonglim.Goal.Goal;
import com.yiyonglim.Obstacle.Vehicle;
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

	StageScene stageScene ;

	Animal frog ;

	/**
	 * Set up Stage 5
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
	    
		stageScene = new StageScene() ;

	    Scene scene  = new Scene(stageScene,600,800) ;

		StageBackgroundImage stage5Background = new StageBackgroundImage("file:Resources/StageBackground/stage5Background.png") ;
		stageScene.add(stage5Background) ;
		
		stageScene.add(new Log("file:Resources/Log/log3.png", 150, 0, 166, 0.75)) ;
		stageScene.add(new Log("file:Resources/Log/logs.png", 300, 150, 276, 0.75)) ;
		
		stageScene.add(new WetTurtle(200, 217, -1, 130, 130)) ;
		stageScene.add(new WetTurtle(425, 320, -1, 130, 130)) ;
		stageScene.add(new WetTurtle(225, 320, -1, 130, 130)) ;
		stageScene.add(new WetTurtle(25, 320, -1, 130, 130)) ;
		stageScene.add(new WetTurtle(515, 376, -1, 130, 130)) ;
		stageScene.add(new WetTurtle(315, 376, -1, 130, 130)) ;
		stageScene.add(new WetTurtle(115, 376, -1, 130, 130)) ;
		
		stageScene.add(new Goal(520,105));
		
		frog = new Animal("file:Resources/Frog/frogUp1.png") ;
		stageScene.add(frog) ;
		
		stageScene.add(new Vehicle("file:Resources/Truck/truck2Right.png", 300, 435, 0, 200, 200)) ;
		stageScene.add(new Vehicle("file:Resources/Truck/truck2Right.png", 50, 435, 0, 200, 200)) ;
		stageScene.add(new Vehicle("file:Resources/Truck/truck2Right.png", 0, 649, 0, 200, 200)) ;
		stageScene.add(new Vehicle("file:Resources/Truck/truck2Right.png", 275, 649, 0, 200, 200)) ;
		stageScene.add(new Vehicle("file:Resources/Truck/truck2Right.png", 500, 540, 0, 200, 200)) ;
		stageScene.add(new Vehicle("file:Resources/Truck/truck2Right.png", 200, 540, 0, 200, 200)) ;
		stageScene.add(new Vehicle("file:Resources/Truck/truck2Right.png", 0, 540, 0, 200, 200)) ;
		
		stageScene.add(new Vehicle("file:Resources/Car/carLeft.png", 500, 490, -10, 50, 50)) ;
		stageScene.add(new Vehicle("file:Resources/Car/carLeft.png", 250, 597, -3, 50, 50)) ;
		stageScene.add(new Vehicle("file:Resources/Car/carLeft.png", 100, 704, -15, 50, 50)) ;
		stageScene.add(new Vehicle("file:Resources/Car/carLeft.png", 300, 704, -15, 50, 50)) ;
		
		stageScene.add(new Digit(0, 30, 570, 25)) ;
		
		stageScene.start() ;

		primaryStage.setScene(scene) ;
        primaryStage.setTitle("STAGE 5");
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