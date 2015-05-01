import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author aravinth
 *
 */
public class clock extends JFrame
{
	/**
	 * 
	 * 
	 */
	public clock()
	{
	 
		
		setSize(500,500);
		setVisible(true);
		//while(true)
			add(new panel());
	}
	private static final long serialVersionUID = 1L;

	public static void main(String arg[])
	{
	
		new clock();
		
	}
	

}
class panel extends JPanel
{

	/**
	 * 
	 */
	 
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("deprecation")
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		 setSize(500,500);
		 g.setColor(Color.BLACK);
		   g.fillOval(0,0, 480, 480);
		  g.setColor(Color.white);
	 	 Date t=new Date();
	 	// System.out.println(t);
		int s= t.getSeconds();
		Line2D l=new Line2D.Double(250,250,timesecx(s),timesecy(s));
		g2.draw(l);
		  repaint();
		
	}
	public int timesecx(int s)
	{
		int x = 0;
		if(s<15)
		x=0+s%250;
		else
			x=250+s%250;
		return x%500;
		
		
	}
	public int timesecy(int s)
	{
		int x = 0;
		if(s<15)
		x=0+s%250;
		else
			x=250+s%250;
		return x%500;
		
	}
	
}