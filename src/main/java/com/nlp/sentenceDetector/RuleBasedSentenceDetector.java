/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlp.sentenceDetector;

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
        String[] sentencesWs = textInput.split(" ");

        List<String> bufferSentences = new ArrayList<>();
        for (String sentenceWs : sentencesWs) {
            if (!sentenceWs.endsWith(".") && !sentenceWs.endsWith("?") && !sentenceWs.endsWith("!")) {
                bufferSentences.add(sentenceWs);
            } else if (getAbbreviations().contains(sentenceWs.toLowerCase())) {
                bufferSentences.add(sentenceWs);
            } else {
                bufferSentences.add(sentenceWs);
                StringBuilder sentence = new StringBuilder();
                for (String bufferSentence : bufferSentences) {
                    sentence.append(" ").append(bufferSentence);
                }
                resultSentences.add(sentence.toString().trim());
                bufferSentences = new ArrayList<>();
            }

        }

        return resultSentences;
    }

}
