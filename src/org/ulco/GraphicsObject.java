package org.ulco;

abstract public class GraphicsObject {
    public GraphicsObject() {
        m_ID = ID.getInstance().generateNextId();
    }

    abstract public GraphicsObject copy();

    public int getID() {
        return m_ID;
    }

    abstract boolean isClosed(Point pt, double distance);

    abstract void move(Point delta);

    abstract public String toJson();

    abstract public String toString();

    public boolean isGroup(){
        return false;
    }

    public int size() {
        return 1;
    }

    private int m_ID;
}
