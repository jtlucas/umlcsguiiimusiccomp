/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MusicAppPack;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

/**
 *
 * @author James
 */
public class JMAddOns extends JPanel {

    public static void main(String[] args){
//        Ellipse e = new Ellipse(jm);
//        Ellipse ell = new Ellipse();
//        ell.component.getBounds();
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

//    public JMAddOns(Resizing rs, java.awt.event.MouseEvent e){
//        Resizing component = rs;
//        Point p = e.getPoint();
//        Rectangle re = component.rect;
//        Ellipse2D.Float el = new Ellipse2D.Float(20, 20, 50, 50);
//        int dx = p.x - re.x;
//        int dy = p.y - re.y;

//        if(component.rect.contains(e.getPoint())){
//            if(dragging == false){
//              if(rs.contains(p)){
//                re.setRect(re.x+dx, re.y+dy, re.width, re.height);
//                component.repaint();
//              }
//            }
//        }

//        if(rs.contains(p)){
//            re.setRect(re.x+dx, re.y+dy, re.width, re.height);
//            component.repaint();
//        }

//        System.out.println("MouseEvent x = "+e.getX());
//        System.out.println("MouseEvent y = "+e.getY());
//        System.out.println("Rectangle x = "+re.x);
//        System.out.println("Rectangle y = "+re.y);
//        System.out.println("Rerizer x = "+rs.getX());
//        System.out.println("Resizer y = "+rs.getY());
//        System.out.println("\n");

//    }
    public JMAddOns(JFrame f){
//        f.getContentPane().remove(new Resizing());
//        f.getContentPane().add(new Resizing());
//        f.getContentPane().add(new TriangleSizer());
        initComponents(f);
        this.invalidate();
    }

    boolean moving = false;

    public void inRect(Resizing c, java.awt.event.MouseEvent me){
        Rectangle re = c.rect;
        if(re.contains(me.getPoint())){
            moving = true;
        }
        else{
            moving = false;
        }
    }

    public void inTri(TriangleSizer ts, java.awt.event.MouseEvent me){
        Polygon tri = ts.triangle;
        if(tri.contains(me.getPoint())){
            moving = true;
        }
        else{
            moving = false;
        }
        System.out.println(moving);
    
    }
        public void inCirc(EllipseSizer es, java.awt.event.MouseEvent me){
        Ellipse2D ell2d = es.el;
        if(ell2d.contains(me.getPoint())){
            moving = true;
        }
        else{
            moving = false;
        }
    }

       public void moveCirc(EllipseSizer es, java.awt.event.MouseEvent me){
        if(moving == true){
            EllipseSizer component = es;
            Point p = me.getPoint();
            Ellipse2D ell2d = component.el;
            Rectangle re = ell2d.getBounds();
            int dx = p.x - re.x;
            int dy = p.y - re.y;
                re.setRect(re.x+dx, re.y+dy, re.width, re.height);
                ell2d.setFrame(re);
                component.repaint();
        }
    }

    public void moveRect(Resizing rs, java.awt.event.MouseEvent me){
        if(moving == true){
            Resizing component = rs;
            Point p = me.getPoint();
            Rectangle re = component.rect;
            int dx = p.x - re.x;
            int dy = p.y - re.y;
                re.setRect(re.x+dx, re.y+dy, re.width, re.height);
                component.repaint();
        }
    }

    public void moveTri(TriangleSizer ts, java.awt.event.MouseEvent me){
        if(moving == true){
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

            JMenuItem jmiNew = new JMenuItem("New");
            JMenuItem jmiQuit = new JMenuItem("Quit");
            JMenuItem jmiSquare = new JMenuItem("Square");
            JMenuItem jmiCircle = new JMenuItem("Circle");
            JMenuItem jmiTriangle = new JMenuItem("Triangle");

            JButton jbttnAdd = new JButton("Add");
            JButton jbttnDel = new JButton("Delete");
            JButton jbttnQuit = new JButton("Quit");
            JButton jbtnSquareTool = new JButton();
            JButton jbtnEllipseTool = new JButton();
            JButton jbtnTriangleTool = new JButton();

            BorderLayout bl = new BorderLayout();

            jmFile.add(jmiNew);
            jmFile.add(new JSeparator());
            jmFile.add(jmiQuit);
            jmInsert.add(jmiSquare);
            jmInsert.add(jmiCircle);
            jmInsert.add(jmiTriangle);

            jmb.add(jmFile);
            jmb.add(jmInsert);

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

//            if(jtb.getLocale().equals(bl.EAST)){
//                jtb.setOrientation(javax.swing.SwingConstants.HORIZONTAL);
//            }
//            else{
//                jtb.setOrientation(javax.swing.SwingConstants.VERTICAL);
//            }

            f.setTitle("Class Project");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            f.add(jmb, bl.NORTH);
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

    private void Nothing(java.awt.event.ActionEvent evt){
          JOptionPane.showMessageDialog(null, "This has not been set up yet.", "Nothing To Do", JOptionPane.INFORMATION_MESSAGE);
    }
    private void Exit(java.awt.event.ActionEvent evt){
        System.exit(0);
    }

    public static int heightAndWidthCheck(int hw){
        if(hw>10){
            return hw;
        }
        else return 10 ;
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

//class Ellipse{
//
//    JMAddOns component;
//
//    public Ellipse(){
//
//    }
//
//    public Ellipse(JMAddOns jm){
//        component = jm;
//    }
//
//}

//class Polygon{
//    JMAddOns component;
//
//    public Polygon(){}
//
//    public Polygon(JMAddOns jm){
//        component = jm;
//    }
//}
