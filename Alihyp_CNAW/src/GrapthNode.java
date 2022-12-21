import java.util.ArrayList;

public class GrapthNode {
    public String name;
    public String color;
    public int index;
    public ArrayList<GrapthNode> neighbores = new ArrayList<GrapthNode>();

    public GrapthNode(String name, int index){
        this.name = name;
        this.index = index;
    }

    // there must be a coloring method
}
