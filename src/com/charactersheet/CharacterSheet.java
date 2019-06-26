package com.charactersheet;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CharacterSheet {
    private JButton btnSave;
    private JPanel panelMain;
    private JTabbedPane tabPane;
    private JTextField txtCharacterName;
    private JTextField textField1;
    private JPanel pnlCharacterInfo;
    private JButton btnOpen;

    private CharacterSheetService characterSheetService;
    private final FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JSON file", "json");

    public CharacterSheet() {
        CharacterModel characterModel = new CharacterModel();
        characterSheetService = new CharacterSheetService(characterModel);

        // Save
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = openFile();
                characterSheetService.saveToFile(file);
            }
        });

        // Open
        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = openFile();
                characterSheetService.readFromFile(file);
            }
        });
    }

    private File openFile()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        File file = null;
        if (fileChooser.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {

            file = fileChooser.getSelectedFile();
        }

        return file;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Character Sheet");
        frame.setContentPane(new CharacterSheet().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
