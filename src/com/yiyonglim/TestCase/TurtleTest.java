package com.yiyonglim.TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yiyonglim.Platform.Turtle;

import javafx.embed.swing.JFXPanel;

/**
 * Turtle.class test case (2 test cases)
 * @author yiyonglim
 */
public class TurtleTest {

	JFXPanel jfxPanel = new JFXPanel() ;

	/**
	 * Test if starting position of turtle is correct
	 */
	@Test
	public void testPosition() {
		
		System.out.println("\nTest case : Turtle's starting position");
		
		Turtle test = new Turtle(500, 376, -1, 130, 130) ;
		
		assertEquals(500.0 , test.getX(), 0.0) ;
		assertEquals(376.0 , test.getY(), 0.0) ;
		
		System.out.println("Starting position , X-coordinate : " + test.getX()) ;
		System.out.println("Starting position , Y-coordinate : " + test.getY()) ;
	}

	/**
	 * Test if turtle is acting normally
	 */
	@Test
	public void testBehaviour() {
		
		System.out.println("\nTest case : Turtle's  behaviour");
		
		Turtle test = new Turtle(601, 376, 1, 130, 130) ;
		
		System.out.println("When whole turtle exit right boundary (getX() > 600) and its speed is 1 (speed > 0), before reset");
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());
		
		test.act(0);

		assertEquals(-200.0 , test.getX(), 0.0) ;

		System.out.println("When whole turtle exit right boundary (getX() > 600) and its speed is 1 (speed > 0), after reset");
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());
		
		Turtle test1 = new Turtle(-76, 376, -1, 130, 130) ;
		
		System.out.println("When whole turtle exit left boundary (getX() < -75) and its speed is -1 (speed < 0), before reset");
		System.out.println("X-coordinate : " + test1.getX());
		System.out.println("Y-coordinate : " + test1.getY());
		
		test1.act(0);

		assertEquals(600.0 , test1.getX(), 0.0) ;

		System.out.println("When whole turtle exit left boundary (getX() < -75) and its speed is -1 (speed < 0), after reset");
		System.out.println("X-coordinate : " + test1.getX());
		System.out.println("Y-coordinate : " + test1.getY());
	}

}
