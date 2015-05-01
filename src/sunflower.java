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
public class sunflower  
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		frame.setVisible(true);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		frame.setSize(d.width, d.height);
		frame.add(new seed2());
		

	}

}
class seed2 extends JPanel
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		double theta;
		final double PHI = (Math.sqrt(5) + 1) / 2;
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		setSize(d.width, d.height);
		g.fillRect(0, 0, d.width, d.height);
		g.setColor(Color.ORANGE);
		for (int i = 0; i < 10000; i++)
		{
				theta=i * 2*Math.PI / PHI;
				int x=(int) ((d.width/2)+ 4 * Math.cos(theta));
				int y=(int) ((d.height/2)- 4 *Math.sin(theta));
				g.fillOval(x+i,y+i,4, 4);
		}
		
	}
}
