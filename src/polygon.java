import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author aravinth
 *
 */
public class polygon extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void paint(Graphics g)
	{
		int x[]=new int[100];
		int y[]=new int[100];
		 Random rand=new Random();
		 for(int i=0;i<50;i++)
		 {
			 x[i]=rand.nextInt(1386);
			y[i]=rand.nextInt(768);
		 }
		g.drawPolygon(x, y,50);
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
		
	}
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new polygon());

	}

}
