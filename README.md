# COMP2042_CW_LimYiYong

## Key changed made for maintenance and extension
___________________________________________________________________

### General maintenance and extension

- Added comments
  - Better understanding
- Rearranged codes
  - Better view
- Eliminated typo and grammar mistakes
  - Avoid misunderstandings
- Used GitHub 
  - Version control
- Added meaningful names (packages , class , variable , method)
  - Clean codes , pleasing to read
- Added JUnit test case
  - Make sure the program is executed as expected
- Added Ant build files
  - To produce executable jar file , FroggerGame.jar

### Key changed made (compare with original code given)

>**Actor.java (com.yiyonglim.Actor)**

- Removed methods
  - getWidth()
  - getHeight()
  - manageInput() 
  - getOneIntersectingObject()
    - Unused methods

> **Animal.java (com.yiyonglim.Character)**

- Renamed variables’ name
  - imgW1 -> frogMoveUp1
  - imgW2 -> frogMoveUp2
  - imgS1 -> frogMoveDown1
  - imgS2 -> frogMoveDown2
  - imgA1 -> frogMoveLeft1
  - imgA2 -> frogMoveLeft2
  - imgD1 -> frogMoveRight1
  - imgD2 -> frogMoveRight2
    - Controls has changed to ARROW UP, ARROW DOWN, ARROW LEFT and ARROW RIGHT
    - Original variables’ name not appropriate
  - second -> frogJump
  - movementX -> frogMovementX
  - movementY -> frogMovementY
  - imgSize -> frogSize
  - card -> frogDeathAnimation
  - carDeath -> frogDeathByVehicle
  - waterDeath -> frogDeathByWater
  - w -> scoreLine
  - noMove -> frogNoMove
    -	Original variables’ name not appropriate
    
- Removed variables
  - points
  - end
    - Set as static variable at StageScene.java
  - stop
  -	changeScore
  -	inter
    -	Unused variables
    
- Removed methods
  - getStop()
  - getPoints()
  - changeScore()
    -	Unused methods
    
- Changed implementation
  -	Highest possible score (800 -> 850)
    -	Game scoring system is changed
  -	Bottom boundary, y-coordinate (734 -> 800)
  -	Right boundary,  x-coordinate (600 -> 570)
  -	Frog’s starting position , y-coordinate (679.8 -> 730)
    -	Game window size is set to 600 * 800
  -	Removed (getIntersectingObjects(End.class).size() >= 1)
    -	Game mechanism is changed to “enter specific goal in each stage to proceed to new stage”

>**Goal.java (com.yiyonglim.Goal)**

- Renamed class’s name
  -	End.java -> Goal.java
    -	Original class’s name not appropriate
- Renamed variable’s name
  -	activated -> goalCompleted
    -	Original variable’s name not appropriate
- Renamed methods’ name
  -	setEnd() -> setGoal()
  -	isActivated() -> isCompleted()
    -	Original methods’ name not appropriate

>**MainMenu.java (com.yiyonglim.Main)**

- Add to replace Main.java
  -	MainMenu.java is responsible for initializing and running the game
-	Create game menu (How To Play)
      - Teach user the controls and scoring system
-	Create game menu (Leaderboard)
      - Show top 10 high score

***This whole class is fully self-made , further details and explanation of implemented codes are at MainMenu.java***

>**Vehicle.java (com.yiyonglim.Obstacle)**

- Renamed class’s name
  -	Obstacle.java -> Vehicle.java
    -	Original class’s name not appropriate
- Renamed variable’s name
  -	speed -> vehicleSpeed
    -	Original variable’s name not appropriate

>**Log.java (com.yiyonglim.Platform)**

- Renamed variable’s name
  -	speed -> logSpeed
    -	Original variable’s name not appropriate

>**WetTurtle.java (com.yiyonglim.Platform)**

- Renamed variable’s name
  -	turtle1 -> wetTurtleSwim
  -	turtle2 -> wetTurtleSink1
  -	turtle3 -> wetTurtleSink2
  -	turtle4 -> wetTurtleSink3
  -	speed -> wetTurtleSpeed
    -	Original variable’s name not appropriate
- Removed variables
  -	i
  -	bool
    -	Unused variable

>**Turtle.java (com.yiyonglim.Platform)**

- Renamed variable’s name
  -	turtle1 -> turtleSwim1
  -	turtle2 -> turtleSwim2
  -	turtle3 -> turtleSwim3
  -	speed -> turtleSpeed
    -	Original variable’s name not appropriate
- Removed variables
  -	i
  -	bool
    -	Unused variable

>**Digit.java (com.yiyonglim.Scoreboard)**

- Renamed variable’s name
  -	im1 -> digit
    -	Original variable’s name not appropriate
- Removed variables
  -	dim
    -	Unused variable

>**Stage1.java , Stage2.java , Stage3.java , Stage4.java , Stage5.java (com.yiyonglim.Stage)**

-	Implemented 5 new stages
    -	Let user have better gaming experience
  
***These whole classes are fully self-made , further details and explanation of implemented codes are at Stage1.java, Stage2.java, Stage3.java, Stage4.java, Stage5.java accordingly***

>**StageBackgroundImage.java (com.yiyonglim.StageBackgroundImage)**

- Renamed class’s name
  -	BackgroundImage.java -> StageBackgroundImage.java
    -	Original class’s name not appropriate
- Renamed method’s name
  -	BackgroundImage() -> StageBackgroundImage()
    -	Original method’s name not appropriate
- Created variable
  -	isBackgroundImageSet
    -	Track if the stage’s background is set
- Created method
  -	isBackgroundImageSet()
    -	Return true when stage’s background is set and vice versa

>**StageScene.java (com.yiyonglim.StageScene)**

- Renamed class’s name
  -	MyStage.java -> StageScene.java
    -	Original class’s name not appropriate
- Renamed methods’ name
  -	playMusic() -> playStageMusic()
  -	stopMusic() -> stopStageMusic()
    -	Original methods’ name not appropriate
- Changed implementation
  -	StageScene()
    -	Pause game when user pressed ESCAPE
- Created methods
  -	setScoreBoard()
    -	Set up scoreboard for each stages
  -	createStageTimer()
    -	Proceed to new stage when met requirement (value of end and stage must be the same)
    -	When reached end game , show and record score , close the program
- Created variables
  -	currentStage (static)
    -	Track current stage
  -	points (static)
    -	Record points gained
  -	stageCompleted (static)
    -	Track number of stages completed
  -	stageTimer
    -	Track stage progress
- Renamed variable’s name
  -	mediaPlayer -> stageMusic
    -	Original variable’s name not appropriate

>**World.java (com.yiyonglim.World)**

- Renamed variable’s name
  -	timer -> worldTimer
    -	Original variable’s name not appropriate

>**JUnit Test Case (com.yiyonglim.TestCase)**

- Wrote test cases
  -	AllTests.java
  -	AnimalTest.java
  -	DigitTest.java
  -	GoalTest.java
  -	LogTest.java
  -	ObstacleTest.java
  -	StageBackgroundTest.java
  -	StageSceneTest.java
  -	TurtleTest.java
  -	WetTurtleTest.java
    -	Make sure the game is executed as expected
    
***These whole Junit test cases are fully self-made , further details and explanation of codes is in AnimalTest.java, DigitTest.java, GoalTest.java, LogTest.java, ObstacleTest.java, StageBackgroundTest.java, StageSceneTest.java, TurtleTest.java, WetTurtleTest.java accordingly***
