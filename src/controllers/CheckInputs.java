package controllers;

import java.util.regex.Pattern;

public class CheckInputs {

    public static boolean isValidSentence(String txt) {
        return txt.contains("|");
    }

}
