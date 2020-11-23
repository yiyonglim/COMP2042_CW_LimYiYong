package com.yiyonglim.TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yiyonglim.Character.Animal;
import com.yiyonglim.Goal.Goal;
import com.yiyonglim.StageScene.StageScene;

import javafx.embed.swing.JFXPanel;

/**
 * Goal.class test case (2 test cases)
 * @author yiyonglim
 */
public class GoalTest {

	JFXPanel jfxPanel = new JFXPanel() ;

	/**
	 * Test if goal's position is set up correctly
	 */
	@Test
	public void testGoalPosition() {
		
		System.out.println("\nTest case : Goal's position");
		
		Goal test = new Goal(10,105) ;
		
		assertEquals(10.0 , test.getX() , 0.0) ;
		
		System.out.println("Goal's position : " + test.getX());
	}

	/**
	 * Test if frog has completed a goal
	 */
	@Test
	public void testGoalCompleted() {
		
		System.out.println("\nTest case : Goal completed");
		
		Goal test = new Goal(10,105) ;
		
		System.out.println("Before frog reached goal : " + test.isCompleted());

		Animal animal = new Animal("file:Resources/Frog/frogUp1.png") ;
		animal.setX(10) ;
		animal.setY(105) ;
		
		StageScene b = new StageScene() ;

		b.add(test);
		b.add(animal);
		
		animal.act(0);
		
		assertEquals(true , test.isCompleted()) ;
		
		System.out.println("After frog reached goal : " + test.isCompleted());

		StageScene.stageCompleted = 0 ;
	}
}
