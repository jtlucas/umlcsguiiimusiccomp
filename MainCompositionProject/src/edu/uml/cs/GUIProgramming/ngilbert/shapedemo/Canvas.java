/*
 * Canvas.java
 *
 * Created on Feb 17, 2009, 1:00:30 AM
 */
package edu.uml.cs.GUIProgramming.ngilbert.shapedemo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

/**
 *
 * @author Nathan Gilbert
 */
public class Canvas extends JPanel implements Scrollable {

    //array of shapes on this Canvas
    ArrayList<MovableShape> shapes = new ArrayList<MovableShape>();
    MovableShape selected = null;
    //buffer to hold
    BufferedImage buffer = new BufferedImage(1000, 1000,
        BufferedImage.TYPE_INT_RGB);
    //true if Canvas needs to be internally redrawn
    boolean dirty = true;
    //position in the buffer to map to the upper left corner of this Canvas
    Point position = new Point(0, 0);
    Point dragOrigin;

    public Canvas() {
        Resizer resizer = new Resizer(this);
        setBackground(Color.WHITE);
        addMouseListener(resizer);
        addMouseMotionListener(resizer);
        setSize(buffer.getWidth(), buffer.getHeight());
        //shapes.add(MovableShape.CreateRect(100, 100, 100, 100));
        //shapes.add(MovableShape.CreateRect(200, 200, 100, 100));
        shapes.add(MovableShape.CreateRegularNgon(new Point2D.Double(100, 100), 50, 3));
        shapes.add(MovableShape.CreateRegularNgon(new Point2D.Double(200, 100), 50, 4));
        shapes.add(MovableShape.CreateRegularNgon(new Point2D.Double(100, 200), 50, 5));
        shapes.add(MovableShape.CreateRegularNgon(new Point2D.Double(200, 200), 50, 6));
    }

    public Canvas(ArrayList<MovableShape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (dirty) {
            Graphics g2 = buffer.getGraphics();
            g2.clearRect(0, 0, buffer.getWidth(), buffer.getHeight());
            for (MovableShape ms : shapes) {
                ms.paint(g2);
            }
            dirty = false;
        }
        g.drawImage(buffer, -position.x, -position.y, this);
    }

