import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class implements a panel with several bouncing balls in it. To
 * create a ball, click on an area without balls. To catch a ball, click
 * on it. Until you release the mouse button the ball will follow the
 * mouse. When you release the mouse button the ball will keep the
 * velocity it last had. You can resize the window and the balls will
 * bounce in the new size. Very rapid balls may not be confined within
 * the box because the calculation assumes that the balls only bounce
 * once between frames. Dragging a ball outside the window (it will
 * appear to bounce) will cause it to go away.
 */
public class Balls extends JPanel
    implements WindowListener, KeyListener, ComponentListener,
    MouseListener, MouseMotionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Color colors[] = { Color.RED,
				      Color.ORANGE,
				      Color.YELLOW,
				      Color.GREEN,
				      Color.BLUE,
				      Color.MAGENTA,
				      Color.GRAY,
				      Color.BLACK }; // available colors
    private int n; // number of balls
    @SuppressWarnings("unused")
	private int minx, maxx, miny, maxy; // bounding box for the action
    private int x[], y[]; // coordinates for the balls
    private int r[]; // radius of the balls
    private int vx[], vy[]; // velocities for the balls
    private Color color[]; // colors of the balls
    private int rate = 100; // refresh rate in seconds

    // The following variables control dragging and releasing balls

    private int draggedBall = -1; // number of ball being dragged
    private int dx, dy; // offset of mouse to ball being dragged
    private int mx, my; // last mouse event coordinates
    private int mvx, mvy; // last velocity of mouse
    private long mt; // last mouse event time

    /**
     * Create a JPanel with bouncing balls in it.
     *
     * @param dimx the initial x dimension of the panel
     * @param dimy the initial y dimension of the panel
     * @param w the window containing the panel
     */
    public Balls( int dimx, int dimy, Window w ) {
	super();
	init( dimx, dimy );
	w.addWindowListener( this ); // for closing
	this.addComponentListener( this ); // for resizing
	this.addKeyListener( this ); // not used
	this.addMouseListener( this ); // for mouse clicks
	this.addMouseMotionListener( this ); // for mouse movement
    }

    /**
     * Initialization code. A single ball is created.
     *
     * @param dimx the initial x dimension of the panel
     * @param dimy the initial y dimension of the panel
     */
    public void init( int dimx, int dimy ) {
	n = 0;
	minx = 0;
	miny = 0;
	maxx = dimx;
	maxy = dimy;
	x = new int[100]; // more than 100 balls will cause a bounds error
	y = new int[100];
	r = new int[100];
	vx = new int[100];
	vy = new int[100];
	color = new Color[100];
	this.setPreferredSize( new Dimension( dimx, dimy ) );
	this.setBackground( Color.WHITE );
	this.setForeground( Color.BLACK );
	// The following code causes the method actionPerformed to be called
	// every "rate" milliseconds.
	new Timer( rate, new ActionListener() {
	    public void actionPerformed( ActionEvent e ) {
		step(); // move the balls
		repaint(); // cause the display to be updated
	    }
	}).start();

	// manually create an initial ball that is slowly moving
	x[0] = 100;
	y[0] = 100;
	r[0] = 20;
	vx[0] = -1;
	vy[0] = -2;
	color[0] = Color.RED;
	n = 1;
    }

    // WindowListener

    public void windowActivated(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
	e.getWindow().dispose(); // close the window (not necessary)
	System.exit( 0 ); // kill the program with error code 0 (normal)
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowOpened(WindowEvent e) {
    }

    // ComponentListener

    public void componentHidden(ComponentEvent e) {
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentResized(ComponentEvent e) {
	maxx = getWidth(); // set the new width on window resizing
	maxy = getHeight(); // set the new height on window resizing
    }

    public void componentShown(ComponentEvent e) {
    }

    // MouseListener

    public void mouseClicked( MouseEvent e ) {
    }

    public void mouseEntered( MouseEvent e ) {
    }

    public void mouseExited( MouseEvent e ) {
    }

    public void mousePressed( MouseEvent e ) {
	// only look at left mouse button
	if( ( e.getModifiers() & MouseEvent.BUTTON1_MASK ) != 0 ) {
	    int newx = e.getX(); // get where the mouse was pressed
	    int newy = e.getY();
	    long newt = e.getWhen();
	    draggedBall = -1; // initialize to no ball being dragged
	    // find ball close to click
	    for( int i = 0; i < n; i++ ) {
		if( ( x[i] - newx ) * ( x[i] - newx ) +
		    ( y[i] - newy ) * ( y[i] - newy ) < r[i] * r[i] ) {
		    draggedBall = i;
		}
	    }
	    if( draggedBall == -1 ) { // no ball clicked - make one
		x[n] = newx;
		y[n] = newy;
		r[n] = 20;
		color[n] = colors[ n % colors.length ]; // cycle through colors
		vx[n] = 0; // initial velocities are zero
		vy[n] = 0;
		draggedBall = n;
		n = n + 1;
	    } else {
		vx[draggedBall] = vy[draggedBall] = 0; // stop ball
		mvx = mvy = 0;
		mx = newx;
		my = newy;
		mt = newt;
		dx = x[draggedBall] - newx; // offset of ball from mouse click
		dy = y[draggedBall] - newy;
	    }
	}
    }

    @SuppressWarnings("unused")
	public void mouseReleased( MouseEvent e ) {
	if( ( draggedBall != -1 &&
	      ( e.getModifiers() & MouseEvent.BUTTON1_MASK ) != 0 ) ) {
	    int newx = e.getX(); // get where the mouse was released
	    int newy = e.getY();
	    long newt = e.getWhen(); // get the time mouse was released
	    int bx = x[draggedBall] = newx + dx; // make ball track mouse
	    int by = y[draggedBall] = newy + dy;
	    vx[draggedBall] = mvx; // set last mouse velocity
	    vy[draggedBall] = mvy;
	    if( bx > maxx - r[draggedBall] ||
		by > maxy - r[draggedBall] ||
		bx < r[draggedBall] ||
		by < r[draggedBall] ) { // if ball outside of window - delete
		for( int i = draggedBall; i < n - 1; i++ ) {
		    x[i] = x[i+1];
		    y[i] = y[i+1];
		    r[i] = r[i+1];
		    vx[i] = vx[i+1];
		    vy[i] = vy[i+1];
		    color[i] = color[i+1];
		}
		n = n - 1;
	    }
	    draggedBall = -1; // no longer have ball to drag
	}
    }

    // MouseMotionListener

    public void mouseDragged( MouseEvent e ) { // we are dragging a ball
	if( draggedBall != -1 ) { // make sure we have a ball number
	    int newx = e.getX(); // get mouse coordinates
	    int newy = e.getY();
	    long newt = e.getWhen(); // get time
	    x[draggedBall] = newx + dx; // set ball position
	    y[draggedBall] = newy + dy;
	    if( newt != mt ) { // if nonzero time elapsed
		// calculate velocity between updates
		mvx = ( ( newx - mx ) * rate ) / (int)( newt - mt );
		mvy = ( ( newy - my ) * rate ) / (int)( newt - mt );
		mx = newx;
		my = newy;
		mt = newt;
	    }
	}
    }

    public void mouseMoved( MouseEvent e ) {
    }

    // KeyListener

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    // Ball stuff

    public void paint( Graphics g ) {
    	Graphics2D g2=(Graphics2D) g;
    	g2.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0, new float[]{9}, 0));
    	// graphics wants to update display
	super.paint( g ); // paint the background etc.
	for( int i = 0; i < n; i++ ) { // for each ball
	    g.setColor( color[i] ); // set the foreground color
	    g.fillOval( x[i] - r[i], y[i] - r[i], 2 * r[i], 2 * r[i]);
	}
    }

    /**
     * Called by the timer and updates the ball positions
     */
    public void step() {
	for( int i = 0; i < n; i++ ) { // for each ball
	    x[i] = x[i] + vx[i]; // update coordinates
	    y[i] = y[i] + vy[i];
	    if( x[i] > maxx - r[i] ) { // if beyond right side
		x[i] = 2 * ( maxx - r[i] ) - x[i]; // bounce
		vx[i] = -vx[i]; // reverse x velocity
	    } else if( x[i] < r[i] ) { // if beyond left side
		x[i] = 2 * r[i] - x[i]; // bounce
		vx[i] = -vx[i]; // reverse x velocity
	    }
	    if( y[i] > maxy - r[i] ) { // if below bottom
		y[i] = 2 * ( maxy - r[i] ) - y[i]; // bounce
		vy[i] = -vy[i]; // reverse y velocity
	    } else if( y[i] < r[i] ) { // if above top
		y[i] = 2 * r[i] - y[i]; // bounce
		vy[i] = -vy[i]; // reverse y velocity
	    }
	}
    }

    public static void main( String args[] ) {
	JFrame window = new JFrame( "Balls" ); // new top-level window
	window.setLocation( 30, 30 ); // position on screen
	JPanel balls = new Balls( 500, 500, window ); // new ball panel
	window.getContentPane().add( balls ); // add to window
	window.pack(); // set all of the sizes
	window.setVisible( true ); // display it
    }
} //Balls
