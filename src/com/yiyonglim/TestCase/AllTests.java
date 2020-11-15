package com.yiyonglim.TestCase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AnimalTest.class, DigitTest.class, GoalTest.class, LogTest.class, ObstacleTest.class,
		StageBackgroundImageTest.class, StageSceneTest.class, TurtleTest.class, WetTurtleTest.class })
public class AllTests {

}
