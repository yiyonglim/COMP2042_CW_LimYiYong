package Actor ;

import javafx.scene.image.ImageView ;

import java.util.ArrayList ;

import Scene.World;

// Handle actors
// Actors --> all objects which involved in game
public abstract class Actor extends ImageView {

	// Set movement on x-axis and y-axis
    public void move(double dx , double dy) {
        setX(getX() + dx) ;
        setY(getY() + dy) ;
    }

    // Return coordinate system of World from its Parent (Pane)
    public World getWorld() {
        return (World) getParent() ;
    }

    // Return width of World
    public double getWidth() {
        return this.getBoundsInLocal().getWidth() ;
    }

    // Return height of World
    public double getHeight() {
        return this.getBoundsInLocal().getHeight() ;
    }

    // Return list of collisions between actors and boundary
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls) {
    	// Create array to store collisions history
        ArrayList<A> someArray = new ArrayList<A>() ;
        for (A actor : getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor) ;
            }
        }
        return someArray ;
    }

    // Create abstract method to be implemented later on child class
    public abstract void act(long now) ;

}
