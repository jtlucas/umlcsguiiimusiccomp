/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProgressBar.java
 *
 * Created on Mar 2, 2009, 10:27:10 PM
 */

package practice;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author j
 */
public class ProgressBar extends javax.swing.JFrame {

    private int i;
    /** Creates new form ProgressBar */
    public ProgressBar() {
        initComponents();

        jbrProg.setMaximum(100);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbrProg = new javax.swing.JProgressBar();
        jbtnStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtnStart.setText("Start");
        jbtnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jbrProg, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jbtnStart)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jbrProg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jbtnStart)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnStartActionPerformed
        Start s = new Start(jbrProg);
        for(int i = 10; i != 100; i += 10)
        {
            s.setInc(i);
            //Start s = new Start(jbrProg, i);
            s.start();
        }
    }//GEN-LAST:event_jbtnStartActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgressBar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jbrProg;
    private javax.swing.JButton jbtnStart;
    // End of variables declaration//GEN-END:variables

}

class Start extends Thread
{
    private JProgressBar jpb;
    private Runnable update, finish;
    int value, min, max, inc;

    public Start(JProgressBar j)
    {
        jpb = j;
        min = jpb.getMinimum();
        max = jpb.getMaximum();
        //inc = n;

        update = new Runnable()
        {
            public void run()
            {
                jpb.setValue(inc);
//                notify();
            }
        };
    }

    public void setInc(int n)
    {
        inc = n;
    }

    public void run()
    {
        simulate();
        SwingUtilities.invokeLater(update);
        //notify();
    }

    @SuppressWarnings("static-access")
    private void simulate()
    {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
