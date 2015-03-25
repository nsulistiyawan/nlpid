/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlpid.regexentity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author n
 */
public class NumericEntity implements RegexEntityInterface{
    
    private final Pattern numericPattern = Pattern.compile("[0-9]+([,.][0-9]{1,2})?");

    @Override
    public boolean isValidEntity(String text) {
        Matcher m = numericPattern.matcher(text);
        return m.matches();
    }
    
}
