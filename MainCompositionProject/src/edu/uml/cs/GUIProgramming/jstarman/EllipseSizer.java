/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uml.cs.GUIProgramming.jstarman;


//import edu.uml.cs.GUIProgramming.jjmccaul.JMAddOns; //having issue with this at the moment.
import edu.uml.cs.GUIProgramming.plaidler.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.*;


/**
 *
 * @author James
 */
public class EllipseSizer extends JPanel {
     Ellipse2D.Double el = new Ellipse2D.Double(50, 50, 200, 200);

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.blue);
        g2.draw(el);
    }

    public static void main(String[] args) {
        EllipseSizer test = new EllipseSizer();
        EllipseResizer resizer = new EllipseResizer(test);
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
class EllipseResizer extends MouseAdapter {
    JMAddOns jmao = new JMAddOns();
    EllipseSizer component;
    boolean dragging = false;
    boolean moving = false;
    // Give user some leeway for selections.
    final int PROX_DIST = 3;

    public EllipseResizer(EllipseSizer r) {
        component = r;
    }

    public void mousePressed(MouseEvent e) {
        if(component.getCursor() != Cursor.getDefaultCursor()) {
            // If cursor is set for resizing, allow dragging.
            dragging = true;
        }
        else{
            jmao.inCirc(component, e);
        }
    }

    public void mouseReleased(MouseEvent e) {
        dragging = false;
        jmao.inCirc(component, e);
        playNote();
       
    }

    public void mouseDragged(MouseEvent e) {
        if(dragging) {
            Point p = e.getPoint();
            Ellipse2D.Double ellip = component.el;
            Rectangle r = component.el.getBounds();
            int type = component.getCursor().getType();
            int dx = p.x - r.x;
            int dy = p.y - r.y;
             switch(type) {
                case Cursor.N_RESIZE_CURSOR:
                    int height = r.height - dy;
//                    r.setRect(r.x, r.y+dy, r.width, height);
                    ellip.setFrame(r.x, r.y+dy, r.width, height);
//                    ellip.x = r.x;
//                    ellip.y = r.y+dy;
//                    ellip.width = r.width;
//                    ellip.height = r.height - dy;
                    break;
                case Cursor.NW_RESIZE_CURSOR:
                    int width = r.width - dx;
                    height = r.height - dy;
//                    r.setRect(r.x+dx, r.y+dy, width, height);
                    ellip.setFrame(r.x+dx, r.y+dy, width, height);
                    break;
                case Cursor.W_RESIZE_CURSOR:
                    width = r.width - dx;
//                    r.setRect(r.x+dx, r.y, width, r.height);
                    ellip.setFrame(r.x+dx, r.y, width, r.height);
                    break;
                case Cursor.SW_RESIZE_CURSOR:
                    width = r.width - dx;
                    height = dy;
//                    r.setRect(r.x+dx, r.y, width, height);
                    ellip.setFrame(r.x+dx, r.y, width, height);
                    break;
                case Cursor.S_RESIZE_CURSOR:
                    height = dy;
//                    r.setRect(r.x, r.y, r.width, height);
                    ellip.setFrame(r.x, r.y, r.width, height);
                    break;
                case Cursor.SE_RESIZE_CURSOR:
                    width = dx;
                    height = dy;
//                    r.setRect(r.x, r.y, width, height);
                    ellip.setFrame(r.x, r.y, width, height);
                    break;
                case Cursor.E_RESIZE_CURSOR:
                    width = dx;
//                    r.setRect(r.x, r.y, width, r.height);
                    ellip.setFrame(r.x, r.y, width, r.height);
                    break;
                case Cursor.NE_RESIZE_CURSOR:
                    width = dx;
                    height = r.height - dy;
//                    r.setRect(r.x, r.y+dy, width, height);
                    ellip.setFrame(r.x, r.y+dy, width, height);
                    break;
                default:
                    System.out.println("unexpected type: " + type);
            }
            component.repaint();
        }
        else{
            jmao.moveCirc(component, e);
        }
    }

    public void mouseMoved(MouseEvent e) {
        Point p = e.getPoint();
        if(!isOverRect(p)) {
            if(component.getCursor() != Cursor.getDefaultCursor()) {
                // If cursor is not over rect reset it to the default.
                component.setCursor(Cursor.getDefaultCursor());
            }
            return;
        }
        // Locate cursor relative to center of rect.
        int outcode = getOutcode(p);
        Rectangle r = component.el.getBounds();
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
     * Make a smaller Rectangle and use it to locate the
     * cursor relative to the Rectangle center.
     */
    private int getOutcode(Point p) {
        Rectangle r = (Rectangle)component.el.getBounds().clone();
        r.grow(-PROX_DIST, -PROX_DIST);
        return r.outcode(p.x, p.y);
    }

   public void playNote() {

        //using Paul's class to handle playing the note.
        Orchestra myOrchestra = new Orchestra();

        //getting the rectangle component
        Rectangle r = component.el.getBounds();

        //calculation duration of note based on shape width,
        //max duration will be slightly longer then 2 seconds.
        double doubleDuration = ((int)r.width * 4);
        int duration = (int)doubleDuration;


        //calculating volume based on shape height, this will change though
        double doubleVolume = ((int)r.height / 2);
        int volume = (int)doubleVolume;

        //max volume is 127 so we want to make sure it cannot be louder
        if(volume > 127){
            volume = 127;
        }


        //making an calculation for pitchbend based on pixels
        //here I am setting the pitch based on increments
        //the reason was when I seemed to use any pitchBend based on height of object
        //it would sometimes not play the sound or play an awkward sound.
        int pitchBend = r.y  ;

        if(pitchBend <= 42){
            pitchBend = 80;
        }
        else if(pitchBend <= 84){
            pitchBend = 70;
        }
        else if(pitchBend <= 126){
            pitchBend = 60;
        }
        else if(pitchBend <= 168){
            pitchBend = 50;
        }
        else if(pitchBend <= 210){
            pitchBend = 40;
        }
        else{
            pitchBend = 35;
        }

        //play the note
        myOrchestra.selectChannel(5);
        myOrchestra.playNote(5, pitchBend, volume, duration);

        //for debugging
        System.err.println("width = " + doubleDuration);
        System.err.println("pitchbend = " + pitchBend);
        System.err.println("height " + r.height);
        System.err.println("volume = " + volume);


   }


     /**
     * Make a larger Rectangle and check to see if the
     * cursor is over it.
     */
    private boolean isOverRect(Point p) {
        Rectangle r = (Rectangle)component.el.getBounds().clone();
        r.grow(PROX_DIST, PROX_DIST);
        return r.contains(p);
    }
}
