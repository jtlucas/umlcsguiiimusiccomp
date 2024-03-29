/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uml.cs.GUIProgramming.etran;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  This was edited to accomodate the other attributes of the Resizing class
 *  such as images and border colors. 
 * @author Professor Heines edited by Elizabeth Tran
 */

public class Resizing extends JPanel {
    /**Color of the border of the rectangle */
    Color initC = Color.blue;
    /** The rectangle represented in the JPanel */
    Rectangle rect = new Rectangle(50,50,150,150);
//    /**Label for the image that the rectangle holds */
//    JLabel Img = new JLabel();
//
//    /**Constructor adds the image */
//    Resizing() {
////        new ResizingUtilities();
//        Img.setBounds(rect.x+2, rect.y+2, rect.width-2, rect.height-2);
//        this.add(Img);
//    }
//
//    /**
//     * Sets up the JLabel to show the following icon
//     * @param icon the image icon passed by the File chooser
//     */
//    public void setUp( ImageIcon imgIcon ) {
//        //Scales the image if it isn't null
//        if( imgIcon != null) {
//            Image ImgtoScale = imgIcon.getImage();
//            Image scaledImg = ImgtoScale.getScaledInstance( rect.width, rect.height, Image.SCALE_SMOOTH);
//            Img.setIcon(new ImageIcon(scaledImg));
//        } else {
//            //otherwise just set the icon to null
//            Img.setIcon(imgIcon);
//        }
//        //repaints the component
//        paintComponent(this.getGraphics());
//    }
//
//    /**
//     * This is a faulty method because the pixels blink as it changes, changes
//     * the size of the icon as well as the label while the rectangle is
//     * constantly resized.
//     * @param x the new x-coordinate
//     * @param y the new y-coordinate
//     * @param w the new width
//     * @param h the new height
//     */
//    public void sizeChange(int x, int y, int w, int h) {
//        //resets the bounds of the Jlabel
//        Img.setBounds(x, y, w, h);
//        //Sets up the image with the new scale
//        setUp((ImageIcon)Img.getIcon());
//    }
    /**
     * Sets up the border and image of the rectangle
     * @param g The graphics of this object
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(initC);
        g2.draw(rect);
    }

//    /**
//     * Returns the Img's Icon
//     */
//    public Icon getImgIcon() {
//        return Img.getIcon();
//    }

    /**
     * Repaints the rectangle
     * @param c the color from the color chooser
     * @param g the graphics of the jPanel
     */
    public void reDraw(Color c, Graphics g) {
        initC = c;
        paintComponent(g);
    }
}
/**
 * MouseAdapter okay for j2se 1.6+
 * Use MouseInputAdapter for j2se 1.5-
 */
class Resizer extends MouseAdapter {
    Resizing component;
    boolean dragging = false;
    // Give user some leeway for selections.
    final int PROX_DIST = 3;

    public Resizer(Resizing r) {
        component = r;
    }

    public void mousePressed(MouseEvent e) {
        if(component.getCursor() != Cursor.getDefaultCursor()) {
            // If cursor is set for resizing, allow dragging.
            dragging = true;
        }
    }

    public void mouseReleased(MouseEvent e) {
        dragging = false;
    }

