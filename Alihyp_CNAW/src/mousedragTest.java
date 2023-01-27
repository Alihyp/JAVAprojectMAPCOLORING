import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.*;

public class mousedragTest extends JFrame {

    Color color;
    static int button2int;
    static int my_color_index=0;
    public static void main(String[] args) {
        JFrame my_frame = new JFrame();
        my_frame.setLayout(new BorderLayout());

        JButton button1 = new JButton("Color Chooser");
        JButton button2 = new JButton("Orange");
        JButton button3 = new JButton("Magneta");
        JButton button4 = new JButton("Blue");
        JButton button5 = new JButton("cyan");
        JButton button6 = new JButton("green");
        JButton button7 = new JButton("red");
        JButton button8 = new JButton("map coloring");

        my_frame.setSize(1400, 800);

        JPanel myPanel =new JPanel();

        myPanel.add(button1);
        myPanel.add(button2);
        myPanel.add(button3);
        myPanel.add(button4);
        myPanel.add(button5);
        myPanel.add(button6);
        myPanel.add(button7);
        myPanel.add(button8);

        my_frame.add(myPanel,BorderLayout.NORTH);
        my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PaintSurface paintSurface = new mousedragTest().new PaintSurface();

        GrapthcolorTEst grapth2 = new GrapthcolorTEst(paintSurface.shapes);

        button1.addActionListener( ae ->{

//            ColorChooserFrame colorChooserFrame = new ColorChooserFrame(paintSurface);
//            colorChooserFrame.setVisible(true);

        } );

        button2.addActionListener( ae ->{
            my_color_index = 0;
        });

        button3.addActionListener( ae ->{
            my_color_index = 1;
        });
        button4.addActionListener( ae ->{
            my_color_index = 2;
        });

        button5.addActionListener( ae ->{
            my_color_index = 3;
        });

        button6.addActionListener( ae ->{
            my_color_index = 4;
        });

        button7.addActionListener( ae ->{
            my_color_index = 5;
        });

        button8.addActionListener( ae ->{
            Runnable r = () -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                suckObject o = new suckObject();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.setResizable(false);
                f.pack();

                f.setVisible(true);
            };
            SwingUtilities.invokeLater(r);
        });

        my_frame.add(paintSurface, BorderLayout.CENTER);
        my_frame.setVisible(true);
    }

    class PaintSurface extends JComponent {
        ArrayList<Shape> shapes = new ArrayList<Shape>();

        ArrayList<Color> arrayIndexColors = new ArrayList<>();
        ArrayList<Integer> userInputIndex = new ArrayList<>();
        Color color[];

        Point startDrag, endDrag;

        public PaintSurface() {
            this.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    startDrag = new Point(e.getX(), e.getY());
                    endDrag = startDrag;
//                repaint();

                }

                public void mouseReleased(MouseEvent e) {
                    Shape r = makeRectangle(startDrag.x, startDrag.y, e.getX(), e.getY());
                    shapes.add(r);
                    startDrag = null;
                    endDrag = null;
//                arrayIndexColors.add(UserInput());
//                userInputIndex.add(Index_User());
                    repaint();
                }
            });

            this.addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    endDrag = new Point(e.getX(), e.getY());
//                repaint();
                }
            });

        }
        private void paintBackground(Graphics2D g2){
            g2.setPaint(Color.LIGHT_GRAY);
            for (int i = 0; i < getSize().width; i += 10) {
                Shape line = new Line2D.Float(i, 0, i, getSize().height);
                g2.draw(line);
            }

            for (int i = 0; i < getSize().height; i += 10) {
                Shape line = new Line2D.Float(0, i, getSize().width, i);
                g2.draw(line);
            }


        }
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            paintBackground(g2);
            Color[] colors = {Color.ORANGE, Color.magenta, Color.BLUE, Color.cyan, Color.green, Color.RED};
            Color my_color;
            int colorIndex = 0;
            Color sameColor;

            g2.setStroke(new BasicStroke(2));
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));


            GrapthcolorTEst grapth = new GrapthcolorTEst(shapes);

            for (int i=0; i<grapth.nodeList.size(); i++) {
                g2.setPaint(Color.BLACK);
                g2.draw(grapth.nodeList.get(i).represention);
//                my_color = colors[(colorIndex++) % 6];
            my_color = colors[my_color_index];
                sameColor = grapth.colorNode(my_color, i);


//            if (sameColor != null) {
//                g2.draw(grapth.nodeList.get(i).represention);
//            }
//            g2.setColor(sameColor);
//            g2.fill(grapth.nodeList.get(i).represention);

            }

            for (int j=0; j < grapth.nodeList.size(); j++){
                if (grapth.nodeList.get(j).color == null){
                    // do nothing
                }
                else {
                    g.setColor(grapth.nodeList.get(j).color);
                    ((Graphics2D) g).fill(grapth.nodeList.get(j).represention);
                }
            }

            if (startDrag != null && endDrag != null) {
                g2.setPaint(Color.LIGHT_GRAY);
                Shape r = makeRectangle(startDrag.x, startDrag.y, endDrag.x, endDrag.y);
                g2.draw(r);
            }
        }

        public Rectangle2D.Float makeRectangle(int x1, int y1, int x2, int y2) {
            return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
        }


        public Color UserInput(){
            Color initialcolor = Color.RED;
            Color user_color=JColorChooser.showDialog(this,"Select a color",initialcolor);

            return user_color;
        }

        public int Index_User(){
            int input1 = 0;
            JFrame f = new JFrame();
            String user_input1 = JOptionPane.showInputDialog(f, "Enter a color index");
            if (user_input1 != null){
                input1 = Integer.parseInt(user_input1);
            }
            return input1;
        }

        public void setColor(Color color[]) {
            this.color = color;
        }
    }

}

