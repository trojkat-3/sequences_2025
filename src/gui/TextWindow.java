package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TextWindow extends JDialog {
    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton closeButton;

    public TextWindow(String title, String text) {
        setContentPane(mainPanel);
        this.setTitle(title);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        textArea.setText(text);
        textArea.setEditable(false);
        //setModal(true);
        //this.pack();
        closeButton.addActionListener(this::closeAction);
    }

    private void closeAction(ActionEvent e) {
        dispose();
    }
}
