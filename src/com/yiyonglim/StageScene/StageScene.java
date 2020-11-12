package com.yiyonglim.StageScene ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File ;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import com.yiyonglim.Character.Animal;
import com.yiyonglim.Scoreboard.Digit;
import com.yiyonglim.Stage.Stage2;
import com.yiyonglim.Stage.Stage3;
import com.yiyonglim.Stage.Stage4;
import com.yiyonglim.Stage.Stage5;
import com.yiyonglim.World.World;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media ;
import javafx.scene.media.MediaPlayer ;
import javafx.stage.Stage;

/**
 * Handle stage scene (pause game , end game , stag's music ,stage's progress , actors in every stages , score board , read / write leaderboard)
 * @author yiyonglim
 */
public class StageScene extends World {
	// Set up media player
	MediaPlayer mediaPlayer ;
	// Tracking stage progress
	public static int stage = 1 ;
	// Create timer
	AnimationTimer timer ;
	
	/**
	 * Pause game
	 */
	public StageScene() {
		
		// When user pressed "ESCAPE" , game paused
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			public void handle(KeyEvent event){
				
				if (event.getCode() == KeyCode.ESCAPE) {	
					mediaPlayer.pause();
					stop() ;
					
					// Show a window to indicate user that game is paused
					Alert alert1 = new Alert(AlertType.CONFIRMATION) ;
					
					alert1.setTitle("Pause") ;
            		alert1.setHeaderText("Having a break ? Let me tell you a joke") ;
            		alert1.setContentText(" How does a frog feel when he has a broken leg ?\n Unhoppy") ;
        
            		ButtonType buttonResume = new ButtonType("Resume");
					ButtonType buttonQuit = new ButtonType("Quit");
					
					alert1.getButtonTypes().setAll(buttonResume,buttonQuit);
            		
            		Optional<ButtonType> result = alert1.showAndWait();
            		
            		if (result.get() == buttonResume){
            			mediaPlayer.play();
            			start() ;
            		} else if (result.get() == buttonQuit) {
            			Stage stage = (Stage) getScene().getWindow();
            			stage.close();
            		} else {
            		    System.exit(0);
            		}
				}
			}
		});	
	}
	
	/**
	 * Create timer for each stage to track stage's progress
	 */
	public void createStageTimer() {

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	// Set score board
            	setNumber(Animal.points) ;
            	
            	// If user completed current stage , closed current stage and proceed to new stage
            	if(Animal.end == 1 && StageScene.stage == 1) {
            		
            		StageScene.stage ++ ;
            		
            		stopStageMusic() ;
            		
            		Stage currentStage = (Stage) getScene().getWindow();
            		currentStage.close();
            		
            		// Trigger startup of stage 2
            		Stage2 stage2 = new Stage2() ;
            		try {
						stage2.start(new Stage()) ;
					} catch (Exception e) {
						e.printStackTrace();
					}
            		
            	} else if (Animal.end == 2 && StageScene.stage == 2) {
            		
            		StageScene.stage ++ ;
            		
            		stopStageMusic() ;
            		
            		Stage currentStage = (Stage) getScene().getWindow();
            		currentStage.close();
            		
            		// Trigger startup of stage 3
            		Stage3 stage3 = new Stage3() ;
            		try {
						stage3.start(new Stage()) ;
					} catch (Exception e) {
						e.printStackTrace();
					}
            	} else if (Animal.end == 3 && StageScene.stage == 3) {
            		
            		StageScene.stage ++ ;
            		
            		stopStageMusic() ;
            		
            		Stage currentStage = (Stage) getScene().getWindow();
            		currentStage.close();
            		
            		// Trigger startup of stage 3
            		Stage4 stage4 = new Stage4() ;
            		try {
						stage4.start(new Stage()) ;
					} catch (Exception e) {
						e.printStackTrace();
					}
            	} else if (Animal.end == 4 && StageScene.stage == 4) {
            		
            		StageScene.stage ++ ;
            		
            		stopStageMusic() ;
            		
            		Stage currentStage = (Stage) getScene().getWindow();
            		currentStage.close();
            		
            		// Trigger startup of stage 3
            		Stage5 stage5 = new Stage5() ;
            		try {
						stage5.start(new Stage()) ;
					} catch (Exception e) {
						e.printStackTrace();
					}
            	} else if (Animal.end == 5 && StageScene.stage == 5) {
            		
            		StageScene.stage ++ ;
            		
            		// Print out in console to show that game has completed
            		System.out.print("END GAME !") ;
            		
            		// Stop music
            		stopStageMusic() ;
            		
            		// Initialize high score
            		int highScore = 0;
            		
            		// Obtain high score from leaderboard.txt
            		try {
            	        BufferedReader reader = new BufferedReader(new FileReader("leaderboard.txt"));
            	        String line = reader.readLine();
            	        // read the leaderboard.txt. line by line
            	        while (line != null)
            	        {
            	            try {
            	            	// Parse each line as an int
            	                int score = Integer.parseInt(line.trim());
            	                // Keep track of the largest
            	                if (score > highScore)
            	                { 
            	                    highScore = score; 
            	                }
            	            } catch (NumberFormatException e1) {
            	                System.err.println("ignoring invalid score: " + line);
            	            }
            	            line = reader.readLine();
            	        }
            	        reader.close();

            	    } catch (IOException ex) {
            	        System.err.println("ERROR reading high score from file");
            	    }
            		
            	    // Record score to leaderboard.txt
            		try {
            	        BufferedWriter output = new BufferedWriter(new FileWriter("leaderboard.txt", true));
            	        output.newLine();
            	        output.append("" + Animal.points);
            	        output.close();
            	    } catch (IOException ex1) {
            	        System.out.printf("ERROR writing score to file: %s\n", ex1);
            	    }
            		
            		// Set pop up window and show message and score obtained to user that the game has completed
            		Alert alert = new Alert(AlertType.INFORMATION) ;
            		
            	    if (Animal.points > highScore) {    
            	        alert.setTitle("You Have Won The Game!") ;
                		alert.setHeaderText("Your High Score: "+ Animal.points +"!") ;
                		alert.setContentText("You beat the previous high score " + highScore) ;
                		alert.show() ;
            	    } else if (Animal.points == highScore) {
            	        alert.setTitle("You Have Won The Game!") ;
                		alert.setHeaderText("Your High Score: "+Animal.points+"!") ;
                		alert.setContentText("So close! You tied the high score!") ;
                		alert.show() ;
            	    } else {
            	        alert.setTitle("You Have Won The Game!") ;
                		alert.setHeaderText("Your High Score: "+Animal.points+"!") ;
                		alert.setContentText("The all time high score was " + highScore) ;
                		alert.show() ;
            	    }
            	
            	    // When alert window is closed , close the whole program
            	    alert.setOnCloseRequest(event -> {
            	    	System.exit(0) ;
	                });
            	}
            }
        } ;
        timer.start();
    }
	
	/**
     * Score board
     * @param n Number of digit
     */
	public void setNumber(int n) {
    	// Move digits in score board to appropriate place when reach single-digit , double-digit and triple-digit....
    	int shift = 0 ;
    	
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10 ;
    		  n = d ;
    		  // Create and add score board to stage scene
    		  add(new Digit(k, 30, 570 - shift, 25)) ;
    		  shift += 30 ;
    		}
    }
	
	/**
	 * Play stage music
	 */
	public void playStageMusic() {
		String musicFile = "Resources/StageMusic/stage" + StageScene.stage + "Music.mp3";   
		// Connect music to media player
		Media sound = new Media(new File(musicFile).toURI().toString()) ;
		mediaPlayer = new MediaPlayer(sound) ;
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE) ;
	    mediaPlayer.play() ;
	}
	
	/**
	 * Stop music
	 */
	public void stopStageMusic() {
		mediaPlayer.stop() ;
	}
	
	@Override
	public void act(long now) {
		
	}

}
