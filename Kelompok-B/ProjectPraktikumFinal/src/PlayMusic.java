import java.sql.SQLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PlayMusic extends Music {
	String judul;
	Clip clip;

	public PlayMusic(String judul) {
		this.judul = judul;
	}

	@Override
	void PlayMusicMenu() {
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File(judul));
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		} catch (UnsupportedAudioFileException uae) {
			System.out.println(uae);
		} catch (IOException ioe) {
			System.out.println(ioe);
		} catch (LineUnavailableException lua) {
			System.out.println(lua);
		}

	}

	@Override
	void PlayMusicKlik() {
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File(judul));
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		} catch (UnsupportedAudioFileException uae) {
			System.out.println(uae);
		} catch (IOException ioe) {
			System.out.println(ioe);
		} catch (LineUnavailableException lua) {
			System.out.println(lua);
		}

	}

	@Override
	void PlayMusicStart() {
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File(judul));
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		} catch (UnsupportedAudioFileException uae) {
			System.out.println(uae);
		} catch (IOException ioe) {
			System.out.println(ioe);
		} catch (LineUnavailableException lua) {
			System.out.println(lua);
		}

	}

	@Override
	void PlayMusicGameOver() {
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File(judul));
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		} catch (UnsupportedAudioFileException uae) {
			System.out.println(uae);
		} catch (IOException ioe) {
			System.out.println(ioe);
		} catch (LineUnavailableException lua) {
			System.out.println(lua);
		}
	}

	public void stopSound() {
		clip.stop();
	}

}
