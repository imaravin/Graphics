import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * 
 */

/**
 * @author aravinth
 *
 */
public class animated_smiley extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void paint(Graphics g)
	{
		super.paint(g);
		Random rand=new Random();
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		g.fillRect(0, 0, d.width, d.height);
		int i=rand.nextInt(100);
		{
			if(i%2==0)
		{
		//super.paint(g);
		g.setColor(Color.YELLOW);
		g.fillOval((1368/2)-300, 100, 600, 600);
		g.setColor(Color.BLACK);
		g.fillOval((1368/2)-175, 275, 45, 45);
		g.fillOval((1368/2)+125, 275, 45, 45);
		g.setColor(Color.WHITE);
		g.fillOval((1368/2)+125+5, 275+5, 35, 35);
		g.fillOval((1368/2)-175+5, 275+5, 35, 35);
		g.setColor(Color.BLACK);
		g.fillArc((1368/2)-100, 425, 200,150, 180,360);
		g.setColor(Color.WHITE);
		g.fillArc((1368/2)-100+5, 425+5, 200-10,150-10, 180,360);
		
		}
			else
		{
			//super.paint(g);
			g.setColor(Color.YELLOW);
			g.fillOval((1368/2)-300, 100, 600, 600);
			g.setColor(Color.BLACK);
			g.fillOval((1368/2)-175, 275, 45, 45);
			g.fillOval((1368/2)+125, 275, 45, 45);
			g.setColor(Color.BLACK);
			g.fillArc((1368/2)-100, 425, 200,150, 180,360);
			
		}
		}
		repaint();
		
	}
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new animated_smiley());
		KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0, false);
		 Action escapeAction = new AbstractAction()
	        {
				private static final long serialVersionUID = 1L;

					public void actionPerformed(ActionEvent e) 
					{
	                System.exit(0);
	                }
	        };
	        frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke,"ESCAPE");
	        frame.getRootPane().getActionMap().put("ESCAPE", escapeAction);
	}

}
