package com.yiyonglim.TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yiyonglim.Character.Animal;
import com.yiyonglim.Goal.Goal;
import com.yiyonglim.Obstacle.Vehicle;
import com.yiyonglim.Platform.Log;
import com.yiyonglim.Platform.Turtle;
import com.yiyonglim.Platform.WetTurtle;
import com.yiyonglim.Scoreboard.Digit;
import com.yiyonglim.StageBackgroundImage.StageBackgroundImage;
import com.yiyonglim.StageScene.StageScene;
import com.yiyonglim.World.World;

import javafx.embed.swing.JFXPanel;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * StageScene.class test case (3 test case)
 * @author yiyonglim
 *
 */
public class StageSceneTest {
	
	JFXPanel jfxPanel = new JFXPanel() ;
	
	/**
	 * Test if actors are successfully added into stage scene
	 */
	@Test
	public void testActor() {
		
		System.out.println("\nTest case : Actor is added into stage scene");
		
		StageScene test = new StageScene() ;
		
		assertEquals(0,test.getObjects(StageBackgroundImage.class).size()) ;
		assertEquals(0,test.getObjects(Log.class).size()) ;
		assertEquals(0,test.getObjects(Turtle.class).size()) ;
		assertEquals(0,test.getObjects(WetTurtle.class).size()) ;
		assertEquals(0,test.getObjects(Goal.class).size()) ;
		assertEquals(0,test.getObjects(Animal.class).size()) ;
		assertEquals(0,test.getObjects(Vehicle.class).size()) ;
		assertEquals(0,test.getObjects(Digit.class).size()) ;
		
		System.out.println("Before adding actors into stage scene : ") ; 
		System.out.println("Nothing is inside stage scene's array (someArray) , its size is 0") ; 		
		System.out.println("array size : " + test.getObjects(StageBackgroundImage.class).size()+ " , " + test.getObjects(StageBackgroundImage.class));
		System.out.println("array size : " + test.getObjects(Log.class).size()+ " , " + test.getObjects(Log.class));
		System.out.println("array size : " + test.getObjects(WetTurtle.class).size()+ " , " + test.getObjects(WetTurtle.class));
		System.out.println("array size : " + test.getObjects(Goal.class).size()+ " , " + test.getObjects(Goal.class));
		System.out.println("array size : " + test.getObjects(Animal.class).size()+ " , " + test.getObjects(Animal.class));
		System.out.println("array size : " + test.getObjects(Vehicle.class).size()+ " , " + test.getObjects(Vehicle.class));
		System.out.println("array size : " + test.getObjects(Digit.class).size()+ " , " + test.getObjects(Digit.class));
		
		test.add(new StageBackgroundImage("file:Resources/StageBackground/Stage4Background.png"));
		test.add(new Log("file:Resources/Log/log3.png", 150, 220, 166, 0.75));
		test.add(new Turtle(500, 376, -1, 130, 130));
		test.add(new WetTurtle(600, 217, -1, 130, 130));
		test.add(new Goal(393,105));
		test.add(new Animal("file:Resources/Frog/frogUp1.png"));
		test.add(new Vehicle("file:Resources/Car/carLeft.png", 150, 704, -5, 50, 50));
		test.add(new Digit(0, 30, 570, 25)) ;
		
		assertEquals(1,test.getObjects(StageBackgroundImage.class).size()) ;
		assertEquals(1,test.getObjects(Log.class).size()) ;
		assertEquals(1,test.getObjects(Turtle.class).size()) ;
		assertEquals(1,test.getObjects(WetTurtle.class).size()) ;
		assertEquals(1,test.getObjects(Goal.class).size()) ;
		assertEquals(1,test.getObjects(Animal.class).size()) ;
		assertEquals(1,test.getObjects(Vehicle.class).size()) ;
		assertEquals(1,test.getObjects(Digit.class).size()) ;	
		
		System.out.println("After adding actors into stage scene : ") ; 
		System.out.println("There is something in stage scene's array (someArray) for each Actor's class , its size is 1") ; 	
		System.out.println("array size : " + test.getObjects(StageBackgroundImage.class).size()+ " , " + test.getObjects(StageBackgroundImage.class));
		System.out.println("array size : " + test.getObjects(Log.class).size()+ " , " + test.getObjects(Log.class));
		System.out.println("array size : " + test.getObjects(WetTurtle.class).size()+ " , " + test.getObjects(WetTurtle.class));
		System.out.println("array size : " + test.getObjects(Goal.class).size()+ " , " + test.getObjects(Goal.class));
		System.out.println("array size : " + test.getObjects(Animal.class).size()+ " , " + test.getObjects(Animal.class));
		System.out.println("array size : " + test.getObjects(Vehicle.class).size()+ " , " + test.getObjects(Vehicle.class));
		System.out.println("array size : " + test.getObjects(Digit.class).size()+ " , " + test.getObjects(Digit.class));
	}
	
