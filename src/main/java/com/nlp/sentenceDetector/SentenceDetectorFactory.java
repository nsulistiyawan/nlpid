/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlp.sentenceDetector;

import java.util.List;

/**
 *
 * @author n
 */
public class SentenceDetectorFactory {

    public static List<String> getRuleBasedSentenceList(String text) {
        SentenceDetectorInterface rbsd = new RuleBasedSentenceDetector();
        List<String> results = rbsd.splitSentences(text);
        return results;
    }

}
