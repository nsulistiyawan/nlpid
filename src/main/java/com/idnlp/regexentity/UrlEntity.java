/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idnlp.regexentity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author n
 */
public class UrlEntity implements RegexEntityInterface{
    private final Pattern urlPattern = Pattern.compile("\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");

    @Override
    public boolean isValidEntity(String text) {
        Matcher m = urlPattern.matcher(text);
        return m.matches();
        
    }
    
}
