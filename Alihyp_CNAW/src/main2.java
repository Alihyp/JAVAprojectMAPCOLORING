import javax.swing.*;
import java.util.ArrayList;

public class main2 {
    public static void main(String[] args) throws Exception {
        ArrayList<Addcolor> shapelist = new ArrayList<>();
//        GrapthcolorTEst grapth = new GrapthcolorTEst(shapelist);
//        grapth.addNeighbore(209, 292);
//        grapth.colorNode("black", 209);
//        grapth.colorNode("red", 292);

        Runnable r = () -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            show o = new show();

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
