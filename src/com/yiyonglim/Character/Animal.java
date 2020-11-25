package com.yiyonglim.Character ;

import com.yiyonglim.Actor.Actor;
import com.yiyonglim.Goal.Goal ;
import com.yiyonglim.Obstacle.Vehicle ;
import com.yiyonglim.Platform.Log ;
import com.yiyonglim.Platform.Turtle ;
import com.yiyonglim.Platform.WetTurtle ;
import com.yiyonglim.StageScene.StageScene;

import javafx.event.EventHandler ;

import javafx.scene.image.Image ;
import javafx.scene.input.KeyCode ;
import javafx.scene.input.KeyEvent ;

/**
 * Handle frog . 
 * Frog is user control character
 * @author yiyonglim
 */
public class Animal extends Actor {

	Image frogMoveUp1 ;
	Image frogMoveUp2 ;
	Image frogMoveDown1 ;
	Image frogMoveDown2 ;
	Image frogMoveLeft1 ;
	Image frogMoveLeft2 ;
	Image frogMoveRight1 ;
	Image frogMoveRight2 ;
	
	// Score will be added after passing a new score line 
	public double scoreLine = 800 ;
	public boolean frogDeathByVehicle = false ;
	public boolean frogDeathByWater = false ;
	
	private int frogDeathAnimation = 0 ;
	private int frogSize = 40 ;
	private double frogMovementX = 10.666666*2 ;
	private double frogMovementY = 13.3333333*2 ;
	// One jumping cycle of frog consists of unfold and fold its legs
	// true -> frogMoveUp1 , frogMoveDown1 , frogMoveLeft1 , frogMoveRight1 (frog folds its legs)
	// false -> frogMoveUp2 , frogMoveDown2 , frogMoveLeft2 , frogMoveRight2 (frog unfolds its legs)
	private boolean frogJump = false ;
	private boolean frogNoMove = false ;
	
