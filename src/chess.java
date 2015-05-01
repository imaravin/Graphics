import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 * 
 */

/**
 * @author aravinth
 *
 */
public class chess extends javax.swing.JPanel  implements MouseListener ,Action
{

	public chess()
	{
		addMouseListener(this);
	//	add(this,new key());
	 
	}

	private static final long serialVersionUID = 1L;
	public void paint(Graphics g)
	{
		super.paint(g);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		int x=0,y=0,i=0,j=0;
	//	g.fillRect(0, 0, d.width, d.height);
		g.setColor(Color.WHITE);
		g.fill3DRect(0, 0, d.width, d.height,true );
		while(y<d.width)
		{
			i=j;
			while(x<d.width)
			{
				//i=new Random().nextInt();
				if(i%2==0)
				{
				//	 g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
					g.setColor(Color.WHITE);
				}
				else
				{
				g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
				//	g.setColor(Color.BLACK);
				//else
				//	g.setColor(Color.WHITE);
				//g.fillOval(x, y, 75,75);
			//	 g.fillRoundRect(x, y, 75, 75, 75, 75);
				// g.fill3DRect(x, y, 75, 75,true);
				}
				// g.fill3DRect(x, y, 75, 75,true);
				g.fillRoundRect(x, y, 75, 75, 75, 75);
				g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
				g.fillRoundRect(x+12, y+12, 50, 50,50,50);
				g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
				g.fillRoundRect(x+25, y+25, 25, 25, 25, 25);
				g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
				g.fillRoundRect(x+31, y+31, 12, 12, 12, 12);
				g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
				g.fillRoundRect(x+34, y+34,6 , 6, 6, 6);
				
				x=x+75;
				i++;
			}
			y=y+75;
			x=0;
			j++;
		}
		try
		{
			Thread.sleep(100);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		frame.add(new chess());
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



	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		System.exit(0);
	}



	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		 //System.exit(0);
	}



	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// System.exit(0);
	}



	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0)
	{
		 System.exit(0);
	}



	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		//System.exit(0);
	}



	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		System.out.println("hahufhfo");
		//System.exit(0);
	}



	/* (non-Javadoc)
	 * @see javax.swing.Action#getValue(java.lang.String)
	 */
	@Override
	public Object getValue(String arg0)
	{
		 
		return null;
	}



	/* (non-Javadoc)
	 * @see javax.swing.Action#putValue(java.lang.String, java.lang.Object)
	 */
	@Override
	public void putValue(String arg0, Object arg1)
	{
	}



	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */


}
