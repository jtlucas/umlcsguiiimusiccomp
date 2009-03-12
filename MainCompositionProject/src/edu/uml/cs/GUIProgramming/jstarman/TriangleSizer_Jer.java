/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uml.cs.GUIProgramming.jstarman;

//import edu.uml.cs.GUIProgramming.jjmccaul.JMAddOns; //having issue with this at the moment.
import edu.uml.cs.GUIProgramming.plaidler.Orchestra;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author James
 */
public class TriangleSizer_Jer extends JPanel{
    Point p1 = new Point(150,150);
    Point p2 = new Point(100,200);
    Point p3 = new Point(200,200);
    int [] xs = {p1.x, p2.x, p3.x};
    int [] ys = {p1.y, p2.y, p3.y};
    Polygon triangle = new Polygon(xs, ys, 3);

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.red);
        g2.draw(triangle);
    }

    public static void main(String[] args) {
        TriangleSizer_Jer test = new TriangleSizer_Jer();
        TriangleSize resizer = new TriangleSize(test);
        test.addMouseListener(resizer);
        test.addMouseMotionListener(resizer);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(test);
        f.setSize(400,400);
        f.setLocation(100,100);
        f.setVisible(true);
        new JMAddOns(f);
    }
}
/**
 * MouseAdapter okay for j2se 1.6+
 * Use MouseInputAdapter for j2se 1.5-
 */
class TriangleSize extends MouseAdapter {
    JMAddOns jmao = new JMAddOns();
    TriangleSizer_Jer component;
    boolean dragging = false;
    boolean moving = false;
    // Give user some leeway for selections.
    final int PROX_DIST = 3;

    public TriangleSize(TriangleSizer_Jer r) {
        component = r;
    }

    public void mousePressed(MouseEvent e) {
        if(component.getCursor() != Cursor.getDefaultCursor()) {
            // If cursor is set for resizing, allow dragging.
            dragging = true;
        }
        else{
            jmao.inTri(component, e);
        }
    }

    public void mouseReleased(MouseEvent e) {
        dragging = false;
        jmao.inTri(component, e);
        playNote();

    }

    public void mouseDragged(MouseEvent e) {
        if(dragging) {
            Point p = e.getPoint();
            Polygon tri = component.triangle;
            int type = component.getCursor().getType();
            int dx = p.x - tri.xpoints[0];
            int dy = p.y - tri.ypoints[0];
             switch(type) {
                case Cursor.N_RESIZE_CURSOR:
                    tri.ypoints[0] = tri.ypoints[0] + dy;
                    break;
                case Cursor.SW_RESIZE_CURSOR:
                    dx = p.x - tri.xpoints[1];
                    dy = p.y - tri.ypoints[1];
                    tri.xpoints[1] = tri.xpoints[1] + dx;
                    tri.ypoints[1] = tri.ypoints[1] + dy;
                    tri.xpoints[2] = tri.xpoints[2] - dx;
                    tri.ypoints[2] = tri.ypoints[2] + dy;
                    break;
                case Cursor.SE_RESIZE_CURSOR:
                    dx = p.x - tri.xpoints[2];
                    dy = p.y - tri.ypoints[2];
                    tri.xpoints[2] = tri.xpoints[2] + dx;
                    tri.ypoints[2] = tri.ypoints[2] + dy;
                    tri.xpoints[1] = tri.xpoints[1] - dx;
                    tri.ypoints[1] = tri.ypoints[1] + dy;
                    break;
                default:
                    System.out.println("unexpected type: " + type);
            }
            component.repaint();
        }
        else{
            jmao.moveTri(component, e);
        }
    }

