import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
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
public class flower extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public flower()
	{
		setSize(getMaximumSize());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new seed());
	}
	public static void main(String arg[])
	{
		new flower();
	}

}
class seed extends JPanel
{
	/**
	 * 
	 */
	public seed()
	{
		repaint();
	}
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		
		Graphics2D g2=(Graphics2D) g;
		g2.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0, new float[]{9}, 0));
		int nbr_circles=600;
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		double width=d.getWidth();
		double height=d.getHeight();
		g2.setPaint(Color.BLUE);
		Rectangle2D base=new Rectangle2D.Double(10,10, 1368, 767);
		g.fillRect(0, 0, 1368, 768);
		g2.draw(base);
		float sm_diameter = 75;
		double cx = width/2;
	    double cy = height/2;
	    double outer_rad = width*.45;
	    double angle_incr = Math.toRadians(2 + 30/12.0);
	    g2.setPaint(Color.YELLOW);
		  for (int i = 1; i <= nbr_circles; ++i) 
		 {
		      float ratio = i/(float)nbr_circles;
		      double spiral_rad = (double) (ratio * outer_rad);
		      double angle = i*angle_incr;
		      double x = cx + Math.cos(angle) * spiral_rad;
		      double y = cy + Math.sin(angle) * spiral_rad;
		  Ellipse2D tmp=new Ellipse2D.Double(x, y, sm_diameter, sm_diameter);
		 //    Arc2D tmp=new Arc2D.Double(x, y, sm_diameter, sm_diameter, angle, x, i);
		       g2.draw(tmp);
		      
		      
		 }
		
		// g.fillRect(0, 0, 1368, 768); 
	   // g.fill3DRect(300, 300, 300, 300,true);
		 repaint();
	}
		 
}