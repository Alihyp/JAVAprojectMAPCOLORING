import java.awt.BorderLayout;

import javax.swing.JFrame;

public class mousedragTest extends JFrame {

    public static void main(String[] args) {
        mousedragTest mouse =  new mousedragTest();
    }

    public mousedragTest() {
        this.setSize(1400, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PaintSurface paintSurface = new PaintSurface();
        this.add(paintSurface, BorderLayout.CENTER);
        this.setVisible(true);
    }

}