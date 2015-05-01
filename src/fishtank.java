import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
public class fishtank extends JPanel
{
	private static final long serialVersionUID = 1L;
	public int x,y,w,h;
	private int centerx;
	private int centery;
	public fishtank()
	{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension d=kit.getScreenSize();
	w=10;
	h=10;
	centerx=d.width;
	centery=d.height;
	x=centerx/2;
	y=centery/2;
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, centerx, centery);
		g.setColor(Color.WHITE);
		g.fillOval(x, y, w, h);
		x=x-1;
		y=y-1;
		w=w+1;
		h=h+1;
		try
		{
			Thread.sleep(300);
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
		frame.add(new fishtank());

	}

}
