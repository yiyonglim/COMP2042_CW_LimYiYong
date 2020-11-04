package com.yiyonglim.Character ;

import java.util.ArrayList ;

import com.yiyonglim.Actor.Actor;
import com.yiyonglim.Goal.End;
import com.yiyonglim.Obstacle.Obstacle;
import com.yiyonglim.Platform.Log;
import com.yiyonglim.Platform.Turtle;
import com.yiyonglim.Platform.WetTurtle;

import javafx.event.EventHandler ;

import javafx.scene.image.Image ;
import javafx.scene.input.KeyCode ;
import javafx.scene.input.KeyEvent ;
import javafx.stage.Stage;

// Handle frog
// Frog --> user control character
public class Animal extends Actor {
	// Initialize image of frog
	Image imgW1 ;
	Image imgA1 ;
	Image imgS1 ;
	Image imgD1 ;
	Image imgW2 ;
	Image imgA2 ;
	Image imgS2 ;
	Image imgD2 ;
	// Initialize starting score
	int points = 0 ;
	// Initialize number of goals completed
	int end = 0 ;
	// Initialize frog death by car animation
	int carD = 0 ;
	// Set frog size (square)
	int imgSize = 40 ;
	// Set jump distance of frog (forward , backward)
	double movement = 13.3333333*2 ;
	// Set jump distance of frog (left , right)
	double movementX = 10.666666*2 ;
	// Initialize limit line for scoring , score will be added when passing it 
	double w = 700 ;
	// Initialize jumping state of frog , two actions are done when frog jumps
	// true -> fold legs , false -> unfold legs
	private boolean second = false ;
	// Initialize movement state of frog
	// true -> stationary , false -> moving	
	boolean noMove = false ;
	// Initialize death state of frog (death by having collision with truck or car)
	// true -> death by car , false -> not death by car
	boolean carDeath = false ;
	// Initialize death state of frog (death by falling into the water)
	// true -> death by water , false -> not death by water
	boolean waterDeath = false ;
	// Either carDeath or waterDeath can be true at the same time
	// Initialize state of score
	// true -> score is changed , false -> score not being changed
	boolean changeScore = false ;
	
	// Track goals , save all the goals' coordinates into array
	ArrayList<End> inter = new ArrayList<End>() ;
	
