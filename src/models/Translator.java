package models;

import dao.Saver;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * created by Ziemo Andrzejewski on 01/02/2018
 */
public class Translator implements SentenceRegistry, SentenceSaver, TranslatorFunctions{
    static final Comparator<Sentence> NUMBER_DECREASE_ORDER;
    //decrease sorting
    static {NUMBER_DECREASE_ORDER = new Comparator<Sentence>() {
        @Override
        public int compare(Sentence sentence1, Sentence sentence2) {
            if (sentence1.number > sentence2.number) {
                return -1;
            } else if (sentence1.number < sentence2.number) {
                return 1;
            }
            return 0;
        }
    };}

    private static int idx = 1;
    private List<Sentence> glossary;

    public List<Sentence> getGlossary() {
        return glossary;
    }

    public Translator(List<String> typeSentences, List<String> typeSentencesChecker) {
        idx = 1;
        this.glossary = new LinkedList<>();
        addSentencesToTranslator(typeSentences, typeSentencesChecker);
    }

    @Override
    public void addSentencesToTranslator(List<String> typeSentences, List<String> typeSentencesChecker) {
        for (int i = 0; i < typeSentences.size(); i++) {
            glossary.add(new Sentence(typeSentences.get(i), typeSentencesChecker.get(i)));
        }
    }

    @Override
    public void saveSentencesToFile(Saver saver) throws FileNotFoundException {
        LinkedList<String> newListSentences = new LinkedList<>();
        LinkedList<String> newListSentencesChecker = new LinkedList<>();

        for (int i = 0; i < glossary.size(); i++) {
            boolean isDoneSentence = glossary.get(i).isDone;
            String engSentence = glossary.get(i).eng;
            String polSentence = glossary.get(i).pol;
            String newSentence = String.join(",", engSentence, polSentence);
            newListSentences.add(newSentence);
            newListSentencesChecker.add(String.valueOf(isDoneSentence));
        }
        saver.saveSentences(newListSentences, newListSentencesChecker);
    }

    @Override
    public void addNewSentence(String newSentenceEng, String newSentencePol) {
        String newSentence = String.join(",", newSentenceEng, newSentencePol);
        glossary.add(new Sentence(newSentence, "false"));
        //add exceptions for ','
    }

    //test
    public void printGlossary() {
        Collections.sort(glossary);//, NUMBER_DECREASE_ORDER);
        for (Sentence i : glossary) {
            System.out.println(i.number + i.eng + i.pol);
        }
    }

    private class Sentence implements Comparable<Sentence> {
        private boolean isDone;
        private String eng;
        private String pol;
        private int number;

        public Sentence(String line, String isDone) {
            String[] lineList = line.split(",");
            this.eng = lineList[0];
            this.pol = lineList[1];
            if (isDone.equals("false")) {
                this.isDone = false;
            } else {
                this.isDone = true;
            }
            this.number = Translator.idx;
            Translator.idx++;
        }

        public boolean isDone() {
            return isDone;
        }

        public String getEng() {
            return eng;
        }

        public String getPol() {
            return pol;
        }

        public int getNumber() {
            return number;
        }

        @Override
        public int compareTo(Sentence sentence) {
            if (this.number > sentence.number) {
                return 1;
            } else if (this.number < sentence.number) {
                return -1;
            }
            return 0;
        }
    }


}

