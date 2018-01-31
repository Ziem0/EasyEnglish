package dao;

import exceptions.WrongSentenceException;
import models.Box;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Dao {

    public static void loadFile(String boxName ,String filePath) throws IOException, WrongSentenceException {
        Box box = new Box(boxName);
        FileReader fr = null;
        String line = "";

        try {
            fr = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("There is no file " + filePath);
        }

        BufferedReader bf = new BufferedReader(fr);

        while ((line = bf.readLine()) != null) {
            System.out.println(line);
            box.addSentence(line);
        }
    }
}
