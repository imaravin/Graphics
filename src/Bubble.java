import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
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
public class Bubble extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int x,y,w,h;
	public int x1,y1,w1,h1;
	private int centerx;
	private int centery;
	public Bubble()
	{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension d=kit.getScreenSize();
	w=10;
	h=10;
	centerx=d.width;
	centery=d.height;
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, centerx, centery);
		//if(x<10 || y <10)
		{
		x=(centerx-w)/2;
		y=(centery-h)/2;
		}
		w+=10;
		h+=10;
		g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
	//	g.setColor(new Color(255,255,255));
		//g.setColor(Color.WHITE);
		//Color c=new Color((float)0.0,(float) 0.0,(float) 0.0,(float) 255);
		//g.setColor(new Color((float)255,(float) 255,(float) 255,(float) 0));
		reset();
		g.fillOval(x, y, w, h);
		try
		{
			//g.setColor(Color.BLACK);
			g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
			Thread.sleep(100);
			x1=(centerx-w1)/2;
			y1=(centery-h1)/2;
			w1+=10;
			h1+=10;
			g.fillOval(x1, y1, w1, h1);
			reset2();
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
		
	}
	public void reset()
	{
		if(x<0|| y<0)
		{
			w=10;
			h=10;
			x=(centerx-w)/2;
			y=(centery-h)/2;
		}
			
	}
	public void reset2()
	{
		if(x1<0|| y1<0)
		{
			w1=10;
			h1=10;
			x1=(centerx-w1)/2;
			y1=(centery-h1)/2;
		}
			
	}
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Bubble tmp=new Bubble();
		frame.add(tmp);
		

	}

}
