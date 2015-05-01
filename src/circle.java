import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author aravinth
 *
 */
public class circle extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public circle()
	{
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new inner());
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
				new circle();
			}
		});
	}
	class inner extends JPanel
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public  void paintComponent(Graphics g)
		{
			Graphics2D g2=(Graphics2D) g;
			g2.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0, new float[]{9}, 0));
		 	g.setColor(Color.BLACK);
			  g.fillOval(20, 20, 400,400);
		 	g.setColor(Color.ORANGE);
			g.fillOval(22, 22, 396, 396);
			g.setColor(Color.WHITE);
			float cx=200;
			float cy=200;
			for(int i=0;i<24;i++)
			{
				float angle=(float) (i*2*Math.PI/24);
				float x=(float) (cx+Math.cos(angle)*40);
				float y=(float)(cy+Math.sin(angle)*40);
				g.fillOval((int)x,(int) y, (int)Math.PI*400/24,  (int)Math.PI*400/24);
				
			}
			
		}
		
	}

}
