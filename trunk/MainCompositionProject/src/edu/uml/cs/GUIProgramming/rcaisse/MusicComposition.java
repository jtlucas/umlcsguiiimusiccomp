/*
 * MusicComposition.java
 *
 * This is the class that stores all the notes in a composition. Its
 * basically a list of notes and a way to manipulate that list.
 *
 * Created on March 1, 2009, 11:57 PM
 */

package edu.uml.cs.GUIProgramming.rcaisse;

import java.util.LinkedList;    // Needed for the LinkedList class
import java.util.Random;        // Needed for generating unique note id's

/**
 *
 * This is class stores a composition as a list of notes and allows the
 * addition/deletion/manipulation of these notes. Its basically the
 * in-memory representation.
 *
 * @author  Ross Caisse, UMass Lowell Computer Science, <a href="mailto:rcaisse@gmail.com">rcaisse@gmail.com</a>
 * @version 1.0, 2009-3-01
 */
public class MusicComposition {

    private LinkedList myNotes; // the list of notes in the composition
    private Random generator;   // used to generate unique note id's
    private int compSize;       // the size of the composition

    /**
     * This is the default constructor for creating a composition
     */
    public MusicComposition() {
        myNotes = new LinkedList(); // instantiate a list
        // Instantiate a new random number generator, seeding it with the
        // system time in nanoseconds
        generator = new Random(System.nanoTime());
        compSize = 0; // set the composition size to 0
    }

    /**
     * Add a note to the composition
     *
     * @param n, the note that is to be added to the composition
     */
    public void addNote( MusicNote n ) {

        int cond = 0; // This makes sure that note id generated is unique

        // Loop until cond is equal to 1
        while(true) {
            // Get an integer from the random number generator
            int temp = Math.abs(generator.nextInt());

            // If this is not the first note in the composition
            if(myNotes.size() > 0 ) {
                // Loop through all the notes
                for( int i = 0, x = myNotes.size(); i < x ; i++ ) {
                    // If this id is the same as the current note
                    if(temp == ((MusicNote)myNotes.get(i)).getNid())
                        break;

                    // If this is the last note in the list and the id
                    // is unique
                    if( i + 1 == x) {
                        cond = 1;  // found a unique id
                        break; // break out of the for loop
                    }
                    
                }

                // If this idea was unique
                if( cond == 1 ) {
                    n.setNid(temp);  // set the id for this note
                    break; // break out of the while loop
                }
            }
            else {  // this condition is hit if this is the first note in
                    // the composition, and this id is obviously unique
                n.setNid(temp); // set the id for this note
                break;  // break out of the while loop
            }

        }

        myNotes.add(n); // add this note to the composition
        compSize++; // increase the composition size
    }

    /**
     * This method deletes the note from the composition.
     *
     * @param n
     */
    public void deleteNote( MusicNote n ) {
        // Get the note id for the note to be deleted
        int id = n.getNid();

        // Loop through the notes
        for( int i = 0, x = myNotes.size(); i < x ; i++ ) {
            // If the id's match
            if( id == ((MusicNote)myNotes.get(i)).getNid()) {
                // Remove the note from the list
                myNotes.remove(i);

                // Decrease the composition size
                compSize--;
                return;
            }
        }

        // If this is reached, we have a problem
        System.out.println("Error finding note");
    }

    /**
     * This method returns a music note given the note id. I'm not sure
     * if this method is going to be necessary but I'd rather be safe.
     *
     * @param nid
     * @return the note matching that id
     */
    public MusicNote getNoteNid(int nid) {

        // Loop through the notes
        for( int i = 0, x = myNotes.size(); i < x ; i++ ) {

            // If the note id's match
            if( nid == ((MusicNote)myNotes.get(i)).getNid()) {
                // Return this note
                return (MusicNote)myNotes.get(i);
            }
        }

        // If we reach here there was a problem
        System.out.println("Error finding note");

        // Return nothing
        return null;
    }

    /**
     * This method returns a note given its index in the list. As with the
     * last method, I'm not sure that this method is going to be necessary,
     * but I'm paranoid.
     *
     * @param index
     * @return the note at the given index in the list
     */
    public MusicNote getNote(int index) {

        // If the index passed in is greater than the size of the list, there's
        // a problem.
        if(index > compSize ) {
            return null;
        }
        else {
            // Return the note at the given index
            return (MusicNote)myNotes.get(index);
        }
    }

    /**
     * This is the get method for the comp size.
     *
     * @return the size of the composition
     */
    public int getCompSize() {
        return compSize;
    }

    /**
     * This method gets the list of notes in the composition.
     *
     * @return the list of notes
     */
    public LinkedList getNotes() {
        return myNotes;
    }

    /**
     * This method prints all the info for every note in the compostion.
     * This is really only useful for debugging purposes.
     *
     * @return the string form of all the notes
     */
    public String toString() {

        // Instantiate a new string
        String myString = new String();

        // Loop though all the notes
        for( int i = 0, x = myNotes.size(); i < x ; i++ ) {
            // Append this notes string form to the total string
            myString = myString + ((MusicNote)myNotes.get(i)).toString();
        }

        // Return the string
        return myString;
    }

} // End of class
