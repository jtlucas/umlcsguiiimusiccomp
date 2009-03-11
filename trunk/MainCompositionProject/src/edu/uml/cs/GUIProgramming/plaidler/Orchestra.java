/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uml.cs.GUIProgramming.plaidler;

import javax.sound.midi.*;

/**
 *
 * @author paul
 */
public class Orchestra {
    Synthesizer synthesizer;
    Sequencer sequencer;
    Sequence sequence;
    Instrument instruments[];
    MidiChannel midiChannels[];
    int selectedChannel;

    public Orchestra()
    {
        try {
          if ( synthesizer == null ) {
            if ( ( synthesizer = MidiSystem.getSynthesizer() ) == null ) {
              System.out.println( "getSynthesizer() failed!" );
              return;
            }
          }
          synthesizer.open();

          // the following statement was replaced by JMH on January 24, 2009 at 8:39 PM
          // sequencer = MidiSystem.getSequencer();
          sequencer = JMHSoundUtilities.getJavaSoundSequencer();

          sequence = new Sequence( Sequence.PPQ, 10 );
        } catch ( Exception ex ) {
          ex.printStackTrace();
          return;
        }


        Soundbank sb = synthesizer.getDefaultSoundbank();

        if ( sb != null ) {
          instruments = synthesizer.getDefaultSoundbank().getInstruments();
          synthesizer.loadInstrument( instruments[0] );
        }

        midiChannels = synthesizer.getChannels();

        setInstrument(0,0);   //Piano
        setInstrument(1,7);   //Clavinet
        setInstrument(2,24);  //NylonGuitar
        setInstrument(3,29);  //OverdrivenGuitar
        setInstrument(4,32);  //AcousticBass
        setInstrument(5,40);  //Violin
        setInstrument(6,48);  //StringEnsemble
        setInstrument(7,52);  //Choir
        setInstrument(8,61);  //BrassEnsemble
        setInstrument(9,128); //Drums - channel 10 is drumkit.
        setInstrument(10,0);  //Unused - Piano
        setInstrument(11,0);  //Unused - Piano
        setInstrument(12,0);  //Unused - Piano
        setInstrument(13,0);  //Unused - Piano
        setInstrument(14,0);  //Unused - Piano
        setInstrument(15,0);  //Unused - Piano
    }

    public void setInstrument(int channel, int value) {
        synthesizer.loadInstrument( instruments[value] );
        midiChannels[channel].programChange( value );
    }

    public void selectChannel(int channel) {
        selectedChannel = channel;
    }

    public int getSelectedChannel() {
        return selectedChannel;
    }

    public void playNote(int channel, int pitch, int velocity, int duration){
      playMidiNote p = new playMidiNote(channel, pitch, velocity, duration);
      new Thread(p).start();
    }

    class playMidiNote implements Runnable {
      int channel;  /** midichannel */
      int pitch;    /** pitch */
      int velocity; /** velocity 0-127 */
      int duration; /** Duration milliseconds */

      playMidiNote(int channel, int pitch, int velocity, int duration) {
          this.channel = channel;
          this.pitch = pitch;
          this.velocity = velocity;
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
