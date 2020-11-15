package com.yiyonglim.Actor ;

import javafx.scene.image.ImageView ;

import java.util.ArrayList ;

import com.yiyonglim.World.World;

/**
 * Handle all actors
 * Actor, User control character(frog), object(truck , car , log , turtle , wetturtle) , boundary in game
 * @author yiyonglim
 */
public abstract class Actor extends ImageView {
	/**
	 * Set actors' movement
	 * @param dx Actor's X coordinate
	 * @param dy Actor's Y coordinate
	 */
    public void move(double dx , double dy) {
        setX(getX() + dx) ;
        setY(getY() + dy) ;
    }
    
    /**
     * Return World coordinate system for tracking actors
     * @return World coordinate system from its Parent (Pane)
     */
    public World getWorld() {
        return (World) getParent() ;
    }
    
    /**
     * Record all intersection between actors
     * @param <A> java.util.List
     * @param cls Class of objects to look for (passing 'null' will find all objects)
     * @return array list of intersecting classes
     */
    // Return list of collisions between actors and boundary
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls) {
    	
        ArrayList<A> someArray = new ArrayList<A>() ;
        
        for (A actor : getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor) ;
            }
        }
        return someArray ;
    }
    
    /**
     * Set actors into action
     * @param now The timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
     */
    public abstract void act(long now) ;
}
