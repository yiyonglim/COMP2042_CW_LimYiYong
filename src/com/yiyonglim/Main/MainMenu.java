package com.yiyonglim.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;

// Handle MainMenu
public class MainMenu extends Application {

	    private GameMenu gameMenu ;

	    @Override
	    public void start(Stage primaryStage) throws Exception {

	    	// Set main menu interface
	        Pane root = new Pane();
	        root.setPrefSize(600, 800);

	        // Set title
	        InputStream title = Files.newInputStream(Paths.get("Resources/Font/title.png"));
	        Image titleImg = new Image(title);
	        title.close();

	        // Set title position and size
	        ImageView titleView = new ImageView(titleImg);
	        titleView.setX(30);
	        titleView.setY(35);
	        titleView.setScaleX(1) ;
	        titleView.setScaleY(1.4) ;
	        
	        // Set instruction to start game
	        InputStream pressEnter = Files.newInputStream(Paths.get("Resources/Font/pressEnter.png"));
	        Image pressEnterImg = new Image(pressEnter);
	        pressEnter.close();
	        
	        // Set instruction position and size
	        ImageView pressEnterView = new ImageView(pressEnterImg);
	        pressEnterView.setX(-25);
	        pressEnterView.setY(500);
	        pressEnterView.setScaleX(0.7) ;
	        pressEnterView.setScaleY(0.7) ;
	        pressEnterView.setVisible(false);
	        
	        // Set background image
	        InputStream bg = Files.newInputStream(Paths.get("Resources/MainMenuBackground/background.gif"));
	        Image bgImg = new Image(bg);
	        bg.close();

	        // Set background image size
	        ImageView bgView = new ImageView(bgImg);
	        bgView.setFitWidth(600);
	        bgView.setFitHeight(800);
	        bgView.setY(20);
	        
	        // Set up game menu
	        gameMenu = new GameMenu();
	        gameMenu.setVisible(false);
	        
	        // Get all elements and add to scene
	        root.getChildren().addAll(bgView,titleView,pressEnterView, gameMenu);
	        Scene scene = new Scene(root);
	        
	        // When user's mouse enter interface of game , instruction is shown
	        scene.setOnMouseEntered(event -> {
	        	if (gameMenu.isVisible()) {
	        		pressEnterView.setVisible(false);
	        	} else {
	        		pressEnterView.setVisible(true);
	        	}
	        });
	        scene.setOnMouseExited(event -> {
	        	pressEnterView.setVisible(false);
	        });
	        
	        // When user pressed ENTER , show game menu
	        scene.setOnKeyPressed(event -> {
	            if (event.getCode() == KeyCode.ENTER) {
	                if (!gameMenu.isVisible()) {
	                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
	                    ft.setFromValue(0);
	                    ft.setToValue(1);
	                    gameMenu.setVisible(true);
	                    pressEnterView.setVisible(false);
	                    ft.play();
	                }
	                else {
	                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
	                    ft.setFromValue(1);
	                    ft.setToValue(0);
	                    ft.setOnFinished(evt -> gameMenu.setVisible(false));
	                    ft.play();
	                }
	            }
	        });
	        
	        // Set up whole menu scene
	        primaryStage.setScene(scene);
	        primaryStage.setResizable(false);
	        primaryStage.show();
	    }

	    // Set game menu
	    private class GameMenu extends Parent {
	        public GameMenu() throws IOException {
	        	
	        	// Main menu
	            VBox menu0 = new VBox(10);
	            // How to play
	            VBox menu1 = new VBox(10);
	            // Leaderboard
	            VBox menu2 = new VBox(10);


	            menu0.setTranslateX(50);
	            menu0.setTranslateY(350);

	            menu1.setTranslateX(100);
	            menu1.setTranslateY(200);
	            
	            menu2.setTranslateX(100);
	            menu2.setTranslateY(200);
	            
	            final int offset = 400;

	            menu1.setTranslateX(offset);
	            
	            // Set function of game menu buttons
	            // START
	            MenuButton btnStart = new MenuButton("START");
	            btnStart.setOnMouseClicked(event -> {
	            	FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
	                ft.setFromValue(1);
	                ft.setToValue(0);
	                ft.setOnFinished(evt -> setVisible(false));
	                ft.play();
	                
	                Main startgame = new Main() ;
	    			try {
						startgame.start(new Stage()) ;
					} catch (Exception e) {
						e.printStackTrace();
					}
	            });

	            // HOW TO PLAY
	            // Show control and scoring system
	            MenuButton btnHowToPlay = new MenuButton("HOW TO PLAY");
	            btnHowToPlay.setOnMouseClicked(event -> {
	                getChildren().add(menu1);

	                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
	                tt.setToX(menu0.getTranslateX() - offset);

	                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
	                tt1.setToX(menu0.getTranslateX());

	                tt.play();
	                tt1.play();

	                tt.setOnFinished(evt -> {
	                    getChildren().remove(menu0);
	                });
	            });
	            
	            // LEADERBOARD
	            // Show top 10 high score
	            MenuButton btnLeaderboard = new MenuButton("LEADERBOARD");
	            btnLeaderboard.setOnMouseClicked(event -> {
	                getChildren().add(menu2);

	                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
	                tt.setToX(menu0.getTranslateX() - offset);

	                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu2);
	                tt1.setToX(menu0.getTranslateX());

	                tt.play();
	                tt1.play();

	                tt.setOnFinished(evt -> {
	                    getChildren().remove(menu0);
	                });
	            });

