/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uml.cs.GUIProgramming.plaidler;

// The following classes are needed in the catch blocks added in method getJavaSoundSequencer
// added by JMH on January 24, 2009 at 8:40 PM
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

/**
 * The class provides utilities to allow the Sun-supplied Java Sound Demo to work.
 * @author Jesse M. Heines, UMass Lowell Computer Science
 * @author <a href="mailto:heines@cs.uml.edu">heines@cs.uml.edu</a>"
 * @version 1.2, updated 2009-01-30
 */
public class JMHSoundUtilities {

  /**
   * This method is necessary because Java does not seem to return the default sequencer.
   * It returns the first Sequencer in the list of available Sequencers, which is the Java
   * Sound Sequencer.
   * added by JMH on January 24, 2009 at 8:39 PM
   * @return the Squencer for the Java Sound Sequencer device
   */
  public static Sequencer getJavaSoundSequencer() {
    try {
      // attempt to get the default sequencer
      return MidiSystem.getSequencer();
    } catch (MidiUnavailableException ex1) {
      // Logger.getLogger(JMHSoundUtilities.class.getName()).log(Level.SEVERE, null, ex);
      // System.out.println( "Trapped MidiUnavailableException ex1." );

      // scroll through the available MIDI devices to find an appropriate sequencer
      MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
      for (int i = 0; i < infos.length; i++) {
        try {
          Object obj = MidiSystem.getMidiDevice(infos[i]);
          // for debugging
          // System.err.println( i + "  " + MidiSystem.getMidiDevice( infos[i] ).getDeviceInfo() ) ;
          if ( obj instanceof javax.sound.midi.Sequencer &&
               ( ((javax.sound.midi.Sequencer) obj).getDeviceInfo().toString().equals("Real Time Sequencer")) ||
               ( ((javax.sound.midi.Sequencer) obj).getDeviceInfo().toString().equals("Java Sound Sequencer")) )
          {
            // System.err.println( "Got it!" ) ;  // for debugging
            return (javax.sound.midi.Sequencer) MidiSystem.getMidiDevice(infos[i]);
          }
        } catch (MidiUnavailableException ex2) {
          //Logger.getLogger(MidiSynth.class.getName()).log(Level.SEVERE, null, ex2);
          // System.out.println( "Trapped MidiUnavailableException ex2." );
        }
      }
    }

    // if nothing works, return null
    return null ;
  }
}
