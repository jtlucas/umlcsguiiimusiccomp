/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Main.java
 *
 * Created on Feb 24, 2009, 2:29:19 PM
 */
package edu.uml.cs.GUIProgramming.MusicComp;

import edu.uml.cs.GUIProgramming.heines.*;
import edu.uml.cs.GUIProgramming.jjmccaul.*;
import edu.uml.cs.GUIProgramming.jtlucas.*;

/**
 * This is the main driver for the entire music composition program.
 * @author Jesse M. Heines, UMass Lowell Computer Science
 * @author <a href="mailto:heines@cs.uml.edu">heines@cs.uml.edu</a>
 * @version 1.0, February 24, 2009
 * Copyright &copy; 2009 by Jesse M. Heines.  All rights reserved.  May be freely
 *     copied or excerpted for educational purposes with credit to the author.
 */
public class Main extends javax.swing.JFrame {

  /** the following is required to keep NetBeans happy */
  static final long serialVersionUID = 0 ;

  /** the Menus object in package jjmccaul by James */
  Menus menus;

  /** the WindowSize object in package jtlucas by Jesse L. */
  JTL_WindowSize WindowSize;

  /** Creates new form Main */
  public Main() {
    GUIUtilities.SetNetBeansCompatibleUIManager();
    initComponents();
    GUIUtilities.setMainWindowLocation( this, null, "GUIMusicCompositionProject" );
    menus = new Menus( this );
    menus.attachMenubar( this );
    WindowSize = new JTL_WindowSize( this );
    WindowSize.setWindowSize( this );
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    btnExit = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("UMass Lowell GUI Programming Music Composition");
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
    });

    btnExit.setText("Exit");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnExitActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(339, Short.MAX_VALUE)
        .addComponent(btnExit)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(266, Short.MAX_VALUE)
        .addComponent(btnExit)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

/**
 * Event handler called when the main window closes.
 * @param evt standard Java WindowEvent
 */
  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    // TODO add your handling code here:
    GUIUtilities.saveMainWindowLocation( this, null,
        "GUIMusicCompositionProject", "GUI Music Composition Project" );
  }//GEN-LAST:event_formWindowClosing

/**
 * Event handler for Exit button.
 * @param evt standard Java ActionEvent
 */
  private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
    // TODO add your handling code here:
    formWindowClosing( new java.awt.event.WindowEvent( Main.getWindows()[0], 0 ));
    System.exit( 0 );
  }//GEN-LAST:event_btnExitActionPerformed

  /**
   * This is the public version of the private NetBeans-generated btnExitActionPerformed
   * that can be called from other classes.
   */
  public void btnExitActionPerformed() {
    btnExitActionPerformed( null ) ;
  }

  /**
   * The standard Java main method.
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        new Main().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  /** Exit button on the main window */
  private javax.swing.JButton btnExit;
  // End of variables declaration//GEN-END:variables
}