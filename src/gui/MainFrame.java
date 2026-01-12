package gui;

import Printers.Printer;
import Printers.PrinterDummy;
import sequences.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("FieldCanBeLocal")
public class MainFrame extends JFrame {
    private JPanel outerPanel;
    private JComboBox<Sequence> sequencesComboBox;
    private JButton selectButton;
    private JTextField setMaxTextField;
    private JButton changeButton;
    private JButton quitButton;
    private JButton resetButton;
    private JButton creditsButton;
    private JTextArea sequenceTextArea;
    private JLabel maxLabel;
    private JPanel utilsPanel;
    private JButton showElementsButton;
    private JButton saveToFileButton;
    private JButton decomposeButton;
    private JButton sumButton;
    private JLabel sequenceLabel;
    private JLabel changeLimitLabel;
    private JLabel upperLimitLabel;

    private final Printer printer = new PrinterDummy();
    private Sequence sq = null;

    public MainFrame() {
        super();
        this.setContentPane(outerPanel);
        this.setTitle("Sequences");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initLook();
        lockSequence(false);
        // -- Actions
        quitButton.addActionListener(quitAction);
        creditsButton.addActionListener(this::creditsAction);
        selectButton.addActionListener(this::selectAction);
        changeButton.addActionListener(this::changeMaxAction);
        resetButton.addActionListener(this::resetAction);
    }

    private void initLook() {
        setMaxTextField.setColumns(10);
        updateMaxInfo();
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

    /**
     * @param lock - true if the sequence is selected
     */
    private void lockSequence(boolean lock) {
        // elements enabled if the sequence is selected
//        showElementsButton.setEnabled(lock);
//        saveToFileButton.setEnabled(lock);
//        decomposeButton.setEnabled(lock);
//        sumButton.setEnabled(lock);

        for (Component c : utilsPanel.getComponents()) {
            c.setEnabled(lock);
        }
        JComponent[] lst1 = {
                setMaxTextField,
                changeButton,
                maxLabel,
                changeLimitLabel,
                upperLimitLabel,
                resetButton
        };
        for (JComponent c : lst1) {
            c.setEnabled(lock);
        }

        // sequence selection elements
        JComponent[] lst2 = {
                selectButton,
                sequencesComboBox,
                sequenceLabel
        };
        for (JComponent c : lst2) {
            c.setEnabled(!lock);
        }

//        selectButton.setEnabled(!lock);
//        sequencesComboBox.setEnabled(!lock);
//        sequenceLabel.setEnabled(!lock);
    }

    private void updateMaxInfo() {
        String str = (sq == null ? "---" : Integer.toString(sq.getMax()));
        maxLabel.setText(str);
    }

    private void updateSequenceTextArea() {
        sequenceTextArea.setText(sq == null ? "" : printer.print(sq));
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // ---------- Actions -------------//

    private void resetAction(ActionEvent e) {
        lockSequence(false);
        sq = null;
        updateSequenceTextArea();
    }


    private void changeMaxAction(ActionEvent e) {
        String maxStr = setMaxTextField.getText().trim();
        try {
            int max = Integer.parseInt(maxStr);
            sq.setMax(max);
            updateSequenceTextArea();
            updateMaxInfo();
        } catch (NumberFormatException ex) {
            showError("Invalid number: " + maxStr);
        }
    }

    private void selectAction(ActionEvent e) {
        sq = (Sequence) sequencesComboBox.getSelectedItem();
        updateSequenceTextArea();
        updateMaxInfo();
        lockSequence(true);
    }

    private void creditsAction(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Developed by MS");
    }

    private final ActionListener quitAction = e -> {
        this.dispose();
    };
}
