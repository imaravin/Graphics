import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author aravinth
 *
 */
public class martial extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public martial()
	{
	//	setResizable(false);
		setSize(getMaximumSize());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new martial_panel());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			
			@Override
			public void run()
			{
				new martial();
			}
		});
	}

}
class  martial_panel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void paintComponent(Graphics g)
	{
		
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		setSize(d);
		float width=(float)d.getWidth();
		float height=(float) d.getHeight();
		Graphics2D g2=(Graphics2D) g;
		g2.setPaint(Color.BLACK);
		Ellipse2D base=new Ellipse2D.Double(height/2-100,0,height-60,height-50);
		g2.fill(base);
		g2.setPaint(Color.WHITE);
		Rectangle2D half=new Rectangle2D.Double(0, 0, width,height/2);
		g2.fill(half);
		g2.setPaint(Color.BLACK);
		Ellipse2D base2=new Ellipse2D.Double(280,100,height-325,550);
		g2.fill(base2);
		g2.setPaint(Color.WHITE);
		Ellipse2D half2=new Ellipse2D.Double(280+height-325,100+550,height-325,550);
		g2.fill(half2);
		
	}
	
}