    public void mouseDragged(MouseEvent e) {
        if(dragging) {
            Point p = e.getPoint();
            Rectangle r = component.rect;
            int type = component.getCursor().getType();
            int dx = p.x - r.x;
            int dy = p.y - r.y;
             switch(type) {
                case Cursor.N_RESIZE_CURSOR:
                    int height = r.height - dy;
                    r.setRect(r.x, r.y+dy, r.width, height);
                    ((ResizingUtilities)component).sizeChange(r.x, r.y+dy, r.width, height);
                    break;
                case Cursor.NW_RESIZE_CURSOR:
                    int width = r.width - dx;
                    height = r.height - dy;
                    r.setRect(r.x+dx, r.y+dy, width, height);
                    ((ResizingUtilities)component).sizeChange(r.x+dx, r.y+dy, width, height);
                    break;
                case Cursor.W_RESIZE_CURSOR:
                    width = r.width - dx;
                    r.setRect(r.x+dx, r.y, width, r.height);
                    ((ResizingUtilities)component).sizeChange(r.x+dx, r.y, width, r.height);
                    break;
                case Cursor.SW_RESIZE_CURSOR:
                    width = r.width - dx;
                    height = dy;
                    r.setRect(r.x+dx, r.y, width, height);
                    ((ResizingUtilities)component).sizeChange(r.x+dx, r.y, width, height);
                    break;
                case Cursor.S_RESIZE_CURSOR:
                    height = dy;
                    r.setRect(r.x, r.y, r.width, height);
                    ((ResizingUtilities)component).sizeChange(r.x, r.y, r.width, height);
                    break;
                case Cursor.SE_RESIZE_CURSOR:
                    width = dx;
                    height = dy;
                    r.setRect(r.x, r.y, width, height);
                    ((ResizingUtilities)component).sizeChange(r.x, r.y, width, height);
                    break;
                case Cursor.E_RESIZE_CURSOR:
                    width = dx;
                    r.setRect(r.x, r.y, width, r.height);
                    ((ResizingUtilities)component).sizeChange(r.x, r.y, width, r.height);
                    break;
                case Cursor.NE_RESIZE_CURSOR:
                    width = dx;
                    height = r.height - dy;
                    r.setRect(r.x, r.y+dy, width, height);
                    ((ResizingUtilities)component).sizeChange(r.x, r.y+dy, width, height);
                    break;
                default:
                    System.out.println("unexpected type: " + type);
            }
            component.repaint();
        }
    }

    public void mouseMoved(MouseEvent e) {
        Point p = e.getPoint();
        if(!isOverRect(p)) {
            if(component.getCursor() != Cursor.getDefaultCursor()) {
                // If cursor is not over rect reset it to the default.
                component.setCursor(Cursor.getDefaultCursor());
            }
            return;
        }
        // Locate cursor relative to center of rect.
        int outcode = getOutcode(p);
        Rectangle r = component.rect;
        switch(outcode) {
            case Rectangle.OUT_TOP:
                if(Math.abs(p.y - r.y) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.N_RESIZE_CURSOR));
                }
                break;
             case Rectangle.OUT_TOP + Rectangle.OUT_LEFT:
                if(Math.abs(p.y - r.y) < PROX_DIST &&
                   Math.abs(p.x - r.x) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.NW_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_LEFT:
                if(Math.abs(p.x - r.x) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.W_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_LEFT + Rectangle.OUT_BOTTOM:
                if(Math.abs(p.x - r.x) < PROX_DIST &&
                   Math.abs(p.y - (r.y+r.height)) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.SW_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_BOTTOM:
                if(Math.abs(p.y - (r.y+r.height)) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.S_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_BOTTOM + Rectangle.OUT_RIGHT:
                if(Math.abs(p.x - (r.x+r.width)) < PROX_DIST &&
                   Math.abs(p.y - (r.y+r.height)) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.SE_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_RIGHT:
                if(Math.abs(p.x - (r.x+r.width)) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.E_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_RIGHT + Rectangle.OUT_TOP:
                if(Math.abs(p.x - (r.x+r.width)) < PROX_DIST &&
                   Math.abs(p.y - r.y) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                                        Cursor.NE_RESIZE_CURSOR));
                }
                break;
            default:    // center
                component.setCursor(Cursor.getDefaultCursor());
        }
    }

    /**
     * Make a smaller Rectangle and use it to locate the
     * cursor relative to the Rectangle center.
     */
    private int getOutcode(Point p) {
        Rectangle r = (Rectangle)component.rect.clone();
        r.grow(-PROX_DIST, -PROX_DIST);
        return r.outcode(p.x, p.y);
    }

     /**
     * Make a larger Rectangle and check to see if the
     * cursor is over it.
     */
    private boolean isOverRect(Point p) {
        Rectangle r = (Rectangle)component.rect.clone();
        r.grow(PROX_DIST, PROX_DIST);
        return r.contains(p);
    }
}
