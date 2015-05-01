import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.swing.JFileChooser;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


public class FileSpeak
{
	public static void main(String arg[])
	{
		new FileSpeak();
	}
	public FileSpeak()
	{
		final String VOICENAME="kevin16";
		JFileChooser open=new JFileChooser();
		open.showOpenDialog(null);
		File file=open.getSelectedFile();
		String path=file.getAbsolutePath();
		try
		{
			
			InputStream input=new FileInputStream(path);
			VoiceManager vm=VoiceManager.getInstance();
			Voice voice=vm.getVoice(VOICENAME);
			voice.allocate();
			voice.speak(input);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
