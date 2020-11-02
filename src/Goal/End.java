package Goal ;

import Actor.Actor;
import javafx.scene.image.Image ;

// Handle goal
public class End extends Actor{
	// Initialize goal state
	boolean activated = false ;
	@Override
	// Goal wont be changing constantly with time , "act" method is empty
	public void act(long now) {

	}
	
	// Set goal position
	public End(int x, int y) {
		// Set goal position
		setX(x) ;
		setY(y) ;
		// Set goal image
		setImage(new Image("file:Resources/Goal/End.png", 60, 60, true, true)) ;
	}
	
	// Set goal state and completed goal image
	public void setEnd() {
		// Image changed after frog has completed the goal
		setImage(new Image("file:Resources/Goal/FrogEnd.png", 70, 70, true, true)) ;
		// Set goal state to completed
		activated = true ;
	}
	
	// To check the goal has been completed or not
	public boolean isActivated() {
		return activated;
	}
	

}
