import java.awt.EventQueue;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFileChooser;

public class audio
{

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					JFileChooser open=new JFileChooser();
					open.showOpenDialog(null);
					File file=open.getSelectedFile();
					//String path=file.getAbsolutePath();
					AudioInputStream audio=AudioSystem.getAudioInputStream(file);
					 Clip clip = AudioSystem.getClip();
					 clip.open(audio);
					 clip.start( );
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	

}
