package com.yiyonglim.TestCase;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.yiyonglim.Character.Animal;
import com.yiyonglim.Obstacle.Vehicle;
import com.yiyonglim.Platform.WetTurtle;
import com.yiyonglim.StageScene.StageScene;

import javafx.embed.swing.JFXPanel;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Animal.class test case (10 test cases)
 * @author yiyonglim
 */
public class AnimalTest {

	JFXPanel jfxPanel = new JFXPanel() ;
	
	/**
	 * Test if frog is in correct starting position (x,y) when game started
	 */
	@Test
	public void testStartingPosition() {
		
		System.out.println("\nTest case : Frog starting position") ;
		
		Animal test = new Animal("file:Resources/Frog/frogUp1.png") ;
		
		assertEquals(300.0 , test.getX() , 0.0) ;
		assertEquals(756.6666666 , test.getY() , 0.0) ;
		
		System.out.println("Starting X-coordinate : " + test.getX()) ;
		System.out.println("Starting Y-coordinate : " + test.getY()) ;
	}
	
	/**
	 * Test if frog is in correct position Y when ARROW UP is pressed and released
	 */
	@Test
	public void testUP() {
		
		System.out.println("\nTest case : Frog move UP") ;
		
		Animal test = new Animal("file:Resources/Frog/frogUp1.png") ;
		
		System.out.println("Before move up , X-coordinate : " + test.getX()) ;
		System.out.println("Before move up , Y-coordinate : " + test.getY()) ;
		
		test.fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED,KeyCode.UP.toString(), KeyCode.UP.toString(), KeyCode.UP, false, false, false, false));
		assertEquals(730.0 , test.getY() , 0.0) ;
		
		test.fireEvent(new KeyEvent(KeyEvent.KEY_RELEASED,KeyCode.UP.toString(), KeyCode.UP.toString(), KeyCode.UP, false, false, false, false));
		assertEquals(703.3333334 , test.getY() , 0.0) ;
		
		System.out.println("After move up , X-coordinate : " + test.getX()) ;
		System.out.println("After move up , Y-coordinate : " + test.getY()) ;
	}
	
	/**
	 * Test if frog is in correct position Y when ARROW DOWN is pressed and released
	 */
	@Test
	public void testDOWN() {
		
		System.out.println("\nTest case : Frog move DOWN") ;

		Animal test = new Animal("file:Resources/Frog/frogUp1.png") ;
		test.setY(703.3333334);
		
		System.out.println("Before move down , X-coordinate : " + test.getX()) ;
		System.out.println("Before move down , Y-coordinate : " + test.getY()) ;
		
		test.fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED,KeyCode.DOWN.toString(), KeyCode.DOWN.toString(), KeyCode.DOWN, false, false, false, false));
		assertEquals(730.0  , test.getY() , 0.0) ;
		
		test.fireEvent(new KeyEvent(KeyEvent.KEY_RELEASED,KeyCode.DOWN.toString(), KeyCode.DOWN.toString(), KeyCode.DOWN, false, false, false, false));
		assertEquals(756.6666666 , test.getY() , 0.0) ;
		
		System.out.println("After move down , X-coordinate : " + test.getX()) ;
		System.out.println("After move down , Y-coordinate : " + test.getY()) ;
	}
	
	/**
	 * Test if frog is in correct position X when ARROW LEFT is pressed and released
	 */
	@Test
	public void testLEFT() {
		
		System.out.println("\nTest case : Frog move LEFT") ;

		Animal test = new Animal("file:Resources/Frog/frogUp1.png") ;
		
		System.out.println("Before move left , X-coordinate : " + test.getX()) ;
		System.out.println("Before move left , Y-coordinate : " + test.getY()) ;
		
		test.fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED,KeyCode.LEFT.toString(), KeyCode.LEFT.toString(), KeyCode.LEFT, false, false, false, false));
		assertEquals(278.666668 , test.getX() , 0.0) ;
		
		test.fireEvent(new KeyEvent(KeyEvent.KEY_RELEASED,KeyCode.LEFT.toString(), KeyCode.LEFT.toString(), KeyCode.LEFT, false, false, false, false));
		assertEquals(257.33333600000003 , test.getX() , 0.0) ;
		
		System.out.println("After move left , X-coordinate : " + test.getX()) ;
		System.out.println("After move left , Y-coordinate : " + test.getY()) ;
	}
	
	/**
	 * Test if frog is in correct position X when ARROW RIGHT is pressed and released
	 */
	@Test
	public void testRIGHT() {
		
		System.out.println("\nTest case : Frog move RIGHT") ;
		
		Animal test = new Animal("file:Resources/Frog/frogUp1.png") ;
		
		System.out.println("Before move right , X-coordinate : " + test.getX()) ;
		System.out.println("Before move right , Y-coordinate : " + test.getY()) ;
		
		test.fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED,KeyCode.RIGHT.toString(), KeyCode.RIGHT.toString(), KeyCode.RIGHT, false, false, false, false));
		assertEquals(321.333332 , test.getX() , 0.0) ;
		
		test.fireEvent(new KeyEvent(KeyEvent.KEY_RELEASED,KeyCode.RIGHT.toString(), KeyCode.RIGHT.toString(), KeyCode.RIGHT, false, false, false, false));
		assertEquals(342.66666399999997 , test.getX() , 0.0) ;
		
		System.out.println("After move right , X-coordinate : " + test.getX()) ;
		System.out.println("After move right , Y-coordinate : " + test.getY()) ;
	}
	
	/**
	 * Test if score is added when frog passed score line
	 * Test if score line is reset
	 */
	@Test
	public void testScore() {
		
		System.out.println("\nTest case : Score line");

		Animal test = new Animal("file:Resources/Frog/frogUp1.png") ;
		
		System.out.println("Score before passing score line : " + StageScene.points);
		System.out.println("Score line before passing score line : " + test.scoreLine);
		
		test.fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED,KeyCode.UP.toString(), KeyCode.UP.toString(), KeyCode.UP, false, false, false, false));
		test.fireEvent(new KeyEvent(KeyEvent.KEY_RELEASED,KeyCode.UP.toString(), KeyCode.UP.toString(), KeyCode.UP, false, false, false, false));
		
		assertEquals(10 , StageScene.points) ;
		assertEquals(730.0 , test.scoreLine , 0.0) ;
		
		System.out.println("Score after passing score line : " + StageScene.points);
		System.out.println("Score line after passing score line : " + test.scoreLine);	
	}
	
	/**
	 * Test if frog hit the top or bottom boundaries
	 */
	@Test
	public void testBoundaryTopBottom()  {
		
		System.out.println("\nTest case : Top and bottom boundaries");
		
		Animal test = new Animal("file:Resources/Frog/frogUp1.png") ;
		
		test.setX(400.0);
		test.setY(-0.1) ;
		
		System.out.println("When frog hit top boundary (getY() < 0) , before reset");
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());

		StageScene a = new StageScene() ;
		a.add(test);
		
		test.act(0);
		
		assertEquals(300.0 , test.getX() , 0.0) ;
		assertEquals(756.6666666 , test.getY() , 0.0) ;
		
		System.out.println("When frog hit top boundary (getY() < 0) , after reset");
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());
		
		Animal test1 = new Animal("file:Resources/Frog/frogUp1.png") ;
		
		test1.setX(400.0);
		test1.setY(800.1) ;
		
		System.out.println("When frog hit bottom boundary (getY() > 800) , before reset");
		System.out.println("X-coordinate : " + test1.getX());
		System.out.println("Y-coordinate : " + test1.getY());
		
		StageScene b = new StageScene() ;
		b.add(test1);
		
		test1.act(0);
		
		assertEquals(300.0 , test1.getX() , 0.0) ;
		assertEquals(756.6666666 , test1.getY() , 0.0) ;
		
		System.out.println("When frog hit bottom boundary (getY() > 800) , after reset");
		System.out.println("X-coordinate : " + test1.getX());
		System.out.println("Y-coordinate : " + test1.getY());
	}
	
	/**
	 * Test if frog hit the left or right boundaries
	 */
	@Test
	public void testBoundaryLeftRight()  {
		
		System.out.println("\nTest case : Left and right boundaries");
		
		Animal test = new Animal("file:Resources/Frog/frogUp1.png") ;
		
		test.setY(400.0);
		test.setX(-0.1) ;
		
		System.out.println("When frog hit left boundary (getX() < 0) , before reset");
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());
		
		StageScene a = new StageScene() ;
		a.add(test);
		
		test.act(0);
		
		assertEquals(53.2333332 , test.getX() , 0.0) ;
		assertEquals(400.0 , test.getY() , 0.0) ;
		
		System.out.println("When frog hit left boundary (getX() < 0) , after reset");
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());
		
		Animal test1 = new Animal("file:Resources/Frog/frogUp1.png") ;
		
		test1.setY(400.0);
		test1.setX(570.1) ;
		
		System.out.println("When frog hit left boundary (getX() > 570) , before reset");
		System.out.println("X-coordinate : " + test1.getX());
		System.out.println("Y-coordinate : " + test1.getY());
		
		StageScene b = new StageScene() ;
		b.add(test1);
		
		test1.act(0);
		
		assertEquals(516.7666668 , test1.getX() , 0.0) ;
		assertEquals(400.0 , test1.getY() , 0.0) ;
		
		System.out.println("When frog hit left boundary (getX() > 057) , after reset");
		System.out.println("X-coordinate : " + test1.getX());
		System.out.println("Y-coordinate : " + test1.getY());
	}
	
	/**
	 * Test frog's vehicle death and its score deduction
	 */
	@Test
	public void testVehicleDeath() {
		
		System.out.println("\nTest case : Vehicle death and score deduction");

		Vehicle obstacle = new Vehicle("file:Resources/Truck/truck1Right.png", 300, 540, 1, 200, 200) ;
		
		Animal test = new Animal("file:Resources/Frog/frogUp1.png") ;
		
		test.setX(400.0) ;
		test.setY(540.0) ;
		
		StageScene b = new StageScene() ;
		StageScene.points = 50 ;
		
		System.out.println("Before frog death :");
		System.out.println("Score : " + StageScene.points);
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());
		
		b.add(test);
		b.add(obstacle);

		// vehicleDeath has 4 death animation , hence act(long now) need to be invoked 4 times
		test.act(0);
		test.act(0);
		test.act(0);
		test.act(0);
		
		assertEquals(300.0 , test.getX() , 0.0) ;
		assertEquals(756.6666666 , test.getY() , 0.0) ;
		assertEquals(0 , StageScene.points) ;
		
		System.out.println("After frog death :");
		System.out.println("Score : " + StageScene.points);
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());
		
	}
	
	/**
	 * Test frog's water death and its score deduction
	 */
	@Test
	public void testWaterDeath() {
		
		System.out.println("\nTest case : Water death and score deduction");
		
		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2000-01-01 00:00:00.0");
		
		System.out.println(timestamp.getTime());

		
		WetTurtle obstacle = new WetTurtle(500, 376, -1, 130, 130) ;
		
		// Frog staying on wet turtle until it sunk and frog fallen into water
		Animal test = new Animal("file:Resources/Frog/frogUp1.png") ;
		
		test.setX(500.0) ;
		test.setY(376.0) ;
		
		StageScene b = new StageScene() ;
		StageScene.points = 50 ;
		
		System.out.println("Before frog death (wet turtle havent sunk):");
		System.out.println("Score : " + StageScene.points);
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());
		
		b.add(test);	
		b.add(obstacle);
		
		obstacle.act(timestamp.getTime() + 3);

		// waterDeath has 5 death animation , hence act(long now) need to be invoked 5 times
		test.act(0);
		test.act(0);
		test.act(0);
		test.act(0);
		test.act(0);
		
		assertEquals(300.0 , test.getX() , 0.0) ;
		assertEquals(756.6666666 , test.getY() , 0.0) ; 
		assertEquals(0 , StageScene.points) ;
		
		System.out.println("After frog death (wet turtle had sunk):");
		System.out.println("Score : " + StageScene.points);
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());
		
		Animal test2 = new Animal("file:Resources/Frog/frogUp1.png") ;
		
		test2.setX(500.0) ;
		test2.setY(412.0) ;
		
		StageScene c = new StageScene() ;
		StageScene.points = 50 ;
		
		System.out.println("Before frog death (havent fall into water):");
		System.out.println("Score : " + StageScene.points);
		System.out.println("X-coordinate : " + test2.getX());
		System.out.println("Y-coordinate : " + test2.getY());
		
		c.add(test2);
		
		// waterDeath has 5 death animation , hence act(long now) need to be invoked 5 times
		test2.act(0);
		test2.act(0);
		test2.act(0);
		test2.act(0);
		test2.act(0);
		
		assertEquals(300.0 , test2.getX() , 0.0) ;
		assertEquals(756.6666666 , test2.getY() , 0.0) ; 
		assertEquals(0 , StageScene.points) ;
		
		System.out.println("Before frog death (fall into water):");
		System.out.println("Score : " + StageScene.points);
		System.out.println("X-coordinate : " + test2.getX());
		System.out.println("Y-coordinate : " + test2.getY());
	}
	
	
}