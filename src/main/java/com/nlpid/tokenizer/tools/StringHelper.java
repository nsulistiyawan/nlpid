/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlpid.tokenizer.tools;

import java.util.regex.Pattern;

/**
 *
 * @author n
 */
public class StringHelper {

    public static final char[] alphaChars = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
        's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    public static final char[] numericChars = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    private static final char[] standarEosChars = {
        '.', '?', '!'
    };

    private static final char[] whiteSpaceChars = {
        ' ', '\t', '\n'
    };

    private static final char[] punctuationChars = {
        ',', '.', ';', ':', '?', '!', '"', '(', ')', '\'',
        '[', ']', '+', '=', '*', '&', '^', '%', '$', '#',
        '@', '~', '`', '{', '}', '\\', '|', '>', '<'
    };

    private static final char[] commonPunctuationAfterWords = {
        '.', ',', '?'
    };

    private static final char[] commonAbbreviationsChars = {
        ',', '?', '(', ')'
    };

    public static boolean isAlphaNumeric(char c) {
        for (char alphaChar : alphaChars) {
            if (c == alphaChar) {
                return true;
            }
        }
        for (char numericChar : numericChars) {
            if (c == numericChar) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPunctuation(char c) {
        for (char punctuationChar : punctuationChars) {
            if (c == punctuationChar) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWhitespace(char c) {
        for (char whiteSpaceChar : whiteSpaceChars) {
            if (c == whiteSpaceChar) {
                return true;
            }
        }
        return false;
    }

    public static boolean isStandarEndOfSentence(char c) {
        for (char standarEosChar : standarEosChars) {
            if (c == standarEosChar) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCommonPunctuationAfterWord(char c) {
        for (char commonPunctuationAfterWord : commonPunctuationAfterWords) {
            if (c == commonPunctuationAfterWord) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCommonAbbreviationsChar(char c) {
        for (char commonAbbreviationsChar : commonAbbreviationsChars) {
            if (c == commonAbbreviationsChar) {
                return true;
            }
        }
        return false;
    }

}
