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
 * It contains START , HOW TO PLAY , LEADERBOARD , EXIT
 * The {@code MainMenu} class is responsible for initializing and running the game.
 * @author yiyonglim
 */
public class MainMenu extends Application {
		// Initialize media player to play music
		MediaPlayer mediaPlayer ;
		// Initialize game menu (Main menu , How to play , Leaderboard)
	    private GameMenu mainMenu ;
	   
	    /**
	     * Start main menu
	     * @throws IOException If an input or output exception occurred (image)
	     */
	    @Override
	    public void start(Stage primaryStage) throws Exception {
	    	// Play main menu music
	    	setMusic() ;
	    	
	    	// Set main menu interface
	        Pane root = new Pane();
	        root.setPrefSize(600, 800);
	        
	        // Set up a game menu for main menu
	        mainMenu = new GameMenu();
	        mainMenu.setVisible(false);

	        // Set title's image
	        InputStream title = Files.newInputStream(Paths.get("Resources/Font/frogger.png"));
	        Image titleImg = new Image(title);
	        title.close();
	        // Set title's position
	        ImageView titleView = new ImageView(titleImg);
	        titleView.setX(30);
	        titleView.setY(35);
	        // Set title's size
	        titleView.setScaleX(1) ;
	        titleView.setScaleY(1.4) ;
	        
	        // Set instruction to show main menu
	        InputStream pressEnter = Files.newInputStream(Paths.get("Resources/Font/pressEnter.png"));
	        Image pressEnterImg = new Image(pressEnter);
	        pressEnter.close();
	        // Set instruction's position
	        ImageView pressEnterView = new ImageView(pressEnterImg);
	        pressEnterView.setX(-25);
	        pressEnterView.setY(500);
	        // Set instruction's size
	        pressEnterView.setScaleX(0.7) ;
	        pressEnterView.setScaleY(0.7) ;
	        // Set instruction's visibility
	        pressEnterView.setVisible(false);
	        
	        // Set background image
	        InputStream bg = Files.newInputStream(Paths.get("Resources/MainMenuBackground/mainMenuBackground.gif"));
	        Image bgImg = new Image(bg);
	        bg.close();
	        // Set background image position
	        ImageView bgView = new ImageView(bgImg);
	        bgView.setY(20);
	        // Set background image size
	        bgView.setFitWidth(600);
	        bgView.setFitHeight(800);
	        
	        // Add to main menu interface
	        root.getChildren().addAll(bgView,titleView,pressEnterView, mainMenu);
	        
	        // Add to scene (main menu)
	        Scene scene = new Scene(root);
	        
	        // When user's mouse enter scene , "PRESS ENTER" instruction is shown 
	        scene.setOnMouseEntered(event -> {
	        	// Play main menu music when mouse entered game window
        		mediaPlayer.play();
	        	// If main menu is shown , hide "PRESS ENTER" instruction
	        	if (mainMenu.isVisible()) {
	        		pressEnterView.setVisible(false);
	        	} else { // If main menu isn't shown , hide "PRESS ENTER" instruction
	        		pressEnterView.setVisible(true);
	        	}
	        }) ;
	        // When user's mouse exit scene , "PRESS ENTER" instruction is hidden
	        scene.setOnMouseExited(event -> {
	        	pressEnterView.setVisible(false) ;
	        }) ;
	        
	        // Show or hide main menu
	        scene.setOnKeyPressed(event -> {
	            if (event.getCode() == KeyCode.ENTER) {
	            	// If main menu isn't shown , "PRESS ENTER" to show
	                if (!mainMenu.isVisible()) {
	                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), mainMenu);
	                    ft.setFromValue(0);
	                    ft.setToValue(1);
	                    mainMenu.setVisible(true);
	                    pressEnterView.setVisible(false);
	                    ft.play();
	                }
	                else { // If main menu is shown , "PRESS ENTER" to hide
	                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), mainMenu);
	                    ft.setFromValue(1);
	                    ft.setToValue(0);
	                    ft.setOnFinished(evt -> mainMenu.setVisible(false));
	                    ft.play();
	                }
	            }
	        });
	        
	        // Set up Main Menu window
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("MAIN MENU");
	        primaryStage.setResizable(false);
	        primaryStage.show();
	    }

	    /**
	     * Set up game menu for main menu , how to play and leaderboard
	     * @author yiyonglim
	     */
	    private class GameMenu extends Parent {
	    	
	    	/**
	    	 * Set up game menu (main menu , how to play , leaderboard)
	    	 * @throws IOException If an input or output exception of an image occurred
	    	 */
	        public GameMenu() throws IOException {
	        	// Main menu
	            VBox mainMenu = new VBox(10);
	            // Set main menu position
	            mainMenu.setTranslateX(50);
	            mainMenu.setTranslateY(350);
	            
	            // How to play
	            VBox howToPlay = new VBox(10);
	            // Set how to play position
	            howToPlay.setTranslateX(100);
	            howToPlay.setTranslateY(200);
	            
	            // Leaderboard
	            VBox leaderboard = new VBox(10);
	            // Set leaderboard positions
	            leaderboard.setTranslateX(100);
	            leaderboard.setTranslateY(200);
	            
	            // Set transition distance between game menu
	            final int offset = 400;
	            
	            // Set transition distance for how to play
	            howToPlay.setTranslateX(offset) ;
	            
	            // Set main menu buttons function
	            // START button
	            // Start game
	            MenuButton btnStart = new MenuButton("START");
	            btnStart.setOnMouseClicked(event -> {
	            	// Set transition effect
	            	FadeTransition ft = new FadeTransition(Duration.seconds(2), this);
	            	
	                ft.setFromValue(1);
	                ft.setToValue(0);
	                ft.setOnFinished(evt -> setVisible(false));
	                ft.play();
	                
	                // Stop playing main menu music
	                mediaPlayer.stop() ;
	                
	                // Start game
	                Stage1 stage1 = new Stage1() ;
	    			try {
	    				stage1.start(new Stage()) ;
					} catch (Exception e) {
						e.printStackTrace();
					}
	            });

	            // HOW TO PLAY button
	            // Show controls and scoring system
	            MenuButton btnHowToPlay = new MenuButton("HOW TO PLAY");
	            btnHowToPlay.setOnMouseClicked(event -> {
	                getChildren().add(howToPlay);
	                // Set transition effect (main menu -> how to play)
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
	            
	            // LEADERBOARD button
	            // Show top 10 high score
	            MenuButton btnLeaderboard = new MenuButton("LEADERBOARD");
	            btnLeaderboard.setOnMouseClicked(event -> {
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

	            // EXIT button
	            // Exit game
	            MenuButton btnExit = new MenuButton("EXIT");
	            btnExit.setOnMouseClicked(event -> {
	                System.exit(0);
	            });

	            // BACK button in how to play
	            // How to play -> main menu
	            MenuButton btnBack = new MenuButton("BACK");
	            btnBack.setOnMouseClicked(event -> {
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
	           
	            // BACK button in leaderboard
	            // Leaderboard -> main menu
	            MenuButton btnBack0 = new MenuButton("BACK");
	            btnBack0.setTranslateY(-120);
	            btnBack0.setOnMouseClicked(event -> {
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
	            
	            // How To Play
	            // Show controls and scoring system
	            InputStream movement = Files.newInputStream(Paths.get("Resources/HowToPlay/movement.gif"));
		        Image movementImg = new Image(movement);
		        movement.close();
	            ImageView movementView = new ImageView(movementImg) ;
	            movementView.setTranslateX(200);
	            movementView.setTranslateY(50) ;
	            movementView.setScaleX(2);
	            movementView.setScaleY(2);
	            
	            InputStream frogjump = Files.newInputStream(Paths.get("Resources/HowToPlay/frogjump.gif"));
		        Image frogjumpImg = new Image(frogjump);
		        frogjump.close();
	            ImageView frogjumpView = new ImageView(frogjumpImg) ;
	            frogjumpView.setTranslateX(-40);
	            frogjumpView.setTranslateY(20) ;
	            frogjumpView.setScaleX(0.8);
	            frogjumpView.setScaleY(2);
	            
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
	            
	            // Create leaderboard.txt which store previous and new high score
	            try {
	                File txt = new File("leaderboard.txt");
	                
	                if (txt.createNewFile()) {
	                  System.out.println("File created: " + txt.getName());
	                  try {
	  	                FileWriter myWriter = new FileWriter("leaderboard.txt");
	  	                myWriter.write("800\n200\n300\n400\n500\n250\n150\n580\n350\n600");
	  	                myWriter.close();
	  	              } catch (IOException e) {
	  	                System.out.println("An error occurred.");
	  	                e.printStackTrace();
	  	              }
	                } else {
	                  System.out.println("File already exists.");
	                }
	            } catch (IOException e) {
	                System.out.println("An error occurred.");
	                e.printStackTrace();
	            }
	                    
	            // Get scores from leaderboard.txt and store them in an array
	            int[] array = new int[100];
        		int n = 0 ;
        		
        		try {
        	        BufferedReader reader = new BufferedReader(new FileReader("leaderboard.txt"));
        	        String line = reader.readLine();
        	        while (line != null)
        	        {
        	            try {
        	                int score = Integer.parseInt(line.trim());
        	                array[n] = score ;
        	                n++ ;
        	            } catch (NumberFormatException e1) {
        	                
        	            }
        	            line = reader.readLine();
        	        }
        	        reader.close();

        	    } catch (IOException ex) {
        	        System.err.println("ERROR reading scores from file");
        	    }
	            
        		// Sort the array in descending order
        		for (int i = 1; i < n; i++) {
        	        int current = array[i];
        	        int j = i - 1;
        	        
        	        while(j >= 0 && current < array[j]) {
        	            array[j+1] = array[j];
        	            j--;
        	        }
        	        array[j+1] = current;
        	    }
        		
        		// Obtain top 10 high score from the array and put them into leaderboard
        		int highScore1 = array[n-1] ;
        		int highScore2 = array[n-2] ;
        		int highScore3 = array[n-3] ;
        		int highScore4 = array[n-4] ;
        		int highScore5 = array[n-5] ;
        		int highScore6 = array[n-6] ;
        		int highScore7 = array[n-7] ;
        		int highScore8 = array[n-8] ;
        		int highScore9 = array[n-9] ;
        		int highScore10 = array[n-10] ;
        		
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
	            
	            // Add buttons to main menu
	            mainMenu.getChildren().addAll(btnStart, btnHowToPlay, btnLeaderboard , btnExit);
	            
	            // Add button , images and gif into how to play
	            howToPlay.getChildren().addAll(btnBack,movementView,frogjumpView,plus10View,goalView,plus50View,deathImgView,minus50View,xView);
	            
	            // Add button and high score into leaderboard
	            leaderboard.getChildren().addAll(btnBack0,high1,high2,high3,high4,high5,high6,high7,high8,high9,high10) ;

	            // Set background fill when opening main menu game menu
	            Rectangle bg = new Rectangle(600, 800);
	            bg.setFill(Color.GREY);
	            bg.setOpacity(0.8);

	            // Add them to scene
	            getChildren().addAll(bg, mainMenu);
	        }
	    }

	    /**
	     * Set effect and style for START , HOW TO PLAY , LEADERBOARD , EXIT and BACK button
	     * @author yiyonglim
	     */
	    private static class MenuButton extends StackPane {
	        private Text text ;
	        
	        /**
	         * Set text effect and style
	         * @param name Text shown on button
	         */
	        public MenuButton(String name) {
	            text = new Text(name);
	            text.setFont(Font.loadFont("file:Resources/Font/BACKTO1982.ttf", 40));
	            text.setFill(Color.WHITE);

	            Rectangle bg = new Rectangle(500, 100);
	            bg.setOpacity(0.6);
	            bg.setFill(Color.BLACK);
	            bg.setEffect(new GaussianBlur(3.5));

	            setAlignment(Pos.CENTER);
	            setRotate(-0.5);
	            getChildren().addAll(bg, text);

	            setOnMouseEntered(event -> {
	            	playMusicButton() ;
	                bg.setTranslateX(10);
	                text.setTranslateX(10);
	                bg.setFill(Color.WHITE);
	                text.setFill(Color.BLACK);
	            });

	            setOnMouseExited(event -> {
	                bg.setTranslateX(0);
	                text.setTranslateX(0);
	                bg.setFill(Color.BLACK);
	                text.setFill(Color.WHITE);
	            });

	            DropShadow drop = new DropShadow(50, Color.WHITE);
	            drop.setInput(new Glow());

	            setOnMousePressed(event -> setEffect(drop));
	            setOnMouseReleased(event -> setEffect(null));
	        }
	        
	    }

	    /**
	     * Set effect and style for top 10 high score in leaderboard
	     * @author yiyonglim
	     */
	    private static class HighScore extends StackPane {
	        private Text text;

	        /**
	         * Set text effect and style
	         * @param name
	         */
	        public HighScore(String name) {
	        	setTranslateY(-120) ;
	            text = new Text(name);
	            text.setFont(Font.loadFont("file:Resources/Font/INVASION2000.ttf", 50));
	            text.setFill(Color.WHITE);

	            Rectangle bg = new Rectangle(500, 50);
	            bg.setOpacity(0.6);
	            bg.setFill(Color.BLACK);
	            bg.setEffect(new GaussianBlur(3.5));

	            setAlignment(Pos.CENTER);
	            setRotate(-0.5);
	            getChildren().addAll(bg, text);

	            setOnMouseEntered(event -> {
	                bg.setTranslateX(10);
	                text.setTranslateX(10);
	                bg.setFill(Color.BLACK);
	                text.setFill(Color.WHITE);
	            });

	            setOnMouseExited(event -> {
	                bg.setTranslateX(0);
	                text.setTranslateX(0);
	                bg.setFill(Color.BLACK);
	                text.setFill(Color.WHITE);
	            });
	        }
	        
	    }
	 
    	/**
    	 * Set main menu music
    	 */
    	public void setMusic() {
        	String musicFile = "Resources/MainMenuMusicAndSoundEffect/MainMenuMusic.mp3";   
        	Media sound = new Media(new File(musicFile).toURI().toString()) ;
        	mediaPlayer = new MediaPlayer(sound) ;
        	mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE) ;
    	}
    	
	    /**
	     * Play sound effect when mouse passes buttons
	     */
	    public static void playMusicButton() {
			String musicFile = "Resources/MainMenuMusicAndSoundEffect/ButtonSoundEffect.wav";   
			Media sound = new Media(new File(musicFile).toURI().toString()) ;
			MediaPlayer mediaPlayer = new MediaPlayer(sound) ;
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE) ;
			mediaPlayer.setCycleCount(1);
			mediaPlayer.play() ;
		}
	    
	    /**
	     * Start javafx program
	     * @param args Arguments passed by command line while starting a program
	     */
	    public static void main(String[] args) {
	        launch(args);
	    }
	}