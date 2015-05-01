import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * 
 */

/**
 * @author aravinth
 *
 */
public class background extends Thread
{
	public void run()
	{
		 AudioInputStream audioInputStream = null;
		try
		{
			audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\knowcat.wav"));
		} catch (UnsupportedAudioFileException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Clip clip = null;
		try
		{
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try
		{
			clip.open(audioInputStream);
		} catch (LineUnavailableException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 clip.start( );
		for(;;)
			if(clip.isActive())
				 clip.start();
	}

}
