import java.awt.*;

import javax.swing.*;

public class mousedragTest extends JFrame {

    public static void main(String[] args) {
        mousedragTest mouse =  new mousedragTest();
    }

    public mousedragTest() {
        setLayout(new BorderLayout());
        this.setSize(1400, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel=new JPanel();
        JButton button = new JButton("click here");
        panel.add(button);
        button.addActionListener(ae->{
                    System.out.println("vdthdrhsdht");

                }
                );
        add(panel,BorderLayout.SOUTH);
        PaintSurface paintSurface = new PaintSurface();
        this.add(paintSurface, BorderLayout.CENTER);
        this.setVisible(true);
    }

}