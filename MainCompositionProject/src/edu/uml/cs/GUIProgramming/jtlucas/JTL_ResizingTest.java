/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uml.cs.GUIProgramming.jtlucas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author JTLucas
 */
public class JTL_ResizingTest extends JPanel  {
/** The resizable rectangle */
    Rectangle rect = new Rectangle(100,100,150,150);

    
    /**
     * This method is called when the JPanel is painted.  It is inherited from JComponent,
     *   of which JPanel is a subclass.
     * @param g a standard Graphics object
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
         g2.setPaint(Color.blue);
        g2.draw(rect);
    }

    /**
     * The standard Java application startup method.
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // create an instance of this application (a JPanel) using the default constructor
        JTL_ResizingTest test = new JTL_ResizingTest();

        // create an instance of the mouse listener class (extends MouseAdapter)
        Resizer resizer = new Resizer(test);

        // add the mouse listener class to this JPanel as both the MouseListener and MouseMotionListener
        test.addMouseListener(resizer);
        test.addMouseMotionListener(resizer);

        // create the JFrame for this application and do a bit of setup
        JFrame f = new JFrame();
        f.setTitle( "JTL_ResizingTest Demo by \"hardwired\"" );   // added by JMH
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400,400);
        f.setLocation(100,100);

        // add the application's JPanel to the JFrame just created
        f.add(test);

        // make the JFrame visible
        f.setVisible(true);
    }
}


/**
 * The mouse listerner class used by the JTL_ResizingTest class.
 * N.B. MouseAdapter OK for J2SE 1.6+. Use MouseInputAdapter for J2SE 1.5-.  (original documentation)
 * @author "hardwired"
 * @see http://www.java-forums.org/new-java/14505-how-resize-shape-jpanel-using-mouse.html
 */
class Resizer extends MouseAdapter {

    /** The JPanel containing the component to be resized */
    JTL_ResizingTest component;

    /** True when dragging is in progress */
    boolean dragging = false;

    /**
     * The number of pixels to the left or right or above or below a rectangle edge that will be
     *   considered on an edge and will initiate dragging.
     * Original Documentation: Give user some leeway for selections.
     */
    final int PROX_DIST = 3;

    /**
     * Constructor that sets the resizable component to a local variable in this class.
     * @param r the JTL_ResizingTest component to remember.
     */
    public Resizer(JTL_ResizingTest r) {
        component = r;
    }

     /**
     * This method is called when the mouse is pressed.  The state of the cursor is queried and
     *   used to determine whether dragging should be initiated.  Note that the cursor changes
     *   in the mouseMoved method based on its position relative to the rectangle to be resized.
     *   If the cursor is not the default cursor, dragging is initiated.
     * @param e a standard MouseEvent
     */
    public void mousePressed(MouseEvent e) {
        if ( component.getCursor() != Cursor.getDefaultCursor() ) {
            // If cursor is set for JTL_ResizingTest, allow dragging.
            dragging = true;
        }
    }

    /**
     * This method is called when the mouse is released.  Doing so terminates dragging.
     * @param e a standard MouseEvent
     */
    public void mouseReleased(MouseEvent e) {
        dragging = false;
    }


