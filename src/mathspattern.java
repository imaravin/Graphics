import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.*;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


public class mathspattern extends JPanel
{
	double x,y,x1,y1,m=50,n=1,a=100;
	public void paint(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		for(x=0;x<100;x=x+0.1)
		{
			//y=(m/n)*(Math.sqrt((n*n)-(x*x)));//Eclipse formula
			//y=Math.sqrt(x);
			y=Math.sqrt((Math.sqrt(100*100*100)-Math.sqrt(x*x*x)))*Math.sqrt((Math.sqrt(100*100*100)-Math.sqrt(x*x*x)))*Math.sqrt((Math.sqrt(100*100*100)-Math.sqrt(x*x*x)));
			Line2D.Double l=new Line2D.Double(x, y, x1, y1);
			g2.draw(l);
			g2.fill(l);
			x1=x;
			y1=y;
		}
		
		repaint();
	}
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new mathspattern());
		KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0, false);
        Action escapeAction = new AbstractAction() {
                /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent e) {
                System.exit(0);
                }
        };
        frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke,"ESCAPE");
        frame.getRootPane().getActionMap().put("ESCAPE", escapeAction);
        
	}
}
