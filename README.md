# COMP2042_CW_LimYiYong

Key changed made for maintenance and extension
___________________________________________________________________

***General maintenance and extension***
• Added comments
  o Better understanding
•	Rearranged codes
  o	Better view
•	Eliminated typo and grammar mistakes
  o	Avoid misunderstandings
•	Used GitHub 
  o	Version control
•	Added meaningful names (packages , class , variable , method)
  o	Clean codes , pleasing to read
•	Added Junit test case
  o	Make sure the program is executed as expected

***Key changed made (compare with original code given)***
Actor.java (com.yiyonglim.Actor)
•	Removed getWidth(), getHeight(), manageInput(), getOneIntersectingObject()
  o	Unused methods

Animal.java (com.yiyonglim.Character)
•	Renamed variables’ name
  o	imgW1 -> frogMoveUp1
  o	imgW2 -> frogMoveUp2
  o	imgS1 -> frogMoveDown1
  o	imgS2 -> frogMoveDown2
  o	imgA1 -> frogMoveLeft1
  o	imgA2 -> frogMoveLeft2
  o	imgD1 -> frogMoveRight1
  o	imgD2 -> frogMoveRight2
    -	Controls has changed to ARROW UP, ARROW DOWN, ARROW LEFT and ARROW RIGHT
    -	Original variables’ name not appropriate
  o	second -> frogJump
  o	movementX -> frogMovementX
  o	movementY -> frogMovementY
  o	imgSize -> frogSize
  o	card -> frogDeathAnimation
  o	carDeath -> frogDeathByVehicle
  o	waterDeath -> frogDeathByWater
  o	w -> scoreLine
  o	noMove -> frogNoMove
    -	Original variables’ name not appropriate
•	Removed variables
  o	points
  o	end
    -	Set as static variable at StageScene.java
  o	stop
  o	changeScore
  o	inter
    -	Unused variables
•	Removed methods
  o	getStop()
  o	getPoints()
  o	changeScore()
    -	Unused methods
•	Changed implementation
  o	Highest possible score (800 -> 850)
    -	Game scoring system is changed
  o	Bottom boundary, y-coordinate (734 -> 800)
  o	Right boundary,  x-coordinate (600 -> 570)
  o	Frog’s base starting position , y-coordinate (679.8 -> 730)
    -	Game window size is set to 600 * 800
  o	Removed (getIntersectingObjects(End.class).size() >= 1)
    -	Game mechanism is changed to “enter specific goal in each stage to proceed to new stage”

Goal.java (com.yiyonglim.Goal)
•	Renamed class’s name
  o	End.java -> Goal.java
    -	Original class’s name not appropriate
•	Renamed variable’s name
  o	activated -> goalCompleted
    -	Original variable’s name not appropriate
•	Renamed methods’ name
  o	setEnd() -> setGoal()
  o	isActivated() -> isCompleted()
    -	Original methods’ name not appropriate

MainMenu.java (com.yiyonglim.Main)
•	Add to replace Main.java
    -	MainMenu.java is responsible for initializing and running the game
•	Create game menu , How To Play
  o	Teach user the controls and scoring system
•	Create game menu , Leaderboard
  o	Show top 10 high score
***This whole class is fully self-made , further details and explanation of codes are at MainMenu.java***

Vehicle.java (com.yiyonglim.Obstacle)
•	Renamed class’s name
  o	Obstacle.java -> Vehicle.java
    -	Original class’s name not appropriate
•	Renamed variable’s name
  o	speed -> vehicleSpeed
    -	Original variable’s name not appropriate

Log.java (com.yiyonglim.Platform)
•	Renamed variable’s name
  o	speed -> logSpeed
    -	Original variable’s name not appropriate

WetTurtle.java (com.yiyonglim.Platform)
•	Renamed variable’s name
  o	turtle1 -> wetTurtleSwim
  o	turtle2 -> wetTurtleSink1
  o	turtle3 -> wetTurtleSink2
  o	turtle4 -> wetTurtleSink3
  o	speed -> wetTurtleSpeed
    -	Original variable’s name not appropriate
•	Remove variables
  o	i
  o	bool
    -	Unused variable

Turtle.java (com.yiyonglim.Platform)
•	Renamed variable’s name
  o	turtle1 -> turtleSwim1
  o	turtle2 -> turtleSwim2
  o	turtle3 -> turtleSwim3
  o	speed -> turtleSpeed
    -	Original variable’s name not appropriate
•	Remove variables
  o	i
  o	bool
    -	Unused variable

Digit.java (com.yiyonglim.Scoreboard)
•	Renamed variable’s name
  o	im1 -> digit
    -	Original variable’s name not appropriate
•	Remove variables
  o	dim
    -	Unused variable

Stage1.java , Stage2.java , Stage3.java , Stage4.java , Stage5.java (com.yiyonglim.Stage)
•	Implemented 5 new stages
  o	Let user have better gaming experience
***These whole classes are self-made , further details and explanation of codes are at Stage1.java, Stage2.java, Stage3.java, Stage4.java, Stage5.java***

StageBackgroundImage.java (com.yiyonglim.StageBackgroundImage)
•	Renamed class’s name
  o	BackgroundImage.java -> StageBackgroundImage.java
    -	Original class’s name not appropriate
•	Renamed method’s name
  o	BackgroundImage() -> StageBackgroundImage()
    -	Original method’s name not appropriate
•	Created variable
  o	isBackgroundImageSet
    -	Track if the stage’s background is set
•	Created method
  o	isBackgroundImageSet()
    -	Return true when stage’s background is set and vice versa

StageScene.java (com.yiyonglim.StageScene)
•	Renamed class’s name
  o	MyStage.java -> StageScene.java
    -	Original class’s name not appropriate
•	Renamed methods’ name
  o	playMusic() -> playStageMusic()
  o	stopMusic() -> stopStageMusic()
    -	Original methods’ name not appropriate
•	Changed implementation
  o	StageScene()
    -	Pause game when user pressed ESCAPE
•	Created methods
  o	setScoreBoard()
    -	Set up scoreboard for each stages
  o	createStageTimer()
    -	Proceed to new stage when met requirement (value of end and stage must be the same)
    -	When reached end game , show and record score , close the program
•	Created variables
  o	currentStage (static)
    -	Track current stage
  o	points (static)
    -	Record points gained
  o	stageCompleted (static)
    -	Track number of stages completed
  o	stageTimer
    -	Track stage progress
•	Renamed variable’s name
  o	mediaPlayer -> stageMusic
    -	Original variable’s name not appropriate

World.java (com.yiyonglim.World)
•	Renamed variable’s name
  o	timer -> worldTimer
    -	Original variable’s name not appropriate

JUnit Test Case (com.yiyonglim.TestCase)
•	Wrote test cases
  o	AllTests.java
  o	AnimalTest.java
  o	DigitTest.java
  o	GoalTest.java
  o	LogTest.java
  o	ObstacleTest.java
  o	StageBackgroundTest.java
  o	StageSceneTest.java
  o	TurtleTest.java
  o	WetTurtleTest.java
    -	Make sure the game is executed as expected
***These whole Junit test cases are self-made , further details and explanation of codes is in AnimalTest.java, DigitTest.java, GoalTest.java, LogTest.java, ObstacleTest.java, StageBackgroundTest.java, StageSceneTest.java, TurtleTest.java, WetTurtleTest.java***
