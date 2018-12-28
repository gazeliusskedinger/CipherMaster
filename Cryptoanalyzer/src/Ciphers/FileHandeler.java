package Ciphers;

import java.io.File;
import java.util.Scanner;

public class FileHandeler {

    /**
     * Reads an file
     * @param filepath
     * @return String
     */

    public String readFile(String filepath) {
        String text = "";
        File file = new File(filepath);
        try {
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                text = text + in.nextLine() + "\n";
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public void saveFile(String filePath, String text){

    }

    public void makeFile(String filePath){
        File file = new File(filePath);


    }
}