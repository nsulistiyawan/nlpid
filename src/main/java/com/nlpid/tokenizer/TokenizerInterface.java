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
public interface TokenizerInterface {
    
    public List<String> tokenize(String text);
    
}
