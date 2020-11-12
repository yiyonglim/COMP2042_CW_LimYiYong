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
 *
 */
public abstract class World extends Pane {
    // Initialize timer
	AnimationTimer timer;
    
	/**
	 * Create general settings for whole game
	 */
    public World() {
    	// Add listener to observe all changes in game
    	sceneProperty().addListener(new ChangeListener<Scene>() {
    		// Detect changes and execute them
			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				// Handle key pressed settings
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
    public void createTimer() {
    	
        timer = new AnimationTimer() {
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
     * Start scene , all actors in action
     */
    public void start() {
    	createTimer() ;
        timer.start() ;
    }

    /**
     * Stop scene , all actors stop
     */
    public void stop() {
        timer.stop();
    }
    
    /**
     * Add actor to game
     * @param actor Actor, User control character(frog), object(truck , car , log , turtle , wetturtle) , boundary in game
     */
    // Adding actor into scene
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
    // Saving actor into array
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

    public abstract void act(long now) ;
}
