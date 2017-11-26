package org.ulco;

import java.util.Vector;

public class Utilitaire {

    public static GraphicsObjects select(Point pt, double distance, Document doc) {
        Vector<Layer> listLayers = doc.getM_layers();
        GraphicsObjects list = new GraphicsObjects();

        for (Layer layer : listLayers) {
            list.addAll(Utilitaire.select(pt, distance, layer));
        }
        return list;
    }

    public static GraphicsObjects select(Point pt, double distance,  Layer lay) {
        Vector<GraphicsObject> listGraphicsObject = lay.getM_list();
        GraphicsObjects list = new GraphicsObjects();

        for (GraphicsObject object : listGraphicsObject) {
            if (object.isClosed(pt, distance)) {
                list.add(object);
            }
        }
        return list;
    }

    // constructeurs document
    public static Document create(Point origin, int line, int column, double length) {
        Document doc = new Document();
        Vector<Layer> m_layers = new Vector<Layer>();

        Layer layer = doc.createLayer();

        for (int indexX = 0; indexX < column; ++indexX) {
            for (int indexY = 0; indexY < line; ++indexY) {
                layer.add(new Square(new Point(origin.getX() + indexX * length, origin.getY() + indexY * length), length));
            }
        }

        return doc;
    }

    public static Document create(Point center, int number, double radius, double delta) {
        Document doc = new Document();
        Vector<Layer> m_layers = new Vector<Layer>();

        Layer layer = doc.createLayer();

        for (int index = 0; index < number; ++index) {
            layer.add(new Circle(center, radius + index * delta));
        }

        return doc;
    }
}
