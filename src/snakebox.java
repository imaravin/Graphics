import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
public class snakebox extends JPanel
{
	private static final long serialVersionUID = 1L;
	static int x[]=new int[300];
	static int y[]=new int[300];
	int width=0;
	int heigth=0;
	int nx=0,ny=0;
	int sx,sy;
	int lx[]=new int[10];
	int ly[]=new int[10];
	public snakebox()
	{
		for(int i=0;width<1378;i++)
		{
			//System.out.println(i);
			x[i]=width;
			width=width+5;
			nx++;
		}
		for(int j=0;heigth<768;j++)
		{
		 	y[j]=heigth;
			heigth=heigth+5;
			ny++;
		}
		sx=new Random().nextInt(nx)-10;
		sy=new Random().nextInt(ny)-10;
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		for(int i=0;i<nx;i++)
			for(int j=0;j<ny;j++)
				g.drawRect(x[i],y[j],5,5);
			for(int k=0;k<10;k++)
			{
				if(sx-k<0)
				lx[k]=x[nx-k];
				else
				lx[k]=x[sx-k];
				ly[k]=x[sy];
			}
			
			for(int m=0;m<10;m++)
				g.fillRect(lx[m], ly[m], 5, 5);
			sx++;
			if(sx>nx)
				sx=0;
				repaint();
		
	}
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
	//	frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new snakebox());
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
