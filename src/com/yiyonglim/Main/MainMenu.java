package com.yiyonglim.Main ;

import java.io.BufferedReader ;
import java.io.File ;
import java.io.FileReader ;
import java.io.FileWriter ;
import java.io.IOException ;
import java.io.InputStream ;

import java.nio.file.Files ;
import java.nio.file.Paths ;

import com.yiyonglim.Stage.Stage1;

import javafx.animation.FadeTransition ;
import javafx.animation.TranslateTransition ;

import javafx.application.Application ;

import javafx.geometry.Pos ;

import javafx.scene.Parent ;
import javafx.scene.Scene ;
import javafx.scene.effect.DropShadow ;
import javafx.scene.effect.GaussianBlur ;
import javafx.scene.effect.Glow ;
import javafx.scene.image.Image ;
import javafx.scene.image.ImageView ;
import javafx.scene.layout.Pane ;
import javafx.scene.layout.StackPane ;
import javafx.scene.layout.VBox ;
import javafx.scene.media.Media ;
import javafx.scene.media.MediaPlayer ;
import javafx.scene.paint.Color ;
import javafx.scene.shape.Rectangle ;
import javafx.scene.text.Font ;
import javafx.scene.text.Text ;
import javafx.scene.input.KeyCode ;

import javafx.stage.Stage ;

import javafx.util.Duration ;

/**
 * Main menu
 * The {@code MainMenu} class is responsible for initializing and running the game.
 * @author yiyonglim
 */
public class MainMenu extends Application {

		MediaPlayer mainMenuMediaPlayer ;

	    private GameMenu mainMenu ;
	   
