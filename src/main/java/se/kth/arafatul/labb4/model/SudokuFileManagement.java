package se.kth.arafatul.labb4.model;

import javafx.stage.FileChooser;
import se.kth.arafatul.labb4.model.Box;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hints on how to implement serialization and deserialization
 * of lists of projects and users.
 */
public class SudokuFileManagement {
    public static void serializeToFile(Box[][] board) throws IOException {
        // ...
        // and then, make sure the file always get closed
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter(
                        "sudoku files", "*.sudoku");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Save sudoku File");
        File file = fileChooser.showSaveDialog(null);

        ObjectOutputStream oos = null;

        try {
            FileOutputStream fout = new FileOutputStream(file);
            oos = new ObjectOutputStream(fout);

            oos.writeObject(board);

            System.out.println("Serializing successfully completed");
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Box[][] deSerializeFromFile() throws IOException, ClassNotFoundException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter(
                        "sudoku files", "*.sudoku");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Open sudoku File");
        File file = fileChooser.showOpenDialog(null);

        // ...
        // and then, make sure the file always get closed
        ObjectInputStream ois = null;

        try {

            FileInputStream fin = new FileInputStream(file);
            ois = new ObjectInputStream(fin);

            // Downcast!
            Box[][] board = (Box[][]) ois.readObject();

            System.out.println("Deserializing successfully completed");
//            System.out.println(projects);

            return board;

        } catch (ClassNotFoundException e) { // !!!
            System.out.println("The class for this type of objects does " + "not exist in this application!");
            throw e;
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private SudokuFileManagement() {}
}
