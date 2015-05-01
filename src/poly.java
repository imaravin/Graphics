import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class poly extends JPanel
{
	private static final long serialVersionUID = 1L;
	public void paint(Graphics g)
	{
		//super.paint(g);
		setPreferredSize(new Dimension(1368, 768));
		int x[]=new int[100];
		int y[]=new int[100];
		 Random rand=new Random();
		 for(int i=0;i<0100;i++)
		 {
			 x[i]=rand.nextInt();
			y[i]=rand.nextInt();
			
		 }
		 g.drawPolygon(x, y,100);
			try
			{
				Thread.sleep(1000);
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
	 	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new poly());


	}

}
