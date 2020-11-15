package com.yiyonglim.TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yiyonglim.Scoreboard.Digit;

import javafx.embed.swing.JFXPanel;

/**
 * Digit.class test case (1 test cases)
 * @author yiyonglim
 */
public class DigitTest {

	JFXPanel jfxPanel = new JFXPanel() ;

	/**
	 * Test if score board is in correct position
	 */
	@Test
	public void testPosition() {
		
		System.out.println("\nTest case : Score board's starting position");
		
		Digit test = new Digit(0, 30, 570, 25) ;
		
		assertEquals(570.0 , test.getX(), 0.0) ;
		assertEquals(25.0 , test.getY(), 0.0) ;
		
		System.out.println("Starting position , X-coordinate : " + test.getX());
		System.out.println("Starting position , Y-coordinate : " + test.getY());
	}

}
