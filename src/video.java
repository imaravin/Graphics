import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;


public class video
{

	public static void main(String[] args) throws IOException,Exception
	{
		String x;
		JFileChooser open=new JFileChooser();
		open.showOpenDialog(null);
		x=open.getSelectedFile().getAbsolutePath();
		int frameNumber = 150;
		BufferedImage frame = FrameGrab.getFrame(new File(x), frameNumber);
		ImageIO.write(frame, "png", new File("frame_150.png"));
	}

}
