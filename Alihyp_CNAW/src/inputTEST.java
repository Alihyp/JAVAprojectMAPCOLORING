import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class inputTEST {
//    public static void main(String[] args) {
//        createWindow();
//    }

    public String createWindow() {
        JFrame frame = new JFrame("Swing Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String answer = createUI(frame);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return answer;
    }

    public String createUI(final JFrame frame){
        final String[] answer = new String[1];
        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);

        JButton button = new JButton("Click Me!");
        final JLabel label = new JLabel();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = (String)JOptionPane.showInputDialog(
                        frame,
                        "Select one of the color",
                        "Swing Tester",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        "Red"
                );
                if(result != null && result.length() > 0){
                    label.setText("You selected:" + result);
                }else {
                    label.setText("None selected");
                }
                answer[0] = result;
            }
        });

        panel.add(button);
        panel.add(label);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        return answer[0];
    }
}