    /**
     * This method is called when the mouse is being dragged.  Note that this is the Java event
     *   that is called whenever the mouse is moved while a mouse button is pressed.  Also note
     *   <i>either</i> this method or mouseMoved is called, never both.
     * <p>When this
     *   method is called, the user may or may not actually be dragging an edge of the rectangle.
     *   The latter state is determined by the state of the boolean variable: dragging.  This is
     *   why all of the code here is inside an if statement that tests to see whether that
     *   variable is true.  If it is, the rectangle is resized.  If it is not, this method does
     *   nothing.
     * @param e a standard MouseEvent
     */
    public void mouseDragged(MouseEvent e) {

        // System.err.println( "mouseDragged called" ) ;

        // test whether current program state is JTL_ResizingTest the resizable rectangle
        if ( dragging ) {

            // the Point (X and Y coordinates) where the mouse is at the moment
            Point p = e.getPoint();

            // the current state of the resizable rectangle
            Rectangle r = component.rect;

            JTL_ShapeResize check = new JTL_ShapeResize();
            JTL_ShapeSize defaultshape = new JTL_ShapeSize( );

            switch(check.Max_Shape_Resize(r)){
                case 1: {
                    r.setBounds((int)r.getX(), (int)r.getY(), (int)r.getWidth()-3, (int)r.getHeight());
                    component.repaint();
                    dragging = false;
                    return;
                }
                case 2: {
                    r.setBounds((int)r.getX(), (int)r.getY(), (int)defaultshape.getShapeMaxWidth()-3 , (int)r.getHeight());
                    component.repaint();
                    dragging = false;
                    return;
                }
                case 3: {
                    r.setBounds((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight()-3);
                    component.repaint();
                    dragging = false;
                    return;
                }
                case 4: {
                    r.setBounds((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)defaultshape.getShapeMaxHeight()-3);
                    component.repaint();
                    dragging = false;
                    return;
                }
            }
            switch(check.Min_Shape_Resize(r)){
                case 1: {
                    r.setBounds((int)r.getX(), (int)r.getY(), (int)r.getWidth()+3, (int)r.getHeight());
                    component.repaint();
                    dragging = false;
                    return;
                }
                case 2: {
                    r.setBounds((int)r.getX(), (int)r.getY(), (int)defaultshape.getShapeMinWidth()+3 , (int)r.getHeight());
                    component.repaint();
                    dragging = false;
                    return;
                }
                case 3: {
                    r.setBounds((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight()+3);
                    component.repaint();
                    dragging = false;
                    return;
                }
                case 4: {
                    r.setBounds((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)defaultshape.getShapeMinHeight()+3);
                    component.repaint();
                    dragging = false;
                    return;
                }
            }

            if(!check.Min_Shape_Position(r)){
                r.setBounds((int)r.getX(), (int)check.getCanvas_Ypos()-3, (int)r.getWidth(), (int)r.getHeight());
                component.repaint();
                dragging = false;
                return;
            }

            // the current state of the cursor
            int type = component.getCursor().getType();

            // the difference between the X coordinate of the cursor and the X coordinate
            //    (upper left-hand corner) of the resizable rectangle
            int dx = p.x - r.x;

            // the difference between the Y coordinate of the cursor and the Y coordinate
            //    (upper left-hand corner) of the resizable rectangle
            int dy = p.y - r.y;

            // note that there are 8 possible states corresponding to the 4 sides and the
            //    4 corners
            switch ( type ) {
                case Cursor.N_RESIZE_CURSOR:
                    int height = r.height - dy;
                    r.setRect(r.x, r.y+dy, r.width, height);
                    break;
                case Cursor.NW_RESIZE_CURSOR:
                    int width = r.width - dx;
                    height = r.height - dy;
                    r.setRect(r.x+dx, r.y+dy, width, height);
                    break;
                case Cursor.W_RESIZE_CURSOR:
                    width = r.width - dx;
                    r.setRect(r.x+dx, r.y, width, r.height);
                    break;
                case Cursor.SW_RESIZE_CURSOR:
                    width = r.width - dx;
                    height = dy;
                    r.setRect(r.x+dx, r.y, width, height);
                    break;
                case Cursor.S_RESIZE_CURSOR:
                    height = dy;
                    r.setRect(r.x, r.y, r.width, height);
                    break;
                case Cursor.SE_RESIZE_CURSOR:
                    width = dx;
                    height = dy;
                    r.setRect(r.x, r.y, width, height);
                    break;
                case Cursor.E_RESIZE_CURSOR:
                    width = dx;
                    r.setRect(r.x, r.y, width, r.height);
                    break;
                case Cursor.NE_RESIZE_CURSOR:
                    width = dx;
                    height = r.height - dy;
                    r.setRect(r.x, r.y+dy, width, height);
                    break;
                default:
                    // changed by JMH form System.out to System.err
                    System.err.println("unexpected type: " + type);
            }
            // the following statement causes method protected void paintComponent(Graphics g)
            //    in class JTL_ResizingTest to be called
            component.repaint();
        }
    }

    /**
     * This method is called when the mouse is moved.  Note that <i>either</i> this method or
     *    mouseDragged is called, never both.
     * <p>The purpose of this method is to determine whether the mouse is within the tolerance
     *    range of being on an edge or a corner.  If it is, the cursor is changed accordingly.
     *    It is the change of cursor that is then used in the mouseDragged listener to determine
     *    how to resize the rectangle.
     * @param e a standard MouseEvent
     */
    public void mouseMoved( MouseEvent e ) {

        // System.err.println( "mouseMoved called" ) ;

        // the current location of the mouse
        Point p = e.getPoint();

         // determine whether the cursor is "over the rectangle", and, if it is not, reset the
        //    cursor to the default cursor
        // Note that this code is within the mouseMoved event, which is not called if the
        //    mouseDragged event is called.  Therefore, this is really here to make the program
        //    more robust.
        if ( ! isOverRect( p ) ) {
            if ( component.getCursor() != Cursor.getDefaultCursor() ) {
                // If cursor is not over rect, reset it to the default.
                component.setCursor( Cursor.getDefaultCursor() );
            }
            return;
        }

        // Locate cursor relative to center of rect.

        // get the logical OR of all appropriate out codes, that is,
        //    Rectangle2D.OUT_LEFT, Rectangle2D.OUT_TOP, Rectangle2D.OUT_RIGHT, Rectangle2D.OUT_BOTTOM
        int outcode = getOutcode( p );

        // get the resizable rectangle
        Rectangle r = component.rect;

        switch(outcode) {
            case Rectangle.OUT_TOP:
                if(Math.abs(p.y - r.y) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.N_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_TOP + Rectangle.OUT_LEFT:
                if(Math.abs(p.y - r.y) < PROX_DIST &&
                   Math.abs(p.x - r.x) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.NW_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_LEFT:
                if(Math.abs(p.x - r.x) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.W_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_LEFT + Rectangle.OUT_BOTTOM:
                if(Math.abs(p.x - r.x) < PROX_DIST &&
                   Math.abs(p.y - (r.y+r.height)) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.SW_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_BOTTOM:
                if(Math.abs(p.y - (r.y+r.height)) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.S_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_BOTTOM + Rectangle.OUT_RIGHT:
                if(Math.abs(p.x - (r.x+r.width)) < PROX_DIST &&
                   Math.abs(p.y - (r.y+r.height)) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.SE_RESIZE_CURSOR));
                }
                break;
             case Rectangle.OUT_RIGHT:
                if(Math.abs(p.x - (r.x+r.width)) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.E_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_RIGHT + Rectangle.OUT_TOP:
                if(Math.abs(p.x - (r.x+r.width)) < PROX_DIST &&
                   Math.abs(p.y - r.y) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.NE_RESIZE_CURSOR));
                }
                break;
            default:    // center
                component.setCursor(Cursor.getDefaultCursor());
        }
    }

    /**
     * Make a smaller Rectangle and use it to locate the cursor relative to the
     *    Rectangle center.  (original documentation)
     * @return true if the cursor is inside the tolerance rectangle, otherwise return false
     */
    private int getOutcode(Point p) {

        // create a copy of the rectangle so that you don't mess up the displayed one
        // the cast is needed because the clone method is a member of the Object class and
        //    returns an Object
        // this copy is not displayed, it is simply used for internal computation in this method
        Rectangle r = (Rectangle)component.rect.clone();

        // decrease the size of the rectangle copy by the tolerance limits
        r.grow( -PROX_DIST, -PROX_DIST );

        // return the logical OR of all appropriate out codes
        //    out codes are:
        //      Rectangle2D.OUT_LEFT, Rectangle2D.OUT_TOP, Rectangle2D.OUT_RIGHT, Rectangle2D.OUT_BOTTOM
        return r.outcode( p.x, p.y );
    }

    /**
     * Make a larger Rectangle and check to see if the cursor is over it.  (original documentation)
     * @return true if the cursor is inside the tolerance rectangle, otherwise return false
     */
    private boolean isOverRect( Point p ) {

        // create a copy of the rectangle so that you don't mess up the displayed one
        // the cast is needed because the clone method is a member of the Object class and
        //    returns an Object
        // this copy is not displayed, it is simply used for internal computation in this method
        Rectangle r = (Rectangle)component.rect.clone();

        // increase the size of the rectangle copy by the tolerance limits
        r.grow( PROX_DIST, PROX_DIST );

        // return true if the cursor is inside the tolerance rectangle, otherwise return false
        return r.contains( p );
    }
}
