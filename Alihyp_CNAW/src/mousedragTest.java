import java.awt.*;

import javax.swing.*;

public class mousedragTest extends JFrame {

    public static void main(String[] args) {
//        mousedragTest mouse =  new mousedragTest();

        JFrame my_frame = new JFrame();
        my_frame.setLayout(new BorderLayout());
        JButton button = new JButton();
        button.setText("clic here");
        button.setFocusable(false);
//        button.setHorizontalTextPosition(JButton.BOTTOM);
        my_frame.setSize(1400, 800);
        my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PaintSurface paintSurface = new PaintSurface();
        my_frame.add(paintSurface, BorderLayout.CENTER);
        my_frame.setVisible(true);
    }

}