/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlpid.tokenizer;

import java.util.List;

/**
 *
 * @author n
 */
public class TokenizerFactory {
    
    public static List<String> getRuleBasedTokenList(String text){
        RuleBasedWordTokenizer tokenizer = new RuleBasedWordTokenizer();
        List<String> tokens = tokenizer.tokenize(text);
        return tokens;
    }
    
    public static String getRuleBasedTokenSentence(String text){
        StringBuilder result = new StringBuilder();
        RuleBasedWordTokenizer tokenizer = new RuleBasedWordTokenizer();
        List<String> tokens = tokenizer.tokenize(text);
        for (String token : tokens) {
            result.append(" "+token);
        }
        return result.toString().trim();
    }
    
}
