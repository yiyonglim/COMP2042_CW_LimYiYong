package com.yiyonglim.Main;

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

	    private GameMenu gameMenu;

	    @Override
	    public void start(Stage primaryStage) throws Exception {

	    	// Set main menu interface
	        Pane root = new Pane();
	        root.setPrefSize(600, 800);

	        // Set title
	        InputStream title = Files.newInputStream(Paths.get("Resources/Font/title.png"));
	        Image titleImg = new Image(title);
	        title.close();

	        // Set title position
	        ImageView titleView = new ImageView(titleImg);
	        titleView.setX(30);
	        titleView.setY(35);
	        titleView.setScaleX(1) ;
	        titleView.setScaleY(1.4) ;
	        
	        
	        
	        // Set background image
	        InputStream bg = Files.newInputStream(Paths.get("Resources/MainMenuBackground/background.gif"));
	        Image bgImg = new Image(bg);
	        bg.close();

	        // Set background image size
	        ImageView bgView = new ImageView(bgImg);
	        bgView.setFitWidth(600);
	        bgView.setFitHeight(800);
	        bgView.setY(20);

	        gameMenu = new GameMenu();
	        gameMenu.setVisible(false);

	        root.getChildren().addAll(bgView,titleView, gameMenu);

	        // When Enter pressed , show button
	        Scene scene = new Scene(root);
	        scene.setOnKeyPressed(event -> {
	            if (event.getCode() == KeyCode.ENTER) {
	                if (!gameMenu.isVisible()) {
	                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
	                    ft.setFromValue(0);
	                    ft.setToValue(1);

	                    gameMenu.setVisible(true);
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

	        // Set up main menu scene
	        primaryStage.setScene(scene);
	        primaryStage.setResizable(false);
	        primaryStage.show();
	    }

	    // Set function of buttons
	    private class GameMenu extends Parent {
	        public GameMenu() {
	            VBox menu0 = new VBox(10);
	            VBox menu1 = new VBox(10);

	            menu0.setTranslateX(50);
	            menu0.setTranslateY(350);

	            menu1.setTranslateX(100);
	            menu1.setTranslateY(200);

	            final int offset = 400;

	            menu1.setTranslateX(offset);

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
	            
	            MenuButton btnLeaderboard = new MenuButton("LEADERBOARD");
	            btnLeaderboard.setOnMouseClicked(event -> {
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

	            MenuButton btnExit = new MenuButton("EXIT");
	            btnExit.setOnMouseClicked(event -> {
	                System.exit(0);
	            });

	            
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

	            menu0.getChildren().addAll(btnStart, btnHowToPlay, btnLeaderboard , btnExit);
	            menu1.getChildren().addAll(btnBack);

	            Rectangle bg = new Rectangle(800, 600);
	            bg.setFill(Color.GREY);
	            bg.setOpacity(0.4);

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

	    public static void main(String[] args) {
	        launch(args);
	    }
	}