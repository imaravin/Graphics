import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author aravinth
 *
 */
public class image extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x=0;
	int y=0;
	public void paint(Graphics g)
	{
		super.paint(g);
		Image img=Toolkit.getDefaultToolkit().getImage("D:\\Nature\\1.jpg");
		Image i=Toolkit.getDefaultToolkit().getImage("D:\\Nature\\2.jpg");
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		g.drawImage(img, 0, 0,d.width,d.height, this);
		g.drawImage(i, x,500, 100,100,this);
		x++;
		y++;
		if(x>d.width)
		{	x=0;
		y=0;}
		repaint();
	}
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		//frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new image());
	}
	
}
