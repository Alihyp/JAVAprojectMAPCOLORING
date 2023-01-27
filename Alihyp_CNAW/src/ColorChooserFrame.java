//import javax.swing.*;
//import java.awt.*;
//
//public class ColorChooserFrame extends JFrame {
//
//    JColorChooser colorChooser;
//    ColorChooserFrame(PaintSurface paint){
//
//        setLayout(new BorderLayout());
//        setSize(400,400);
//        setTitle("Color Chooser");
//        colorChooser = new JColorChooser();
//        add(colorChooser);
//
//        JButton ok = new JButton("Ok");
//
//        ok.addActionListener(ae->{
//
//            if(colorChooser.getColor() != null)
////                paint.setColor(colorChooser.getColor());
//            setVisible(false);
//
//        });
//
//        JPanel panel=new JPanel();
//        panel.add(ok);
//        add(panel,BorderLayout.SOUTH);
//
//    }
//
//    private Color getColor(){
//
//        return  colorChooser.getColor();
//
//    }
//
//}
