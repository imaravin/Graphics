import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;


public class ArrayComponent extends JComponent
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Double[] values;
private Double marked1;
private Double marked2;

public synchronized void setValues(Double[] values,Double marked1,Double marked2)
{
	this.values=values;
	this.marked1=marked1;
	this.marked1=marked2;
	repaint();
}
public synchronized void paintComponent(Graphics g)
{
	if(values==null)
	return;
	Graphics2D g2=(Graphics2D)g;
	int width=getWidth();
	for(int i=0;i<values.length;i++)
	{
		double height=values[i]*getHeight();
		Rectangle2D bar=new Rectangle2D.Double(width*i,0,width,height);
		if(values[i]==marked1||values[i]==marked2)
			g2.fill(bar);
		else
			g2.fill(bar);
	}
}
}
