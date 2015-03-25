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
public class AgeEntity implements RegexEntityInterface{
    
    private static final Pattern agePattern = Pattern.compile("\\([0-9][0-9]?\\)");
    
    @Override
    public boolean isValidEntity(String text) {
        Matcher m = agePattern.matcher(text);
        return m.matches();
    }
   
    
}
