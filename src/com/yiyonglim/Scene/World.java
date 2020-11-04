package com.yiyonglim.Scene ;


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

// Handle scene
public abstract class World extends Pane {
    // Initialize scene timer
	private AnimationTimer timer;
    
	// Create scene for actors to act on
    public World() {
    	// Detect interactions in scene
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			// Detect changes and execute them
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				// If there is a change
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {
						@Override
						// Call "handle" method to execute the change
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

    // Create general timer for handling all actors except user control frog , score board and goal
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

    // Start scene , all actors do their jobs
    public void start() {
    	createTimer() ;
        timer.start() ;
    }

    // Stop scene , all actors stop doing their jobs
    public void stop() {
        timer.stop();
    }
    
    // Adding actor into scene
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    // Removing actor from scene
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

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

    // Create "act" method for child class which need to change constantly with time
    public abstract void act(long now) ;
}
