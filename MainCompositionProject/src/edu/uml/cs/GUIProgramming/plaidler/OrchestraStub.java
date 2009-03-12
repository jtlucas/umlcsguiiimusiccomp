/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InstrumentSelectDemo.java
 *
 * Created on Feb 19, 2009, 2:43:03 AM
 */

//TODO: Toolbar needs icons
package edu.uml.cs.GUIProgramming.plaidler;


/**
 *
 * @author paul
 */
public class OrchestraStub extends javax.swing.JFrame {
    /** Creates new form InstrumentSelectDemo */
    Orchestra myOrchestra;

    public OrchestraStub() {
        initComponents();
        myOrchestra = new Orchestra();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InstrumentButtons = new javax.swing.ButtonGroup();
        jtb_InstrumentToolbar = new javax.swing.JToolBar();
        jb_Piano = new javax.swing.JToggleButton();
        jb_Clavinet = new javax.swing.JToggleButton();
        jb_NylonGuitar = new javax.swing.JToggleButton();
        jb_OverdrivenGuitar = new javax.swing.JToggleButton();
        jb_AcousticBass = new javax.swing.JToggleButton();
        jb_Violin = new javax.swing.JToggleButton();
        jb_StringEnsemble = new javax.swing.JToggleButton();
        jb_Choir = new javax.swing.JToggleButton();
        jb_BrassEnsemble = new javax.swing.JToggleButton();
        jb_Drumkit = new javax.swing.JToggleButton();
        jmb_MainMenuBar = new javax.swing.JMenuBar();
        jm_OldInstrumentMenu = new javax.swing.JMenu();
        jmi_Piano = new javax.swing.JMenuItem();
        jmi_Clavinet = new javax.swing.JMenuItem();
        jmi_NylonGuitar = new javax.swing.JMenuItem();
        jmi_OverdrivenGuitar = new javax.swing.JMenuItem();
        jmi_AcousticBass = new javax.swing.JMenuItem();
        jmi_Violin = new javax.swing.JMenuItem();
        jmi_StringEnsemble = new javax.swing.JMenuItem();
        jmi_Choir = new javax.swing.JMenuItem();
        jmi_BrassEnsemble = new javax.swing.JMenuItem();
        jmi_Drumkit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Instrument Select");

        jtb_InstrumentToolbar.setFloatable(false);
        jtb_InstrumentToolbar.setRollover(true);

        InstrumentButtons.add(jb_Piano);
        jb_Piano.setText("Piano");
        jb_Piano.setFocusable(false);
        jb_Piano.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_Piano.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_Piano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_PianoActionPerformed(evt);
            }
        });
        jtb_InstrumentToolbar.add(jb_Piano);

        InstrumentButtons.add(jb_Clavinet);
        jb_Clavinet.setText("Clavinet");
        jb_Clavinet.setFocusable(false);
        jb_Clavinet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_Clavinet.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_Clavinet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ClavinetActionPerformed(evt);
            }
        });
        jtb_InstrumentToolbar.add(jb_Clavinet);

        InstrumentButtons.add(jb_NylonGuitar);
        jb_NylonGuitar.setText("Nylon Guitar");
        jb_NylonGuitar.setFocusable(false);
        jb_NylonGuitar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_NylonGuitar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_NylonGuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_NylonGuitarActionPerformed(evt);
            }
        });
        jtb_InstrumentToolbar.add(jb_NylonGuitar);

        InstrumentButtons.add(jb_OverdrivenGuitar);
        jb_OverdrivenGuitar.setText("Overdriven Guitar");
        jb_OverdrivenGuitar.setFocusable(false);
        jb_OverdrivenGuitar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_OverdrivenGuitar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_OverdrivenGuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_OverdrivenGuitarActionPerformed(evt);
            }
        });
        jtb_InstrumentToolbar.add(jb_OverdrivenGuitar);

        InstrumentButtons.add(jb_AcousticBass);
        jb_AcousticBass.setText("Acoustic Bass");
        jb_AcousticBass.setFocusable(false);
        jb_AcousticBass.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_AcousticBass.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_AcousticBass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_AcousticBassActionPerformed(evt);
            }
        });
        jtb_InstrumentToolbar.add(jb_AcousticBass);

        InstrumentButtons.add(jb_Violin);
        jb_Violin.setText("Violin");
        jb_Violin.setFocusable(false);
        jb_Violin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_Violin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_Violin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ViolinActionPerformed(evt);
            }
        });
        jtb_InstrumentToolbar.add(jb_Violin);

        InstrumentButtons.add(jb_StringEnsemble);
        jb_StringEnsemble.setText("String Ensemble");
        jb_StringEnsemble.setFocusable(false);
        jb_StringEnsemble.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_StringEnsemble.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_StringEnsemble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_StringEnsembleActionPerformed(evt);
            }
        });
        jtb_InstrumentToolbar.add(jb_StringEnsemble);

        InstrumentButtons.add(jb_Choir);
        jb_Choir.setText("Choir");
        jb_Choir.setFocusable(false);
        jb_Choir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_Choir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_Choir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ChoirActionPerformed(evt);
            }
        });
        jtb_InstrumentToolbar.add(jb_Choir);

        InstrumentButtons.add(jb_BrassEnsemble);
        jb_BrassEnsemble.setText("Brass Ensemble");
        jb_BrassEnsemble.setFocusable(false);
        jb_BrassEnsemble.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_BrassEnsemble.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_BrassEnsemble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_BrassEnsembleActionPerformed(evt);
            }
        });
        jtb_InstrumentToolbar.add(jb_BrassEnsemble);

        InstrumentButtons.add(jb_Drumkit);
        jb_Drumkit.setText("Drumkit");
        jb_Drumkit.setFocusable(false);
        jb_Drumkit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_Drumkit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_Drumkit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_DrumkitActionPerformed(evt);
            }
        });
        jtb_InstrumentToolbar.add(jb_Drumkit);

        jm_OldInstrumentMenu.setText("Instrument Menu");

        jmi_Piano.setText("Piano");
        jmi_Piano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_PianoActionPerformed(evt);
            }
        });
        jm_OldInstrumentMenu.add(jmi_Piano);

        jmi_Clavinet.setText("Clavinet");
        jmi_Clavinet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_ClavinetActionPerformed(evt);
            }
        });
        jm_OldInstrumentMenu.add(jmi_Clavinet);

        jmi_NylonGuitar.setText("Nylon Guitar");
        jmi_NylonGuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_NylonGuitarActionPerformed(evt);
            }
        });
        jm_OldInstrumentMenu.add(jmi_NylonGuitar);

        jmi_OverdrivenGuitar.setText("Overdriven Guitar");
        jmi_OverdrivenGuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_OverdrivenGuitarActionPerformed(evt);
            }
        });
        jm_OldInstrumentMenu.add(jmi_OverdrivenGuitar);

        jmi_AcousticBass.setText("Acoustic Bass");
        jmi_AcousticBass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_AcousticBassActionPerformed(evt);
            }
        });
        jm_OldInstrumentMenu.add(jmi_AcousticBass);

        jmi_Violin.setText("Violin");
        jmi_Violin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_ViolinActionPerformed(evt);
            }
        });
        jm_OldInstrumentMenu.add(jmi_Violin);

        jmi_StringEnsemble.setText("String Ensemble");
        jmi_StringEnsemble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_StringEnsembleActionPerformed(evt);
            }
        });
        jm_OldInstrumentMenu.add(jmi_StringEnsemble);

        jmi_Choir.setText("Choir");
        jmi_Choir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_ChoirActionPerformed(evt);
            }
        });
        jm_OldInstrumentMenu.add(jmi_Choir);

        jmi_BrassEnsemble.setText("Brass Ensamble");
        jmi_BrassEnsemble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_BrassEnsembleActionPerformed(evt);
            }
        });
        jm_OldInstrumentMenu.add(jmi_BrassEnsemble);

        jmi_Drumkit.setText("Drumkit");
        jmi_Drumkit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_DrumkitActionPerformed(evt);
            }
        });
        jm_OldInstrumentMenu.add(jmi_Drumkit);

        jmb_MainMenuBar.add(jm_OldInstrumentMenu);

        setJMenuBar(jmb_MainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtb_InstrumentToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtb_InstrumentToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmi_PianoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_PianoActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(0);
        myOrchestra.playNote(0, 60, 127, 500);
}//GEN-LAST:event_jmi_PianoActionPerformed

    private void jmi_ClavinetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_ClavinetActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(1);
        myOrchestra.playNote(1, 60, 127, 500);
    }//GEN-LAST:event_jmi_ClavinetActionPerformed

    private void jmi_NylonGuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_NylonGuitarActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(2);
        myOrchestra.playNote(2, 60, 127, 500);
    }//GEN-LAST:event_jmi_NylonGuitarActionPerformed

    private void jmi_OverdrivenGuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_OverdrivenGuitarActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(3);
        myOrchestra.playNote(3, 60, 127, 500);
    }//GEN-LAST:event_jmi_OverdrivenGuitarActionPerformed

    private void jmi_AcousticBassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_AcousticBassActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(4);
        myOrchestra.playNote(4, 60, 127, 500);
    }//GEN-LAST:event_jmi_AcousticBassActionPerformed

    private void jmi_ViolinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_ViolinActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(5);
        myOrchestra.playNote(5, 60, 127, 500);
    }//GEN-LAST:event_jmi_ViolinActionPerformed

    private void jmi_StringEnsembleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_StringEnsembleActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(6);
        myOrchestra.playNote(6, 60, 127, 500);
    }//GEN-LAST:event_jmi_StringEnsembleActionPerformed

    private void jmi_ChoirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_ChoirActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(7);
        myOrchestra.playNote(7, 60, 127, 500);
    }//GEN-LAST:event_jmi_ChoirActionPerformed

    private void jmi_BrassEnsembleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_BrassEnsembleActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(8);
        myOrchestra.playNote(8, 60, 127, 500);
    }//GEN-LAST:event_jmi_BrassEnsembleActionPerformed

    private void jmi_DrumkitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_DrumkitActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(9);
        myOrchestra.playNote(9, 60, 127, 500);
}//GEN-LAST:event_jmi_DrumkitActionPerformed

    private void jb_PianoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_PianoActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(1);
        myOrchestra.playNote(0, 60, 127, 500);
    }//GEN-LAST:event_jb_PianoActionPerformed

    private void jb_ClavinetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ClavinetActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(1);
        myOrchestra.playNote(1, 60, 127, 500);
    }//GEN-LAST:event_jb_ClavinetActionPerformed

    private void jb_NylonGuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_NylonGuitarActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(2);
        myOrchestra.playNote(2, 60, 127, 500);
}//GEN-LAST:event_jb_NylonGuitarActionPerformed

    private void jb_OverdrivenGuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_OverdrivenGuitarActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(3);
        myOrchestra.playNote(3, 60, 127, 500);
}//GEN-LAST:event_jb_OverdrivenGuitarActionPerformed

    private void jb_AcousticBassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_AcousticBassActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(4);
        myOrchestra.playNote(4, 60, 127, 500);
}//GEN-LAST:event_jb_AcousticBassActionPerformed

    private void jb_ViolinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ViolinActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(5);
        myOrchestra.playNote(5, 60, 127, 500);
}//GEN-LAST:event_jb_ViolinActionPerformed

    private void jb_StringEnsembleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_StringEnsembleActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(6);
        myOrchestra.playNote(6, 60, 127, 500);
}//GEN-LAST:event_jb_StringEnsembleActionPerformed

    private void jb_ChoirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ChoirActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(7);
        myOrchestra.playNote(7, 60, 127, 500);
}//GEN-LAST:event_jb_ChoirActionPerformed

    private void jb_BrassEnsembleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_BrassEnsembleActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(8);
        myOrchestra.playNote(8, 60, 127, 500);
}//GEN-LAST:event_jb_BrassEnsembleActionPerformed

    private void jb_DrumkitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_DrumkitActionPerformed
        // TODO add your handling code here:
        myOrchestra.selectChannel(9);
        myOrchestra.playNote(9, 60, 127, 500);
}//GEN-LAST:event_jb_DrumkitActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrchestraStub().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup InstrumentButtons;
    private javax.swing.JToggleButton jb_AcousticBass;
    private javax.swing.JToggleButton jb_BrassEnsemble;
    private javax.swing.JToggleButton jb_Choir;
    private javax.swing.JToggleButton jb_Clavinet;
    private javax.swing.JToggleButton jb_Drumkit;
    private javax.swing.JToggleButton jb_NylonGuitar;
    private javax.swing.JToggleButton jb_OverdrivenGuitar;
    private javax.swing.JToggleButton jb_Piano;
    private javax.swing.JToggleButton jb_StringEnsemble;
    private javax.swing.JToggleButton jb_Violin;
    private javax.swing.JMenu jm_OldInstrumentMenu;
    private javax.swing.JMenuBar jmb_MainMenuBar;
    private javax.swing.JMenuItem jmi_AcousticBass;
    private javax.swing.JMenuItem jmi_BrassEnsemble;
    private javax.swing.JMenuItem jmi_Choir;
    private javax.swing.JMenuItem jmi_Clavinet;
    private javax.swing.JMenuItem jmi_Drumkit;
    private javax.swing.JMenuItem jmi_NylonGuitar;
    private javax.swing.JMenuItem jmi_OverdrivenGuitar;
    private javax.swing.JMenuItem jmi_Piano;
    private javax.swing.JMenuItem jmi_StringEnsemble;
    private javax.swing.JMenuItem jmi_Violin;
    private javax.swing.JToolBar jtb_InstrumentToolbar;
    // End of variables declaration//GEN-END:variables

}