	// Create user control character
	public Animal(String imageLink) {
		// Set frog image
		setImage(new Image(imageLink, imgSize, imgSize, true, true)) ;
		// Set starting point of frog
		setX(300) ;
		setY(679.8+movement) ;
		// Images of frog moving
		imgW1 = new Image("file:Resources/Frog/froggerUp.png", imgSize, imgSize, true, true) ;
		imgA1 = new Image("file:Resources/Frog/froggerLeft.png", imgSize, imgSize, true, true) ;
		imgS1 = new Image("file:Resources/Frog/froggerDown.png", imgSize, imgSize, true, true) ;
		imgD1 = new Image("file:Resources/Frog/froggerRight.png", imgSize, imgSize, true, true) ;
		imgW2 = new Image("file:Resources/Frog/froggerUpJump.png", imgSize, imgSize, true, true) ;
		imgA2 = new Image("file:Resources/Frog/froggerLeftJump.png", imgSize, imgSize, true, true) ;
		imgS2 = new Image("file:Resources/Frog/froggerDownJump.png", imgSize, imgSize, true, true) ;
		imgD2 = new Image("file:Resources/Frog/froggerRightJump.png", imgSize, imgSize, true, true) ;
		
		// Detect keys pressed by user and react accordingly
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			// How pressed key is handled
			public void handle(KeyEvent event) {
				// Exit game
				if (event.getCode() == KeyCode.ESCAPE) {	  
					Stage stage = (Stage) getScene().getWindow();
					stage.close();

	            }
				// Frog movement
				// Check current movement state of frog (stationary or moving)
				if (noMove) {
					
				}
				else {
				// Check which key is pressed and response respectively
				// Set jumping state of frog (extend or fold)
				if (second) { // Move upward
					if (event.getCode() == KeyCode.W) {	  
		                move(0, -movement) ;
		                // Change state of score
		                changeScore = false ;
		                setImage(imgW1) ;
		                second = false ;
		            } // Move left
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-movementX, 0) ;
		            	 setImage(imgA1) ;
		            	 second = false ;
		            } // Move backward
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, movement) ;
		            	 setImage(imgS1) ;
		            	 second = false ;
		            } // Move right
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(movementX, 0) ;
		            	 setImage(imgD1) ;
		            	 second = false ;
		            }
				} // Move upward
				else if (event.getCode() == KeyCode.W) {	            	
	                move(0, -movement) ;
	                setImage(imgW2) ;
	                second = true ;
	            } // Move Left
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0) ;
	            	 setImage(imgA2) ;
	            	 second = true ;
	            } // Move backward
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement) ;
	            	 setImage(imgS2) ;
	            	 second = true ;
	            } // Move right
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0) ;
	            	 setImage(imgD2) ;
	            	 second = true ;
	            }
				}
			}
		}) ;	
		
		// Frog movement when user release the key (W , A , S , D)
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			// How released key is handled
			public void handle(KeyEvent event) {
				// Check current movement state of frog (stationary or moving)
				if (noMove) {
					
				}
				else {
				// Check which key is released and response respectively
				// Set jumping state of frog (extend or fold)
				// Move upward
				if (event.getCode() == KeyCode.W) {
					// Check limit line for scoring , score will be added when passing it
					if (getY() < w) {
						w = getY() ;
						points += 10 ;
						// Change state of score
						changeScore = true ;
					}
	                	move(0, -movement) ;
	                	setImage(imgW1) ;
	                	second = false ;
	            } // Move right
	            else if (event.getCode() == KeyCode.A) {	            	
	            	move(-movementX, 0) ;
	            	setImage(imgA1) ;
	            	second = false ;
	            } // Move backward
	            else if (event.getCode() == KeyCode.S) {	            	
	            	move(0, movement) ;
	            	setImage(imgS1) ;
	            	second = false ;
	            } // Move right
	            else if (event.getCode() == KeyCode.D) {	            	
	            	move(movementX, 0) ;
	            	setImage(imgD1) ;
	            	second = false ;
	            }
				}
			}
			
		});
	}
	
	@Override
	// How frog acts in game
	public void act(long now) {
		// How frog acts when hit boundaries
		// When the frog hit bottom or top boundary  , it will be reset to starting point
		if (getY() < 0 || getY() > 734) {
			setX(300) ;
			setY(679.8 + movement) ;
		}
		// When the frog hit left or right boundary , it will be pushed back
		if (getX() < 0) {
			move(movement*2, 0) ;
		}
		else if(getX() > 570) {
			move(-movement*2, 0) ;
		}
		
		// How frog acts when death by car
		if (carDeath) {
			// Set movement state of frog to stationary
			noMove = true ;
			// Show death animation
			// carD is used to mimic death animation frame by frame
			if ((now)% 11 == 0) {
				carD++ ;
			}
			if (carD == 1) {
				setImage(new Image("file:Resources/Death/cardeath1.png", imgSize, imgSize, true, true)) ;
			}
			if (carD == 2) {
				setImage(new Image("file:Resources/Death/cardeath2.png", imgSize, imgSize, true, true)) ;
			}
			if (carD == 3) {
				setImage(new Image("file:Resources/Death/cardeath3.png", imgSize, imgSize, true, true)) ;
			}
			if (carD == 4) {
				// Reset position of frog to starting point
				setX(300) ;
				setY(679.8+movement) ;
				// Reset death state of frog
				carDeath = false ;
				carD = 0 ;
				// Reset image of frog (dead -> alive)
				setImage(new Image("file:Resources/Frog/froggerUp.png", imgSize, imgSize, true, true)) ;
				// Reset movement state of frog
				noMove = false ;
				// Deduction of score
				// 50 score for one death , if the score isnt enough to be deducted , deduction is denied
				if (points > 50) {
					points -= 50 ;
					// Change state of score
					changeScore = true ;
				}
			}
			
		}
		
		// How frog acts when death by water
		if (waterDeath) {
			// Set movement state of frog to stationary
			noMove = true ;
			// Show death animation
			// carD is used to mimic death animation frame by frame
			if ((now)% 11 == 0) {
				carD++;
			}
			if (carD == 1) {
				setImage(new Image("file:Resources/Death/waterdeath1.png", imgSize,imgSize , true, true)) ;
			}
			if (carD == 2) {
				setImage(new Image("file:Resources/Death/waterdeath2.png", imgSize,imgSize , true, true)) ;
			}
			if (carD == 3) {
				setImage(new Image("file:Resources/Death/waterdeath3.png", imgSize,imgSize , true, true)) ;
			}
			if (carD == 4) {
				setImage(new Image("file:Resources/Death/waterdeath4.png", imgSize,imgSize , true, true)) ;
			}
			if (carD == 5) {
				// Reset position of frog to starting point
				setX(300) ;
				setY(679.8+movement) ;
				// Reset the death state of frog
				waterDeath = false ;
				carD = 0 ;
				// Reset the image of the frog (dead -> alive)
				setImage(new Image("file:Resources/Frog/froggerUp.png", imgSize, imgSize, true, true)) ;
				// Reset movement state of the frog
				noMove = false ;
				// Deduction of score
				// 50 score for one death , if the score isnt enough to be deducted , deduction is denied
				if (points>50) {
					points-=50 ;
					// Change state of score
					changeScore = true ;
				}
			}
			
		}
		
		// If frog had collision with obstacle (car , truck) , it will be dead
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true ;
		}
		// If frog had collision with platform (log , turtle , wet turtle)
		// When frog step on log , stay on and move with it
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0) ;
			else
				move (.75,0) ;
		} // When  frog step on turtle , stay on and move with it
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0) ;
		} // When frog step on wet turtle , stay on and move with it when it float , fall into water (death) when it sink
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true ;
			} else {
				move(-1,0) ;
			}
		} // When frog reach goal
		else if (getIntersectingObjects(End.class).size() >= 1) {
			// Save all goals' position in array
			inter = (ArrayList<End>) getIntersectingObjects(End.class) ;
			// While entering completed goal again , no score will be awarded
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end-- ;
				points -= 60 ;
			}
			// Adding score for completing a goal
			points += 50 ;
			// Change state of score
			changeScore = true ;
			// Reset the limit line for scoring
			w = 800 ;
			// Set goal image (completed)
			getIntersectingObjects(End.class).get(0).setEnd() ;
			// Increase number of goal completed
			end++ ;
			// Reset  position of frog to starting point
			setX(300) ;
			setY(679.8+movement) ;
		} // Amplify water death
		else if (getY() < 413) {
			waterDeath = true ;
		}
	}
	
	// Return number of goals to be completed to end the game
	public boolean getStop() {
		return end == 5 ;
	}
	
	// Return score
	public int getPoints() {
		return points ;
	}
	
	// Return and reset state of score
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false ;
			return true ;
		}
		return false ;
	}
}
