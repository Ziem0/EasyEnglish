package dao;

import java.io.FileNotFoundException;
import java.util.List;

public interface Saver {
    void saveSentences(List<String> newListSentencesChecker, List<String> newListSentences) throws FileNotFoundException;
}
