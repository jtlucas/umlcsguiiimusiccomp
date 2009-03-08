/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JTL_ShapeSize.java
 *
 * Created on Mar 3, 2009, 10:59:09 AM
 */

package edu.uml.cs.GUIProgramming.jtlucas;

/**
 * This class contains the code to generate the shape sizes.
 * @author Jesse T. Lucas, UMass Lowell Computer Science
 * @author <a href="mailto:jtlucas@cs.uml.edu">heines@cs.uml.edu</a>
 * @version 1.0, March 3, 2009
 * Copyright &copy; 2009 by Jesse T. Lucas.  All rights reserved.  May be freely
 *     copied or excerpted for educational purposes with credit to the author.
 */
public class JTL_ShapeSize {

    /* The Max Height of a Shape */
    private int ShapeMaxHeight = 254;
    /* The Min Height of a Shape */
    private int ShapeMinHeight = 10;
    /* The Max Width of a Shape */
    private int ShapeMaxWidth = 2990;
    /* The Min Width of a Shape */
    private int ShapeMinWidth = 10;

    /**
     * This method is intended to be called from other classes.
     * This is to return the max height of a shape.
     * @return int that corresponds to the maximum height
     */
     public int getShapeMaxHeight() {
         return (ShapeMaxHeight);
     }

     /**
     * This method is intended to be called from other classes.
     * This is to set the max height of a shape.
     * @param value int that sets the maximum height
     */
     public void setShapeMaxHeight(int value) {
         ShapeMaxHeight = value;
     }

     /**
     * This method is intended to be called from other classes.
     * This is to return the min height of a shape.
     * @return int that corresponds to the minimum height
     */
     public int getShapeMinHeight() {
         return (ShapeMinHeight);
     }

     /**
     * This method is intended to be called from other classes.
     * This is to set the min height of a shape.
     * @param value int that sets the minimum height
     */
     public void setShapeMinHeight(int value) {
         ShapeMinHeight = value;
     }

     /**
     * This method is intended to be called from other classes.
     * This is to return the min width of a shape.
     * @return int that corresponds to the minimum width
     */
     public int getShapeMinWidth() {
         return (ShapeMinWidth);
     }

     /**
     * This method is intended to be called from other classes.
     * This is set the min width of a shape.
     * @param value int sets the minimum width
     */
     public void setShapeMinWidth( int value ) {
         ShapeMinWidth = value;
     }

     /**
     * This method is intended to be called from other classes.
     * This is to return the max width of a shape.
     * @return int that corresponds to the maximum width
     */
     public int getShapeMaxWidth() {
         return (ShapeMaxWidth);
     }

     /**
     * This method is intended to be called from other classes.
     * This is to set the max width of a shape.
     * @param value sets the maximum width
     */
     public void setShapeMaxWidth( int value ) {
         ShapeMaxWidth = value;
     }



}
