/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uml.cs.GUIProgramming.jtlucas;

import java.awt.geom.*;

/**
 * This class contains the code to generate the shape sizes.
 * @author Jesse T. Lucas, UMass Lowell Computer Science
 * @author <a href="mailto:jtlucas@cs.uml.edu">jtlucas@cs.uml.edu</a>
 * @version 1.0, March 10, 2009
 * Copyright &copy; 2009 by Jesse T. Lucas.  All rights reserved.  May be freely
 *     copied or excerpted for educational purposes with credit to the author.
 */
public class JTL_ShapeResize {

    /* The Default Window Width Size */
    private double Canvas_Ypos = 254;

    /**
     * This method is intended to be called from other classes.
     * This is to get the Canvas_Ypos
     * @return double returns the Canvas_Ypos
     */
    public double getCanvas_Ypos(){
        return Canvas_Ypos;
    }

    /**
     * This method is intended to be called from other classes.
     * This is to set the Canvas_Ypos
     * @param value sets the Canvas_Ypos
     */
    public void setCanvas_Ypos( double value ){
        Canvas_Ypos = value;
    }

     /**
     * This method is intended to be called from other classes.
     * This function will return false when the size of the shape is equal to the maximum value
     * @param shape the shape object passed to the function
     * @return boolean true for if the shape can still be re-sized but false if it is equal to the maximum
     */
    public boolean Max_Shape_Resize ( RectangularShape shape ){

        double height = shape.getHeight();
        double width = shape.getWidth();

        JTL_ShapeSize defaultshape = new JTL_ShapeSize();

        if( height == defaultshape.getShapeMaxHeight()){
            return false;
        }

        if( width == defaultshape.getShapeMaxWidth()){
            return false;
        }

        return true;
    }
    /**
     * This method is intended to be called from other classes.
     * This function will return false when the size of the shape is equal to the minimum value
     * @param shape the shape object passed to the function
     * @return boolean true for if the shape can still be re-sized but false if it is equal to the minimum
     */
    public boolean Min_Shape_Resize ( RectangularShape shape ){

        double height = shape.getHeight();
        double width = shape.getWidth();

        JTL_ShapeSize defaultshape = new JTL_ShapeSize();

        if( height == defaultshape.getShapeMinHeight()){
            return false;
        }

        if( width == defaultshape.getShapeMinWidth()){
            return false;
        }

        return true;
    }

     /**
     * This method is intended to be called from other classes.
     * This should not let the shape below a certain point on the canvas
     * @param shape the shape object given to the function
     * @return boolean true if the object hasn't reached the point and false if it has.
     */
    public boolean Min_Shape_Position ( RectangularShape shape ){

        double ypos = shape.getY();

        if( ypos == Canvas_Ypos ){
            return false;
        }

        return true;
    }
    
}
