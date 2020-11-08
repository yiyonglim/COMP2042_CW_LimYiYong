package com.yiyonglim.Main ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.yiyonglim.Character.Animal;
import com.yiyonglim.Goal.End;
import com.yiyonglim.Obstacle.Obstacle;
import com.yiyonglim.Platform.Log;
import com.yiyonglim.Platform.Turtle;
import com.yiyonglim.Platform.WetTurtle;
import com.yiyonglim.Scene.BackgroundImage;
import com.yiyonglim.Scene.MyStage;
import com.yiyonglim.Scoreboard.Digit;

import javafx.animation.AnimationTimer ;
import javafx.application.Application ;
import javafx.scene.Scene ;
import javafx.scene.control.Alert ;
import javafx.scene.control.Alert.AlertType ;
import javafx.stage.Stage ;

public class Main extends Application {
	// Create general timer, called when the JavaFX program started to run
	AnimationTimer timer ;
	// Initialize scene 
	MyStage background ;
	// Initialize frog, user control character
	Animal animal ;
	
	// Entry point
	public static void main(String[] args) {
		// Launch JavaFX runtime and JavaFX application
		launch(args) ;
	}

	@Override
	// Start scene
	public void start(Stage primaryStage) throws Exception {
	    
		// Create scene
		background = new MyStage() ;
		
	    // Create default window size when the game is started
	    Scene scene  = new Scene(background,600,800) ;

	    // Initialize map
		BackgroundImage froggerback = new BackgroundImage("file:Resources/GameBackground/iKogsKW.png") ;
	    
		// Add to scene
		background.add(froggerback) ;
		
		// Create actors (platform) and add to scene
		// Frog can stand on platform
		// First row of log (counting from top) (short log)
		background.add(new Log("file:Resources/Log/log3.png", 150, 0, 166, 0.75)) ;
		background.add(new Log("file:Resources/Log/log3.png", 150, 220, 166, 0.75)) ;
		background.add(new Log("file:Resources/Log/log3.png", 150, 440, 166, 0.75)) ;
		// Second row of log (counting from top) (long log)
		background.add(new Log("file:Resources/Log/logs.png", 300, 0, 276, -2)) ;
		background.add(new Log("file:Resources/Log/logs.png", 300, 400, 276, -2)) ;
		// Third row of log (counting from top) (short log)
		background.add(new Log("file:Resources/Log/log3.png", 150, 50, 329, 0.75)) ;
		background.add(new Log("file:Resources/Log/log3.png", 150, 270, 329, 0.75)) ;
		background.add(new Log("file:Resources/Log/log3.png", 150, 490, 329, 0.75)) ;
		// First row of turtle (counting from top)
		background.add(new Turtle(500, 376, -1, 130, 130)) ;
		background.add(new Turtle(300, 376, -1, 130, 130)) ;
		// First row of wet turtle (counting from top)
		background.add(new WetTurtle(600, 217, -1, 130, 130)) ;
		background.add(new WetTurtle(400, 217, -1, 130, 130)) ;
		background.add(new WetTurtle(200, 217, -1, 130, 130)) ;
		// Second row of wet turtle (counting from top)
		background.add(new WetTurtle(700, 376, -1, 130, 130)) ;
		// Set position of goals for frog to enter
		background.add(new End(13,96)) ;
		background.add(new End(141,96)) ;
		background.add(new End(141 + 141-13,96)) ;
		background.add(new End(141 + 141-13+141-13+1,96)) ;
		background.add(new End(141 + 141-13+141-13+141-13+3,96)) ;
		// Create frog (user control character)
		animal = new Animal("file:Resources/Frog/froggerUp.png") ;
		// Add frog to scene
		background.add(animal) ;
		
		// Create actors (obstacles -> car , truck) and add to scene
		// When frog hit by obstacles, it will die
		// First row of truck (counting from bottom)
		background.add(new Obstacle("file:Resources/Truck/truck1"+"Right.png", 0, 649, 1, 120, 120)) ;
		background.add(new Obstacle("file:Resources/Truck/truck1"+"Right.png", 300, 649, 1, 120, 120)) ;
		background.add(new Obstacle("file:Resources/Truck/truck1"+"Right.png", 600, 649, 1, 120, 120)) ;
		// Second row of truck (counting from bottom)
		background.add(new Obstacle("file:Resources/Truck/truck2Right.png", 0, 540, 1, 200, 200)) ;
		background.add(new Obstacle("file:Resources/Truck/truck2Right.png", 500, 540, 1, 200, 200)) ;
		// First row of car (counting from bottom)
		background.add(new Obstacle("file:Resources/Car/car1Left.png", 150, 704, -1, 50, 50)) ;
		background.add(new Obstacle("file:Resources/Car/car1Left.png", 500, 704, -1, 50, 50)) ;
		// Second row of car (counting from bottom)
		background.add(new Obstacle("file:Resources/Car/car1Left.png", 100, 597, -1, 50, 50)) ;
		background.add(new Obstacle("file:Resources/Car/car1Left.png", 250, 597, -1, 50, 50)) ;
		background.add(new Obstacle("file:Resources/Car/car1Left.png", 400, 597, -1, 50, 50)) ;
		background.add(new Obstacle("file:Resources/Car/car1Left.png", 550, 597, -1, 50, 50)) ;
		// Third row of car (counting from bottom)
		background.add(new Obstacle("file:Resources/Car/car1Left.png", 500, 490, -5, 50, 50)) ;
		
		// Create score board and add to scene
		background.add(new Digit(0, 30, 570, 25)) ;
		
		// Start scene
		background.start() ;
		
		// Set up the game 
		primaryStage.setScene(scene) ;
		
		// Show interface of game in window
		// If disabled , the game will still run but no window is shown
		primaryStage.show() ;
		
		// Start up whole JavaFX program
		// if disabled the program can still run, but will be throwing an exception when the user close the program
		start() ;  
	}
	
