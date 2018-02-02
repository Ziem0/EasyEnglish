package app;

import dao.Dao;
import models.Translator;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        Dao dao = new Dao(Dao.COMMONLY_SENTENCES, Dao.COMMONLY_SENTENCES_CHECKER);
        dao.loadSentences();

        Translator translator = new Translator(dao.getSentences(), dao.getBooleansForSentences());
//        translator.addNewSentence("This is saver1", "To jest zapisywacz1");
        translator.removeSentence(214);
        translator.printGlossary();
//        translator.saveSentencesToFile(dao);


        //SentenceRegistry
        //SentenceSaver
    }
}
