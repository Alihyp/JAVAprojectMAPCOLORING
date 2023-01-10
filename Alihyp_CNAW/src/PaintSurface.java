import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class PaintSurface extends JComponent {
    ArrayList<Shape> shapes = new ArrayList<Shape>();

    ArrayList<Color> arrayIndexColors = new ArrayList<>();

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
                arrayIndexColors.add(UserInput());
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
        Color[] colors = { Color.YELLOW, Color.MAGENTA, Color.CYAN , Color.RED, Color.BLUE, Color.PINK};
        Color my_color;
        int colorIndex = 0;
        Color sameColor;

        g2.setStroke(new BasicStroke(2));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));


        GrapthcolorTEst grapth = new GrapthcolorTEst(shapes);

        for (int i=0; i<grapth.nodeList.size(); i++) {
            g2.setPaint(Color.BLACK);
//            g2.draw(grapth.nodeList.get(i).represention);
//            my_color = colors[(colorIndex++) % 6];
            my_color = arrayIndexColors.get(i);
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
        int input1 = 0, input2 = 0, input3 = 0;
        JFrame f = new JFrame();
        String user_input1 = JOptionPane.showInputDialog(f, "Enter a red number betwheen 1, 255");
        JFrame f2 = new JFrame();
        String user_input2 = JOptionPane.showInputDialog(f2, "Enter a green number betwheen 1, 255");
        JFrame f3 = new JFrame();
        String user_input3 = JOptionPane.showInputDialog(f3, "Enter a blue number betwheen 1, 255");

        if (user_input1 != null){
            input1 = Integer.parseInt(user_input1);
        }
        if (user_input2 != null){
            input2 = Integer.parseInt(user_input2);
        }
        if (user_input3 != null){
            input3 = Integer.parseInt(user_input3);
        }

        Color user_color = new Color(input1, input2, input3);

        return user_color;
    }


}