//class PaintSurface extends JComponent {
//    ArrayList<Shape> shapes = new ArrayList<Shape>();
//
//    ArrayList<Color> arrayIndexColors = new ArrayList<>();
//    ArrayList<Integer> userInputIndex = new ArrayList<>();
//    Color color[];
//
//    Point startDrag, endDrag;
//
//    public PaintSurface() {
//        this.addMouseListener(new MouseAdapter() {
//            public void mousePressed(MouseEvent e) {
//                startDrag = new Point(e.getX(), e.getY());
//                endDrag = startDrag;
////                repaint();
//
//            }
//
//            public void mouseReleased(MouseEvent e) {
//                Shape r = makeRectangle(startDrag.x, startDrag.y, e.getX(), e.getY());
//                shapes.add(r);
//                startDrag = null;
//                endDrag = null;
////                arrayIndexColors.add(UserInput());
////                userInputIndex.add(Index_User());
//                repaint();
//            }
//        });
//
//        this.addMouseMotionListener(new MouseMotionAdapter() {
//            public void mouseDragged(MouseEvent e) {
//                endDrag = new Point(e.getX(), e.getY());
////                repaint();
//            }
//        });
//
//    }
//    private void paintBackground(Graphics2D g2){
//        g2.setPaint(Color.LIGHT_GRAY);
//        for (int i = 0; i < getSize().width; i += 10) {
//            Shape line = new Line2D.Float(i, 0, i, getSize().height);
//            g2.draw(line);
//        }
//
//        for (int i = 0; i < getSize().height; i += 10) {
//            Shape line = new Line2D.Float(0, i, getSize().width, i);
//            g2.draw(line);
//        }
//
//
//    }
//    public void paint(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        paintBackground(g2);
//        Color[] colors = {Color.ORANGE, Color.magenta, Color.BLUE, Color.cyan, Color.green, Color.RED};
//        Color my_color;
//        int colorIndex = 0;
//        Color sameColor;
//
//        g2.setStroke(new BasicStroke(2));
//        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));
//
//
//        GrapthcolorTEst grapth = new GrapthcolorTEst(shapes);
//
//        for (int i=0; i<grapth.nodeList.size(); i++) {
//            g2.setPaint(Color.BLACK);
//            g2.draw(grapth.nodeList.get(i).represention);
//            my_color = colors[(colorIndex++) % 6];
////            my_color = colors[mousedragTest.my_color_index];
//            sameColor = grapth.colorNode(my_color, i);
//
//
////            if (sameColor != null) {
////                g2.draw(grapth.nodeList.get(i).represention);
////            }
////            g2.setColor(sameColor);
////            g2.fill(grapth.nodeList.get(i).represention);
//
//        }
//
//        for (int j=0; j < grapth.nodeList.size(); j++){
//            if (grapth.nodeList.get(j).color == null){
//                // do nothing
//            }
//            else {
//                g.setColor(grapth.nodeList.get(j).color);
//                ((Graphics2D) g).fill(grapth.nodeList.get(j).represention);
//            }
//        }
//
//        if (startDrag != null && endDrag != null) {
//            g2.setPaint(Color.LIGHT_GRAY);
//            Shape r = makeRectangle(startDrag.x, startDrag.y, endDrag.x, endDrag.y);
//            g2.draw(r);
//        }
//    }
//
//    public Rectangle2D.Float makeRectangle(int x1, int y1, int x2, int y2) {
//        return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
//    }
//
//
//    public Color UserInput(){
//        Color initialcolor = Color.RED;
//        Color user_color=JColorChooser.showDialog(this,"Select a color",initialcolor);
//
//        return user_color;
//    }
//
//    public int Index_User(){
//        int input1 = 0;
//        JFrame f = new JFrame();
//        String user_input1 = JOptionPane.showInputDialog(f, "Enter a color index");
//        if (user_input1 != null){
//            input1 = Integer.parseInt(user_input1);
//        }
//        return input1;
//    }
//
//    public void setColor(Color color[]) {
//        this.color = color;
//    }
//}