/*
 * MovableShape.java
 *
 * Created on Feb 18, 2009, 11:11:50 PM
 */
package edu.uml.cs.GUIProgramming.ngilbert.shapedemo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.Arrays;

/**
 *
 * @author Nathan Gilbert
 */
public class MovableShape extends Polygon {

    //true if the shape, an edge, or a vertex is selected
    private boolean selected;
    //index of selected edge / vertex or -1 for the entire shape
    private int selIndex;
    //true if selection is a vertex, false if an edge
    private boolean vertex;
    //color of the selected edge / vertex
    private Color selColor = Color.YELLOW;
    //stroke color for the shape
    private Color lineColor = Color.BLUE;
    //fill color for the shape
    private Color fillColor = Color.YELLOW;
    //Name of the shape
    private String name;
    //Internal high precesion points;
    double[] intxpoints = new double[1], intypoints = new double[1];
    //Selection rectangle
    private static final Rectangle selRect = new Rectangle(-2, -2, 4, 4);
    private static final Rectangle clickRect = new Rectangle(-4, -4, 8, 8);

    public static MovableShape CreateRect(double x, double y, double width, double height) {
        MovableShape shape = new MovableShape();
        shape.addPoint(x, y);
        shape.addPoint(x + width, y);
        shape.addPoint(x + width, y + height);
        shape.addPoint(x, y + height);
        return shape;
    }

    public void addPoint(double x, double y) {
        super.addPoint((int) x, (int) y);
        if (intxpoints.length < npoints) {
            intxpoints = Arrays.copyOf(intxpoints, npoints * 2);
            intypoints = Arrays.copyOf(intypoints, npoints * 2);
        }
        intxpoints[npoints - 1] = x;
        intypoints[npoints - 1] = y;
    }

    /**
     * @return the lineColor
     */
    public Color getLineColor() {
        return lineColor;
    }

    /**
     * @param lineColor the lineColor to set
     */
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    /**
     * @return the fillColor
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * @param fillColor the fillColor to set
     */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * paint this shape
     * @param g Graphics context to paint to
     */
    public void paint(Graphics g) {
        g.setPaintMode();
        if (getFillColor() != null) {
            g.setColor(getFillColor());
            g.fillPolygon(this);
        }
        if (getLineColor() != null) {
            g.setColor(getLineColor());
            g.drawPolygon(this);
        }
        if (selected) {
            g.setXORMode(selColor);
            if (!vertex) {
                g.drawLine(xpoints[selIndex], ypoints[selIndex],
                    xpoints[(selIndex + 1) % npoints],
                    ypoints[(selIndex + 1) % npoints]);
            } else if (selIndex == -1) {
                for (int i = 0; i < npoints; i++) {
                    Rectangle r = (Rectangle) selRect.clone();
                    r.translate(xpoints[i], ypoints[i]);
                    g.drawRect(r.x, r.y, r.width, r.height);
                }
            } else {
                Rectangle r = (Rectangle) selRect.clone();
                r.translate(xpoints[selIndex], ypoints[selIndex]);
                g.drawRect(r.x, r.y, r.width, r.height);
            }
        }
    }

    public void Move(Point delta) {
        if (vertex) {
            if (delta.x > 0) {
                MoveRight(selIndex, delta.x);
            } else if (delta.x < 0) {
                MoveLeft(selIndex, -delta.x);
            }
            if (delta.y > 0) {
                MoveDown(selIndex, delta.y);
            } else if (delta.y < 0) {
                MoveUp(selIndex, -delta.y);
            }
        } else {
            if (delta.x > 0) {
                MoveRight(selIndex, delta.x);
                MoveRight((selIndex + 1) % npoints, delta.x);
            } else if (delta.x < 0) {
                MoveLeft(selIndex, -delta.x);
                MoveLeft((selIndex + 1) % npoints, -delta.x);
            }
            if (delta.y > 0) {
                MoveDown(selIndex, delta.y);
                MoveDown((selIndex + 1) % npoints, delta.y);
            } else if (delta.y < 0) {
                MoveUp(selIndex, -delta.y);
                MoveUp((selIndex + 1) % npoints, -delta.y);
            }
        }
    }

    /**
     * Move the selected vertex up a pixel
     */
    public void MoveUp() {
        if (selected && vertex) {
            MoveUp(selIndex, 1);
        }
        invalidate();
    }

    /**
     * Move the selected vertex down a pixel
     */
    public void MoveDown() {
        if (selected && vertex) {
            MoveDown(selIndex, 1);
        }
    }

    /**
     * Move the selected vertex left a pixel
     */
    public void MoveLeft() {
        if (selected && vertex) {
            MoveLeft(selIndex, 1);
        }
    }

    /**
     * Move the selected vertex right a pixel
     */
    public void MoveRight() {
        if (selected && vertex) {
            MoveRight(selIndex, 1);
        }
    }

