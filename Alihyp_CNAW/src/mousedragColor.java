import java.awt.*;
import java.util.ArrayList;

public class mousedragColor {
    public Color color;
    public String name;
    public Shape represention;

    public ArrayList<Addcolor> neighbores = new ArrayList<>();

    public mousedragColor(Shape shape){
        this.represention = shape;
    }

}
