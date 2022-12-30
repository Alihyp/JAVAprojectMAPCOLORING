import java.awt.*;
import java.util.ArrayList;

public class GrapthcolorTEst {
    public ArrayList<Addcolor> nodeList = new ArrayList<Addcolor>();



    public GrapthcolorTEst(ArrayList<Shape> nodeList){
        this.nodeList = shaplidtTOaddcolor(nodeList);
    }

    public void addNeighbore(int first_index, int second_index){
        Addcolor First = nodeList.get(first_index);
        Addcolor Second = nodeList.get(second_index);
        First.neighbores.add(Second);
        Second.neighbores.add(First);
    }



    // Eror catching requaried

    public void colorNode(Color color, int index) throws Exception{
        Addcolor currentNode = nodeList.get(index);
        for (Addcolor node: currentNode.neighbores){
            if (color == node.color){
                throw new Exception("neighbore color already in use");
            }
        }

        currentNode.color = color;
    }

    // Eror catching requaried



    public void printGrapth(){
        System.out.println();
        for (Addcolor node: nodeList){
            System.out.print(node.name + " color of "+ node.color+ " ");
            for (Addcolor node1: node.neighbores){
                System.out.print(node1.name + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public ArrayList<Addcolor> shaplidtTOaddcolor(ArrayList<Shape> List) {
        ArrayList<Addcolor> modifiedlist = new ArrayList<>();
        for (int counter = 0; counter < List.size(); counter++){
            modifiedlist.add(new Addcolor(List.get(counter)));
        }
        return modifiedlist;
    }

}