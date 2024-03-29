/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JTL_WindowSize.java
 *
 * Created on Mar 2, 2009, 12:59:09 PM
 */

package edu.uml.cs.GUIProgramming.jtlucas;

import edu.uml.cs.GUIProgramming.MusicComp.*;
import javax.swing.*;

/**
 * This class contains the code to generate the application window sizes.
 * @author Jesse T. Lucas, UMass Lowell Computer Science
 * @author <a href="mailto:jtlucas@cs.uml.edu">jtlucas@cs.uml.edu</a>
 * @version 1.0, March 3, 2009
 * Copyright &copy; 2009 by Jesse T. Lucas.  All rights reserved.  May be freely
 *     copied or excerpted for educational purposes with credit to the author.
 */
public class JTL_WindowSize extends javax.swing.JFrame {

    /** the following is required to keep NetBeans happy */
    static final long serialVersionUID = 0 ;

    /** The main application for reference within this class. */
    Main mainApp = null;
    
    /* The Default Window Width Size */
    private int Window_WidthSize = 800;
    /* The Default Window Height Size */
    private int Window_HeightSize = 700;
    /* The Default Panel Width Size */
    private int JPanel_WidthSize = 3000;
    /* The Default Panel Height Size */
    private int JPanel_HeightSize = 508;
    /* The Default JScrollPane Width Size */
    private int JScroll_WidthSize = 780;
    /* The Default JScrollPane Height Size */
    private int JScroll_HeightSize = 508;

    /** Creates new form JTL_WindowSize */
    public JTL_WindowSize() {
        initComponents();
    }

