package com.yiyonglim.World ;


import java.util.ArrayList ;
import java.util.List ;

import com.yiyonglim.Actor.Actor;

import javafx.animation.AnimationTimer ;
import javafx.beans.value.ChangeListener ;
import javafx.beans.value.ObservableValue ;
import javafx.event.EventHandler ;
import javafx.scene.Node ;
import javafx.scene.Scene ;
import javafx.scene.input.KeyEvent ;
import javafx.scene.layout.Pane ;

/**
 * Handle whole game (general settings)
 * @author yiyonglim
 */
public abstract class World extends Pane {

	AnimationTimer worldTimer;
    
	/**
	 * Create general settings for whole game
	 */
    public World() {

    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {

				if (newValue != null) {
					
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {
						
						@Override
						public void handle(KeyEvent event) {
							
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event) ;
							
							List<Actor> myActors = getObjects(Actor.class) ;
							
							for (Actor anActor: myActors) {
								
								if (anActor.getOnKeyReleased() != null) {
									
									anActor.getOnKeyReleased().handle(event) ;
								}
							}
						}
					}) ;
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {
						
						@Override
						public void handle(KeyEvent event) {
							
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							
							List<Actor> myActors = getObjects(Actor.class) ;
							
							for (Actor anActor: myActors) {
								
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event) ;
								}
							}
						}
					}) ;
				}
			}
		}) ;
    }
    
    /**
     * Create timer for handling all actors
     */
    public void createWorldTimer() {
    	
        worldTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now) ;
                List<Actor> actors = getObjects(Actor.class) ;
                
                for (Actor anActor: actors) {
                	anActor.act(now) ;
                }
            }
        } ;
    }

    /**
     * Start world
     */
    public void start() {
    	
    	createWorldTimer() ;
        worldTimer.start() ;
    }

    /**
     * Stop world
     */
    public void stop() {
    	
        worldTimer.stop();
    }
    
    /**
     * Add actors to game
     * @param actor Actor, User control character(frog), object(truck , car , log , turtle , wet turtle) , boundary in game
     */
    public void add(Actor actor) {
    	
        getChildren().add(actor);
    }

    /**
     * Remove actor from game
     * @param actor Actor, User control character(frog), object(truck , car , log , turtle , wetturtle) , boundary in game
     */
    public void remove(Actor actor) {
    	
        getChildren().remove(actor);
    }

    /**
     * Record all Object present in game
     * @param <A> java.util.List
     * @param cls Class of objects to look for (passing 'null' will find all objects)
     * @return array list of classes
     */
    @SuppressWarnings("unchecked")
	public <A extends Actor> List<A> getObjects(Class<A> cls) {
    	
        ArrayList<A> someArray = new ArrayList<A>() ;
        
        for (Node n: getChildren()) {
        	
            if (cls.isInstance(n)) {
                someArray.add((A)n) ;
            }
        }
        return someArray ;
    }

    /**
     * For set actors into action
     * @param now The timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
     */
    public abstract void act(long now) ;
}
