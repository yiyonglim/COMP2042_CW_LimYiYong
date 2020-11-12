package com.yiyonglim.Character ;

import com.yiyonglim.Actor.Actor;
import com.yiyonglim.Goal.End ;
import com.yiyonglim.Obstacle.Obstacle ;
import com.yiyonglim.Platform.Log ;
import com.yiyonglim.Platform.Turtle ;
import com.yiyonglim.Platform.WetTurtle ;

import javafx.event.EventHandler ;

import javafx.scene.image.Image ;
import javafx.scene.input.KeyCode ;
import javafx.scene.input.KeyEvent ;

/**
 * Handle frog
 * Frog , user control character
 * @author yiyonglim
 */
public class Animal extends Actor {
	// Initialize frog's moving image
	Image frogUp1 ;
	Image frogLeft1 ;
	Image frogDown1 ;
	Image frogRight1 ;
	Image frogUp2 ;
	Image frogLeft2 ;
	Image frogDown2 ;
	Image frogRight2 ;
	// Initialize starting score
	public static int points = 0 ;
	// Initialize number of stages completed
	public static int end = 0 ;
	// Initialize frog death animation
	int deathAnimation = 0 ;
	// Set frog's size
	int frogSize = 40 ;
	// Set frog's vertical jump distance
	double movementY = 13.3333333*2 ;
	// Set frog's horizontal jump distance
	double movementX = 10.666666*2 ;
	// Initialize score line , score will be added after passing it 
	double scoreLine = 800 ;
	// Initialize frog's jumping state
	// true -> fold legs , false -> unfold legs
	private boolean jump = false ;
	// Initialize frog's movement state
	// true -> stationary , false -> moving	
	boolean noMove = false ;
	// Initialize frog's death reason
	// true -> death by vehicle , false -> not death by vehicle
	// Having collision with car or truck
	boolean vehicleDeath = false ;
	// true -> death by water , false -> not death by water
	// Fall into water
	boolean waterDeath = false ;
	// Either vehicleDeath or waterDeath can be true at the same time
	
