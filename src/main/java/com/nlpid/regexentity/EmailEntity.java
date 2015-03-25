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
public class EmailEntity implements RegexEntityInterface {

    private final Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    @Override
    public boolean isValidEntity(String text) {
        Matcher m = emailPattern.matcher(text);
        return m.matches();
    }

}
