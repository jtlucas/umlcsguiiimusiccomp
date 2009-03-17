/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Scroll.java
 *
 * Created on Feb 23, 2009, 9:34:53 PM
 */

package edu.uml.cs.GUIProgramming.jebert;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.BoundedRangeModel;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *  This program demonstrates the functionality of the scroll pane using mouse events
 *  @author  Jim Ebert, UMass Lowell Computer Science, <a href="mailto:jim.ebert@comcast.net">jim.ebert@comcast.net</a>
 *  @version 1.1, 2009-3-17
 *  Last updated: 2008-3-17
 */
public class Scroll extends javax.swing.JFrame {

    /** Size of the area taken up by the new labels */
    private Dimension area = new Dimension(0,0);

    /** Keeps track of the number of labels */
    private int numberOfLabels = 0;

    /** Creates new form Scroll */
    public Scroll() {

                // set the LookAndFeel to match the IDE
        // reference: Robinson & Vorobiev p. 728
        UIManager.LookAndFeelInfo[] info =
            UIManager.getInstalledLookAndFeels() ;

        int lafno = 3 ;   // desired LookAndFeel for Windows XP
        try {
          UIManager.setLookAndFeel( info[lafno].getClassName() ) ;
        } catch (Exception e) {
          System.out.println( "Couldn't load " + info[lafno].getClassName() +
              " look and feel " + e ) ;
          System.exit( 1 ) ;  // abort run
        }
        
        initComponents();

        // sets the preferred size of the jpanel to (0, 0) so that the scroll
        // bars are not visible since they are not needed yet
        jpnlHold.setPreferredSize(new Dimension(0, 0));

        // set it so that the user cannot try and scroll w/o scroll bars
        jbtnScroll.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlScrollPaneHolder = new javax.swing.JPanel();
        jsclShift = new javax.swing.JScrollPane();
        jpnlHold = new javax.swing.JPanel();
        jbtnScroll = new javax.swing.JButton();
        jtxtLabelToFind = new javax.swing.JTextField();
        jlblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scroll Practice");

        jpnlHold.setToolTipText("Left-click to add a label, right-click to clear all the added labels.");
        jpnlHold.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jpnlHoldMouseReleased(evt);
            }
        });
        jpnlHold.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jpnlHoldComponentResized(evt);
            }
        });

        jbtnScroll.setText("Scroll to label: ");
        jbtnScroll.setToolTipText("Press this to go to the position of the number entered so that it's label is visible.");
        jbtnScroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnScrollActionPerformed(evt);
            }
        });

        jtxtLabelToFind.setToolTipText("Put the number of the label to look for here.");

        javax.swing.GroupLayout jpnlHoldLayout = new javax.swing.GroupLayout(jpnlHold);
        jpnlHold.setLayout(jpnlHoldLayout);
        jpnlHoldLayout.setHorizontalGroup(
            jpnlHoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlHoldLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlHoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jlblError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnlHoldLayout.createSequentialGroup()
                        .addComponent(jbtnScroll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtLabelToFind, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(236, Short.MAX_VALUE))
        );
        jpnlHoldLayout.setVerticalGroup(
            jpnlHoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlHoldLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlHoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnScroll)
                    .addComponent(jtxtLabelToFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(244, Short.MAX_VALUE))
        );

        jsclShift.setViewportView(jpnlHold);

        javax.swing.GroupLayout jpnlScrollPaneHolderLayout = new javax.swing.GroupLayout(jpnlScrollPaneHolder);
        jpnlScrollPaneHolder.setLayout(jpnlScrollPaneHolderLayout);
        jpnlScrollPaneHolderLayout.setHorizontalGroup(
            jpnlScrollPaneHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsclShift, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jpnlScrollPaneHolderLayout.setVerticalGroup(
            jpnlScrollPaneHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsclShift, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlScrollPaneHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlScrollPaneHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Occurs when the mouse is released
     * @param evt a java mouse event
     */
    private void jpnlHoldMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlHoldMouseReleased
        jlblError.setText("");

        /**
         * The update of the area was influenced by:
         * http://java.sun.com/docs/books/tutorial/uiswing/components
         * /scrollpane.html
         */

        jsclShift.setVerticalScrollBarPolicy
                (ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsclShift.setHorizontalScrollBarPolicy
                (ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        final int labelWidth = 30;
        final int labelHeight = 30;
        /** the extra space added to the height and width if the 
         rectangle to make it look better*/
        final int extra = 1;

        // holds the x position of the mouse event
        int x ;
        // holds the y position of the mouse event
        int y ;
        // holds the dimensions and position of the new label
        Rectangle rect = new Rectangle();

        boolean changed = false;
        if (SwingUtilities.isRightMouseButton(evt)) {            
            //clear all the labels the user created
            removeAdded();
            area.width=0;
            area.height=0;
            changed = true;
            numberOfLabels = 0;
        } 
        else
        {
            //add another label
            ++numberOfLabels;

            x = evt.getX();
            y = evt.getY();
            if (x < 0) x = 0;
            if (y < 0) y = 0;
            rect = new Rectangle(x, y, labelWidth, labelHeight);
            
            jpnlHold.scrollRectToVisible(rect);

            // check to see if the area of the new labels is
            // greater than the original area
            int newWidth = (x + labelWidth + extra);
            if (newWidth > area.width) {
                area.width = newWidth;
                changed = true;
            }

            int newHeight = (y + labelHeight + extra);
            
            if (newHeight > area.height)
            {
                area.height = newHeight;
                changed = true;
            }

            JLabel j = new JLabel();
            j.setText( String.valueOf(numberOfLabels));
            j.setBorder(BorderFactory.createEtchedBorder());
            jpnlHold.add(j);
            j.setBounds(rect); // set the size and placement of the new label
        }
        if (changed) {
            //Update preferred size because
            //the area taken up by the label has
            //changed.
            jpnlHold.setPreferredSize(area);

            //Let the scroll pane know to update itself
            //and its scrollbars.
            jpnlHold.revalidate();            
        }
        jpnlHold.repaint();
    }//GEN-LAST:event_jpnlHoldMouseReleased

    /**
     * Done when the scroll to label button is entered
     * @param evt a java action event
     */
    private void jbtnScrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnScrollActionPerformed
        int labelNumber = -1;

        try
         {
            labelNumber = Integer.parseInt(jtxtLabelToFind.getText());
         }
         catch(Exception e)
         {
             jlblError.setText("You must enter a number to look for.");
             return;
         }
         jlblError.setText("");

         if(labelNumber > numberOfLabels || labelNumber <= 0)
         {
             jlblError.setText("Invalid label number entered.");
         }
         else if(getLoc() == false)
         {
             jlblError.setText("Cannot find the indicated label.");                       
         }
    }//GEN-LAST:event_jbtnScrollActionPerformed

    /**
     * Checks to see if the panel has changed size, if it has it will enable or
     * disable the button to scroll
     * @param evt a java component event
     */
    private void jpnlHoldComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jpnlHoldComponentResized
        if(jsclShift.getVerticalScrollBar().isShowing() ||
                    jsclShift.getHorizontalScrollBar().isShowing())
        {
            jbtnScroll.setEnabled(true);
        }
        else
        {
            jbtnScroll.setEnabled(false);
        }
    }//GEN-LAST:event_jpnlHoldComponentResized
    
    /**
     * Gets the location of the label the user is looking for
     * @return true if it has a location, false otherwise
     */
    private boolean getLoc()
    {
        Component[] c = jpnlHold.getComponents();

        for(int i = 0; i != c.length; ++i)
        {
            if(c[i].getClass() == JLabel.class &&
                    ((JLabel) c[i]).getText().equals(jtxtLabelToFind.getText()))
            {
                JLabel j = (JLabel) c[i];
                jpnlHold.scrollRectToVisible(j.getBounds());
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the added Labels
     */
    private void removeAdded()
    {
        Component[] c = jpnlHold.getComponents();

        for(int i = 0; i != c.length; ++i)
        {
            if(c[i].getClass() == JLabel.class && c[i] != jlblError)
            {
                jpnlHold.remove(c[i]);
            }
        }
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Scroll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /** goes to the specific jlabel that is indicated in the test field */
    private javax.swing.JButton jbtnScroll;
    /** Displays error messages to the user */
    private javax.swing.JLabel jlblError;
    /** holds the gui components */
    private javax.swing.JPanel jpnlHold;
    /** holds the scroll pane */
    private javax.swing.JPanel jpnlScrollPaneHolder;
    /** Allows the panel to be scrollable */
    private javax.swing.JScrollPane jsclShift;
    /** Holds the number of the label to scroll to */
    private javax.swing.JTextField jtxtLabelToFind;
    // End of variables declaration//GEN-END:variables
}