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
     * @return int 1: When the width equals the shape maximum width
     *             2: When the width is less than the shape maximum width
     *             3: When the height equals the shape maximum height
     *             4: When the height is less than the shape maximum height
     */
    public int Max_Shape_Resize ( RectangularShape shape ){

        double height = shape.getHeight();
        double width = shape.getWidth();

        JTL_ShapeSize defaultshape = new JTL_ShapeSize();

        if( width == defaultshape.getShapeMaxWidth()){
            return 1;
        }

        if( width > defaultshape.getShapeMaxWidth()){
            return 2;
        }

        if( height == defaultshape.getShapeMaxHeight()){
            return 3;
        }

        if( height > defaultshape.getShapeMaxHeight()){
            return 4;
        }
        
        return 0;
    }
    /**
     * This method is intended to be called from other classes.
     * This function will return false when the size of the shape is equal to the minimum value
     * @param shape the shape object passed to the function
     * @return int 1: When the width equals the shape minimum width
     *             2: When the width is less than the shape minimum width
     *             3: When the height equals the shape minimum height
     *             4: When the height is less than the shape minimum height
     */
    public int Min_Shape_Resize ( RectangularShape shape ){

        double height = shape.getHeight();
        double width = shape.getWidth();

        JTL_ShapeSize defaultshape = new JTL_ShapeSize();

        if( width == defaultshape.getShapeMinWidth()){
            return 1;
        }

        if( width < defaultshape.getShapeMinWidth()){
            return 2;
        }

        if( height == defaultshape.getShapeMinHeight()){
            return 3;
        }

        if( height < defaultshape.getShapeMinHeight()){
            return 4;
        }

        return 0;
    }

     /**
     * This method is intended to be called from other classes.
     * This should not let the shape below a certain point on the canvas
     * @param shape the shape object given to the function
     * @return boolean true if the object hasn't reached the point and false if it has.
     */
    public boolean Min_Shape_Position ( RectangularShape shape ){

        double ypos = shape.getY();

        if( ypos >= Canvas_Ypos ){
            return false;
        }

        return true;
    }
    
}
