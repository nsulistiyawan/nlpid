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
public class DateEntity implements RegexEntityInterface{
    
    private static final Pattern datePattern = Pattern.compile("\\(\\d+{1,2}/\\d+{1,2}/?(\\d+{1,4})?\\)");
    
    @Override
    public boolean isValidEntity(String text) {
        Matcher m = datePattern.matcher(text);
        return m.matches();
    }
   
    
}
