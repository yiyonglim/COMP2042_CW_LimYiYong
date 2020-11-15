package com.yiyonglim.TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yiyonglim.StageBackgroundImage.StageBackgroundImage;

import javafx.embed.swing.JFXPanel;

/**
 * StageBackgroundImage.class test case (1 test cases)
 * @author yiyonglim
 */
public class StageBackgroundImageTest {

	JFXPanel jfxPanel = new JFXPanel() ;
	
	/**
	 * Test if stage's background image is set
	 */
	@Test
	public void test() {
		System.out.println("Test case : Stage's background image") ;

		StageBackgroundImage test =  new StageBackgroundImage("file:Resources/StageBackground/Stage1Background.png") ;
		
		assertEquals(true , test.isSet()) ;
		System.out.println("Is stage's background image set : " + test.isSet());
	}

}
