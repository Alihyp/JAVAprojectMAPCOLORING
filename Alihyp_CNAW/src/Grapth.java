import java.util.ArrayList;

public class Grapth {
    public ArrayList<GrapthNode> nodeList = new ArrayList<GrapthNode>();



    public Grapth(ArrayList<GrapthNode> nodeList){
        this.nodeList = nodeList;
    }

    public void addNeighbore(int first_index, int second_index){
        GrapthNode First = nodeList.get(first_index);
        GrapthNode Second = nodeList.get(second_index);
        First.neighbores.add(Second);
        Second.neighbores.add(First);
    }



    // Eror catching requaried

    public void colorNode(String color, int index) throws Exception{
        GrapthNode currentNode = nodeList.get(index);
        for (GrapthNode node: currentNode.neighbores){
            if (color == node.color){
                throw new Exception("neighbore color already in use");
            }
        }

        currentNode.color = color;
    }

    // Eror catching requaried



    public void printGrapth(){
        System.out.println();
        for (GrapthNode node: nodeList){
            System.out.print(node.name + " color of "+ node.color+ " ");
            for (GrapthNode node1: node.neighbores){
                System.out.print(node1.name + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
