import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;

public class suckObject {

    public Object testIntersection;
    private JComponent ui = null;
    JLabel output = new JLabel();
    public static final int SIZE = 750;
    BufferedImage image;
    Area area;
    ArrayList<Shape> shapeList;

    public suckObject() {
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
        GrapthcolorTEst grapthcolorTEst = new GrapthcolorTEst(shapeList);

        grapthcolorTEst.addNeighbore(292, 209);
        grapthcolorTEst.addNeighbore(292, 339);
        grapthcolorTEst.addNeighbore(209, 182);
        grapthcolorTEst.addNeighbore(207, 182);
        grapthcolorTEst.addNeighbore(292, 182);
        grapthcolorTEst.addNeighbore(207, 292);
        grapthcolorTEst.addNeighbore(207, 209);
        grapthcolorTEst.addNeighbore(194, 292);
        grapthcolorTEst.addNeighbore(209, 194);
        grapthcolorTEst.addNeighbore(483, 485);
        grapthcolorTEst.addNeighbore(483, 473);
        grapthcolorTEst.addNeighbore(483, 465);
        grapthcolorTEst.addNeighbore(483, 460);
        grapthcolorTEst.addNeighbore(473, 469);
        grapthcolorTEst.addNeighbore(485, 460);
        grapthcolorTEst.addNeighbore(485, 455);
        grapthcolorTEst.addNeighbore(465, 469);
        grapthcolorTEst.addNeighbore(465, 460);
        grapthcolorTEst.addNeighbore(460, 469);
        grapthcolorTEst.addNeighbore(460, 455);
        grapthcolorTEst.addNeighbore(485, 460);
        grapthcolorTEst.addNeighbore(469, 455);
        grapthcolorTEst.addNeighbore(469, 424);
        grapthcolorTEst.addNeighbore(469, 415);
        grapthcolorTEst.addNeighbore(455, 430);
        grapthcolorTEst.addNeighbore(455, 424);
        grapthcolorTEst.addNeighbore(430, 424);
        grapthcolorTEst.addNeighbore(424, 415);
        grapthcolorTEst.addNeighbore(447, 439);
        grapthcolorTEst.addNeighbore(435, 438);
        grapthcolorTEst.addNeighbore(470, 462);
        grapthcolorTEst.addNeighbore(470, 466);
        grapthcolorTEst.addNeighbore(470, 459);
        grapthcolorTEst.addNeighbore(470, 463);
        grapthcolorTEst.addNeighbore(466, 462);
        grapthcolorTEst.addNeighbore(466, 456);
        grapthcolorTEst.addNeighbore(462, 459);
        grapthcolorTEst.addNeighbore(462, 459);
        grapthcolorTEst.addNeighbore(462, 456);
        grapthcolorTEst.addNeighbore(462, 454);
        grapthcolorTEst.addNeighbore(459, 463);
        grapthcolorTEst.addNeighbore(459, 454);
        grapthcolorTEst.addNeighbore(463, 452);
        grapthcolorTEst.addNeighbore(463, 454);
        grapthcolorTEst.addNeighbore(463, 450);
        grapthcolorTEst.addNeighbore(466, 462);
        grapthcolorTEst.addNeighbore(452, 454);
        grapthcolorTEst.addNeighbore(452, 450);
        grapthcolorTEst.addNeighbore(454, 456);
        grapthcolorTEst.addNeighbore(454, 451);
        grapthcolorTEst.addNeighbore(454, 450);
        grapthcolorTEst.addNeighbore(456, 451);
        grapthcolorTEst.addNeighbore(450, 451);
        grapthcolorTEst.addNeighbore(450, 419);
        grapthcolorTEst.addNeighbore(450, 429);
        grapthcolorTEst.addNeighbore(450, 420);
        grapthcolorTEst.addNeighbore(451, 419);
        grapthcolorTEst.addNeighbore(451, 404);
        grapthcolorTEst.addNeighbore(451, 407);
        grapthcolorTEst.addNeighbore(451, 431);
        grapthcolorTEst.addNeighbore(431, 425);
        grapthcolorTEst.addNeighbore(431, 407);
        grapthcolorTEst.addNeighbore(431, 410);
        grapthcolorTEst.addNeighbore(425, 410);
        grapthcolorTEst.addNeighbore(429, 420);
        grapthcolorTEst.addNeighbore(429, 406);
        grapthcolorTEst.addNeighbore(429, 419);
        grapthcolorTEst.addNeighbore(429, 404);
        grapthcolorTEst.addNeighbore(419, 404);
        grapthcolorTEst.addNeighbore(420, 406);
        grapthcolorTEst.addNeighbore(406, 404);
        grapthcolorTEst.addNeighbore(406, 340);
        grapthcolorTEst.addNeighbore(406, 382);
        grapthcolorTEst.addNeighbore(404, 382);
        grapthcolorTEst.addNeighbore(404, 407);
        grapthcolorTEst.addNeighbore(407, 382);
        grapthcolorTEst.addNeighbore(407, 386);
        grapthcolorTEst.addNeighbore(407, 410);
        grapthcolorTEst.addNeighbore(410, 382);
        grapthcolorTEst.addNeighbore(410, 302);
        grapthcolorTEst.addNeighbore(410, 386);
        grapthcolorTEst.addNeighbore(340, 382);
        grapthcolorTEst.addNeighbore(340, 382);
        grapthcolorTEst.addNeighbore(382, 382);
        grapthcolorTEst.addNeighbore(382, 386);
        grapthcolorTEst.addNeighbore(382, 306);
        grapthcolorTEst.addNeighbore(382, 310);
        grapthcolorTEst.addNeighbore(386, 310);
        grapthcolorTEst.addNeighbore(386, 356);
        grapthcolorTEst.addNeighbore(386, 402);
        grapthcolorTEst.addNeighbore(402, 356);
        grapthcolorTEst.addNeighbore(402, 395);
        grapthcolorTEst.addNeighbore(306, 310);
        grapthcolorTEst.addNeighbore(310, 313);
        grapthcolorTEst.addNeighbore(310, 272);
        grapthcolorTEst.addNeighbore(313, 283);
        grapthcolorTEst.addNeighbore(313, 307);
        grapthcolorTEst.addNeighbore(313, 338);
        grapthcolorTEst.addNeighbore(313, 368);
        grapthcolorTEst.addNeighbore(283, 258);
        grapthcolorTEst.addNeighbore(283, 307);
        grapthcolorTEst.addNeighbore(307, 338);
        grapthcolorTEst.addNeighbore(338, 368);
        grapthcolorTEst.addNeighbore(338, 354);
        grapthcolorTEst.addNeighbore(368, 368);
        grapthcolorTEst.addNeighbore(368, 356);
        grapthcolorTEst.addNeighbore(368, 373);
        grapthcolorTEst.addNeighbore(368, 400);
        grapthcolorTEst.addNeighbore(368, 388);
        grapthcolorTEst.addNeighbore(368, 354);
        grapthcolorTEst.addNeighbore(356, 368);
        grapthcolorTEst.addNeighbore(356, 395);
        grapthcolorTEst.addNeighbore(356, 373);
        grapthcolorTEst.addNeighbore(395, 373);
        grapthcolorTEst.addNeighbore(395, 394);
        grapthcolorTEst.addNeighbore(394, 373);
        grapthcolorTEst.addNeighbore(394, 399);
        grapthcolorTEst.addNeighbore(399, 368);
        grapthcolorTEst.addNeighbore(399, 373);
        grapthcolorTEst.addNeighbore(400, 373);
        grapthcolorTEst.addNeighbore(390, 388);
        grapthcolorTEst.addNeighbore(388, 354);
        grapthcolorTEst.addNeighbore(388, 368);
        grapthcolorTEst.addNeighbore(354, 390);
        grapthcolorTEst.addNeighbore(328, 349);
        grapthcolorTEst.addNeighbore(328, 352);
        grapthcolorTEst.addNeighbore(328, 329);
        grapthcolorTEst.addNeighbore(328, 300);
        grapthcolorTEst.addNeighbore(328, 278);
        grapthcolorTEst.addNeighbore(328, 277);
        grapthcolorTEst.addNeighbore(300, 329);
        grapthcolorTEst.addNeighbore(329, 352);
        grapthcolorTEst.addNeighbore(277, 368);
        grapthcolorTEst.addNeighbore(277, 378);
        grapthcolorTEst.addNeighbore(357, 323);
        grapthcolorTEst.addNeighbore(357, 335);
        grapthcolorTEst.addNeighbore(316, 309);
        grapthcolorTEst.addNeighbore(323, 315);
        grapthcolorTEst.addNeighbore(323, 309);
        grapthcolorTEst.addNeighbore(323, 335);
        grapthcolorTEst.addNeighbore(335, 309);
        grapthcolorTEst.addNeighbore(335, 301);
        grapthcolorTEst.addNeighbore(301, 285);
        grapthcolorTEst.addNeighbore(301, 309);
        grapthcolorTEst.addNeighbore(285, 384);
        grapthcolorTEst.addNeighbore(285, 309);
        grapthcolorTEst.addNeighbore(309, 384);
        grapthcolorTEst.addNeighbore(309, 221);
        grapthcolorTEst.addNeighbore(309, 226);
        grapthcolorTEst.addNeighbore(309, 232);
        grapthcolorTEst.addNeighbore(309, 242);
        grapthcolorTEst.addNeighbore(309, 255);
        grapthcolorTEst.addNeighbore(309, 296);
        grapthcolorTEst.addNeighbore(309, 384);
        grapthcolorTEst.addNeighbore(221, 226);
        grapthcolorTEst.addNeighbore(221, 226);
        grapthcolorTEst.addNeighbore(226, 232);
        grapthcolorTEst.addNeighbore(226, 227);
        grapthcolorTEst.addNeighbore(226, 257);
        grapthcolorTEst.addNeighbore(226, 186);
        grapthcolorTEst.addNeighbore(226, 158);
        grapthcolorTEst.addNeighbore(226, 231);
        grapthcolorTEst.addNeighbore(384, 296);
        grapthcolorTEst.addNeighbore(296, 274);
        grapthcolorTEst.addNeighbore(296, 291);
        grapthcolorTEst.addNeighbore(296, 255);
        grapthcolorTEst.addNeighbore(274, 226);
        grapthcolorTEst.addNeighbore(274, 291);
        grapthcolorTEst.addNeighbore(274, 255);
        grapthcolorTEst.addNeighbore(274, 251);
        grapthcolorTEst.addNeighbore(274, 260);
        grapthcolorTEst.addNeighbore(255, 242);
        grapthcolorTEst.addNeighbore(255, 251);
        grapthcolorTEst.addNeighbore(251, 260);
        grapthcolorTEst.addNeighbore(260, 291);
        grapthcolorTEst.addNeighbore(260, 257);
        grapthcolorTEst.addNeighbore(260, 232);
        grapthcolorTEst.addNeighbore(291, 257);
        grapthcolorTEst.addNeighbore(291, 245);
        grapthcolorTEst.addNeighbore(291, 241);
        grapthcolorTEst.addNeighbore(291, 278);
        grapthcolorTEst.addNeighbore(291, 259);
        grapthcolorTEst.addNeighbore(257, 232);
        grapthcolorTEst.addNeighbore(257, 245);
        grapthcolorTEst.addNeighbore(245, 227);
        grapthcolorTEst.addNeighbore(245, 241);
        grapthcolorTEst.addNeighbore(245, 227);
        grapthcolorTEst.addNeighbore(245, 226);
        grapthcolorTEst.addNeighbore(227, 241);
        grapthcolorTEst.addNeighbore(227, 231);
        grapthcolorTEst.addNeighbore(227, 259);
        grapthcolorTEst.addNeighbore(241, 259);
        grapthcolorTEst.addNeighbore(278, 268);
        grapthcolorTEst.addNeighbore(278, 259);
        grapthcolorTEst.addNeighbore(278, 277);
        grapthcolorTEst.addNeighbore(268, 259);
        grapthcolorTEst.addNeighbore(268, 227);
        grapthcolorTEst.addNeighbore(259, 231);
        grapthcolorTEst.addNeighbore(231, 225);
        grapthcolorTEst.addNeighbore(231, 202);
        grapthcolorTEst.addNeighbore(231, 190);
        grapthcolorTEst.addNeighbore(231, 186);
        grapthcolorTEst.addNeighbore(186, 190);
        grapthcolorTEst.addNeighbore(186, 158);
        grapthcolorTEst.addNeighbore(186, 188);
        grapthcolorTEst.addNeighbore(186, 202);
        grapthcolorTEst.addNeighbore(186, 168);
        grapthcolorTEst.addNeighbore(186, 177);
        grapthcolorTEst.addNeighbore(190, 202);
        grapthcolorTEst.addNeighbore(202, 202);
        grapthcolorTEst.addNeighbore(202, 188);
        grapthcolorTEst.addNeighbore(202, 212);
        grapthcolorTEst.addNeighbore(202, 225);
        grapthcolorTEst.addNeighbore(225, 212);
        grapthcolorTEst.addNeighbore(212, 208);
        grapthcolorTEst.addNeighbore(212, 188);
        grapthcolorTEst.addNeighbore(188, 177);
        grapthcolorTEst.addNeighbore(188, 183);
        grapthcolorTEst.addNeighbore(177, 183);
        grapthcolorTEst.addNeighbore(177, 170);
        grapthcolorTEst.addNeighbore(177, 168);
        grapthcolorTEst.addNeighbore(168, 158);
        grapthcolorTEst.addNeighbore(168, 179);
        grapthcolorTEst.addNeighbore(158, 212);
        grapthcolorTEst.addNeighbore(170, 183);
        grapthcolorTEst.addNeighbore(170, 183);
        grapthcolorTEst.addNeighbore(170, 168);
        grapthcolorTEst.addNeighbore(183, 248);
        grapthcolorTEst.addNeighbore(248, 210);
        grapthcolorTEst.addNeighbore(179, 170);
        grapthcolorTEst.addNeighbore(179, 159);
        grapthcolorTEst.addNeighbore(179, 167);
        grapthcolorTEst.addNeighbore(179, 210);
        grapthcolorTEst.addNeighbore(179, 183);
        grapthcolorTEst.addNeighbore(159, 167);
        grapthcolorTEst.addNeighbore(167, 210);
        grapthcolorTEst.addNeighbore(210, 258);
        grapthcolorTEst.addNeighbore(258, 252);
        grapthcolorTEst.addNeighbore(304, 335);
        grapthcolorTEst.addNeighbore(304, 301);
        grapthcolorTEst.addNeighbore(304, 285);
        grapthcolorTEst.addNeighbore(304, 384);
        grapthcolorTEst.addNeighbore(187, 248);
        grapthcolorTEst.addNeighbore(187, 210);
        grapthcolorTEst.addNeighbore(187, 179);
        grapthcolorTEst.addNeighbore(187, 183);
        grapthcolorTEst.addNeighbore(272, 310);
        grapthcolorTEst.addNeighbore(272, 313);
        grapthcolorTEst.addNeighbore(200, 208);
        grapthcolorTEst.addNeighbore(200, 188);
        grapthcolorTEst.addNeighbore(200, 183);
        grapthcolorTEst.addNeighbore(349, 340);
        grapthcolorTEst.addNeighbore(349, 306);
        grapthcolorTEst.addNeighbore(349, 282);
        grapthcolorTEst.addNeighbore(349, 277);
        grapthcolorTEst.addNeighbore(349, 328);
        grapthcolorTEst.addNeighbore(349, 352);
        grapthcolorTEst.addNeighbore(229, 212);
        grapthcolorTEst.addNeighbore(229, 225);
        grapthcolorTEst.addNeighbore(282, 306);
        grapthcolorTEst.addNeighbore(282, 277);



        // add *282 *229 *349 *200 *272 *187 *304



        grapthcolorTEst.colorNode(Color.BLACK, 292);
        grapthcolorTEst.colorNode(Color.GREEN, 209);
        grapthcolorTEst.colorNode(Color.RED, 339);
        grapthcolorTEst.colorNode(Color.BLUE, 182);
        grapthcolorTEst.colorNode(Color.yellow, 207);

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        output.addMouseMotionListener(new MousePositionListener());

        ui.add(output);

        refresh(grapthcolorTEst);
    }

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

