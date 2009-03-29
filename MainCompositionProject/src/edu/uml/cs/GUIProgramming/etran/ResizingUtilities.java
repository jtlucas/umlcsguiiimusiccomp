/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uml.cs.GUIProgramming.etran;

import java.awt.Image;
import javax.swing.*;

/**
 * Extends the Resizing class, so that I can add methods without altering
 * another programmer's code. Provides utilities that a Resizing object might
 * need. Doesn't work yet.
 * @author Elizabeth Tran
 */
public class ResizingUtilities extends Resizing {
    /**Label for the image that the rectangle holds */
    JLabel Img = new JLabel();

    /**Constructor adds the image */
    ResizingUtilities() {
        Img.setBounds(rect.x+2, rect.y+2, rect.width-2, rect.height-2);
        this.add(Img);
    }

   /**
     * Sets up the JLabel to show the following icon
     * @param icon the image icon passed by the File chooser
     */
    public void setUp( ImageIcon imgIcon ) {
        //Scales the image if it isn't null
        if( imgIcon != null) {
            Image ImgtoScale = imgIcon.getImage();
            Image scaledImg = ImgtoScale.getScaledInstance( rect.width, rect.height, Image.SCALE_SMOOTH);
            Img.setIcon(new ImageIcon(scaledImg));
        } else {
            //otherwise just set the icon to null
            Img.setIcon(imgIcon);
        }
        //repaints the component
        paintComponent(this.getGraphics());
    }

    /**
     * This is a faulty method because the pixels blink as it changes, changes
     * the size of the icon as well as the label while the rectangle is
     * constantly resized.
     * @param x the new x-coordinate
     * @param y the new y-coordinate
     * @param w the new width
     * @param h the new height
     */
    public void sizeChange(int x, int y, int w, int h) {
        //resets the bounds of the Jlabel
        Img.setBounds(x, y, w, h);
        //Sets up the image with the new scale
        setUp((ImageIcon)Img.getIcon());
    }

   /**
     * Returns the Img's Icon
     */
    public Icon getImgIcon() {
        return Img.getIcon();
    }
    

}
