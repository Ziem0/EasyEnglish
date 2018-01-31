package models;

import controllers.CheckInputs;
import exceptions.WrongSentenceException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Box {
    public static List<Box> allBoxes = new ArrayList<>();
    public List<Sentence> sentences;
    private String name;

    public Box(String name) {
        this.sentences = new LinkedList<>();
        this.name = name;
        allBoxes.add(this);
    }

    public void addSentence(String line) throws WrongSentenceException {
        if (CheckInputs.isValidSentence(line)) {
            sentences.add(new Sentence(line));
        } else {
            throw new WrongSentenceException("Sentence should contain at least two words divided by |");
        }
    }

    public String getName() {
        return name;
    }

    private class Sentence {
        private String line;
        private boolean isDone;

        private Sentence(String line) {
            this.line = line;
            this.isDone = false;
        }
    }

}