    //<editor-fold defaultstate="collapsed" desc="Scrollable Methods">
    public Dimension getPreferredScrollableViewportSize() {
//        return getPreferredSize();
        return new Dimension(buffer.getWidth(), buffer.getHeight());
    }

    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        position.x = visibleRect.x;
        position.y = visibleRect.y;
        if (orientation == SwingConstants.HORIZONTAL) {
            if (direction < 0) {
                return Math.min(position.x, 1);
            } else {
                return Math.min(getWidth() - (buffer.getWidth() - position.x), 1);
            }
        } else if (direction < 0) {
            return Math.min(position.y, 1);
        } else {
            return Math.min(getHeight() - (buffer.getHeight() - position.y), 1);
        }
    }

    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        position.x = visibleRect.x;
        position.y = visibleRect.y;
        if (orientation == SwingConstants.HORIZONTAL) {
            if (getWidth() < 20) {
                return getScrollableUnitIncrement(visibleRect, orientation, direction);
            } else if (direction < 0) {
                return Math.min(position.x, 20);
            } else {
                return Math.min(getWidth() - (buffer.getWidth() - position.x), 1);
            }
        } else if (getHeight() < 20) {
            return getScrollableUnitIncrement(visibleRect, orientation, direction);
        } else if (direction < 0) {
            return Math.min(position.y, 20);
        } else {
            return Math.min(getHeight() - (buffer.getHeight() - position.y), 20);
        }
    }

    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    public boolean getScrollableTracksViewportHeight() {
        return false;
    }
    //</editor-fold>

    private int findShapeByName(String name) {
        for (int i = shapes.size() - 1; i >= 0; i--) {
            if (shapes.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean bringToFront(String name) {
        int index = findShapeByName(name);
        if (index >= 0) {
            MovableShape shape = shapes.get(index);
            shapes.remove(index);
            shapes.add(shape);
            return true;
        }
        return false;
    }

    public boolean sendToBack(String name) {
        int index = findShapeByName(name);
        if (index >= 0) {
            MovableShape shape = shapes.get(index);
            for (int i = 0; i <= index; i++) {
                shape = shapes.set(index, shape);
            }
            return true;
        }
        return false;
    }

    public String[] getShapeNames() {
        String[] names = new String[shapes.size()];
        for (int i = 0; i <= shapes.size(); i++) {
            names[i] = shapes.get(i).getName();
        }
        return names;
    }

    public boolean setShapeName(String oldName, String newName) {
        int oldIndex = findShapeByName(oldName);
        if (oldIndex >= 0) {
            int newIndex = findShapeByName(newName);
            if (newIndex == -1) {
                shapes.get(oldIndex).setName(newName);
                return true;
            }
        }
        return false;
    }

    public boolean deleteShape(String name) {
        int index = findShapeByName(name);
        if (index >= 0) {
            shapes.remove(index);
            return true;
        }
        return false;
    }
}

/**
 * MouseAdapter okay for j2se 1.6+
 * Use MouseInputAdapter for j2se 1.5-
 */
class Resizer extends MouseAdapter {

    Canvas component;
    boolean dragging = false;
    // Give user some leeway for selections.
    final int PROX_DIST = 3;

    public Resizer(Canvas r) {
        component = r;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        if (!dragging) {
            dragging = true;
            component.dragOrigin = e.getPoint();
            for (MovableShape ms : component.shapes) {
                ms.clearSelection();
            }
            for (int i = component.shapes.size() - 1; i >= 0; i--) {
                if (component.shapes.get(i).selectPoint(e.getPoint())) {
                    component.selected = component.shapes.get(i);
                    return;
                }
            }
            component.selected = null;
        }
    }

    public void mouseReleased(MouseEvent e) {
        dragging = false;
        component.dirty = true;
        component.repaint();
    }

    public void mouseDragged(MouseEvent e) {
        if (dragging && component.selected != null) {
            Point p = e.getPoint();
            p.translate(-component.dragOrigin.x, -component.dragOrigin.y);
            component.selected.Move(p);
            component.dragOrigin = e.getPoint();
//            Rectangle r = component.getBounds();
//            int type = component.getCursor().getType();
//            int dx = p.x - r.x;
//            int dy = p.y - r.y;
//            switch (type) {
//                case Cursor.N_RESIZE_CURSOR:
//                    int height = r.height - dy;
//                    r.setRect(r.x, r.y + dy, r.width, height);
//                    break;
//                case Cursor.NW_RESIZE_CURSOR:
//                    int width = r.width - dx;
//                    height = r.height - dy;
//                    r.setRect(r.x + dx, r.y + dy, width, height);
//                    break;
//                case Cursor.W_RESIZE_CURSOR:
//                    width = r.width - dx;
//                    r.setRect(r.x + dx, r.y, width, r.height);
//                    break;
//                case Cursor.SW_RESIZE_CURSOR:
//                    width = r.width - dx;
//                    height = dy;
//                    r.setRect(r.x + dx, r.y, width, height);
//                    break;
//                case Cursor.S_RESIZE_CURSOR:
//                    height = dy;
//                    r.setRect(r.x, r.y, r.width, height);
//                    break;
//                case Cursor.SE_RESIZE_CURSOR:
//                    width = dx;
//                    height = dy;
//                    r.setRect(r.x, r.y, width, height);
//                    break;
//                case Cursor.E_RESIZE_CURSOR:
//                    width = dx;
//                    r.setRect(r.x, r.y, width, r.height);
//                    break;
//                case Cursor.NE_RESIZE_CURSOR:
//                    width = dx;
//                    height = r.height - dy;
//                    r.setRect(r.x, r.y + dy, width, height);
//                    break;
//                default:
//                    System.out.println("unexpected type: " + type);
//            }
//            component.setBounds(r);
            component.dirty = true;
            component.repaint();
        }
    }

    public void mouseMoved(MouseEvent e) {
        Point p = e.getPoint();
        if (!isOverRect(p)) {
            if (component.getCursor() != Cursor.getDefaultCursor()) {
                // If cursor is not over rect reset it to the default.
                component.setCursor(Cursor.getDefaultCursor());
            }
            return;
        }
        // Locate cursor relative to center of rect.
        int outcode = getOutcode(p);
        Rectangle r = component.getBounds();
        switch (outcode) {
            case Rectangle.OUT_TOP:
                if (Math.abs(p.y - r.y) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                        Cursor.N_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_TOP + Rectangle.OUT_LEFT:
                if (Math.abs(p.y - r.y) < PROX_DIST &&
                    Math.abs(p.x - r.x) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                        Cursor.NW_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_LEFT:
                if (Math.abs(p.x - r.x) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                        Cursor.W_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_LEFT + Rectangle.OUT_BOTTOM:
                if (Math.abs(p.x - r.x) < PROX_DIST &&
                    Math.abs(p.y - (r.y + r.height)) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                        Cursor.SW_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_BOTTOM:
                if (Math.abs(p.y - (r.y + r.height)) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                        Cursor.S_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_BOTTOM + Rectangle.OUT_RIGHT:
                if (Math.abs(p.x - (r.x + r.width)) < PROX_DIST &&
                    Math.abs(p.y - (r.y + r.height)) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                        Cursor.SE_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_RIGHT:
                if (Math.abs(p.x - (r.x + r.width)) < PROX_DIST) {
                    component.setCursor(Cursor.getPredefinedCursor(
                        Cursor.E_RESIZE_CURSOR));
                }
                break;
            case Rectangle.OUT_RIGHT + Rectangle.OUT_TOP:
                if (Math.abs(p.x - (r.x + r.width)) < PROX_DIST &&
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
        Rectangle r = new Rectangle(0, 0, component.getBounds().width - 1,
            component.getBounds().height - 1);
        r.grow(-PROX_DIST, -PROX_DIST);
        return r.outcode(p.x, p.y);
    }

    /**
     * Make a larger Rectangle and check to see if the
     * cursor is over it.
     */
    private boolean isOverRect(Point p) {
        Rectangle r = new Rectangle(0, 0, component.getBounds().width - 1,
            component.getBounds().height - 1);
        r.grow(PROX_DIST, PROX_DIST);
        return r.contains(p);
    }
}