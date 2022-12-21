import javax.swing.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws Exception {
//        ArrayList<GrapthNode> nodeList = new ArrayList<GrapthNode>();
//        nodeList.add(new GrapthNode("america", 0));
//        nodeList.add(new GrapthNode("canada", 1));
//        nodeList.add(new GrapthNode("mexico", 2));
//
//        Grapth grapth = new Grapth(nodeList);

//        grapth.addNeighbore(0, 1);
//        grapth.addNeighbore(1, 2);
//        grapth.addNeighbore(2, 0);
//
//        grapth.printGrapth();
//
//        grapth.colorNode("black", 0);
//        grapth.colorNode("white", 1);
//        grapth.colorNode("yellow", 2);
//
//        grapth.printGrapth();
//
//        nodeList.add(new GrapthNode("alaska", 3));
//        grapth.addNeighbore(3, 0);
//        grapth.colorNode("black", 3);

//    StackoverFlow map = new StackoverFlow();
//    StackoverFlow.MousePositionListener;

//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        MapToObj map = new MapToObj();
//        System.out.println(map.shapeList);
//
//        JFrame f = new JFrame(map.getClass().getSimpleName());
//        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        f.setLocationByPlatform(true);
//
//        f.setContentPane(map.getUI());
//        f.setResizable(false);
//        f.pack();
//
//        f.setVisible(true);

        ArrayList<ShapetoGrapthTEST> nodeList = new ArrayList<ShapetoGrapthTEST>();
        nodeList.add(new ShapetoGrapthTEST());
        nodeList.add(new ShapetoGrapthTEST());
        nodeList.add(new ShapetoGrapthTEST());
        nodeList.get(0).name = "america";
        nodeList.get(1).name = "canada";
        nodeList.get(2).name = "mexic";
//        nodeList.get(0).color = "black";
//        nodeList.get(1).color = "white";
//        nodeList.get(2).color = "red";

        GRAPTHTEST grapth = new GRAPTHTEST(nodeList);
        grapth.colorNode("black", 0);
        grapth.colorNode("white", 1);
        grapth.colorNode("yellow", 2);

        grapth.addNeighbore(0, 1);
        grapth.addNeighbore(1, 2);
        grapth.addNeighbore(2, 0);

        grapth.printGrapth();

//        nodeList.add(new ShapetoGrapthTEST());
//        nodeList.get(3).name = "russia";
//        grapth.addNeighbore(3, 0);
//        grapth.colorNode("black", 3);

        grapth.printGrapth();

        Runnable r = () -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
//            StackoverFlow o = new StackoverFlow();
            ShapetoGrapthTEST o = new ShapetoGrapthTEST();

            JFrame f = new JFrame(o.getClass().getSimpleName());
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationByPlatform(true);

            f.setContentPane(o.getUI());
            f.setResizable(false);
            f.pack();

            f.setVisible(true);
        };
        SwingUtilities.invokeLater(r);


    }
}
