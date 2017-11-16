package org.ulco;

import java.lang.reflect.Constructor;


public class JSON {
    static public GraphicsObject parse(String json) {
        GraphicsObject o = null;
        String str = json.replaceAll("\\s+", "");
        String type = str.substring(str.indexOf("type") + 5, str.indexOf(","));

        String nomClass = type.substring(0, 1).toUpperCase() + type.substring(1);
        Class classe;

        try {
            classe = Class.forName("org.ulco."+nomClass);
            Class[] params = new Class[]{String.class};

            Constructor ct = classe.getConstructor(params);

            o = (GraphicsObject)ct.newInstance(new String[]{str});
        } catch(Exception e) {
            e.printStackTrace();
        }

        /*if (type.compareTo("square") == 0) {
            o = new Square(str);
        } else if (type.compareTo("rectangle") == 0) {
            o = new Rectangle(str);
        } else if (type.compareTo("circle") == 0) {
            o = new Circle(str);
        }*/
        return o;
    }

    static public Group parseGroup(String json) {
        return new Group(json);
    }

    static public Layer parseLayer(String json) {
        return new Layer(json);
    }

    static public Document parseDocument(String json) {
        return new Document(json);
    }
}
