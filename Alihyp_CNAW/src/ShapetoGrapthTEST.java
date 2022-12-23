import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import java.awt.event.MouseEvent;

public class ShapetoGrapthTEST {
    public String name;
    public String color;
    public int index;
    public ArrayList<ShapetoGrapthTEST> neighbores = new ArrayList<ShapetoGrapthTEST>();

    private JComponent ui = null;
    JLabel output = new JLabel();
    public static final int SIZE = 750;
    BufferedImage image;
    Area area;
    ArrayList<Shape> shapeList;

    public ShapetoGrapthTEST() {
        try {
            initUI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public final void initUI() throws Exception {
        if (ui != null) {
            return;
        }
        URL url = new URL("https://i.stack.imgur.com/N4eOn.png");
        image = ImageIO.read(url);
        long then = System.currentTimeMillis();
        System.out.println("" + then);
        area = getOutline(Color.WHITE, image, 12);
        long now = System.currentTimeMillis();
        System.out.println("Time in mins: " + (now - then) / 60000d);
        shapeList = separateShapeIntoRegions(area);
        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        output.addMouseMotionListener(new ShapetoGrapthTEST.MousePositionListener());

        ui.add(output);

        refresh();
    }



    // Not complete yet ---------------------------------------------------------------------
    private void refresh() {
        output.setIcon(new ImageIcon(getImage()));
    }

    // Not complete yet ---------------------------------------------------------------------


    public Area getOutline(Color target, BufferedImage bi, int tolerance) {
        // construct the GeneralPath
        GeneralPath gp = new GeneralPath();

        boolean cont = false;
        for (int xx = 0; xx < bi.getWidth(); xx++) {
            for (int yy = 0; yy < bi.getHeight(); yy++) {
                if (isIncluded(new Color(bi.getRGB(xx, yy)), target, tolerance)) {
                    //if (bi.getRGB(xx,yy)==targetRGB) {
                    if (cont) {
                        gp.lineTo(xx, yy);
                        gp.lineTo(xx, yy + 1);
                        gp.lineTo(xx + 1, yy + 1);
                        gp.lineTo(xx + 1, yy);
                        gp.lineTo(xx, yy);
                    } else {
                        gp.moveTo(xx, yy);
                    }
                    cont = true;
                } else {
                    cont = false;
                }
            }
            cont = false;
        }
        gp.closePath();

        // construct the Area from the GP & return it
        return new Area(gp);
    }

    public ArrayList<Shape> separateShapeIntoRegions(Shape shape) {
        ArrayList<Shape> regions = new ArrayList<>();

        PathIterator pi = shape.getPathIterator(null);
        GeneralPath gp = new GeneralPath();
        while (!pi.isDone()) {
            double[] coords = new double[6];
            int pathSegmentType = pi.currentSegment(coords);
            int windingRule = pi.getWindingRule();
            gp.setWindingRule(windingRule);
            if (pathSegmentType == PathIterator.SEG_MOVETO) {
                gp = new GeneralPath();
                gp.setWindingRule(windingRule);
                gp.moveTo(coords[0], coords[1]);
            } else if (pathSegmentType == PathIterator.SEG_LINETO) {
                gp.lineTo(coords[0], coords[1]);
            } else if (pathSegmentType == PathIterator.SEG_QUADTO) {
                gp.quadTo(coords[0], coords[1], coords[2], coords[3]);
            } else if (pathSegmentType == PathIterator.SEG_CUBICTO) {
                gp.curveTo(
                        coords[0], coords[1],
                        coords[2], coords[3],
                        coords[4], coords[5]);
            } else if (pathSegmentType == PathIterator.SEG_CLOSE) {
                gp.closePath();
                regions.add(new Area(gp));
            } else {
                System.err.println("Unexpected value! " + pathSegmentType);
            }

            pi.next();
        }

        return regions;
    }

    public static boolean isIncluded(Color target, Color pixel, int tolerance) {
        int rT = target.getRed();
        int gT = target.getGreen();
        int bT = target.getBlue();
        int rP = pixel.getRed();
        int gP = pixel.getGreen();
        int bP = pixel.getBlue();
        return ((rP - tolerance <= rT) && (rT <= rP + tolerance)
                && (gP - tolerance <= gT) && (gT <= gP + tolerance)
                && (bP - tolerance <= bT) && (bT <= bP + tolerance));
    }

    public BufferedImage getImage() {
        BufferedImage bi = new BufferedImage(2 * SIZE, SIZE, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bi.createGraphics();
        g.drawImage(image, 0, 0, output);
        g.setColor(Color.ORANGE.darker());
        g.fill(area);
        g.setColor(Color.RED);
        g.draw(area);
        try {
            Point p = MouseInfo.getPointerInfo().getLocation();
            Point p1 = output.getLocationOnScreen();
            int x = p.x - p1.x;
            int y = p.y - p1.y;
            Point pointOnImage = new Point(x, y);
            for (Shape shape : shapeList) {
                if (shape.contains(pointOnImage)) {
//                    inputTEST window = new inputTEST();
//                    this.color = window.createWindow();
                    g.setColor(Color.GREEN.darker());
                    g.fill(shape);
//                    Point2D clicked =  ;
//                    if (shape.contains(clicked))
                    break;
                }
            }
        } catch (Exception doNothing) {
        }

        g.dispose();

        return bi;
    }

    class MousePositionListener implements MouseMotionListener, MouseListener {

        @Override
        public void mouseClicked(MouseEvent e){
//            Point clicked = new getPoint();
//            inputTEST window = new inputTEST();
//            for (Shape shape : shapeList){
//                if (shape.contains(clicked)){
//                    color = window.createWindow();
//                }
//            }
            inputTEST window = new inputTEST();
            color = window.createWindow();
            System.out.println("clicked");
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        //------------------------------------------------------
        @Override
        public void mouseDragged(MouseEvent e) {
            // NOT COMPLETE
        }
        //------------------------------------------------------

        @Override
        public void mouseMoved(MouseEvent e) {
            refresh();
        }

        private class getPoint extends Point {

        }
    }

    public JComponent getUI() {
        return ui;
    }
}

