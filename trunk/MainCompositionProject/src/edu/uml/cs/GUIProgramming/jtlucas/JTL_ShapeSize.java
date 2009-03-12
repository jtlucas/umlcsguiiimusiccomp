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
 * @author <a href="mailto:jtlucas@cs.uml.edu">jtlucas@cs.uml.edu</a>
 * @version 1.0, March 3, 2009
 * Copyright &copy; 2009 by Jesse T. Lucas.  All rights reserved.  May be freely
 *     copied or excerpted for educational purposes with credit to the author.
 */
public class JTL_ShapeSize {

    /* The Max Height of a Shape */
    private double ShapeMaxHeight = 254;
    /* The Min Height of a Shape */
    private double ShapeMinHeight = 10;
    /* The Max Width of a Shape */
    private double ShapeMaxWidth = 2990;
    /* The Min Width of a Shape */
    private double ShapeMinWidth = 10;

    /**
     * This method is intended to be called from other classes.
     * This is to return the max height of a shape.
     * @return double that corresponds to the maximum height
     */
     public double getShapeMaxHeight() {
         return (ShapeMaxHeight);
     }

     /**
     * This method is intended to be called from other classes.
     * This is to set the max height of a shape.
     * @param value double that sets the maximum height
     */
     public void setShapeMaxHeight(double value) {
         ShapeMaxHeight = value;
     }

     /**
     * This method is intended to be called from other classes.
     * This is to return the min height of a shape.
     * @return double that corresponds to the minimum height
     */
     public double getShapeMinHeight() {
         return (ShapeMinHeight);
     }

     /**
     * This method is intended to be called from other classes.
     * This is to set the min height of a shape.
     * @param value double that sets the minimum height
     */
     public void setShapeMinHeight(double value) {
         ShapeMinHeight = value;
     }

     /**
     * This method is intended to be called from other classes.
     * This is to return the min width of a shape.
     * @return double that corresponds to the minimum width
     */
     public double getShapeMinWidth() {
         return (ShapeMinWidth);
     }

     /**
     * This method is intended to be called from other classes.
     * This is set the min width of a shape.
     * @param value double sets the minimum width
     */
     public void setShapeMinWidth( double value ) {
         ShapeMinWidth = value;
     }

     /**
     * This method is intended to be called from other classes.
     * This is to return the max width of a shape.
     * @return double that corresponds to the maximum width
     */
     public double getShapeMaxWidth() {
         return (ShapeMaxWidth);
     }

     /**
     * This method is intended to be called from other classes.
     * This is to set the max width of a shape.
     * @param value sets the maximum width
     */
     public void setShapeMaxWidth( double value ) {
         ShapeMaxWidth = value;
     }

}
