package com.yiyonglim.TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yiyonglim.Platform.Log;

import javafx.embed.swing.JFXPanel;

/**
 * Log.class test case (3 test cases)
 * @author yiyonglim
 */
public class LogTest {

	JFXPanel jfxPanel = new JFXPanel() ;
	
	/**
	 * Test if starting position of log is correct
	 */
	@Test
	public void testPosition() {
		
		System.out.println("\nTest case : Log's starting position");
		
		Log test = new Log("file:Resources/Log/log3.png", 150, 0, 166, 0.75) ;
		
		assertEquals(0.0 , test.getX(), 0.0) ;
		assertEquals(166.0 , test.getY(), 0.0) ;
		
		System.out.println("Starting position , X-coordinate : " + test.getX()) ;
		System.out.println("Starting position , Y-coordinate : " + test.getY()) ;
	}

	/**
	 * Test if log is acting normally
	 */
	@Test
	public void testBehaviour() {
		
		System.out.println("\nTest case : Log's  behaviour");
		
		Log test = new Log("file:Resources/Log/log3.png", 150, 601, 166, 1) ;
		
		System.out.println("When whole log exit right boundary (getX() > 600) and its speed is 1 (speed > 0), before reset");
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());
		
		test.act(0);

		assertEquals(-180.0 , test.getX(), 0.0) ;

		System.out.println("When whole log exit right boundary (getX() > 600) and its speed is 1 (speed > 0), after reset");
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());
		
		Log test1 = new Log("file:Resources/Log/log3.png", 150, -301, 166, -1) ;
		
		System.out.println("When whole log exit left boundary (getX() < -300) and its speed is 1 (speed < 0), before reset");
		System.out.println("X-coordinate : " + test1.getX());
		System.out.println("Y-coordinate : " + test1.getY());
		
		test1.act(0);

		assertEquals(700.0 , test1.getX(), 0.0) ;

		System.out.println("When whole log exit left boundary (getX() < -300) and its speed is 1 (speed < 0), after reset");
		System.out.println("X-coordinate : " + test1.getX());
		System.out.println("Y-coordinate : " + test1.getY());
	}
	
	/**
	 * Test if log's movement speed is less than 0
	 */
	@Test
	public void testSpeed() {
		
		System.out.println("\nTest case : Log's  speed");
		
		Log test = new Log("file:Resources/Log/log3.png", 150, 601, 166, -1) ;
	
		assertEquals(true , test.getLeft()) ;
	
		System.out.println("Is log's speed < 0 : " + test.getLeft());
	}
}