    /**
    * Call this constructor from the Main application to initialize the class level mainApp object.
    * @param mainApp the main application for reference within this class
    */
    public JTL_WindowSize( Main mainApp ) {
      this();   // call the default constructor, which must always be called first
      this.mainApp = mainApp;   // save the reference to the Main application
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jspCanvas = new javax.swing.JScrollPane();
    jplCanvas = new JTL_ResizingTest();
    Resizer resizer = new Resizer((JTL_ResizingTest)jplCanvas);
    jplCanvas.addMouseListener(resizer);
    jplCanvas.addMouseMotionListener(resizer);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setMinimumSize(new java.awt.Dimension(800, 700));

    jspCanvas.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    jspCanvas.setMaximumSize(new java.awt.Dimension(780, 530));
    jspCanvas.setMinimumSize(new java.awt.Dimension(780, 530));
    jspCanvas.setPreferredSize(new java.awt.Dimension(780, 530));

    jplCanvas.setMaximumSize(new java.awt.Dimension(3000, 508));
    jplCanvas.setMinimumSize(new java.awt.Dimension(3000, 508));
    jplCanvas.setPreferredSize(new java.awt.Dimension(3000, 508));

    javax.swing.GroupLayout jplCanvasLayout = new javax.swing.GroupLayout(jplCanvas);
    jplCanvas.setLayout(jplCanvasLayout);
    jplCanvasLayout.setHorizontalGroup(
      jplCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 3000, Short.MAX_VALUE)
    );
    jplCanvasLayout.setVerticalGroup(
      jplCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 511, Short.MAX_VALUE)
    );

    jspCanvas.setViewportView(jplCanvas);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jspCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jspCanvas, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(170, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    /**
     * This method is intended to be called from other classes.
     * This is to get the Window_WidthSize
     * @return int returns the Window_WidthSize
     */
    public int getWindow_WidthSize(){
        return Window_WidthSize;
    }

    /**
     * This method is intended to be called from other classes.
     * This is to set the Window_WidthSize
     * @param value sets the Window_WidthSize
     */
    public void setWindow_WidthSize( int value ){
        Window_WidthSize = value;
    }

    /**
     * This method is intended to be called from other classes.
     * This is to get the Window_HeightSize
     * @return int returns the Window_HeightSize
     */
    public int getWindow_HeightSize(){
        return Window_HeightSize;
    }

    /**
     * This method is intended to be called from other classes.
     * This is to set the Window_HeightSize
     * @param value sets the Window_HeightSize
     */
    public void setWindow_HeightSize( int value ){
        Window_HeightSize = value;
    }

    /**
     * This method is intended to be called from other classes.
     * This is to get the JPanel_WidthSize
     * @return int returns the JPanel_WidthSize
     */
    public int getJPanel_WidthSize(){
        return JPanel_WidthSize;
    }

    /**
     * This method is intended to be called from other classes.
     * This is to set the JPanel_WidthSize
     * @param value sets the JPanel_WidthSize
     */
    public void setJPanel_WidthSize( int value ){
        JPanel_WidthSize = value;
    }

    /**
     * This method is intended to be called from other classes.
     * This is to get the JPanel_HeightSize
     * @return int returns the JPanel_HeightSize
     */
    public int getJPanel_HeightSize(){
        return JPanel_HeightSize;
    }

    /**
     * This method is intended to be called from other classes.
     * This is to set the JPanel_HeightSize
     * @param value sets the JPanel_HeightSize
     */
    public void setJPanel_HeightSize( int value ){
        JPanel_HeightSize = value;
    }

    /**
     * This method is intended to be called from other classes.
     * This is to get the JScroll_WidthSize
     * @return int returns the JScroll_WidthSize
     */
    public int getJScroll_WidthSize(){
        return JScroll_WidthSize;
    }

    /**
     * This method is intended to be called from other classes.
     * This is to set the JScroll_WidthSize
     * @param value sets the JScroll_WidthSize
     */
    public void setJScroll_WidthSize( int value ){
        JScroll_WidthSize = value;
    }

    /**
     * This method is intended to be called from other classes.
     * This is to get the JScroll_HeightSize
     * @return int returns the JScroll_HeightSize
     */
    public int getJScroll_HeightSize(){
        return JScroll_HeightSize;
    }

    /**
     * This method is intended to be called from other classes.
     * This is to set the JScroll_HeightSize
     * @param value sets the JScroll_HeightSize
     */
    public void setJScroll_HeightSize( int value ){
        JScroll_HeightSize = value;
    }
    






     /**
     * This method is intended to be called from other classes.
     * To set the window sizes to those that were chosen by Jesse L.
     * @param jfrm
     */
     public void setWindowSize( JFrame jfrm ) {
       jfrm.setMinimumSize(new java.awt.Dimension(Window_WidthSize, Window_HeightSize));
       jfrm.setPreferredSize(new java.awt.Dimension(Window_WidthSize, Window_HeightSize));
     }

     /**
     * This method is intended to be called from other classes.
     * To set the scroll panel sizes to those that were chosen by Jesse L.
     * @param jspane
     */
     public void setScrollPaneSize( JScrollPane jspane ) {
       //Set all jscroll pane sizes to be Width = 780, Height = 530.
       jspane.setMinimumSize(new java.awt.Dimension(JScroll_WidthSize, JScroll_HeightSize));
       jspane.setMaximumSize(new java.awt.Dimension(JScroll_WidthSize, JScroll_HeightSize));
       jspane.setPreferredSize(new java.awt.Dimension(JScroll_WidthSize, JScroll_HeightSize));
     }


     /**
     * This method is intended to be called from other classes.
     * To set the panel sizes to those that were chosen by Jesse L.
     * @param jpanel
     */
     public void setPanelSize( JPanel jpanel ) {
       //Set all jpanel sizes to be Width = 3000, Height = 508.
       jpanel.setMinimumSize(new java.awt.Dimension(JPanel_WidthSize, JPanel_HeightSize));
       jpanel.setMaximumSize(new java.awt.Dimension(JPanel_WidthSize, JPanel_HeightSize));
       jpanel.setPreferredSize(new java.awt.Dimension(JPanel_WidthSize, JPanel_HeightSize));
     }
     
    /**
     * This method is intended to be called from other classes.
     * This overrides the main function for when there are no arguements that are passed.
     */
     public static void main () {
         // Create empty args that are requred by the default main
         String[] args = new String[2];
         // Call the default main with the empty args
         main(args);
     }
     
     /**
     * @param args the command line arguments
     */
     public static void main(String args[]) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JTL_WindowSize().setVisible(true);
            }
        });
     }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  /** This is the panel that represents the canvas */
  private javax.swing.JPanel jplCanvas;
  /** The scroll pane that contains the canvas */
  private javax.swing.JScrollPane jspCanvas;
  // End of variables declaration//GEN-END:variables

}
