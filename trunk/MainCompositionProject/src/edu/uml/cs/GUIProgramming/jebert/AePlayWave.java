/*
 * AePlayWaveTest.java
 *
 * Source:
 * http://www.anyexample.com/programming/java/java_play_wav_sound_file.xml
 * modified by JMH to run in NetBeans on April 10, 2008
 *
 * from the website:
 *
 * AePlayWave ... can play WAV (AUFF, SND, AU might also be supported) sound files
 * asynchronously (in a separate thread, without interruption of main program).  It is
 * possible to use it in console or GUI Java programs for playing user notification sounds.
 *
 * Our class extends Java Thread class to be asynchronous.  There are two constructors:
 * AePlayWave(String wavfile) which has only one argument (a file name), and
 * AePlayWave(String wavfile, Position p) which takes a file name and a Position constant,
 * either Position.LEFT or Position.RIGHT.  This is a simple balance control, which can
 * toggle between the left or right channel of stereo sound (useful for storing two different
 * sounds in a single wave file).
 *
 * Various javax.sound.sampled classes are used to prepare audio input stream and audio data line.
 * Afterward, we simply read and write (through 512Kb buffer, which is suitable for most formats)
 * sound data from file to sound device.
 */

package edu.uml.cs.GUIProgramming.jebert;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AePlayWave extends Thread {

  private String filename;
  private Position curPosition;
  private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb

  enum Position {
    LEFT, RIGHT, NORMAL
  } ;

  public  AePlayWave( String wavfile ) {
    filename = wavfile;

    curPosition = Position.NORMAL;
  }

  public AePlayWave(String wavfile, Position p) {
    filename = wavfile;
    curPosition = p;
  }

  // @Override indicates that a method declaration is intended to override a method declaration
  // in a superclass. If a method is annotated with this annotation type but does not override
  // a superclass method, compilers are required to generate an error message.
  @Override
  public void run() {
    File soundFile = new File(filename);
    if (!soundFile.exists()) {
      System.err.println("Wave file not found: " + filename);
      return;
    }

    AudioInputStream audioInputStream = null;
    try {
      audioInputStream = AudioSystem.getAudioInputStream(soundFile);
    } catch (UnsupportedAudioFileException e1) {
      e1.printStackTrace();
      return;
    } catch (IOException e1) {
      e1.printStackTrace();
      return;
    }

    AudioFormat format = audioInputStream.getFormat();
    SourceDataLine auline = null;
    DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

    try {
      auline = (SourceDataLine) AudioSystem.getLine(info);
      auline.open(format);
    } catch (LineUnavailableException e) {
      e.printStackTrace();
      return;
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }

    if (auline.isControlSupported(FloatControl.Type.PAN)) {
      FloatControl pan = (FloatControl) auline.getControl(FloatControl.Type.PAN);
      if (curPosition == Position.RIGHT) {
        pan.setValue(1.0f);
      } else if (curPosition == Position.LEFT) {
        pan.setValue(-1.0f);
      }
    }

    auline.start();
    int nBytesRead = 0;
    byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

    try {
      while (nBytesRead != -1) {
        nBytesRead = audioInputStream.read(abData, 0, abData.length);
        if (nBytesRead >= 0) {
          auline.write(abData, 0, nBytesRead);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
      return;
    } finally {
      auline.drain();
      auline.close();
    }

  }

}
