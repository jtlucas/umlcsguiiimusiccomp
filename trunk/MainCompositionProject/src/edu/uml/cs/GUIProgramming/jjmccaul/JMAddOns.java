/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uml.cs.GUIProgramming.jjmccaul;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

/**
 *
 * @author James
 */
public class JMAddOns extends JPanel {
    boolean moving = false;
    int offx = 0, offy = 0;

    public static void main(String[] args){
        JFrame f = new JFrame();
        JMAddOns jm = new JMAddOns(f);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(jm);
        f.setSize(400,400);
        f.setLocation(100,100);
        f.setVisible(true);
    }

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
//        g2.draw(el);
        g2.setPaint(Color.RED);
//        g2.draw(p);
    }

    public JMAddOns(){
    }

    public JMAddOns(JFrame f){
//        f.getContentPane().remove(new SquareSizer());
//        f.getContentPane().add(new SquareSizer());
//        f.getContentPane().add(new TriangleSizer());
        initComponents(f);
        this.invalidate();
    }

    public void inRect(SquareSizer c, java.awt.event.MouseEvent me){
        Rectangle re = c.rect;
        offx = re.x - me.getX();
        offy = re.y - me.getY();
        if(re.contains(me.getPoint())){
            moving = true;
        }
        else{
            moving = false;
        }
    }

    public void inTri(TriangleSizer ts, java.awt.event.MouseEvent me){
        Polygon tri = ts.triangle;
        offx = tri.xpoints[0] - me.getX();
        offy = tri.ypoints[0] - me.getY();
        if(tri.contains(me.getPoint())){
            moving = true;
        }
        else{
            moving = false;
        }    
    }

    public void inCirc(EllipseSizer es, java.awt.event.MouseEvent me){
        Ellipse2D ell2d = es.el;
        Rectangle re = ell2d.getBounds();
        offx = re.x - me.getX();
        offy = re.y - me.getY();
        if(ell2d.contains(me.getPoint())){
            moving = true;
        }
        else{
            moving = false;
        }
    }

    public void moveCirc(EllipseSizer es, java.awt.event.MouseEvent me){
        if(moving == true){
            Rectangle rect = es.el.getBounds();
            rect.setLocation(offx + me.getX(), offy+ me.getY());
            es.el.setFrame(rect);
            es.repaint();

//            EllipseSizer component = es;
//            Point p = me.getPoint();
//            Ellipse2D ell2d = component.el;
//            Rectangle re = ell2d.getBounds();
//            int dx = p.x - re.x;
//            int dy = p.y - re.y;
//                re.setRect(re.x+dx, re.y+dy, re.width, re.height);
//                ell2d.setFrame(re);
//                component.repaint();
        }
    }

    public void moveRect(SquareSizer rs, java.awt.event.MouseEvent me){
        if(moving == true){
//            SquareSizer component = rs;
//            Rectangle re = component.rect;
//            re.setLocation(offx + me.getX(), offy + me.getY());
//            component.repaint();
            rs.rect.setLocation(offx + me.getX(), offy+ me.getY());
            rs.repaint();
        }
    }

    public void moveTri(TriangleSizer ts, java.awt.event.MouseEvent me){
        if(moving == true){
//            Rectangle rect = ts.triangle.getBounds();
//            rect.setLocation(offx + me.getX(), offy+ me.getY());
//            ts.triangle.translate( (int)rect.x - me.getX() + offx , (int) rect.y - me.getY() + offy);
//            ts.repaint();
//            ts.triangle.getBounds().setLocation(offx + me.getX(), offy + me.getY());
//            ts.repaint();

//            ts.triangle.translate(offx + me.getX(), offy + me.getY());
//            ts.repaint();
//
//            for(int i = 0; i<3; i++){
//                ts.triangle.xpoints[i] +=  me.getX();
//                ts.triangle.ypoints[i] +=  me.getY();
//                ts.repaint();
//            }

            TriangleSizer component = ts;
            Point p = me.getPoint();
            Polygon triangle = component.triangle;
            int dx = p.x - triangle.xpoints[0];
            int dy = p.y - triangle.ypoints[0];
//                re.setRect(re.x+dx, re.y+dy, re.width, re.height);
            triangle.translate(dx, dy);
            component.repaint();
        }
    }

    private void initComponents(JFrame f){
            JPanel jpButtons = new JPanel();

            JToolBar jtb = new JToolBar(javax.swing.SwingConstants.VERTICAL);

            JMenuBar jmb = new JMenuBar();

            JMenu jmFile = new JMenu("File");
            JMenu jmInsert = new JMenu("Insert");
            JMenu jmHelp = new JMenu("Help");

            JMenuItem jmiNew = new JMenuItem("New");
            JMenuItem jmiLoad = new JMenuItem("Load");
            JMenuItem jmiSave = new JMenuItem("Save");
            JMenuItem jmiQuit = new JMenuItem("Quit");
            JMenuItem jmiSquare = new JMenuItem("Square");
            JMenuItem jmiCircle = new JMenuItem("Circle");
            JMenuItem jmiTriangle = new JMenuItem("Triangle");
            JMenuItem jmiPhoto = new JMenuItem("Picture");
            JMenuItem jmiSound = new JMenuItem("Sound");
            JMenuItem jmiAbout = new JMenuItem("About");

            JButton jbttnAdd = new JButton("Add");
            JButton jbttnDel = new JButton("Delete");
            JButton jbttnQuit = new JButton("Quit");
            JButton jbtnSquareTool = new JButton();
            JButton jbtnEllipseTool = new JButton();
            JButton jbtnTriangleTool = new JButton();

            BorderLayout bl = new BorderLayout();

            jmFile.add(jmiNew);
            jmFile.add(jmiLoad);
            jmFile.add(jmiSave);
            jmFile.add(new JSeparator());
            jmFile.add(jmiQuit);
            jmInsert.add(jmiSquare);
            jmInsert.add(jmiCircle);
            jmInsert.add(jmiTriangle);
            jmInsert.add(new JSeparator());
            jmInsert.add(jmiSound);
            jmInsert.add(jmiPhoto);
            jmHelp.add(jmiAbout);

            jmb.add(jmFile);
            jmb.add(jmInsert);
            jmb.add(jmHelp);

            jpButtons.add(jbttnAdd);
            jpButtons.add(jbttnDel);
            jpButtons.add(jbttnQuit);

            jbtnSquareTool.setText("Square");
            jbtnEllipseTool.setText("Circle");
            jbtnTriangleTool.setText("Triangle");

            jtb.add(jbtnSquareTool);
            jtb.add(jbtnEllipseTool);
            jtb.add(jbtnTriangleTool);
            jtb.setRollover(true);
            jtb.setName("Tools");


            f.setTitle("Class Project");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setJMenuBar(jmb);
            f.add(jtb, bl.EAST);
            f.add(jpButtons, bl.SOUTH);
            f.setSize(400,400);
            f.setLocation(100,100);
            f.setVisible(true);

        jbttnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nothing(evt);
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
        jbtnSquareTool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nothing(evt);
            }
        });
        jbtnEllipseTool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nothing(evt);
            }
        });
        jbtnTriangleTool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nothing(evt);
            }
        });
        jmiNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nothing(evt);
            }
        });
        jmiLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nothing(evt);
            }
        });
        jmiSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nothing(evt);
            }
        });
        jmiQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit(evt);
            }
        });
        jmiSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nothing(evt);
            }
        });
        jmiPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nothing(evt);
            }
        });
        jmiAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                About(evt);
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

    private void Nothing(java.awt.event.ActionEvent evt){
          JOptionPane.showMessageDialog(null, "This has not been set up yet.", "Nothing To Do", JOptionPane.INFORMATION_MESSAGE);
    }
    private void Exit(java.awt.event.ActionEvent evt){
        System.exit(0);
    }
    private void About(java.awt.event.ActionEvent evt){
        JOptionPane.showMessageDialog(null, "This program is for a GUI 2 class, Spring 2009.", "About This Program", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int heightAndWidthCheck(int hw){
        if(hw>10){
            return hw;
        }
        else return 10 ;
    }
}