	    /**
	     * Start main menu
	     * @throws IOException If an input or output exception has occurred
	     */
	    @Override
	    public void start(Stage primaryStage) throws Exception {

	    	setMusic() ;
	    	
	    	// Window interface
	        Pane root = new Pane();
	        root.setPrefSize(600, 800);
	        
	        // Main menu interface
	        mainMenu = new GameMenu();
	        mainMenu.setVisible(false);

	        // Game title --> FROGGER
	        InputStream gameTitle = Files.newInputStream(Paths.get("Resources/Font/frogger.png"));
	        Image gameTitleImg = new Image(gameTitle);
	        gameTitle.close() ;
	        ImageView gameTitleView = new ImageView(gameTitleImg);
	        gameTitleView.setX(30);
	        gameTitleView.setY(35);
	        gameTitleView.setScaleX(1) ;
	        gameTitleView.setScaleY(1.4) ;
	        
	        // Instruction --> PRESS ENTER
	        InputStream pressEnter = Files.newInputStream(Paths.get("Resources/Font/pressEnter.png"));
	        Image pressEnterImg = new Image(pressEnter);
	        pressEnter.close();
	        ImageView pressEnterView = new ImageView(pressEnterImg);
	        pressEnterView.setX(-25);
	        pressEnterView.setY(500);
	        pressEnterView.setScaleX(0.7) ;
	        pressEnterView.setScaleY(0.7) ;
	        pressEnterView.setVisible(false);
	        
	        // Main menu background
	        InputStream background = Files.newInputStream(Paths.get("Resources/MainMenuBackground/mainMenuBackground.gif"));
	        Image backgroundImg = new Image(background);
	        background.close();
	        ImageView backgroundView = new ImageView(backgroundImg);
	        backgroundView.setY(20);
	        backgroundView.setFitWidth(600);
	        backgroundView.setFitHeight(800);
	        
	        root.getChildren().addAll(backgroundView,gameTitleView,pressEnterView, mainMenu);
	        
	        Scene scene = new Scene(root);
	        
	        // When user's mouse enter scene , "PRESS ENTER" instruction is shown , main menu music is played
	        scene.setOnMouseEntered(event -> {

        		mainMenuMediaPlayer.play();

	        	if (mainMenu.isVisible()) {
	        		
	        		pressEnterView.setVisible(false);
	        	} else {

	        		pressEnterView.setVisible(true);
	        	}
	        }) ;
	        
	        // When user's mouse exit scene , "PRESS ENTER" instruction is hidden
	        scene.setOnMouseExited(event -> {
	        	
	        	pressEnterView.setVisible(false) ;
	        }) ;
	        
	        // Show main menu by pressing "ENTER" , hide it by pressing "ENTER" again
	        scene.setOnKeyPressed(event -> {
	        	
	            if (event.getCode() == KeyCode.ENTER) {
	            	
	                if (!mainMenu.isVisible()) {
	                	
	                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), mainMenu);
	                    
	                    ft.setFromValue(0);
	                    ft.setToValue(1);
	                    mainMenu.setVisible(true);
	                    pressEnterView.setVisible(false);
	                    ft.play();
	                }
	                else {
	                	
	                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), mainMenu);
	                    
	                    ft.setFromValue(1);
	                    ft.setToValue(0);
	                    ft.setOnFinished(evt -> mainMenu.setVisible(false));
	                    ft.play();
	                }
	            }
	        });
	        
	        // Set up game window
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("MAIN MENU");
	        primaryStage.setResizable(false);
	        primaryStage.show();
	    }

	    /**
	     * Set up main menu , how to play and leaderboard
	     * @author yiyonglim
	     */
	    private class GameMenu extends Parent {
	    	
	    	/**
	    	 * Set up main menu , how to play and leaderboard
	    	 * @throws IOException If an input or output exception has occurred
	    	 */
	        public GameMenu() throws IOException {

	        	final int offset = 400;
	        	
	            VBox mainMenu = new VBox(10);
	            mainMenu.setTranslateX(50);
	            mainMenu.setTranslateY(350);
	            
	            VBox howToPlay = new VBox(10);
	            howToPlay.setTranslateX(offset);
	            howToPlay.setTranslateY(200);
	            
	            VBox leaderboard = new VBox(10);
	            leaderboard.setTranslateX(offset);
	            leaderboard.setTranslateY(200); 
	            
	            Button startButton = new Button("START");
	            startButton.setOnMouseClicked(event -> {

	            	FadeTransition ft = new FadeTransition(Duration.seconds(2), this);
	            	
	                ft.setFromValue(1);
	                ft.setToValue(0);
	                ft.setOnFinished(evt -> setVisible(false));
	                ft.play();

	                mainMenuMediaPlayer.stop() ;
	                
	                // Start stage 1
	                Stage1 stage1 = new Stage1() ;
	    			try {
	    				stage1.start(new Stage()) ;
					} catch (Exception e) {
						e.printStackTrace();
					}
	            });

	            Button howToPlayButton = new Button("HOW TO PLAY");
	            howToPlayButton.setOnMouseClicked(event -> {
	            	
	                getChildren().add(howToPlay);

	                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), mainMenu);
	                tt.setToX(mainMenu.getTranslateX() - offset);
	                
	                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), howToPlay);
	                tt1.setToX(mainMenu.getTranslateX());
	                
	                tt.play();
	                tt1.play();
	                
	                tt.setOnFinished(evt -> {
	                    getChildren().remove(mainMenu);
	                });
	            });
	            
	            Button backButtonHowToPlay = new Button("BACK");
	            backButtonHowToPlay.setOnMouseClicked(event -> {
	            	
	                getChildren().add(mainMenu);

	                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), howToPlay);
	                tt.setToX(howToPlay.getTranslateX() + offset);

	                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), mainMenu);
	                tt1.setToX(howToPlay.getTranslateX());

	                tt.play();
	                tt1.play();

	                tt.setOnFinished(evt -> {
	                    getChildren().remove(howToPlay);
	                });
	            });
	            
	            Button leaderboardButton = new Button("LEADERBOARD");
	            leaderboardButton.setOnMouseClicked(event -> {
	            	
	                getChildren().add(leaderboard);
	                
	                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), mainMenu);
	                tt.setToX(mainMenu.getTranslateX() - offset);
	                
	                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), leaderboard);
	                tt1.setToX(mainMenu.getTranslateX());
	                
	                tt.play();
	                tt1.play();
	                
	                tt.setOnFinished(evt -> {
	                    getChildren().remove(mainMenu);
	                });
	            });
	            
	            Button backButtonLeaderboard = new Button("BACK");
	            backButtonLeaderboard.setTranslateY(-120);
	            backButtonLeaderboard.setOnMouseClicked(event -> {
	            	
	                getChildren().add(mainMenu);

	                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), leaderboard);
	                tt.setToX(leaderboard.getTranslateX() + offset);

	                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), mainMenu);
	                tt1.setToX(leaderboard.getTranslateX());

	                tt.play();
	                tt1.play();

	                tt.setOnFinished(evt -> {
	                    getChildren().remove(leaderboard);
	                });
	            });

	            Button exitButton = new Button("EXIT");
	            exitButton.setOnMouseClicked(event -> {
	            	
	                System.exit(0);
	            });
	            
	            // Components in HOW TO PLAY
	            InputStream controls = Files.newInputStream(Paths.get("Resources/HowToPlay/controls.gif"));
		        Image controlsImg = new Image(controls);
		        controls.close();
	            ImageView controlsView = new ImageView(controlsImg) ;
	            controlsView.setTranslateX(200);
	            controlsView.setTranslateY(50) ;
	            controlsView.setScaleX(2);
	            controlsView.setScaleY(2);
	            
	            InputStream frogJump = Files.newInputStream(Paths.get("Resources/HowToPlay/frogJump.gif"));
		        Image frogJumpImg = new Image(frogJump);
		        frogJump.close();
	            ImageView frogJumpView = new ImageView(frogJumpImg) ;
	            frogJumpView.setTranslateX(-40);
	            frogJumpView.setTranslateY(20) ;
	            frogJumpView.setScaleX(0.8);
	            frogJumpView.setScaleY(2);
	            
	            InputStream plus10 = Files.newInputStream(Paths.get("Resources/HowToPlay/plus10.gif"));
		        Image plus10Img = new Image(plus10);
		        plus10.close();
	            ImageView plus10View = new ImageView(plus10Img) ;
	            plus10View.setTranslateX(40);
	            plus10View.setTranslateY(-25) ;
	            plus10View.setScaleX(1.75);
	            plus10View.setScaleY(1.75);
	            
	            InputStream goal = Files.newInputStream(Paths.get("Resources/Goal/End1.png"));
		        Image goalImg = new Image(goal);
		        goal.close();
	            ImageView goalView = new ImageView(goalImg) ;
	            goalView.setTranslateX(260);
	            goalView.setTranslateY(-130) ;
	            goalView.setScaleX(1.5);
	            goalView.setScaleY(1.5);
	            
	            InputStream plus50 = Files.newInputStream(Paths.get("Resources/HowToPlay/plus50.gif"));
		        Image plus50Img = new Image(plus50);
		        plus50.close();
	            ImageView plus50View = new ImageView(plus50Img) ;
	            plus50View.setTranslateX(375);
	            plus50View.setTranslateY(-235) ;
	            plus50View.setScaleX(1.75);
	            plus50View.setScaleY(1.75);
	            
	            InputStream death = Files.newInputStream(Paths.get("Resources/HowToPlay/death.gif"));
		        Image deathImg = new Image(death);
		        death.close();
	            ImageView deathImgView = new ImageView(deathImg) ;
	            deathImgView.setTranslateX(250);
	            deathImgView.setTranslateY(-275) ;
	            deathImgView.setScaleX(0.6);
	            deathImgView.setScaleY(0.6);
	            
	            InputStream minus50 = Files.newInputStream(Paths.get("Resources/HowToPlay/50.gif"));
		        Image minus50Img = new Image(minus50);
		        minus50.close();
	            ImageView minus50View = new ImageView(minus50Img) ;
	            minus50View.setTranslateX(150);
	            minus50View.setTranslateY(-400) ;
	            minus50View.setScaleX(2.1);
	            minus50View.setScaleY(2.1);
	            
	            InputStream x = Files.newInputStream(Paths.get("Resources/HowToPlay/x.gif"));
		        Image xImg = new Image(x);
		        x.close();
	            ImageView xView = new ImageView(xImg) ;
	            xView.setTranslateX(-70);
	            xView.setTranslateY(-695) ;
	            xView.setScaleX(0.4);
	            xView.setScaleY(0.4);
	            
	            // LEADERBOARD
	            // Create leaderboard.txt (TOP 10 highscore)
	            try {
	            	
	                File txt = new File("leaderboard.txt");
	                
	                if (txt.createNewFile()) {
	                	
	                  System.out.println("File created: " + txt.getName());
	                  
	                  try {
	                	  
	  	                FileWriter myWriter = new FileWriter("leaderboard.txt");
	  	                myWriter.write("800\n200\n300\n400\n500\n250\n150\n580\n350\n600");
	  	                myWriter.close();
	  	              } catch (IOException e) {
	  	            	  
	  	                System.out.println("Failed creating score in leaderboard.txt");
	  	                e.printStackTrace();
	  	              }
	                } else {
	                	
	                  System.out.println("leaderboard.txt already exists.");
	                }
	            } catch (IOException e) {
	            	
	                System.out.println("An error occurred.");
	                e.printStackTrace();
	            }
	                    
	            // Read TOP 10 high score from leaderboard.txt and show them at LEADERBOARD
	            int[] highScoreArray = new int[100];
        		int n = 0 ;
        		
        		try {
        			
        	        BufferedReader reader = new BufferedReader(new FileReader("leaderboard.txt"));
        	        String line = reader.readLine();
        	        
        	        while (line != null) {
        	        	
        	            try {
        	            	
        	                int score = Integer.parseInt(line.trim());
        	                highScoreArray[n] = score ;
        	                n++ ;
        	            } catch (NumberFormatException e1) {
        	                
        	            }
        	            line = reader.readLine();
        	        }
        	        reader.close();
        	    } catch (IOException ex) {
        	        System.err.println("ERROR reading scores from file");
        	    }
	            
        		// Sort in descending order
        		for (int i = 1; i < n; i++) {
        			
        	        int currentScore = highScoreArray[i];
        	        int j = i - 1;
        	        
        	        while(j >= 0 && currentScore < highScoreArray[j]) {
        	        	
        	            highScoreArray[j+1] = highScoreArray[j];
        	            j--;
        	        }
        	        highScoreArray[j+1] = currentScore;
        	    }
        		
        		int highScore1 = highScoreArray[n-1] ;
        		int highScore2 = highScoreArray[n-2] ;
        		int highScore3 = highScoreArray[n-3] ;
        		int highScore4 = highScoreArray[n-4] ;
        		int highScore5 = highScoreArray[n-5] ;
        		int highScore6 = highScoreArray[n-6] ;
        		int highScore7 = highScoreArray[n-7] ;
        		int highScore8 = highScoreArray[n-8] ;
        		int highScore9 = highScoreArray[n-9] ;
        		int highScore10 = highScoreArray[n-10] ;
        		
	            HighScore high1 = new HighScore("1st : " + highScore1);
	            HighScore high2 = new HighScore("2nd : " + highScore2);
	            HighScore high3 = new HighScore("3rd : " + highScore3);
	            HighScore high4 = new HighScore("4th : " + highScore4);
	            HighScore high5 = new HighScore("5th : " + highScore5);
	            HighScore high6 = new HighScore("6th : " + highScore6);
	            HighScore high7 = new HighScore("7th : " + highScore7);
	            HighScore high8 = new HighScore("8th : " + highScore8);
	            HighScore high9 = new HighScore("9th : " + highScore9);
	            HighScore high10 = new HighScore("10th : " + highScore10);
	            
	            mainMenu.getChildren().addAll(startButton, howToPlayButton, leaderboardButton , exitButton);
	            howToPlay.getChildren().addAll(backButtonHowToPlay,controlsView,frogJumpView,plus10View,goalView,plus50View,deathImgView,minus50View,xView);
	            leaderboard.getChildren().addAll(backButtonLeaderboard,high1,high2,high3,high4,high5,high6,high7,high8,high9,high10) ;

	            // Fade effect when main menu is shown
	            Rectangle backgroundEffect = new Rectangle(600, 800);
	            backgroundEffect.setFill(Color.GREY);
	            backgroundEffect.setOpacity(0.8);

	            getChildren().addAll(backgroundEffect, mainMenu);
	        }
	    }

	    /**
	     * Set effect and style for buttons
	     * @author yiyonglim
	     */
	    private static class Button extends StackPane {
	        
	    	private Text text ;
	        
	        /**
	         * Set effect and style for buttons
	         * @param name Text shown on button
	         */
	        public Button(String name) {
	        	
	            text = new Text(name);
	            text.setFont(Font.loadFont("file:Resources/Font/BACKTO1982.ttf", 40));
	            text.setFill(Color.WHITE);

	            Rectangle buttonEffect = new Rectangle(500, 100);
	            buttonEffect.setOpacity(0.6);
	            buttonEffect.setFill(Color.BLACK);
	            buttonEffect.setEffect(new GaussianBlur(3.5));

	            setAlignment(Pos.CENTER);
	            setRotate(-0.5);
	            getChildren().addAll(buttonEffect, text);

	            setOnMouseEntered(event -> {
	            	playButtonSoundEffect() ;
	                buttonEffect.setTranslateX(10);
	                text.setTranslateX(10);
	                buttonEffect.setFill(Color.WHITE);
	                text.setFill(Color.BLACK);
	            });

	            setOnMouseExited(event -> {
	                buttonEffect.setTranslateX(0);
	                text.setTranslateX(0);
	                buttonEffect.setFill(Color.BLACK);
	                text.setFill(Color.WHITE);
	            });

	            DropShadow drop = new DropShadow(50, Color.WHITE);
	            drop.setInput(new Glow());

	            setOnMousePressed(event -> setEffect(drop));
	            setOnMouseReleased(event -> setEffect(null));
	        }
	        
	    }

	    /**
	     * Set effect and style for TOP 10 high score
	     * @author yiyonglim
	     */
	    private static class HighScore extends StackPane {
	    	
	        private Text text;

	        /**
	         * Set effect and style for TOP 10 high score
	         * @param name Score being shown
	         */
	        public HighScore(String name) {
	        	
	        	setTranslateY(-120) ;
	            text = new Text(name);
	            text.setFont(Font.loadFont("file:Resources/Font/INVASION2000.ttf", 50));
	            text.setFill(Color.WHITE);

	            Rectangle scoreEffect = new Rectangle(500, 50);
	            scoreEffect.setOpacity(0.6);
	            scoreEffect.setFill(Color.BLACK);
	            scoreEffect.setEffect(new GaussianBlur(3.5));

	            setAlignment(Pos.CENTER);
	            setRotate(-0.5);
	            getChildren().addAll(scoreEffect, text);

	            setOnMouseEntered(event -> {
	                scoreEffect.setTranslateX(10);
	                text.setTranslateX(10);
	                scoreEffect.setFill(Color.BLACK);
	                text.setFill(Color.WHITE);
	            });

	            setOnMouseExited(event -> {
	                scoreEffect.setTranslateX(0);
	                text.setTranslateX(0);
	                scoreEffect.setFill(Color.BLACK);
	                text.setFill(Color.WHITE);
	            });
	        }
	        
	    }
	 
    	/**
    	 * Set main menu music
    	 */
    	public void setMusic() {
    		
        	String mainMenuMusicFile = "Resources/MainMenuMusicAndSoundEffect/MainMenuMusic.mp3";   
        	Media mainMenuMusic = new Media(new File(mainMenuMusicFile).toURI().toString()) ;
        	mainMenuMediaPlayer = new MediaPlayer(mainMenuMusic) ;
        	mainMenuMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE) ;
    	}
    	
	    /**
	     * Play sound effect when mouse passes buttons
	     */
	    public static void playButtonSoundEffect() {
			String buttonSoundEffectFile = "Resources/MainMenuMusicAndSoundEffect/ButtonSoundEffect.wav";   
			Media buttonSoundEffect = new Media(new File(buttonSoundEffectFile).toURI().toString()) ;
			MediaPlayer buttonSound = new MediaPlayer(buttonSoundEffect) ;
			buttonSound.setCycleCount(1);
			buttonSound.play() ;
		}
	    
	    /**
	     * Start javafx program
	     * @param args Arguments passed by command line while starting a program
	     */
	    public static void main(String[] args) {
	    	
	        launch(args);
	    }
	}