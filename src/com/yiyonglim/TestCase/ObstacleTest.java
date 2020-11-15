package com.yiyonglim.TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yiyonglim.Obstacle.Obstacle;

import javafx.embed.swing.JFXPanel;

/**
 * Obstacle.class test case (2 test cases)
 * @author yiyonglim
 */
public class ObstacleTest {
	
	JFXPanel jfxPanel = new JFXPanel() ;

	/**
	 * Test if starting position of obstacle is correct
	 */
	@Test
	public void testPosition() {
		System.out.println("\nTest case : Obstacle's starting position");
		
		Obstacle test = new Obstacle("file:Resources/Car/carLeft.png", 150, 704, -1, 50, 50) ;
		
		assertEquals(150.0 , test.getX(), 0.0) ;
		assertEquals(704.0 , test.getY(), 0.0) ;
		
		System.out.println("Starting position , X-coordinate : " + test.getX()) ;
		System.out.println("Starting position , Y-coordinate : " + test.getY()) ;
	}

	/**
	 * Test if obstacle is acting normally
	 */
	@Test
	public void testBehaviour() {
		System.out.println("\nTest case : Obstacle's  behaviour");
		
		Obstacle test = new Obstacle("file:Resources/Car/carLeft.png", 601, 597, 1, 50, 50) ;
		
		System.out.println("When whole obstacle exit right boundary (getX() > 600) and its speed is 1 (speed > 0), before reset");
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());
		
		test.act(0);

		assertEquals(-200.0 , test.getX(), 0.0) ;

		System.out.println("When whole obstacle exit right boundary (getX() > 600) and its speed is 1 (speed > 0), after reset");
		System.out.println("X-coordinate : " + test.getX());
		System.out.println("Y-coordinate : " + test.getY());
		
		Obstacle test1 = new Obstacle("file:Resources/Car/carLeft.png", -51, 597, -1, 50, 50) ;
		
		System.out.println("When whole obstacle exit left boundary (getX() < -50) and its speed is -1 (speed < 0), before reset");
		System.out.println("X-coordinate : " + test1.getX());
		System.out.println("Y-coordinate : " + test1.getY());
		
		test1.act(0);

		assertEquals(600.0 , test1.getX(), 0.0) ;

		System.out.println("When whole obstacle exit left boundary (getX() < -50) and its speed is -1 (speed < 0), after reset");
		System.out.println("X-coordinate : " + test1.getX());
		System.out.println("Y-coordinate : " + test1.getY());
	}
}
