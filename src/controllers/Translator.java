package controllers;

import dao.Dao;
import exceptions.WrongSentenceException;

import java.io.IOException;

public class Translator {

    public static final String COMMONLY_SENTENCES = "src/resources/commonlySentences.csv";
    public static final String GRAMMA_SENTENCES = "src/resources/grammaSentences.csv";
    public static final String IT_SENTENCES = "src/resources/itSentences.csv";


    public static void main(String[] args) throws IOException, WrongSentenceException {
        Dao.loadFile("common", COMMONLY_SENTENCES);



    }
}
