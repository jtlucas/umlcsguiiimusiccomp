/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uml.cs.GUIProgramming.jstarman.MusicAppPack;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;
import javax.swing.*;

/**
 *
 * @author James
 */
public class JMAddOns extends JPanel {

    Sequence sequence = null;
    Sequencer sequencer = null;
    int x = -1;
    int y = -1;


    public static void main(String[] args){
        JMAddOns jm = new JMAddOns();
//        Ellipse e = new Ellipse(jm);
//        Ellipse e = new Ellipse();
//        int [] x = {75,125,100};
//        int [] y = {75,75,125};
//        Polygon p = new Polygon(x, y, 3);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(jm);
//        f.add(e);
        f.setSize(400,400);
        f.setLocation(100,100);
        f.setVisible(true);
    }

//    private static void Nothing(java.awt.event.ActionEvent evt) {
//          // TODO add your handling code here:
//          JOptionPane.showMessageDialog(null, "This has not been set up yet.", "Nothing To Do", JOptionPane.INFORMATION_MESSAGE);
//    }

    protected void paintComponent(Graphics g) {
        Ellipse2D.Float el = new Ellipse2D.Float(20, 20, 50, 50);
        int [] x = {75,125,100};
        int [] y = {75,75,125};
        Polygon p = new Polygon(x, y, 3);
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.blue);
        g2.draw(el);
        g2.setPaint(Color.RED);
        g2.draw(p);
    }

    public JMAddOns(){
    }

    public JMAddOns(Resizing rs, java.awt.event.MouseEvent e){
        Resizing component = rs;
        Point p = e.getPoint();
        Rectangle re = component.rect;

//        Ellipse2D.Float el = new Ellipse2D.Float(20, 20, 50, 50);
        int dx = p.x - re.x;
        int dy = p.y - re.y;
        x = re.x;
        y = re.y;
        //Resizing comonent2 = Resizing.
        //System.err.println("y = " + y);

//        if(component.rect.contains(e.getPoint())){
//            if(dragging == false){
//              if(rs.contains(p)){
//                re.setRect(re.x+dx, re.y+dy, re.width, re.height);
//                component.repaint();
//              }
//            }
//        }

        if(rs.contains(p)){
            re.setRect(re.x+dx, re.y+dy, re.width, re.height);
            component.repaint();
        }

//        System.out.println("MouseEvent x = "+e.getX());
//        System.out.println("MouseEvent y = "+e.getY());
//        System.out.println("Rectangle x = "+re.x);
//        System.out.println("Rectangle y = "+re.y);
//        System.out.println("Rerizer x = "+rs.getX());
//        System.out.println("Resizer y = "+rs.getY());
//        System.out.println("\n");

    }
    public JMAddOns(JFrame f){
        initComponents(f);
    }

    private void initComponents(JFrame f){
            f.setTitle("Class Project");
            JMenuBar jmb = new JMenuBar();
            JMenu jmFile = new JMenu("File");
            JMenu jmInsert = new JMenu("Insert");
            JMenuItem jmiNew = new JMenuItem("New");
            JMenuItem jmiQuit = new JMenuItem("Quit");
            JMenuItem jmiSquare = new JMenuItem("Square");
            JMenuItem jmiCircle = new JMenuItem("Circle");
            JMenuItem jmiTriangle = new JMenuItem("Triangle");
//            JMenuItem jmiInsert = new JMenuItem("Insert");
            JButton jbttnAdd = new JButton("Play");
            JButton jbttnDel = new JButton("Delete");
            JButton jbttnQuit = new JButton("Quit");
            jmFile.add(jmiNew);
            jmFile.add(new JSeparator());
            jmFile.add(jmiQuit);
//            jmInsert.add(jmiInsert);
            jmInsert.add(jmiSquare);
            jmInsert.add(jmiCircle);
            jmInsert.add(jmiTriangle);
            jmb.add(jmFile);
            jmb.add(jmInsert);
            BorderLayout bl = new BorderLayout();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(jmb, bl.NORTH);
            JPanel jp = new JPanel();
            f.add(jp, bl.SOUTH);
            jp.add(jbttnAdd, bl.SOUTH);
            jp.add(jbttnDel, bl.SOUTH);
            jp.add(jbttnQuit, bl.SOUTH);

//            jp.add(new JButton("Delete"), bl.SOUTH);
//            jp.add(new JButton("Move"), bl.SOUTH);
//            jp.add(new JButton("Exit"), bl.SOUTH);
            f.setSize(400,400);
            f.setLocation(100,100);
            f.setVisible(true);

        jbttnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Play(evt);
             }
        });

        jbttnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nothing(evt);
             }
        });

        jbttnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit(evt);
            }
        });
        jmiQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit(evt);
            }
        });
        jmiTriangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nothing(evt);
            }
        });
        jmiCircle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nothing(evt);
            }
        });
        jmiSquare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nothing(evt);
            }
        });
    }

    private void Play(java.awt.event.ActionEvent evt){
        //Resizer.playNote();
    }

    private void Nothing(java.awt.event.ActionEvent evt){
          JOptionPane.showMessageDialog(null, "This has not been set up yet.", "Nothing To Do", JOptionPane.INFORMATION_MESSAGE);
    }
    private void Exit(java.awt.event.ActionEvent evt){
        System.exit(0);
    }


    static public void playNote2()
    {
       try
        {
             //Rectangle r = component.rect;
               // sequencer.setSequence(sequence);
                //MouseEvent e = null;
                //Point p = e.getPoint();
                //System.err.println("p.x = " + p.x);
                //System.err.println("p x = " + x);
                Synthesizer synth = MidiSystem.getSynthesizer();
                synth.open();
                MidiChannel[] channels = synth.getChannels();

                channels[1].setPitchBend(2000);
                channels[1].noteOn(64, 100);
                System.err.println("Pitch bend 1: " + channels[1].getPitchBend() );

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
}

//class Nothing{
//
//    public Nothing(){}
//
//    public Nothing(java.awt.event.ActionEvent evt){
//         JOptionPane.showMessageDialog(null, "This has not been set up yet.", "Nothing To Do", JOptionPane.INFORMATION_MESSAGE);
//    }
//
//}

class Ellipse{

    JMAddOns component;

    public Ellipse(){

    }

    public Ellipse(JMAddOns jm){
        component = jm;
    }

}






//class Polygon{
//    JMAddOns component;
//
//    public Polygon(){}
//
//    public Polygon(JMAddOns jm){
//        component = jm;
//    }
//}
