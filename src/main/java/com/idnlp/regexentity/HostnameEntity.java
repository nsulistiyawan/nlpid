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
public class HostnameEntity implements RegexEntityInterface{

    private final Pattern hostnamePattern = Pattern.compile("^(([a-zA-Z]|[a-zA-Z][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)*([A-Za-z]|[A-Za-z][A-Za-z0-9\\-]*[A-Za-z0-9])$");
    
    @Override
    public boolean isValidEntity(String text) {
        Matcher m = hostnamePattern.matcher(text);
        return m.matches();
    }
    
}
