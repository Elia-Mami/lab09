package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final String TITLE = "This is a simple gui";
    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller = new SimpleController();

    public SimpleGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextField text = new JTextField();
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JButton printButton = new JButton("Print");
        JButton showHistoryButton = new JButton("Show history");
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        //ActionListeners
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setNextString(text.getText());
                controller.printCurrentString();
            }
        });
        showHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String history = "";
                for(String currentString : controller.getStringHistory()){
                    history = history + currentString + " ";
                }
                textArea.setText(history);
            }
        });
        //Adding components
        panel.add(text, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(printButton, BorderLayout.BEFORE_FIRST_LINE);
        bottomPanel.add(showHistoryButton, BorderLayout.AFTER_LAST_LINE);
        //Setting dimensions
        frame.setContentPane(panel);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setLocationByPlatform(true);
    }

    public void display(){
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SimpleGUI simpleGUI = new SimpleGUI();
        simpleGUI.display();
    }
}
