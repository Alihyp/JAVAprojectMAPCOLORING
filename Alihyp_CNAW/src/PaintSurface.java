import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PaintSurface extends JComponent {
    ArrayList<Shape> shapes = new ArrayList<Shape>();

    ArrayList<Color> arrayIndexColors = new ArrayList<>();
    ArrayList<Integer> userInputIndex = new ArrayList<>();

    Point startDrag, endDrag;

    public PaintSurface() {
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startDrag = new Point(e.getX(), e.getY());
                endDrag = startDrag;
                repaint();

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
                repaint();
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
//        for (int counter = 0; counter < arrayIndexColors.size(); counter++){
//            colors.add(arrayIndexColors.get(counter));
//        }
//        Color[] colors = {new Color(100, 0, 0), new Color(0, 100, 0), new Color(0, 0, 100)};
//
//        colors.add(new Color(100, 0, 0));
//        colors.add(new Color(0, 0, 100));
//        colors.add(new Color(0, 100, 0));

        Color my_color;
        int colorIndex = 0;
        Color sameColor;

        g2.setStroke(new BasicStroke(2));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));


        GrapthcolorTEst grapth = new GrapthcolorTEst(shapes);

        for (int i=0; i<grapth.nodeList.size(); i++) {
            g2.setPaint(Color.BLACK);
            g2.draw(grapth.nodeList.get(i).represention);
            my_color = colors[(colorIndex++) % 6];
//            my_color = colors.get(i%colors.size());
//            my_color = arrayIndexColors.get(i);
//            my_color = colors[userInputIndex.get(i) % 6];
            sameColor = grapth.colorNode(my_color, i);


            if (sameColor != null) {
                g2.draw(grapth.nodeList.get(i).represention);
            }
            g2.setColor(sameColor);
            g2.fill(grapth.nodeList.get(i).represention);

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
//        int input1 = 0, input2 = 0, input3 = 0;
//        JTextField RedField = new JTextField(5);
//        JTextField GreenField = new JTextField(5);
//        JTextField BlueField = new JTextField(5);
//        JPanel myPanel = new JPanel();
//        myPanel.add(new JLabel("Red(1-255):"));
//        myPanel.add(RedField);
//        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
//        myPanel.add(new JLabel("Green(1-255):"));
//        myPanel.add(GreenField);
//        myPanel.add(Box.createHorizontalStrut(15));
//        myPanel.add(new JLabel("Blue(1-255):"));
//        myPanel.add(BlueField);
//        int result = JOptionPane.showConfirmDialog(null, myPanel,
//                "Please Enter RGB for a color", JOptionPane.OK_CANCEL_OPTION);
//        if (result == JOptionPane.OK_OPTION) {
//            if (RedField != null){
//                input1 = Integer.parseInt(RedField.getText());
//            }
//            if (GreenField != null){
//                input2 = Integer.parseInt(GreenField.getText());
//            }
//            if (BlueField != null){
//                input3 = Integer.parseInt(BlueField.getText());
//            }
//        }
//
//        Color user_color = new Color(input1, input2, input3);

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


}