	            // EXIT
	            MenuButton btnExit = new MenuButton("EXIT");
	            btnExit.setOnMouseClicked(event -> {
	                System.exit(0);
	            });

	            // BACK (How to play --> Main menu)
	            MenuButton btnBack = new MenuButton("BACK");
	            btnBack.setOnMouseClicked(event -> {
	                getChildren().add(menu0);

	                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
	                tt.setToX(menu1.getTranslateX() + offset);

	                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
	                tt1.setToX(menu1.getTranslateX());

	                tt.play();
	                tt1.play();

	                tt.setOnFinished(evt -> {
	                    getChildren().remove(menu1);
	                });
	            });
	            
	            // BACK (Leaderboard --> Main menu)
	            MenuButton btnBack0 = new MenuButton("BACK");
	            btnBack0.setTranslateY(-120);
	            btnBack0.setOnMouseClicked(event -> {
	                getChildren().add(menu0);

	                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu2);
	                tt.setToX(menu2.getTranslateX() + offset);

	                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
	                tt1.setToX(menu2.getTranslateX());

	                tt.play();
	                tt1.play();

	                tt.setOnFinished(evt -> {
	                    getChildren().remove(menu2);
	                });
	            });
	            
	            // How To Play Scene
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
	            
	            InputStream goal = Files.newInputStream(Paths.get("Resources/Goal/End.png"));
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
	            
	            try {
	                File myObj = new File("leaderboard.txt");
	                if (myObj.createNewFile()) {
	                  System.out.println("File created: " + myObj.getName());
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
	                    
	            
	            // Leaderboard scene
	            int[] array = new int[100];
        		int n = 0 ;
        		
        		// Get scores from score.txt and sort them in descending order
        		try {
        	        BufferedReader reader = new BufferedReader(new FileReader("leaderboard.txt"));
        	        String line = reader.readLine();
        	        while (line != null)                 // read the score file line by line
        	        {
        	            try {
        	                int score = Integer.parseInt(line.trim());   // parse each line as an int
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
	            
        		for (int i = 1; i < n; i++) {
        	        int current = array[i];
        	        int j = i - 1;
        	        while(j >= 0 && current < array[j]) {
        	            array[j+1] = array[j];
        	            j--;
        	        }
        	        // at this point we've exited, so j is either -1
        	        // or it's at the first element where current >= a[j]
        	        array[j+1] = current;
        	    }
        		
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
        		
	            ShowButton high1 = new ShowButton("1st : " + highScore1);
	            ShowButton high2 = new ShowButton("2nd : " + highScore2);
	            ShowButton high3 = new ShowButton("3rd : " + highScore3);
	            ShowButton high4 = new ShowButton("4th : " + highScore4);
	            ShowButton high5 = new ShowButton("5th : " + highScore5);
	            ShowButton high6 = new ShowButton("6th : " + highScore6);
	            ShowButton high7 = new ShowButton("7th : " + highScore7);
	            ShowButton high8 = new ShowButton("8th : " + highScore8);
	            ShowButton high9 = new ShowButton("9th : " + highScore9);
	            ShowButton high10 = new ShowButton("10th : " + highScore10);
	            
	            // Add buttons to game menu accordingly
	            menu0.getChildren().addAll(btnStart, btnHowToPlay, btnLeaderboard , btnExit);
	            menu1.getChildren().addAll(btnBack,movementView,frogjumpView,plus10View,goalView,plus50View,deathImgView,minus50View,xView);
	            menu2.getChildren().addAll(btnBack0,high1,high2,high3,high4,high5,high6,high7,high8,high9,high10) ;

	            // Set background fill when opening game menu
	            Rectangle bg = new Rectangle(600, 800);
	            bg.setFill(Color.GREY);
	            bg.setOpacity(0.8);

	            // Add to scene
	            getChildren().addAll(bg, menu0);
	        }
	    }

	    // Set style and effect
	    private static class MenuButton extends StackPane {
	        private Text text;

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

	    private static class ShowButton extends StackPane {
	        private Text text;

	        public ShowButton(String name) {
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
	    
	    public static void main(String[] args) {
	        launch(args);
	    }
	}