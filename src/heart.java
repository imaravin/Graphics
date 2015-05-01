import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class heart extends javax.swing.JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1368, 768);
		g.setColor(Color.RED);
		/*
		g.drawLine(400, 300, 600,600);
		g.drawLine(800, 300, 600,600);
		g.drawArc(400, 225, 200, 150, 0, 180);
		g.drawArc(600, 225, 200, 150,0,180);*/
		int x[]={400,800,600};
		int y[]={300,300,600};  
		g.fillPolygon(x, y, 3);
		g.fillArc(400, 225, 200, 150, 0, 180);
		g.fillArc(600, 225, 200, 150,0,180);
		
	}

	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new heart());

	}

}
