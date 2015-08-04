package homework7.notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Razer on 31.07.15.
 */
public class VisualInterface extends JFrame {


    private static final String TITLE = "Notepad";
    JTextArea textArea=new JTextArea();
    private JFrame jFrame=new JFrame();
    Notepad notepad = new Notepad(jFrame);
    private JMenuItem openButton;
    private JMenuItem saveButton;


    public VisualInterface() {
        super(TITLE);
        init();
    }

    private void init() {
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setupMenu();
        setupTextArea();


    }

    private void setupTextArea() {
        JScrollPane jScrollBar=new JScrollPane(textArea,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textArea.setLineWrap(true);
        textArea.setEditable(true);
        textArea.setBackground(Color.gray);
        getContentPane().add(textArea);
    }


    private void setupMenu() {
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("File");

        openButton=new JMenuItem("Open");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            try{textArea.setText(notepad.openButton());}
            catch (FileNotFoundException e1){
                JOptionPane.showMessageDialog(jFrame, "Error,file not found!", " ", JOptionPane.ERROR_MESSAGE);
            }
            }
        });

        saveButton=new JMenuItem("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    notepad.saveButton(textArea.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        bar.add(menu);
        menu.add(openButton);
        menu.add(saveButton);
        setJMenuBar(bar);
    }



}
