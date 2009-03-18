/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uml.cs.GUIProgramming.plaidler;

import javax.sound.midi.*;

/**
 * This class contains an interface to the java midi synthesizer
 * @author Paul A Laidler, UMass Lowell Computer Science
 * @version 1.01, March 18, 2009
 */
public class Orchestra {
    /** The Synthesizer object to be used by the orchestra. */
    Synthesizer synthesizer;
    /** The array of instruments from a midi soundbank to be used by the orchestra. */
    Instrument instruments[];
    /** The array of midi channels on which an instrument may be played */
    MidiChannel midiChannels[];
    /** The midi channel that is currently active in the orchestra */
    int selectedChannel;

    /**
     * Creates new Orchestra object
     */
    public Orchestra()
    {
        //Initialize the midi synthesizer

        /* Initialization derived from JavaSoundDemo.MidiSynth.java
         * version: @(#)MidiSynth.java	1.15 99/12/03
         * author: Brian Lichtenwalter
         */
        try {
          if ( synthesizer == null ) {
            if ( ( synthesizer = MidiSystem.getSynthesizer() ) == null ) {
              System.out.println( "getSynthesizer() failed!" );
              return;
            }
          }
          synthesizer.open();
        } catch ( Exception ex ) {
          ex.printStackTrace();
          return;
        }

        //Get soundbank, and load instruments
        Soundbank sb = synthesizer.getDefaultSoundbank();
        if ( sb != null ) {
          //initialize instruments
          instruments = synthesizer.getDefaultSoundbank().getInstruments();
          synthesizer.loadInstrument( instruments[0] );
        }

        //initialize midi channels
        midiChannels = synthesizer.getChannels();

        //Set default Instrument on each midi channel
        setInstrument(0,0);   //Piano
        setInstrument(1,7);   //Clavinet
        setInstrument(2,24);  //NylonGuitar
        setInstrument(3,29);  //OverdrivenGuitar
        setInstrument(4,32);  //AcousticBass
        setInstrument(5,40);  //Violin
        setInstrument(6,48);  //StringEnsemble
        setInstrument(7,52);  //Choir
        setInstrument(8,61);  //BrassEnsemble
        setInstrument(9,127); //Drums - channel 10 is drumkit.
        setInstrument(10,0);  //Unused - Piano
        setInstrument(11,0);  //Unused - Piano
        setInstrument(12,0);  //Unused - Piano
        setInstrument(13,0);  //Unused - Piano
        setInstrument(14,0);  //Unused - Piano
        setInstrument(15,0);  //Unused - Piano
        
        selectedChannel = 0;
    }
    /**
     * Set the Instrument on a channel
     */
    public void setInstrument(int channel, int value) {
        if( value > 127 ){ value = 127; } // Maximum instrument index
        if( value < 0 ){ value = 0; } // Minimum instrument index

        if( channel >= 16 ){ channel = 16; } //Maximum channel Index
        if( channel < 0 ){ channel = 0; } //Minimum channel index

        //load the instrument
        synthesizer.loadInstrument( instruments[value] );
        //change the midi channels instrument to the newly loaded instrument
        midiChannels[channel].programChange( value );
    }

    /**
     * Get the index of the Instrument on a channel
     */
    public int getInstrument(int channel) {
        return midiChannels[channel].getProgram();
    }

    /**
     * Get the index of the Instrument on the currently selected channel
     */
    public int getSelectedInstrument() {
        return getInstrument(getSelectedChannel());
    }

    /**
     * Get the name of the Instrument on a channel
     */
    public String getInstrumentName(int value) {
       return instruments[value].getName();
    }

    /**
     * Get the name of the Instrument on the currently selected channel
     */
    public String getSelectedInstrumentName() {
      String InstrumentName;
      int InstrumentValue = getInstrument(selectedChannel);
      if( selectedChannel == 9 ) {
          InstrumentName = "Drumkit"; //Channel 10 is always the drumkit
      }
      else {
          InstrumentName = getInstrumentName(InstrumentValue);
      }
      return InstrumentName;
    }

    /**
     * Select the current midi channel of the orchestra
     */
    public void selectChannel(int channel) {
        selectedChannel = channel;
    }

    /**
     * get the currently selected midi channel of the orchestra
     */
    public int getSelectedChannel() {
        return selectedChannel;
    }

    /**
     * Use the orchestra to play a midi note.
     */
    public void playNote(int channel, int pitch, int velocity, int duration) {
      //create a play midi note thread
      playMidiNote p = new playMidiNote(channel, pitch, velocity, duration);
      //start the thread
      new Thread(p).start();
    }

    /**
     * This class plays a midi note for a specified duration
     */
    class playMidiNote implements Runnable {
      /** midichannel 0 - 16 */
      int channel;
      /** pitch 0-127 */
      int pitch;
      /** velocity 0-127 */
      int velocity;
      /** Duration in milliseconds */
      int duration; 

      playMidiNote(int channel, int pitch, int velocity, int duration) {
          if( channel > 16 ){ channel = 16; }   //Max channel
          if( channel < 0 ){ channel = 0; }     //Min channel
          this.channel = channel;

          if( pitch > 127 ){ pitch = 127; } //Max pitch
          if( pitch < 0 ){ pitch = 0; }     //Min pitch
          this.pitch = pitch;

          if( velocity > 127 ){ velocity = 127; } //Max Velocity
          if( velocity < 0 ){ velocity = 0; }     //Min Velocity
          this.velocity = velocity;

          if( duration < 0 ){ duration = 0; } //Min Duration
          this.duration = duration;
      }
      public void run() {
          //Note on
          midiChannels[channel].noteOn( pitch, velocity );

          //Sleep for the note's duration
          try { Thread.sleep(duration); }
          catch( InterruptedException e ) { }

          //Note off
          midiChannels[channel].noteOff( pitch, velocity );
        }
    }
}
