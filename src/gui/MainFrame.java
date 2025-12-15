package gui;

import sequences.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Array;

@SuppressWarnings("FieldCanBeLocal")
public class MainFrame extends JFrame {
    private JPanel outerPanel;
    private JComboBox<Sequence> sequencesComboBox;
    private JButton selectButton;
    private JTextField textField1;
    private JButton changeButton;
    private JButton quitButton;
    private JButton resetButton;
    private JButton creditsButton;

    public MainFrame() {
        super();
        this.setContentPane(outerPanel);
        this.setTitle("Sequences");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initLook();
        // -- Actions
        quitButton.addActionListener(quitAction);
    }

    private void initLook() {
        sequencesComboBox.setModel(new DefaultComboBoxModel<>(
                        new Sequence[]{
                                new Integers(),
                                new Squares(),
                                new Primes(),
                                new Fibonacci()
                        }
                )
        );
    }

    private final ActionListener quitAction = e -> {
        this.dispose();
    };
}