	// Create general timer for JavaFX program to run
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            // Handle completion of the game
            public void handle(long now) {
            	// Show score
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints()) ;
            	}
            	// End game when user completes all goals
            	if (animal.getStop()) {
            		// Print out in console to show that game has completed
            		System.out.print("STOPP:") ;
            		// Stop music
            		background.stopMusic() ;
            		// Stop JavaFX program
            		stop() ;
            		// Stop scene
            		background.stop() ;
            		// Set pop up window and show message to user that the game has completed
            		
            		// Writing highscore to file
            		int highScore = 0;
            		
            		try {
            	        BufferedReader reader = new BufferedReader(new FileReader("leaderboard.txt"));
            	        String line = reader.readLine();
            	        while (line != null)                 // read the score file line by line
            	        {
            	            try {
            	                int score = Integer.parseInt(line.trim());   // parse each line as an int
            	                if (score > highScore)                       // and keep track of the largest
            	                { 
            	                    highScore = score; 
            	                }
            	            } catch (NumberFormatException e1) {
            	                // ignore invalid scores
            	                //System.err.println("ignoring invalid score: " + line);
            	            }
            	            line = reader.readLine();
            	        }
            	        reader.close();

            	    } catch (IOException ex) {
            	        System.err.println("ERROR reading scores from file");
            	    }
            		
            	    // Record score to leaderboard.txt
            		try {
            	        BufferedWriter output = new BufferedWriter(new FileWriter("leaderboard.txt", true));
            	        output.newLine();
            	        output.append("" + animal.getPoints());
            	        output.close();

            	    } catch (IOException ex1) {
            	        System.out.printf("ERROR writing score to file: %s\n", ex1);
            	    }
            		
            	    // display the high score
            		
            		Alert alert = new Alert(AlertType.INFORMATION) ;
            		
            		
            	    if (animal.getPoints() > highScore) {    
            	        alert.setTitle("You Have Won The Game!") ;
                		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!") ;
                		alert.setContentText("You beat the previous high score " + highScore) ;
                		alert.show() ;
            	    } else if (animal.getPoints() == highScore) {
            	        alert.setTitle("You Have Won The Game!") ;
                		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!") ;
                		alert.setContentText("So close! You tied the high score!") ;
                		alert.show() ;
            	    } else {
            	        alert.setTitle("You Have Won The Game!") ;
                		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!") ;
                		alert.setContentText("The all time high score was " + highScore) ;
                		alert.show() ;
            	    }
            	
            	    // when alert window is closed , close the whole program
            	    alert.setOnCloseRequest(event -> {
            	    	System.exit(0) ;
            	    	
	                });
            	    
            	}
            }
        } ;
    }
	
	// Start up whole JavaFX program
	public void start() {
		// Play music
		background.playMusic() ;
		// Create general timer , called when the JavaFX program started to run
    	createTimer() ;
    	// Start timer
        timer.start() ;
    }

	// Stop whole JavaFX program
    public void stop() {
    	// Stop general timer , whole JavaFX program will stop
        timer.stop() ;
    }
    
    // Show score board
    public void setNumber(int n) {
    	// Move digits in score board to appropriate place when reach single-digit , double-digit and triple-digit....
    	int shift = 0 ;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10 ;
    		  n = d ;
    		  background.add(new Digit(k, 30, 570 - shift, 25)) ;
    		  shift += 30 ;
    		}
    }
}
