package com.charactersheet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterSheet {
    private JButton btnSave;
    private JPanel panelMain;
    private JTabbedPane tabPane;
    private JTextField txtCharacterName;
    private JTextField textField1;
    private JPanel pnlCharacterInfo;
    private JButton btnOpen;

    public CharacterSheet() {
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello World");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Character Sheet");
        frame.setContentPane(new CharacterSheet().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
