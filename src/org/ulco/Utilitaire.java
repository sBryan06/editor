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
}