    public void mouseMoved(MouseEvent e) {
        Point p = e.getPoint();
//        if(!isOverRect(p)) {
//            if(component.getCursor() != Cursor.getDefaultCursor()) {
//                // If cursor is not over rect reset it to the default.
//                component.setCursor(Cursor.getDefaultCursor());
//            }
//            return;
//        }
//        Point loc = e.getLocationOnScreen();
//        if(component.triangle.contains(e.getLocationOnScreen())){
//            System.out.println(loc);
//        }
        
        // Locate cursor relative to center of rect.
//        int outcode = getOutcode(p);
//        Rectangle r = component.rect;
        Polygon tri = component.triangle;
        if((Math.abs(e.getX()-tri.xpoints[2])) < PROX_DIST){
            if(Math.abs(e.getY()-tri.ypoints[2])< PROX_DIST){
                component.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
            }
        }
        else if((Math.abs(e.getX()-tri.xpoints[1])) < PROX_DIST){
            if(Math.abs(e.getY()-tri.ypoints[1])< PROX_DIST){
                component.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
            }
        }
        else if((Math.abs(e.getX()-tri.xpoints[0])) < PROX_DIST){
            if(Math.abs(e.getY()-tri.ypoints[0])< PROX_DIST){
                component.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
            }
        }
        else{
             component.setCursor(Cursor.getDefaultCursor());
        }





//        switch(outcode) {
//            case Rectangle.OUT_TOP:
//                if(Math.abs(p.y - r.y) < PROX_DIST) {
//                    component.setCursor(Cursor.getPredefinedCursor(
//                                        Cursor.N_RESIZE_CURSOR));
//                }
//                break;
//             case Rectangle.OUT_TOP + Rectangle.OUT_LEFT:
//                if(Math.abs(p.y - r.y) < PROX_DIST &&
//                   Math.abs(p.x - r.x) < PROX_DIST) {
//                    component.setCursor(Cursor.getPredefinedCursor(
//                                        Cursor.NW_RESIZE_CURSOR));
//                }
//                break;
//            case Rectangle.OUT_LEFT:
//                if(Math.abs(p.x - r.x) < PROX_DIST) {
//                    component.setCursor(Cursor.getPredefinedCursor(
//                                        Cursor.W_RESIZE_CURSOR));
//                }
//                break;
//            case Rectangle.OUT_LEFT + Rectangle.OUT_BOTTOM:
//                if(Math.abs(p.x - r.x) < PROX_DIST &&
//                   Math.abs(p.y - (r.y+r.height)) < PROX_DIST) {
//                    component.setCursor(Cursor.getPredefinedCursor(
//                                        Cursor.SW_RESIZE_CURSOR));
//                }
//                break;
//            case Rectangle.OUT_BOTTOM:
//                if(Math.abs(p.y - (r.y+r.height)) < PROX_DIST) {
//                    component.setCursor(Cursor.getPredefinedCursor(
//                                        Cursor.S_RESIZE_CURSOR));
//                }
//                break;
//            case Rectangle.OUT_BOTTOM + Rectangle.OUT_RIGHT:
//                if(Math.abs(p.x - (r.x+r.width)) < PROX_DIST &&
//                   Math.abs(p.y - (r.y+r.height)) < PROX_DIST) {
//                    component.setCursor(Cursor.getPredefinedCursor(
//                                        Cursor.SE_RESIZE_CURSOR));
//                }
//                break;
//            case Rectangle.OUT_RIGHT:
//                if(Math.abs(p.x - (r.x+r.width)) < PROX_DIST) {
//                    component.setCursor(Cursor.getPredefinedCursor(
//                                        Cursor.E_RESIZE_CURSOR));
//                }
//                break;
//            case Rectangle.OUT_RIGHT + Rectangle.OUT_TOP:
//                if(Math.abs(p.x - (r.x+r.width)) < PROX_DIST &&
//                   Math.abs(p.y - r.y) < PROX_DIST) {
//                    component.setCursor(Cursor.getPredefinedCursor(
//                                        Cursor.NE_RESIZE_CURSOR));
//                }
//                break;
//            default:    // center
//                component.setCursor(Cursor.getDefaultCursor());
        }

    public void playNote()
    {

        //using Paul's class to handle playing the note.
        Orchestra myOrchestra = new Orchestra();

        //getting the rectangle component
        Polygon tri = component.triangle;

        //calculation duration of note based on shape width,
        //max duration will be slightly longer then 2 seconds.

        int duration = (tri.xpoints[2] - tri.xpoints[1]) * 4;
        //double doubleDuration = ((int) tri.xpoints[2] - tri.xpoints[1] );
        //int duration = (int)doubleDuration;

        System.err.println(tri.xpoints[0] + " " + tri.xpoints[1] + " " + tri.xpoints[2] );



        //calculating volume based on shape height, this will change though
        int volume = (tri.ypoints[1] - tri.ypoints[0])/2;

        //max volume is 127 so we want to make sure it cannot be louder
        if(volume > 127){
            volume = 127;
        }

        //making an calculation for pitchbend based on pixels
        //here I am setting the pitch based on increments
        //the reason was when I seemed to use any pitchBend based on height of object
        //it would sometimes not play the sound or play an awkward sound.
        int pitchBend = tri.ypoints[0] ;
        if(pitchBend <= 42){
            pitchBend = 65;
        }
        else if(pitchBend <= 84){
            pitchBend = 60;
        }
        else if(pitchBend <= 126){
            pitchBend = 55;
        }
        else if(pitchBend <= 168){
            pitchBend = 50;
        }
        else if(pitchBend <= 210){
            pitchBend = 45;
        }
        else{
            pitchBend = 40;
        }

        //play the note
        myOrchestra.selectChannel(3);
        myOrchestra.playNote(3, pitchBend, volume, duration);

        //for debugging
        System.err.println("duration = " + duration);
        System.err.println("pitchbend = " + pitchBend);
        System.err.println("height " + volume*2);
        System.err.println("volume = " + volume);
    }


    /**
     * Make a smaller Rectangle and use it to locate the
     * cursor relative to the Rectangle center.
     */
//    private int getOutcode(Point p) {
//        Rectangle r = (Rectangle)component.rect.clone();
//        r.grow(-PROX_DIST, -PROX_DIST);
//        return r.outcode(p.x, p.y);
//    }

     /**
     * Make a larger Rectangle and check to see if the
     * cursor is over it.
     */
//    private boolean isOverRect(Point p) {
//        Rectangle r = (Rectangle)component.rect.clone();
//        r.grow(PROX_DIST, PROX_DIST);
//        return r.contains(p);
//    }
}