	/**
	 * Test if pause game is functioning well
	 */
	@Test
	public void testPauseGame() {
		
		System.out.println("\nTest case : Game paused (alert window shown)");

		World test = new StageScene() ;
		
		test.start() ;
		
		((StageScene) test).playStageMusic();
		
		try {
			
			test.fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED,KeyCode.ESCAPE.toString(), KeyCode.ESCAPE.toString(), KeyCode.ESCAPE, false, false, false, false));
		} catch (IllegalStateException e) {
			
			System.out.println("IllegalStateException is thrown");
			System.out.println("Alert window is detected , game is paused");
		}
	}
	
	/**
	 * Test if user proceed to next stage , after meeting the requirement
	 */
	@Test
	public void testStageProceed() {
		
		System.out.println("\nTest case : Next stage");
		
		StageScene test = new StageScene() ;
		
		assertEquals(0 , StageScene.stageCompleted) ;
		
		System.out.println("Before frog reach stage 1's goal :") ;
		System.out.println("end : " + StageScene.stageCompleted);
		
		Goal goal1 = new Goal(10,105) ;
		
		Animal animal = new Animal("file:Resources/Frog/frogUp1.png") ;
		animal.setX(10) ;
		animal.setY(105) ;
		
		test.add(goal1) ;
		test.add(animal) ;
		
		animal.act(0);
		
		test.createStageTimer();
		
		assertEquals(1 , StageScene.stageCompleted) ;
		
		System.out.println("After frog reached stage 1's goal :") ;
		System.out.println("end : " + StageScene.stageCompleted);
		System.out.println("Stage 1 is completed , proceed to stage 2") ;
	
		
		
		System.out.println("Before frog reach stage 2's goal :") ;
		System.out.println("end : " + StageScene.stageCompleted);
		
		Goal goal2 = new Goal(140,105) ;
		
		animal.setX(140) ;
		animal.setY(105) ;
		
		test.add(goal2);
		
		animal.act(0);
		
		assertEquals(2 , StageScene.stageCompleted) ;
		
		System.out.println("After frog reached stage 2's goal :") ;
		System.out.println("end : " + StageScene.stageCompleted);
		System.out.println("Stage 2 is completed , proceed to stage 3") ;
	
		
		
		System.out.println("Before frog reach stage 3's goal :") ;
		System.out.println("end : " + StageScene.stageCompleted);
		
		Goal goal3 = new Goal(265,105) ;
		
		animal.setX(265) ;
		animal.setY(105) ;
		
		test.add(goal3);
		
		animal.act(0);
		
		assertEquals(3 , StageScene.stageCompleted) ;
		
		System.out.println("After frog reached stage 3's goal :") ;
		System.out.println("end : " + StageScene.stageCompleted);
		System.out.println("Stage 3 is completed , proceed to stage 4") ;
		
		
		
		System.out.println("Before frog reach stage 4's goal :") ;
		System.out.println("end : " + StageScene.stageCompleted);
		
		Goal goal4 = new Goal(393,105) ;
		
		animal.setX(393) ;
		animal.setY(105) ;
		
		test.add(goal4);
		
		animal.act(0);
		
		assertEquals(4 , StageScene.stageCompleted) ;
		
		System.out.println("After frog reached stage 4's goal :") ;
		System.out.println("end : " + StageScene.stageCompleted);
		System.out.println("Stage 4 is completed , proceed to stage 5") ;
		
		
		
		System.out.println("Before frog reach stage 5's goal :") ;
		System.out.println("end : " + StageScene.stageCompleted);
		
		Goal goal5 = new Goal(520,105) ;
		
		animal.setX(520) ;
		animal.setY(105) ;
		
		test.add(goal5);
		
		animal.act(0);
		
		assertEquals(5 , StageScene.stageCompleted) ;
		
		System.out.println("After frog reached stage 5's goal :") ;
		System.out.println("end : " + StageScene.stageCompleted);
		System.out.println("Stage 5 is completed , end game") ;
	}
}
