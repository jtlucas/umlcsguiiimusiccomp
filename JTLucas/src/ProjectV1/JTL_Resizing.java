/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjectV1;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author JTLucas
 */
public class JTL_Resizing {

    static public Boolean ResizingMax (Point p, Object component){

        // Get the x and y coordinate of the point grabbed by the mouse
        double pointx = p.getX();
        double pointy = p.getY();

        String compstring, beforex, afterx, strpanely, strpanelx;

        // Get the component string to pull width and height of main frame
        // ProjectV1.Driver[,0,0,384
        // The width and height of the frame is the string "384x364" in this example
        compstring = component.toString();

        try{

            // Get everything before the "x"
            // ProjectV1.Driver[,0,0,384
            beforex = compstring.substring(0, compstring.indexOf("x"));
            // Get the width of the panel by usig beforex
            // 384
            strpanelx = beforex.substring(beforex.lastIndexOf(",")+1);

            // Get everything after the "x" and remove the x
            // 364,layout=javax.swing.GroupLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=]
            afterx = compstring.substring(compstring.indexOf("x")+1);
            // Get the height of the panel using afterx
            // 364
            strpanely = afterx.substring(0,afterx.indexOf(","));

        } catch(Exception e ){
            System.out.println(e);
            System.out.println(compstring);
            return false;
        }

        // Convert the strings to double so you can compare them
        double panelx = new Double(strpanelx);
        double panely = new Double(strpanely);

        if((pointx + 3) >= panelx){
            return false;
        }
        if((pointy + 3) >= panely){
            return false;
        }
        if((pointx - 3) <= 0){
            return false;
        }
        if((pointy - 3) <= 0){
            return false;
        }

        return true;

    }

    static public Boolean ResizingMin (Point p, Object component ){

        String compstring, afterwidth, afterheight, strwidth, strheight;
        String afterx, aftery, strpositionx, strpositiony;

        Double width,height;

        Double pointx, pointy;
        Double positionx, positiony;

        pointx = p.getX();
        pointy = p.getY();

        //java.awt.Rectangle[x=100,y=135,width=150,height=115]
        compstring = component.toString();

        try{

            // 150,height=115]
            afterwidth = compstring.substring(compstring.indexOf("width=")+6);
            // 150
            strwidth = afterwidth.substring(0,afterwidth.indexOf(","));
            // 115]
            afterheight = compstring.substring(compstring.indexOf("height=")+7);
            // 115
            strheight = afterheight.substring(0,afterheight.indexOf("]"));

            // 100,y=135,width=150,height=115]
            afterx = compstring.substring(compstring.indexOf("x=")+2);
            // 100
            strpositionx = afterx.substring(0,afterx.indexOf(","));
            // 135,width=150,height=115]
            aftery = compstring.substring(compstring.indexOf("y=")+2);
            // 135
            strpositiony = aftery.substring(0,aftery.indexOf(","));

        } catch (Exception e){
            System.out.println(e);
            System.out.println(compstring);
            return false;
        }

        width = new Double(strwidth);
        height = new Double(strheight);

        positionx = new Double(strpositionx);
        positiony = new Double(strpositiony);
        System.out.println(compstring);
        //System.out.println("rect " + positionx + " " + width + " " + (positionx+10) );
        //System.out.println("point " + pointx);
        System.out.println(p.toString());

        //right move
        if( ((positionx + 10.0) > pointx) && (width >= 10) ){
            //System.out.println("right");
            return false;
        }
        //bottom move
        if( ((positiony + 10.0) > pointy) && (height >= 10) ){
            //System.out.println("bottom");
            return false;
        }
        
        return true;

    }

}
