package models;

import dao.Saver;

import java.io.FileNotFoundException;

public interface SentenceSaver<T extends Saver> {
    void saveSentencesToFile(T saver) throws FileNotFoundException;
}