    /**
     * Move the selected edge in a pixel
     */
    public void MoveIn() {
        if (selected && !vertex) {
            MoveIn(selIndex, 1);
        }
    }

    /**
     * Move the selected edge out a pixel
     */
    public void MoveOut() {
        if (selected && !vertex) {
            MoveOut(selIndex, 1);
        }
    }

    /**
     * Rotate the selected vertex left a degree
     */
    public void RotateLeft() {
        if (selected && !vertex) {
            RotateLeft(selIndex, 1);
        }
    }

    /**
     * Rotate the selected vertex right a degree
     */
    public void RotateRight() {
        if (selected && !vertex) {
            RotateRight(selIndex, 1);
        }
    }

    /**
     * Move the specified vertex up a pixel
     * @param vertex Index of the vertex to change
     * @param amount Amount to move the vertex
     */
    public void MoveUp(int vertex, int amount) {
        if (vertex == -1) {
            for (int i = 0; i < npoints; i++) {
                this.intypoints[i] -= amount;
                this.ypoints[i] = (int)intypoints[i];
            }
        } else if (vertex < npoints) {
            this.intypoints[vertex] -= amount;
            ypoints[vertex] = (int)intypoints[vertex];
        }
        invalidate();
    }

    /**
     * Move the specified vertex down a pixel
     * @param vertex Index of the vertex to change
     * @param amount Amount to move the vertex
     */
    public void MoveDown(int vertex, int amount) {
        if (vertex == -1) {
            for (int i = 0; i < npoints; i++) {
                intypoints[i] += amount;
                ypoints[i] = (int)intypoints[i];
            }
        } else if (vertex < npoints) {
            intypoints[vertex] += amount;
            ypoints[vertex] = (int)intypoints[vertex];
        }
        invalidate();
    }

    /**
     * Move the specified vertex left a pixel
     * @param vertex Index of the vertex to change
     * @param amount Amount to move the vertex
     */
    public void MoveLeft(int vertex, int amount) {
        if (vertex == -1) {
            for (int i = 0; i < npoints; i++) {
                intxpoints[i] -= amount;
            xpoints[i] = (int)intxpoints[i];
            }
        } else if (vertex < npoints) {
            intxpoints[vertex] -= amount;
            xpoints[vertex] = (int)intxpoints[vertex];
        }
        invalidate();
    }

    /**
     * Move the specified vertex right a pixel
     * @param vertex Index of the vertex to change
     * @param amount Amount to move the vertex
     */
    public void MoveRight(int vertex, int amount) {
        if (vertex == -1) {
            for (int i = 0; i < npoints; i++) {
                intxpoints[i] += amount;
                xpoints[i] = (int)intxpoints[i];
            }
        } else if (vertex < npoints) {
            intxpoints[vertex] += amount;
            xpoints[vertex] = (int)intxpoints[vertex];
        }
        invalidate();
    }

    /**
     * Move the specified edge up a pixel
     * @param edge Index of the edge to change
     * @param amount Amount to move the vertex
     */
    public void MoveIn(int edge, int amount) {
    }

    /**
     * Move the specified edge down a pixel
     * @param edge Index of the edge to change
     * @param amount Amount to move the vertex
     */
    public void MoveOut(int edge, int amount) {
    }

    /**
     * Rotate the specified edge left a degree
     * @param edge Index of the edge to change
     * @param amount Amount to rotate the vertex
     */
    public void RotateLeft(int edge, int amount) {
    }

    /**
     * Rotate the specified edge right a degree
     * @param edge Index of the edge to change
     * @param amount Amount to rotate the vertex
     */
    public void RotateRight(int edge, int amount) {
    }

    public void setSelection(int index, boolean vertex) {
        selected = true;
        selIndex = index;
        this.vertex = vertex;
    }

    public void clearSelection() {
        selected = false;
    }

    /**
     *
     * @param p the hit point for the selection
     * @return true if any part of the object was selected
     */
    public boolean selectPoint(Point p) {
        Rectangle r = (Rectangle) clickRect.clone();
        r.translate(p.x, p.y);
        selected = false;
        //Check vertices
        for (int i = 0; i < npoints; i++) {
            if (xpoints[i] >= r.x && xpoints[i] <= (r.x + r.width) &&
                ypoints[i] >= r.y && ypoints[i] <= (r.y + r.height)) {
//            if (r.contains(xpoints[i], ypoints[i])) {
                selected = true;
                selIndex = i;
                vertex = true;
                return true;
            }
        }
        //Check edges
        for (int i = 0; i < npoints; i++) {
            if (r.intersectsLine(xpoints[i], ypoints[i],
                xpoints[(i + 1) % npoints],
                ypoints[(i + 1) % npoints])) {
                selected = true;
                selIndex = i;
                vertex = false;
                return true;
            }
        }
        //Check interior
        if (this.intersects(r)) {
            selected = true;
            selIndex = -1;
            vertex = true;
            return true;
        }
        return false;
    }
}