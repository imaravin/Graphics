import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Bus extends JPanel
{
	/**
	 * 
	 */
	Random rand=new Random();
	int theta=1;
	private static final long serialVersionUID = 1L;
	int x=0,y=00;
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, 30, 30);
	}
	public void move()
	{
		x=rand.nextInt(1368 - 30 * 2 - 20) + 30+ 10;
		 y= rand.nextInt(768 - 30 * 2 - 20) + 30+ 10;
		 int ballMoveAngle = rand.nextInt(300); // 0 to 359
	     float ballSpeed = rand.nextInt(5) +1;
	     float ballSpeedX = (float)(ballSpeed * Math.cos(Math.toRadians(ballMoveAngle)));
	      float ballSpeedY = (float)(ballSpeed * Math.sin(Math.toRadians(ballMoveAngle)));
	      x=(int) +ballSpeedX;
	      y=(int) +ballSpeedY;
	      if (x - 30 < 0)
	      {
              ballSpeedX = -ballSpeedX;
             x=30;
	      }
	      else if (x +30 > 1368)
	      {
              ballSpeedX = -ballSpeedX;
              x = 1368 -30;
           }
	      if (y- 30 < 0) 
	      {
              ballSpeedY = -ballSpeedY;
              y = 30;
           } else if (y + 30 > 768) 
           {
              ballSpeedY = -ballSpeedY;
              y=768 -30;
           }
	      repaint();
	}
		
	public static void main(String arg[]) throws Exception
	{
		JFrame frame=new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		Bus bus=new Bus();
		frame.add(bus);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while(true)
		{
		bus.move();
		bus.repaint();
		Thread.sleep(20 );
		}
	}
}