	/**
	 * Create user control character , frog
	 * @param imageLink Frog's image
	 */
	public Animal(String imageLink) {
		// Set frog image
		setImage(new Image(imageLink, frogSize, frogSize, true, true)) ;
		// Set frog's starting point
		setX(300) ;
		setY(730 + movementY) ;
		// Initialize frog's moving image
		frogUp1 = new Image("file:Resources/Frog/frogUp1.png", frogSize, frogSize, true, true) ;
		frogLeft1 = new Image("file:Resources/Frog/frogLeft1.png", frogSize, frogSize, true, true) ;
		frogDown1 = new Image("file:Resources/Frog/frogDown1.png", frogSize, frogSize, true, true) ;
		frogRight1 = new Image("file:Resources/Frog/frogRight1.png", frogSize, frogSize, true, true) ;
		frogUp2 = new Image("file:Resources/Frog/frogUp2.png", frogSize, frogSize, true, true) ;
		frogLeft2 = new Image("file:Resources/Frog/frogLeft2.png", frogSize, frogSize, true, true) ;
		frogDown2 = new Image("file:Resources/Frog/frogDown2.png", frogSize, frogSize, true, true) ;
		frogRight2 = new Image("file:Resources/Frog/frogRight2.png", frogSize, frogSize, true, true) ;
		// Frog's movement
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			// How key pressed is handle
			public void handle(KeyEvent event) {
				// Check current movement state of frog (stationary or moving)
				if (noMove) {
					
				}
				else {
					// Check frog's jumping state
					if (jump) {
						// Check which key is pressed and response respectively
						// Move up when press ARROW UP
						if (event.getCode() == KeyCode.UP) {	
							// Move frog
			                move(0, -movementY) ;
			                // Set frog's moving image
			                setImage(frogUp1) ;
			                // Set frog's jumping state
			                jump = false ;
			            } // Move left when press ARROW LEFT
			            else if (event.getCode() == KeyCode.LEFT) {	            	
			            	 // Move frog 
			            	 move(-movementX, 0) ;
			            	 setImage(frogLeft1) ;
			            	 jump = false ;
			            } // Move down when press ARROW DOWN
			            else if (event.getCode() == KeyCode.DOWN) {	            	
			            	 move(0, movementY) ;
			            	 setImage(frogDown1) ;
			            	 jump = false ;
			            } // Move right when press ARROW RIGHT
			            else if (event.getCode() == KeyCode.RIGHT) {	            	
			            	 move(movementX, 0) ;
			            	 setImage(frogRight1) ;
			            	 jump = false ;
			            }
					}
					else if (event.getCode() == KeyCode.UP) {	            	
		                move(0, -movementY) ;
		                setImage(frogUp2) ;
		                jump = true ;
		            }
		            else if (event.getCode() == KeyCode.LEFT) {	            	
		            	 move(-movementX, 0) ;
		            	 setImage(frogLeft2) ;
		            	 jump = true ;
		            }
		            else if (event.getCode() == KeyCode.DOWN) {	            	
		            	 move(0, movementY) ;
		            	 setImage(frogDown2) ;
		            	 jump = true ;
		            }
		            else if (event.getCode() == KeyCode.RIGHT) {	            	
		            	 move(movementX, 0) ;
		            	 setImage(frogRight2) ;
		            	 jump = true ;
		            }
				}
			}
		}) ;
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {
					
				}
				else {
					if (event.getCode() == KeyCode.UP) {
						// Check if frog passed score line
						if (getY() < scoreLine) {
							scoreLine = getY() ;
							points += 10 ;
						}
		                	move(0, -movementY) ;
		                	setImage(frogUp1) ;
		                	jump = false ;
		            }
		            else if (event.getCode() == KeyCode.LEFT) {	            	
		            	move(-movementX, 0) ;
		            	setImage(frogLeft1) ;
		            	jump = false ;
		            }
		            else if (event.getCode() == KeyCode.DOWN) {	            	
		            	move(0, movementY) ;
		            	setImage(frogDown1) ;
		            	jump = false ;
		            }
		            else if (event.getCode() == KeyCode.RIGHT) {	            	
		            	move(movementX, 0) ;
		            	setImage(frogRight1) ;
		            	jump = false ;
		            }
				}
			}
		});
	}
	
	/**
	 * Set frog into action
	 */
	@Override
	public void act(long now) {
		// When frog hit bottom or top boundary , it will be reset to starting point
		if (getY() < 0 || getY() > 800) {
			setX(300) ;
			setY(730 + movementY) ;
		}
		// When frog hit left or right boundary , it will be pushed back
		if (getX() < 0) {
			move(movementY*2, 0) ;
		}
		else if(getX() > 570) {
			move(-movementY*2, 0) ;
		}
		// When frog death by vehicle
		if (vehicleDeath) {
			// Set frog's movement state
			noMove = true ;
			// Show frog's death animation
			if ((now)% 11 == 0) {
				deathAnimation++ ;
			}
			if (deathAnimation == 1) {
				setImage(new Image("file:Resources/Death/vehicleDeath1.png", frogSize, frogSize, true, true)) ;
			}
			if (deathAnimation == 2) {
				setImage(new Image("file:Resources/Death/vehicleDeath2.png", frogSize, frogSize, true, true)) ;
			}
			if (deathAnimation == 3) {
				setImage(new Image("file:Resources/Death/vehicleDeath3.png", frogSize, frogSize, true, true)) ;
			}
			if (deathAnimation == 4) {
				// Reset frog's position to starting point
				setX(300) ;
				setY(730+movementY) ;
				// Reset frog's death state
				vehicleDeath = false ;
				// Reset frog's death animation
				deathAnimation = 0 ;
				// Reset frog's image (dead -> alive)
				setImage(new Image("file:Resources/Frog/frogUp1.png", frogSize, frogSize, true, true)) ;
				// Reset frog's movement state
				noMove = false ;
				// 50 score will be deducted if died, if score isn't enough to be deducted , deduction is denied
				if (points > 50) {
					points -= 50 ;
				}
			}
		}
		// When frog death by water
		// Implementation same as above
		if (waterDeath) {
			
			noMove = true ;
			
			if ((now)% 11 == 0) {
				deathAnimation++;
			}
			if (deathAnimation == 1) {
				setImage(new Image("file:Resources/Death/waterdeath1.png", frogSize,frogSize , true, true)) ;
			}
			if (deathAnimation == 2) {
				setImage(new Image("file:Resources/Death/waterdeath2.png", frogSize,frogSize , true, true)) ;
			}
			if (deathAnimation == 3) {
				setImage(new Image("file:Resources/Death/waterdeath3.png", frogSize,frogSize , true, true)) ;
			}
			if (deathAnimation == 4) {
				setImage(new Image("file:Resources/Death/waterdeath4.png", frogSize,frogSize , true, true)) ;
			}
			if (deathAnimation == 5) {
				
				setX(300) ;
				setY(730+movementY) ;

				waterDeath = false ;
				
				deathAnimation = 0 ;
				
				setImage(new Image("file:Resources/Frog/frogUp1.png", frogSize, frogSize, true, true)) ;
				
				noMove = false ;
				
				if (points>50) {
					points-=50 ;
				}
			}
		}
		// If frog had collision with vehicle(car , truck) , it will die
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			vehicleDeath = true ;
		}
		// If frog step on platform(log , turtle , wet turtle) , stay on and move with it
		// When frog step on log , stay on and move with it
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0) ;
			else
				move (.75,0) ;
		} // When frog step on turtle , stay on and move with it
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0) ;
		} // When frog step on wet turtle , stay on and move with it when it float , fall into water when it sink
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true ;
			} else {
				move(-1,0) ;
			}
		} // When frog reach goal
		else if (getIntersectingObjects(End.class).size() >= 1) {
			// Add score for completing a goal
			points += 50 ;
			// Reset the score line
			scoreLine = 800 ;
			// Set goal image (completed)
			getIntersectingObjects(End.class).get(0).setEnd() ;
			// Increase number of stages completed
			end ++ ;
			// Reset  position of frog to starting point
			setX(300) ;
			setY(730+movementY) ;
		} // Amplify water death
		else if (getY() < 413) {
			waterDeath = true ;
		}
	}
}
