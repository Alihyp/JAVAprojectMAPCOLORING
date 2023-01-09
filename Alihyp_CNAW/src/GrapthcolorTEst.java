import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class GrapthcolorTEst {

    boolean eror_catching = false;
    public ArrayList<Addcolor> nodeList = new ArrayList<Addcolor>();
    public ArrayList<Color> colors = new ArrayList<>();

    public GrapthcolorTEst(ArrayList<Shape> nodeList){
        this.nodeList = shaplidtTOaddcolor(nodeList);
        for (int counter2 = 0; counter2 < nodeList.size(); counter2++){
            colors.add(new Color((int)Math.floor(Math.random()*(255-1+1)+1),
                    (int)Math.floor(Math.random()*(255-1+1)+1),
                    (int)Math.floor(Math.random()*(255-1+1)+1)));
        }
    }

    public void neiboredetection(){
        for (int counter1 = 0; counter1 < nodeList.size(); counter1++){
            for (int counter2 = counter1+1; counter2 < nodeList.size(); counter2++){
                if (nodeList.get(counter1).represention.intersects((Rectangle2D) nodeList.get(counter2).represention)){
                    addNeighbore(counter1, counter2);
                }
            }
        }
    }

    public void addNeighbore(int first_index, int second_index){
        Addcolor First = nodeList.get(first_index);
        Addcolor Second = nodeList.get(second_index);
        First.neighbores.add(Second);
        Second.neighbores.add(First);
    }



    // Eror catching requaried

    public Color colorNode(Color color, int index){
        neiboredetection();
        Addcolor currentNode = nodeList.get(index);
        for (Addcolor node: currentNode.neighbores){
            if (color == node.color){
                return null;
            }
        }

        currentNode.color = color;
        return color;

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

    // Assigns colors (starting from 0) to all vertices and
    // prints the assignment of colors

    public int[] greedyColoring(){

        int colornumber[] = new int[nodeList.size()];

        // Initialize all vertices as unassigned
        Arrays.fill(colornumber, -1);


        // Assign the first color to first vertex
        colornumber[0] = 0;


        // A temporary array to store the available colors. False
        // value of available[cr] would mean that the color cr is
        // assigned to one of its adjacent vertices

        boolean available[] = new boolean[nodeList.size()];

        // Initially, all colors are available
        Arrays.fill(available, true);

        // Assign colors to remaining V-1 vertices

        for (int counter = 1; counter < nodeList.size(); counter++){
            // Process all adjacent vertices and flag their colors
            // as unavailable
            Iterator<Integer> my_iter = (Iterator<Integer>) nodeList.get(counter);
            while (my_iter.hasNext()) {
                int i = my_iter.next();
                if (colornumber[i] != -1) {
                    available[colornumber[i]] = false;
                }
            }
            // Find the first available color
            int color;
            for (color = 0; color < nodeList.size(); color++){
                if (available[color]){
                    break;
                }
            }
            colornumber[counter] = color; // Assign the found color
            // Reset the values back to true for the next iteration
            Arrays.fill(available, true);
        }

        return colornumber;

    }

}