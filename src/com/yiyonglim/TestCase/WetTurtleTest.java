package com.yiyonglim.TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yiyonglim.Platform.WetTurtle;

import javafx.embed.swing.JFXPanel;

/**
 * WetTurtle.class test case (3 test cases)
 * @author yiyonglim
 */
public class WetTurtleTest {

	JFXPanel jfxPanel = new JFXPanel() ;

	/**
	 * Test if starting position of wet turtle is correct
	 */
	@Test
	public void testPosition() {
		
		System.out.println("\nTest case : Wet turtle's starting position");
		
		WetTurtle test = new WetTurtle(700, 376, -1, 130, 130) ;
		
		assertEquals(700.0 , test.getX(), 0.0) ;
		assertEquals(376.0 , test.getY(), 0.0) ;
		
		System.out.println("Starting position , X-coordinate : " + test.getX()) ;
		System.out.println("Starting position , Y-coordinate : " + test.getY()) ;
	}
	
	/**
	 * Test if wet turtle is sunk or not
	 */
	@Test
	public void testSunk() {
		
		System.out.println("\nTest case : Wet turtle sunk or float");

		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2000-01-01 00:00:00.0");
		
		WetTurtle test = new WetTurtle(700, 376, -1, 130, 130) ;

		assertEquals(false , test.isSunk()) ;
		
		System.out.println("When stage first started , wet turtle sunk : " + test.isSunk()) ;
	
		test.act(timestamp.getTime());
		
		assertEquals(true , test.isSunk()) ;
		
		System.out.println("When stage first for awhile , wet turtle sunk : " + test.isSunk()) ;
	}
	
	/**
	 * Test if wet turtle is acting normally
	 */
	@Test
	public void testBehaviour() {
		
		System.out.println("\nTest case : Wet turtle's  behaviour");
		
		WetTurtle test = new WetTurtle(601, 376, 1, 130, 130) ;
		
		System.out.println("When whole wet turtle exit right boundary (getX() > 600) and its speed is 1 (speed > 0), before reset");
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());
		
		test.act(0);

		assertEquals(-200.0 , test.getX(), 0.0) ;

		System.out.println("When whole wet turtle exit right boundary (getX() > 600) and its speed is 1 (speed > 0), after reset");
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());
		
		WetTurtle test1 = new WetTurtle(-76, 376, -1, 130, 130) ;
		
		System.out.println("When whole wet turtle exit left boundary (getX() < -75) and its speed is -1 (speed < 0), before reset");
		System.out.println("X-coordinate : " + test1.getX());
		System.out.println("Y-coordinate : " + test1.getY());
		
		test1.act(0);

		assertEquals(600.0 , test1.getX(), 0.0) ;

		System.out.println("When whole wet turtle exit left boundary (getX() < -75) and its speed is -1 (speed < 0), after reset");
		System.out.println("X-coordinate : " + test1.getX());
		System.out.println("Y-coordinate : " + test1.getY());
	}
}
