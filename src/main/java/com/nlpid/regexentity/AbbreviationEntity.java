/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlpid.regexentity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author n
 */
public class AbbreviationEntity implements RegexEntityInterface{
    
    private static final Pattern abbreviationPattern = Pattern.compile("\\([A-Z]{1,10}\\)");
    
    @Override
    public boolean isValidEntity(String text) {
        Matcher m = abbreviationPattern.matcher(text);
        return m.matches();
    }
   
    
}
