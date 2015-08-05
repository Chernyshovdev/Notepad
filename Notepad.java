package homework7.notepad;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Razer on 31.07.15.
 */
public class Notepad {
    private final String PATH = "/Users/johnsmith/IdeaProjects/ACO3/src/homework7/notepad/";
    private final String DEFAULT_NAME_OF_FILE = "notepad.txt";
    private JFrame jFrame;

    public Notepad(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    public void saveButton(String text) throws IOException {
        String nameOfFile = JOptionPane.showInputDialog(jFrame,
                "Enter name of file:", "notepad");
        if (nameOfFile.equals("")) {
            nameOfFile = DEFAULT_NAME_OF_FILE;
        }
        File file = new File(PATH + nameOfFile + ".txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter Writer = new FileWriter(file);
        Writer.write(text);
        Writer.close();
    }

    public String openButton() throws FileNotFoundException {
        String text = "";
        String nameOfFile = JOptionPane.showInputDialog(jFrame, "Enter name of file to open:", "notepad");
        try (Scanner scanner = new Scanner(new File(PATH + nameOfFile + ".txt"))) {
            while (scanner.hasNext()) {
                text = scanner.nextLine();
            }
        }
        return text;
    }
}
