import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
public class bubblesort extends JPanel implements MouseListener
{
	
	private static final long serialVersionUID = 941560150001675727L;
	int arr[]={2,4,6,7,4,8,1,3,9 };
	int width,x;
	boolean b[];
	private int i;
	private int tmp;
	int z,y;
	int m=0,n=0,l;
	
	public bubblesort()
	{
		l=0;
		z=arr.length;
		y=x;
		b=new boolean[arr.length];
		addMouseListener(this);
		x=1368/arr.length;		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		((Graphics2D) g).setStroke( new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
		for( i=0,width=0;i<arr.length;i++,width=width+x)
		{
			
			if(!b[i])
			g.drawRect(width,744-(arr[i]*50),x,arr[i]*50);
			else
				g.fillRect(width,744-(arr[i]*50),x,arr[i]*50);
			b[i]=false;
		}
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i=0;
	//	repaint();
	}
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		//frame.setUndecorated(true);
		
	//	frame.add(new JButton("Run"),new temp());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new bubblesort());
		KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0, false);
		
        Action escapeAction = new AbstractAction() {
                /**
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
		
		
		
		//for(m=0;m<x;m++)
		//	for(n=0;n<y;n++)
			if(m>=0 && m<arr.length && n>=0 && n<arr.length)
			{
				b[m]=true;
				b[n]=true;
				repaint();
				if(arr[m]>arr[n])
				{
					tmp=arr[n];
					arr[n]=arr[m];
					arr[m]=tmp;
				}
				repaint();
				b[m]=false;
				b[n]=false;
				
			}
			
			n++;
			if(n>arr.length)
			{
				m++;
				n=0;
			}
			if(m>arr.length)
				m=0;
			
		
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
	class temp implements ActionListener
	{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(m>=0 && m<arr.length && n>=0 && n<arr.length)
			{
				b[m]=true;
				b[n]=true;
				repaint();
				if(arr[m]>arr[n])
				{
					tmp=arr[n];
					arr[n]=arr[m];
					arr[m]=tmp;
				}
				repaint();
				b[m]=false;
				b[n]=false;
				
			}
			
			n++;
			if(n>arr.length)
			{
				m++;
				n=0;
			}
			if(m>arr.length)
				m=0;
			
		}
		
	}

}
