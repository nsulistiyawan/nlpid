/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlpid.sentenceDetector;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author n
 */
public class RuleBasedSentenceDetector implements SentenceDetectorInterface {

    private List<String> abbreviations;

    public void setAbbreviations(List<String> abbreviations) {
        this.abbreviations = abbreviations;
    }

    public List<String> getAbbreviations() {
        return abbreviations;
    }

    private void initAbbreviations() {
        List<String> abbreviationsDict = new ArrayList<>();
        Scanner s = new Scanner(getClass().getResourceAsStream("/abbreviations.txt"));
        while (s.hasNext()) {
            abbreviationsDict.add(s.next());
        }
        setAbbreviations(abbreviationsDict);

    }

    public RuleBasedSentenceDetector() {
        initAbbreviations();
    }

    @Override
    public List<String> splitSentences(String text) {

        //clean multiple whitespace
        String textInput = text.replaceAll("\\s+", " ");
        List<String> resultSentences = new ArrayList<>();
        String[] wordsWs = textInput.split(" ");
        List<String> bufferSentences = new ArrayList<>();
        for (String wordWs : wordsWs) {
            boolean isNewSentences = false;
            bufferSentences.add(wordWs);

            if (wordWs.endsWith("?") || wordWs.endsWith("!")) {
                isNewSentences = true;
            } else if (wordWs.endsWith(".") && !this.getAbbreviations().contains(wordWs.toLowerCase())) {
                isNewSentences = true;
            }

            if (isNewSentences) {
                StringBuilder sentences = new StringBuilder();
                for (String bufferSentence : bufferSentences) {
                    sentences.append(bufferSentence).append(" ");
                }
                resultSentences.add(sentences.toString().trim());
                bufferSentences = new ArrayList<>();
            }

        }

        return resultSentences;
    }

}
