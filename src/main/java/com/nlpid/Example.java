/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlpid;

import com.nlpid.sentenceDetector.SentenceDetectorFactory;
import com.nlpid.tokenizer.TokenizerFactory;
import java.util.List;

/**
 *
 * @author n
 */
public class Example {

    public static void main(String[] args) {

        String s = "Ibu Budi bernama Dr. Rani, sedangkan bapaknya bernama Prof. Joko. Mereka tinggal di Jln. Awan No. 22.";
        List<String> sentences = SentenceDetectorFactory.getRuleBasedSentenceList(s);
        for (String sentence : sentences) {
            System.out.println(sentence);
        }

        List<String> tokens = TokenizerFactory.getRuleBasedTokenList(s);
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}
