/*
 * MusicNote.java
 *
 * This is the class that stores the information for each note.
 *
 * Created on March 1, 2009, 11:57 PM
 */

package edu.uml.cs.GUIProgramming.rcaisse;

/**
 *
 * This is class stores all information for a specific note (or shape).
 *
 * @author  Ross Caisse, UMass Lowell Computer Science, <a href="mailto:rcaisse@gmail.com">rcaisse@gmail.com</a>
 * @version 1.0, 2009-3-01
 */
public class MusicNote {

    private int x;  // the x coordinate of the note on the screen
    private int y;  // the y coordinate of the note on the screen
    private int height; // the heigh of the object
    private int width;  // the width of the object
    private String shape;   // the type of shape
    private String orientation; // the orientation of the shape
    private String picture; // the path to the picture (if applicable)
    private boolean isPic;  // the flag that sets if a picture is present
    private int nid;    // the note id (which may or not be used)

    /**
     * This is the default constructor that initializes everything to 0
     */
    public MusicNote() {
        this.x = 0;
        this.y = 0;
        this.height = 0;
        this.width = 0;
        this.shape = new String();
        this.orientation = new String();
        this.picture = new String();
        this.isPic = false;
        this.nid = 0;
    }

    /**
     * This is the constructor that sets all the basic properties of a note,
     * and initializes everything else to 0 or a blank string
     *
     * @param x
     * @param y
     * @param height
     * @param width
     * @param shape
     */
    public MusicNote(int x, int y, int height, int width, String shape) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.shape = shape;

        this.orientation = new String();
        this.picture = new String();
        this.isPic = false;
        this.nid = 0;
    }

    /**
     * This constructor sets all properties of the shape, but initializes
     * the note id field to 0.
     *
     * @param x
     * @param y
     * @param height
     * @param width
     * @param shape
     * @param orientation
     * @param picture
     * @param isPic
     */
    public MusicNote(int x, int y, int height, int width, String shape, String orientation, String picture, boolean isPic) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.shape = shape;
        this.orientation = orientation;
        this.picture = picture;
        this.isPic = isPic;
        
        this.nid = 0;
    }

    /**
     * This constructor sets every property of a note.
     *
     * @param x
     * @param y
     * @param height
     * @param width
     * @param shape
     * @param orientation
     * @param picture
     * @param isPic
     * @param nid
     */
    public MusicNote(int x, int y, int height, int width, String shape, String orientation, String picture, boolean isPic, int nid) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.shape = shape;
        this.orientation = orientation;
        this.picture = picture;
        this.isPic = isPic;
        this.nid = nid;
    }

    /**
     * Get the height of the shape.
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set the height of the shape.
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Returns whether or not a picture is present
     *
     * @return isPic
     */
    public boolean isIsPic() {
        return isPic;
    }

    /**
     * Set whether a picture is present.
     *
     * @param isPic
     */
    public void setIsPic(boolean isPic) {
        this.isPic = isPic;
    }

    /**
     * Get the orientation of the shape
     *
     * @return orientation
     */
    public String getOrientation() {
        return orientation;
    }

    /**
     * Set the orientation of the shape
     *
     * @param orientation
     */
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    /**
     * Get the path to the picture.
     *
     * @return picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Set the path to the picture
     *
     * @param picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * Get the shape of the object.
     *
     * @return shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * Set the shape of the object.
     *
     * @param shape
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * Get the width of the object
     *
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set the width of the object
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Get the x coordinate of the object
     *
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Set the x coordinate of the object
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get the y coordinate of the object
     *
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Set the y coordinate of the object
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get the note id
     *
     * @return nid
     */
    public int getNid() {
        return nid;
    }

    /**
     * Set the note id
     *
     * @param nid
     */
    public void setNid(int nid) {
        this.nid = nid;
    }

    /**
     * Return all note information in a string.
     *
     * @return note info
     */
    public String toString() {
        String myString = new String(
                "X = " + getX() + "\n" +
                "Y = " + getY() + "\n" +
                "Type = " + getShape() + "\n" +
                "Height = " + getHeight() + "\n" +
                "Width = " + getWidth() + "\n" +
                "Note ID = " + getNid() + "\n\n"
                );

        return myString;
    }
}
