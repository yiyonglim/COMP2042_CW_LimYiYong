package com.yiyonglim.StageScene ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File ;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

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
 * Handle stage scene . 
 * Stage scene consist of pause game , end game , quit game , stage's music , stage's progress , actors in every stages , score board , read / write leaderboard.txt
 * @author yiyonglim
 */
public class StageScene extends World {

	AnimationTimer stageTimer ;
	
	MediaPlayer stageMusic ;

	public static int stageCompleted = 0 ;
	public static int currentStage = 1 ;
	public static int points = 0 ;
	
	/**
	 * Handle pause game
	 */
	public StageScene() {
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			public void handle(KeyEvent event){
				
				if (event.getCode() == KeyCode.ESCAPE) {
					
					stageMusic.pause();
					stop() ;
					
					Alert pauseAlert = new Alert(AlertType.CONFIRMATION) ;
					pauseAlert.setTitle("Pause") ;
            		pauseAlert.setHeaderText("Having a break ? Let me tell you a joke") ;
            		pauseAlert.setContentText(" How does a frog feel when he has a broken leg ?\n Unhoppy") ;
        
            		ButtonType resume = new ButtonType("Resume");
					ButtonType quit = new ButtonType("Quit");
					
					pauseAlert.getButtonTypes().setAll(resume,quit);
            		
            		Optional<ButtonType> result = pauseAlert.showAndWait();
            		
            		if (result.get() == resume){
            			
            			stageMusic.play();
            			start() ;
            		} else if (result.get() == quit) {
            			
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
		
        stageTimer = new AnimationTimer() {
        	
            @Override
            public void handle(long now) {

            	setScoreBoard(points) ;
            	
            	// If user completed current stage , closed current stage and start new stage
            	if(stageCompleted == 1 && currentStage == 1) {
            		
            		currentStage ++ ;
            		
            		stopStageMusic() ;
            		
            		try {
            			
            			getChildren().clear();
            			
            			Stage currentStage = (Stage) getScene().getWindow();
            			currentStage.close();
            			System.gc();
            		} catch (NullPointerException e) {
            			
            			System.out.println("Error closing stage 1 !") ;
            		}
            		            		
            		Stage2 stage2 = new Stage2() ;
            		try {
            			
						stage2.start(new Stage()) ;
					} catch (Exception e) {
						
						System.out.println("Error starting stage 2 !");
					}
            		
            	} else if (stageCompleted == 2 && currentStage == 2) {
            		
            		currentStage ++ ;
            		
            		stopStageMusic() ;
            		
            		try {
            			
            			getChildren().clear();
            			
            			Stage currentStage = (Stage) getScene().getWindow();
                		currentStage.close();
            			System.gc();
            		} catch (NullPointerException e) {
            			
            			System.out.println("Error closing stage 2 !") ;
            		}
            		
            		Stage3 stage3 = new Stage3() ;
            		try {
            			
						stage3.start(new Stage()) ;
					} catch (Exception e) {
						
						System.out.println("Error starting stage 3 !") ;
					}
            	} else if (stageCompleted == 3 && currentStage == 3) {
            		
            		currentStage ++ ;
            		
            		stopStageMusic() ;
            		
            		try {
            			
            			getChildren().clear();
            			
            			Stage currentStage = (Stage) getScene().getWindow();
                		currentStage.close();
            			System.gc();
            		} catch (NullPointerException e) {
            			
            			System.out.println("Error closing stage 3 !") ;
            		}
            		
            		Stage4 stage4 = new Stage4() ;
            		try {
            			
						stage4.start(new Stage()) ;
					} catch (Exception e) {
						
						System.out.println("Error starting stage 4 !") ;
					}
            	} else if (stageCompleted == 4 && currentStage == 4) {
            		
            		currentStage ++ ;
            		
            		stopStageMusic() ;
            		
            		try {
            			
            			getChildren().clear();
            			
            			Stage currentStage = (Stage) getScene().getWindow();
                		currentStage.close();
            			System.gc();
            		} catch (NullPointerException e) {
            			
            			System.out.println("Error closing stage 4 !") ;
            		}
            		
            		Stage5 stage5 = new Stage5() ;
            		try {
            			
						stage5.start(new Stage()) ;
					} catch (Exception e) {
						
						System.out.println("Error starting stage 5 !") ;
					}
            	} else if (stageCompleted == 5 && currentStage == 5) {
            		
            		currentStage ++ ;

            		stopStageMusic() ;
            		
            		stop() ;
            		         		
            		// Obtain highest score from leaderboard.txt and compare it with the score obtained by user
            		int highScore = 0;
            		
            		try {
            			
            	        BufferedReader reader = new BufferedReader(new FileReader("leaderboard.txt"));
            	        String line = reader.readLine();

            	        while (line != null) {
            	        	
            	            try {
            	            	
            	                int score = Integer.parseInt(line.trim());

            	                if (score > highScore) { 
            	                	
            	                    highScore = score; 
            	                }
            	            } catch (NumberFormatException e1) {
            	            	
            	                System.err.println("Ignoring invalid score: " + line);
            	            }
            	            
            	            line = reader.readLine();
            	        }
            	        
            	        reader.close();

            	    } catch (IOException ex) {
            	    	
            	        System.err.println("Error reading high score from leaderboard.txt");
            	    }
            		
            		try {
            			
            	        BufferedWriter output = new BufferedWriter(new FileWriter("leaderboard.txt", true));
            	        output.newLine();
            	        output.append("" + points);
            	        output.close();
            	    } catch (IOException e) {
            	    	
            	        System.out.printf("Error writing score to file: %s\n", e);
            	    }
            		
            		Alert endGameAlert = new Alert(AlertType.INFORMATION) ;
            		
            	    if (points > highScore) {
            	    	
            	        endGameAlert.setTitle("You Have Won The Game!") ;
                		endGameAlert.setHeaderText("Your High Score: "+ points +"!") ;
                		endGameAlert.setContentText("You beat the previous high score " + highScore) ;
                		endGameAlert.show() ;
            	    } else if (points == highScore) {
            	    	
            	        endGameAlert.setTitle("You Have Won The Game!") ;
                		endGameAlert.setHeaderText("Your High Score: "+points+"!") ;
                		endGameAlert.setContentText("So close! You tied the high score!") ;
                		endGameAlert.show() ;
            	    } else {
            	    	
            	        endGameAlert.setTitle("You Have Won The Game!") ;
                		endGameAlert.setHeaderText("Your High Score: "+points+"!") ;
                		endGameAlert.setContentText("The all time high score was " + highScore) ;
                		endGameAlert.show() ;
            	    }
            	
            	    endGameAlert.setOnCloseRequest(event -> {
            	    	
            	    	System.exit(0) ;
	                });
            	}
            }
        } ;
        
        stageTimer.start();
    }
	
	/**
     * Set up Score board
     * @param number Score
     */
	public void setScoreBoard(int number) {
		
    	// Shift digits in score board to appropriate place when reach single-digit , double-digit , triple-digit and so on
    	int horizontalShift = 0 ;
    	
    	while (number > 0) {
    		
    		  int tens = number / 10 ;
    		  int ones = number - tens * 10 ;
    		  number = tens ;

    		  add(new Digit(ones, 30, 570 - horizontalShift, 25)) ;
    		  horizontalShift += 30 ;
    	}
    	
    }
	
	/**
	 * Play stage music
	 */
	public void playStageMusic() {
		
		String stageMusicFile = "Resources/StageMusic/stage" + StageScene.currentStage + "Music.mp3";   
		Media music = new Media(new File(stageMusicFile).toURI().toString()) ;
		stageMusic = new MediaPlayer(music) ;
		stageMusic.setCycleCount(MediaPlayer.INDEFINITE) ;
	    stageMusic.play() ;
	}
	
	/**
	 * Stop stage music
	 */
	public void stopStageMusic() {
		
		stageMusic.stop() ;
	}
	
	@Override
	public void act(long now) {
		
	}

}
