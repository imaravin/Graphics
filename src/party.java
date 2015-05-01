import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
public class party extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int x[]=new int[100];
	public int y[]=new int[100];
	public int w[]=new int[100];
	public int h[]=new int[100];
	private int centerx;
	private int centery;
	public party()
	{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension d=kit.getScreenSize();
	for(int i=0;i<100;i++)
	{
	w[i]=10;
	h[i]=10;
	centerx=d.width;
	centery=d.height;
	}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2=(Graphics2D) g;
		g2.setStroke(new BasicStroke(0.8f));
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, centerx, centery);
		for(int i=0;i<100;i++)
		{
			x[i]=(centerx-w[i])/2;
			y[i]=(centery-h[i])/2;
			w[i]+=10;
			h[i]+=10;
		}
		for(int i=0;i<100;i++)
		{
		g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
			
		g.fillOval(x[i], y[i], w[i], h[i]);
		if(x[i]<0|| y[i]<0)
		{
			w[i]=10;
			h[i]=10;
			x[i]=(centerx-w[i])/2;
			y[i]=(centery-h[i])/2;
		}
		
		}
		repaint();
		
		
	}
	
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new party());
	}

}