    class MousePositionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            // do nothing
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            refresh(new GrapthcolorTEst(shapeList));
        }
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

    public void refresh(GrapthcolorTEst grapthcolorTEst) {
        output.setIcon(new ImageIcon(getImage(grapthcolorTEst)));
    }

    public BufferedImage getImage(GrapthcolorTEst grapthcolorTEst) {
        BufferedImage bi = new BufferedImage(
                2 * SIZE, SIZE, BufferedImage.TYPE_INT_RGB);

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
//            g.setColor(Color.GREEN);
//            g.fill(grapthcolorTEst.nodeList.get(209).represention);
//            g.setColor(Color.YELLOW);
//            g.fill(grapthcolorTEst.nodeList.get(207).represention);
//            g.setColor(Color.BLACK);
//            g.fill(grapthcolorTEst.nodeList.get(339).represention);
//            g.setColor(Color.BLUE);
//            g.fill(grapthcolorTEst.nodeList.get(182).represention);
//            g.setColor(Color.RED);
//            g.fill(grapthcolorTEst.nodeList.get(292).represention);
//            for (int i = 500; i < 550; i++){
//                g.fill(shapeList.get(i));
//            }

            for (Shape shape : shapeList){
                int index = (int)(Math.random() * shapeList.size());
                int random_int = (int)Math.floor(Math.random()*(shapeList.size()-1+1)+1);
                g.setColor(grapthcolorTEst.colors.get(random_int));
                g.fill(shape);
            }

            // greedy coloring

//            int[] colorsindex = grapthcolorTEst.greedyColoring();
//            for (int j = 0; j < shapeList.size(); j++){
//                g.setColor(grapthcolorTEst.colors.get(colorsindex[j]));
//                g.fill(shapeList.get(j));
//            }


//            for (Shape shape : shapeList) {
//                if (shape.contains(pointOnImage)) {
//                    g.setColor(Color.GREEN.darker());
//                    g.fill(shape);
//                    break;
//                }
//            }
        } catch (Exception doNothing) {
        }

        g.dispose();

        return bi;
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
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
    }
}
