import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
public class photo extends JPanel 
{
	
	private static final long serialVersionUID = 1L;
	static int x[]=new int[120];
	static int y[]=new int[120];
	static int xv=5;
	static int yv=0;
	static Action upaction;
	static Action downaction;
	static Action right;
	static Action left;
	static Action back;
	static Action fwd;
	static Action full;
	private static int f;
	static String tm;
	static JFrame frame;
	static int m,n,o,p;
	public photo()
	{
		xv=5;
		yv=0;
		m=0;
		n=0;
		o=Toolkit.getDefaultToolkit().getScreenSize().width;
		p=Toolkit.getDefaultToolkit().getScreenSize().height;
		x[0]=Toolkit.getDefaultToolkit().getScreenSize().width/2;
		for(int i=0;i<120;i++)
			y[i]=Toolkit.getDefaultToolkit().getScreenSize().height/2;
		for(int i=1;i<120;i++)
			x[i]=x[i-1]-5;
		 f=new Random().nextInt(180);
		 tm="D:\\Nature\\"+f+".jpg";
	}
	@SuppressWarnings("deprecation")
	public void paint(Graphics g)
	{
	//	super.paint(g);
		 g.drawImage(Toolkit.getDefaultToolkit().getImage(tm), m, n,o,p, null);
		Date time=new Date();
		StringBuffer timestring=new StringBuffer();
	//	String timestring="";
		timestring.append(time.getDate());
		timestring.append("/");
		timestring.append(time.getMonth());
		timestring.append("/");
		timestring.append((time.getYear()+1900));
		timestring.append("   ");
		timestring.append((time.getHours()%12));
		timestring.append("-");
		timestring.append((time.getMinutes()%60));
		timestring.append("-");
		timestring.append((time.getSeconds()%60));
		String tmp=new String(timestring);
		
		
		Font custom=new Font("Serif", Font.BOLD,4);
		setFont(custom);
		g.setColor(Color.WHITE);
		g.drawString(tmp, 1225, 700);
		for(int i=0;i<12;i++)
		{
			x[i]=x[i]+xv;
			y[i]=y[i]+yv;
			if(x[i]>Toolkit.getDefaultToolkit().getScreenSize().width)
				x[i]=0;
			if(y[i]>Toolkit.getDefaultToolkit().getScreenSize().height)
				y[i]=0;
			if(x[i]<0)
				x[i]=Toolkit.getDefaultToolkit().getScreenSize().width;
			if(y[i]<0)
				y[i]=Toolkit.getDefaultToolkit().getScreenSize().height;
		}
		
	//	repaint();
		
	}

	 
		public static void main(String[] args)
		{
			  frame=new JFrame();
			frame.setUndecorated(true);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(new photo());
			KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0, false);
			KeyStroke fullstroke = KeyStroke.getKeyStroke(KeyEvent.VK_F11,0, false);
			KeyStroke Bstroke=KeyStroke.getKeyStroke("N");
			KeyStroke Vstroke=KeyStroke.getKeyStroke("P");
			KeyStroke rightKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0, false);
			KeyStroke leftKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0, false);
			KeyStroke upKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_UP,0, false);
			KeyStroke downKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0, false);
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
			back=new AbstractAction()
			{
		
				private static final long serialVersionUID = 1L;
				public void actionPerformed(ActionEvent arg0)
				{
					  f++;
					  if( f>180)
							 f=180;
						 if(f<1)
							 f=1;
					 tm="D:\\Nature\\"+f+".jpg";
				}
			};
			fwd = new AbstractAction()
			{
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent arg0)
				{
					 f--;
					 if( f>180)
						 f=180;
					 if(f<1)
						 f=1;
					 tm="D:\\Nature\\"+f+".jpg";
				}
			};
			 right=new AbstractAction()
				{
					private static final long serialVersionUID = 1L;
					public void actionPerformed(ActionEvent arg0)
					{
						  f++;
						  if( f>180)
								 f=180;
							 if(f<1)
								 f=1;
						 tm="D:\\Nature\\"+f+".jpg";
					}
				};
				 left=new AbstractAction()
				{
					private static final long serialVersionUID = 1L;
					public void actionPerformed(ActionEvent arg0)
					{
						 f--;
						 if( f>180)
							 f=180;
						 if(f<1)
							 f=1;
						 tm="D:\\Nature\\"+f+".jpg";
						
					}
				};
			full=new AbstractAction()
			{
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
				
				}
			};
			 upaction=new AbstractAction()
				{
					private static final long serialVersionUID = 1L;
					public void actionPerformed(ActionEvent arg0)
					{
						m++;n++;
						p--;
						o--;
						if(m>Toolkit.getDefaultToolkit().getScreenSize().width/2)
							m=Toolkit.getDefaultToolkit().getScreenSize().width/2;
						if(n>Toolkit.getDefaultToolkit().getScreenSize().height/2)
							n=Toolkit.getDefaultToolkit().getScreenSize().height/2;
					}
				};
				   downaction =new AbstractAction()
					{
						private static final long serialVersionUID = 1L;

						@Override
						public void actionPerformed(ActionEvent arg0)
						{
					m--;n--;
					o++;p++;
					if(m<0)
						m=0;
					if(n<0)
						n=0;
						}
					};
			frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(Bstroke, "BACK");
			frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(fullstroke, "FULL");
			frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(Vstroke, "FWD");
			frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(rightKeyStroke,"RIGHT");
			frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(leftKeyStroke,"LEFT");
			frame.getRootPane().getActionMap().put("RIGHT", right);
			frame.getRootPane().getActionMap().put("LEFT", left);
			frame.getRootPane().getActionMap().put("BACK", back);
			frame.getRootPane().getActionMap().put("FWD", fwd);
			frame.getRootPane().getActionMap().put("FULL", full);
			frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(upKeyStroke, "UP");
			frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(downKeyStroke, "DOWN");
			frame.getRootPane().getActionMap().put("UP", upaction);
			frame.getRootPane().getActionMap().put("DOWN", downaction);
			frame.setVisible(true);
		}
	
}
