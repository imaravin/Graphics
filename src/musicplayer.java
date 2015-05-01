import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import java.util.Random;

import javax.swing.*;
public class musicplayer extends JPanel implements MouseListener
{
	int width,height;
	private int i;
	Color color[];
	public musicplayer()
	{
		Color[] color={Color.YELLOW,Color.BLACK,Color.BLUE};
		addMouseListener(this);
	}
	public void paint(Graphics g)
	{
		width=0;
		i=0;
		super.paint(g);
		setBackground(Color.WHITE);
		for(;width<1368;)
		{
			int x= new Random().nextInt(768);
			int j=new Random().nextInt(2);
			  g.setColor(color[j]);
			  if(i%2==0)
				 g.setColor(Color.white);
			//g.setColor(new Color(new Random().nextInt(255)));
			g.fillRect(width,x,10,768-x);
			width=width+10;
			i++;
		}
		//repaint();
		
	}
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new musicplayer());
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
		repaint();
	}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
	}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0)
	{
	}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0)
	{
	}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
	}
}
