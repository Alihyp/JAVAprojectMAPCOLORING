import java.util.ArrayList;

public class GRAPTHTEST{
    public ArrayList<ShapetoGrapthTEST> nodeList = new ArrayList<ShapetoGrapthTEST>();

    public GRAPTHTEST(ArrayList<ShapetoGrapthTEST> nodeList){
        this.nodeList = nodeList;
    }

    public void addNeighbore(int first_index, int second_index){
        ShapetoGrapthTEST First = nodeList.get(first_index);
        ShapetoGrapthTEST Second = nodeList.get(second_index);
        First.neighbores.add(Second);
        Second.neighbores.add(First);
    }



    // Eror catching requaried

    public void colorNode(String color, int index) throws Exception{
        ShapetoGrapthTEST currentNode = nodeList.get(index);
        for (ShapetoGrapthTEST node: currentNode.neighbores){
            if (color == node.color){
                throw new Exception("neighbore color already in use");
            }
        }

        currentNode.color = color;
    }

    // Eror catching requaried



    public void printGrapth(){
        System.out.println();
        for (ShapetoGrapthTEST node: nodeList){
            System.out.print(node.name + " color of "+ node.color+ " ");
            for (ShapetoGrapthTEST node1: node.neighbores){
                System.out.print(node1.name + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
