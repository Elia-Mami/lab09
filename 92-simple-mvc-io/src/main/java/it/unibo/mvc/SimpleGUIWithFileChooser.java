package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final String TITLE = "My gui java applications with file chooser";
    private final JFrame frame = new JFrame(TITLE);
    private Controller controller = new Controller();

    public SimpleGUIWithFileChooser(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        JTextField textField = new JTextField(controller.GetCurrentFilePath());
        textField.setEditable(false);
        JButton browseButton = new JButton("Browse...");
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser("Choose where to save...");
                int result = chooser.showSaveDialog(frame);
                switch(result){
                    case JFileChooser.APPROVE_OPTION:
                        controller.ChangeCurrentFile(chooser.getSelectedFile());
                        textField.setText(controller.GetCurrentFilePath());
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    default:
                    JOptionPane.showMessageDialog(frame, result, "Error!", JOptionPane.ERROR_MESSAGE);
                        break;
                }
                controller.ChangeCurrentFile(chooser.getSelectedFile());
                textField.setText(controller.GetCurrentFilePath());
            }
        });
        panel.add(topPanel, BorderLayout.NORTH);
        topPanel.add(textField, BorderLayout.CENTER);
        topPanel.add(browseButton, BorderLayout.LINE_END);
        frame.setContentPane(panel);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 4, sh / 4);
        frame.setLocationByPlatform(true);
    }

    public void display(){
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SimpleGUIWithFileChooser simpleGUIWithFileChooser = new SimpleGUIWithFileChooser();
        simpleGUIWithFileChooser.display();
    }

}
