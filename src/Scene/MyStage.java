package Scene ;

import java.io.File ;

import javafx.scene.media.Media ;
import javafx.scene.media.MediaPlayer ;
import javafx.util.Duration ;

public class MyStage extends World {
	// Set up media player
	MediaPlayer mediaPlayer ;
	@Override
	// Once music is played , it wont change with time , "act" method is empty
	public void act(long now) {
		
	}
	
	// Setting stages
	public MyStage() {
		
	}
	
	// Play music
	public void playMusic() {
		// Music path
		String musicFile = "Resources/Music/Frogger Main Song Theme (loop).mp3";   
		// Connect music to media player
		Media sound = new Media(new File(musicFile).toURI().toString()) ;
		mediaPlayer = new MediaPlayer(sound) ;
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE) ;
	    mediaPlayer.play() ;
	}
	
	// Stop music
	public void stopMusic() {
		// Stop media player
		mediaPlayer.stop() ;
	}

}