	/**
	 * Create user control character , frog
	 * @param image Frog's image
	 */
	public Animal(String image) {

		// Frog's starting image
		setImage(new Image(image, frogSize, frogSize, true, true)) ;
		
		// Frog's starting position
		setX(300) ;
		setY(730 + frogMovementY) ;
		
		// Frog's moving image
		frogMoveUp1 = new Image("file:Resources/Frog/frogUp1.png", frogSize, frogSize, true, true) ;
		frogMoveLeft1 = new Image("file:Resources/Frog/frogLeft1.png", frogSize, frogSize, true, true) ;
		frogMoveDown1 = new Image("file:Resources/Frog/frogDown1.png", frogSize, frogSize, true, true) ;
		frogMoveRight1 = new Image("file:Resources/Frog/frogRight1.png", frogSize, frogSize, true, true) ;
		frogMoveUp2 = new Image("file:Resources/Frog/frogUp2.png", frogSize, frogSize, true, true) ;
		frogMoveLeft2 = new Image("file:Resources/Frog/frogLeft2.png", frogSize, frogSize, true, true) ;
		frogMoveDown2 = new Image("file:Resources/Frog/frogDown2.png", frogSize, frogSize, true, true) ;
		frogMoveRight2 = new Image("file:Resources/Frog/frogRight2.png", frogSize, frogSize, true, true) ;
		
		// Frog's movement (controlled by user)
		// ARROW UP --> Frog move up
		// ARROW DOWN --> Frog move down
		// ARROW LEFT --> Frog move left
		// ARROW RIGHT --> Frog move right
		setOnKeyPressed(new EventHandler<KeyEvent>() {

			public void handle(KeyEvent event) {

				if (frogNoMove) {
					
				}
				else {

					if (frogJump) {

						if (event.getCode() == KeyCode.UP) {
							
			                move(0, -frogMovementY) ;
			                setImage(frogMoveUp1) ;
			                frogJump = false ;
			            }
			            else if (event.getCode() == KeyCode.LEFT) {	
			            	
			            	 move(-frogMovementX, 0) ;
			            	 setImage(frogMoveLeft1) ;
			            	 frogJump = false ;
			            }
			            else if (event.getCode() == KeyCode.DOWN) {	
			            	
			            	 move(0, frogMovementY) ;
			            	 setImage(frogMoveDown1) ;
			            	 frogJump = false ;
			            }
			            else if (event.getCode() == KeyCode.RIGHT) {
			            	
			            	 move(frogMovementX, 0) ;
			            	 setImage(frogMoveRight1) ;
			            	 frogJump = false ;
			            }
					}
					else if (event.getCode() == KeyCode.UP) {
						
		                move(0, -frogMovementY) ;
		                setImage(frogMoveUp2) ;
		                frogJump = true ;
		            }
		            else if (event.getCode() == KeyCode.LEFT) {
		            	
		            	 move(-frogMovementX, 0) ;
		            	 setImage(frogMoveLeft2) ;
		            	 frogJump = true ;
		            }
		            else if (event.getCode() == KeyCode.DOWN) {
		            	
		            	 move(0, frogMovementY) ;
		            	 setImage(frogMoveDown2) ;
		            	 frogJump = true ;
		            }
		            else if (event.getCode() == KeyCode.RIGHT) {
		            	
		            	 move(frogMovementX, 0) ;
		            	 setImage(frogMoveRight2) ;
		            	 frogJump = true ;
		            }
				}
			}
		}) ;
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			
			public void handle(KeyEvent event) {
				
				if (frogNoMove) {
					
				}
				else {
					
					if (event.getCode() == KeyCode.UP) {
						
						// Score is added when frog has passed a new score line
						if (getY() < scoreLine) {
							
							scoreLine = getY() ;
							StageScene.points += 10 ;
						}
						
		                	move(0, -frogMovementY) ;
		                	setImage(frogMoveUp1) ;
		                	frogJump = false ;
		            }
		            else if (event.getCode() == KeyCode.LEFT) {
		            	
		            	move(-frogMovementX, 0) ;
		            	setImage(frogMoveLeft1) ;
		            	frogJump = false ;
		            }
		            else if (event.getCode() == KeyCode.DOWN) {
		            	
		            	move(0, frogMovementY) ;
		            	setImage(frogMoveDown1) ;
		            	frogJump = false ;
		            }
		            else if (event.getCode() == KeyCode.RIGHT) {
		            	
		            	move(frogMovementX, 0) ;
		            	setImage(frogMoveRight1) ;
		            	frogJump = false ;
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
		
		// When frog reach bottom boundary (0) or top boundary (800) , it will be reset to starting position
		if (getY() < 0 || getY() > 800) {
			
			setX(300) ;
			setY(730 + frogMovementY) ;
		}
		
		// When frog reach left boundary (0) or right boundary (570) , it will be pushed back
		if (getX() < 0) {
			
			move(frogMovementY*2, 0) ;
		}
		else if(getX() > 570) {
			
			move(-frogMovementY*2, 0) ;
		}
		
		// Frog will die when having collision with vehicle (car , truck)
		if (getIntersectingObjects(Vehicle.class).size() >= 1) {
			
			frogDeathByVehicle = true ;
		}
		
		// Frog will move with platform (log , turtle , wet turtle) when stand on it
		if (getIntersectingObjects(Log.class).size() >= 1 && !frogNoMove) {
			
			if(getIntersectingObjects(Log.class).get(0).getLeft()) {
				
				move(-2,0) ;
			}
			else {
				
				move (.75,0) ;
			}
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !frogNoMove) {
			
			move(-1,0) ;
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			
			// Frog will die if keep standing on wet turtle when wet turtle sunk
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				
				frogDeathByWater = true ;
			}
			else {
				
				move(-1,0) ;
			}
		} // Add score and proceed to new stage when frog has reached the goal
		else if(getIntersectingObjects(Goal.class).size() >= 1) {
			
			StageScene.points += 50 ;
			StageScene.stageCompleted ++ ;
			
			// Set goal completed image
			getIntersectingObjects(Goal.class).get(0).setGoal() ;
			
			setX(300) ;
			setY(730 + frogMovementY) ;
		} // If frog didn't intersect with one of the objects mentioned above (platform and goal is on water) , frog will die because it fall into water
		else if (getY() < 413) {
			
			frogDeathByWater = true ;
		}
		
		// When frog is dead , death animation is invoked , then frog is reset to its starting position
		// 50 score will be deducted if frog is dead , if current score isn't enough to be deducted , deduction is denied
		if (frogDeathByVehicle) {

			frogNoMove = true ;

			if ((now)% 11 == 0) {
				frogDeathAnimation++ ;
			}
			
			if (frogDeathAnimation == 1) {
				
				setImage(new Image("file:Resources/Death/vehicleDeath1.png", frogSize, frogSize, true, true)) ;
			}
			
			if (frogDeathAnimation == 2) {
				
				setImage(new Image("file:Resources/Death/vehicleDeath2.png", frogSize, frogSize, true, true)) ;
			}
			
			if (frogDeathAnimation == 3) {
				
				setImage(new Image("file:Resources/Death/vehicleDeath3.png", frogSize, frogSize, true, true)) ;
			}
			
			if (frogDeathAnimation == 4) {

				frogNoMove = false ;
				frogDeathByVehicle = false ;
				frogDeathAnimation = 0 ;
				
				setX(300) ;
				setY(730 + frogMovementY) ;
				
				setImage(new Image("file:Resources/Frog/frogUp1.png", frogSize, frogSize, true, true)) ;

				if (StageScene.points >= 50) {
					
					StageScene.points -= 50 ;
				}
			}
		}

		if (frogDeathByWater) {
			
			frogNoMove = true ;
			
			if ((now)% 11 == 0) {
				
				frogDeathAnimation++;
			}
			
			if (frogDeathAnimation == 1) {
				
				setImage(new Image("file:Resources/Death/waterdeath1.png", frogSize,frogSize , true, true)) ;
			}
			
			if (frogDeathAnimation == 2) {
				
				setImage(new Image("file:Resources/Death/waterdeath2.png", frogSize,frogSize , true, true)) ;
			}
			
			if (frogDeathAnimation == 3) {
				
				setImage(new Image("file:Resources/Death/waterdeath3.png", frogSize,frogSize , true, true)) ;
			}
			
			if (frogDeathAnimation == 4) {
				
				setImage(new Image("file:Resources/Death/waterdeath4.png", frogSize,frogSize , true, true)) ;
			}
			
			if (frogDeathAnimation == 5) {
				
				frogNoMove = false ;
				frogDeathByWater = false ;		
				frogDeathAnimation = 0 ;
				
				setX(300) ;
				setY(730+frogMovementY) ;
				
				setImage(new Image("file:Resources/Frog/frogUp1.png", frogSize, frogSize, true, true)) ;
				
				if (StageScene.points>=50) {
					
					StageScene.points-=50 ;
				}
			}
		}
	}
}
