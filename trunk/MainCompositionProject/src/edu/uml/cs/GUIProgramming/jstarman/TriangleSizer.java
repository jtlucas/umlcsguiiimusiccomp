/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uml.cs.GUIProgramming.jstarman;


import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.*;

/**
 *
 * @author James
 */
public class TriangleSizer extends JPanel{
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
        TriangleSizer test = new TriangleSizer();
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
    TriangleSizer component;
    boolean dragging = false;
    boolean moving = false;
    // Give user some leeway for selections.
    final int PROX_DIST = 3;

    public TriangleSize(TriangleSizer r) {
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
        try {
            playNote();
        } catch (InterruptedException ex) {
            Logger.getLogger(TriangleSize.class.getName()).log(Level.SEVERE, null, ex);
        }
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





//    }

      public void playNote() throws InterruptedException
        {
       try
        {
            //getting the rectangle component
            //Rectangle r = component.rect;
            Polygon tri = component.triangle;
            

            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            //getting every channel and assigning it to position in the channel array
            MidiChannel[] channels = synth.getChannels();
            //int volume = ((r.x+25)/2);

            int height = tri.ypoints[1] - tri.ypoints[0];
            
            //calculating volume based on shape size, this will change though
            int volume = height/2;

            

            //max volume is 127 so we want to make sure it cannot be louder
            if(volume > 127){
                volume = 127;
            }

            System.err.println("Volume = " + volume);

            //making an calculation for pitchbend based on pixels, but this will change
            int pitchBend = tri.ypoints[0]  * 66;

            System.err.println("Pitchbend = " + pitchBend);

            //System.err.println("pitchbend = " + pitchBend);
           //System.err.println("height " + r.height);

            channels[1].setPitchBend(pitchBend); //setting the pitch bend based on y position of shape
           // channels[1].setPolyPressure(65,127); //testing duration, but doesn't seem to be doing anything

            //play the note
            channels[1].noteOn(65, volume);

            //channels[7].noteOff(65);


            // System.err.println("volume = " + intVolume);
            //System.err.println("Pitch bend 1: " + channels[1].getPitchBend() );

                //channels[2].noteOn(64, 127);


//                double gain = 0.9D;
//                for (int i=0; i<channels.length; i++) {
//                    channels[i].controlChange(7, 1);
//                    channels[i].setPitchBend(0);
//                    System.err.println("controller " + i  + ": " + channels[i].getController(7));
//                    System.err.println("pitch bend " + i  + ": " + channels[i].getPitchBend());
//                }
                //synth.close();

               // sequencer.start();
               //synth.close();

            }
    catch (MidiUnavailableException e){
    }
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
