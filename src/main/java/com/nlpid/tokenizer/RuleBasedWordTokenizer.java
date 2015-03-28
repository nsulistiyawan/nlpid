/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlpid.tokenizer;

import com.nlpid.regexentity.AbbreviationEntity;
import com.nlpid.regexentity.AgeEntity;
import com.nlpid.regexentity.DateEntity;
import com.nlpid.regexentity.EmailEntity;
import com.nlpid.regexentity.HostnameEntity;
import com.nlpid.regexentity.NumericEntity;
import com.nlpid.regexentity.RegexEntityInterface;
import com.nlpid.regexentity.UrlEntity;
import com.nlpid.tokenizer.tools.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *
 * @author n
 */
public class RuleBasedWordTokenizer implements TokenizerInterface {

    private List<String> abbreviations;
    private List<RegexEntityInterface> regexEntities;

    public RuleBasedWordTokenizer() {
        initAbbreviations();
        initRegexEntity();
    }

    public List<String> getAbbreviations() {
        return abbreviations;
    }

    public void setAbbreviations(List<String> abbreviations) {
        this.abbreviations = abbreviations;
    }

    public void addAbbreviations(String abbreviation) {
        this.abbreviations.add(abbreviation);
    }

    private void initAbbreviations() {
        List<String> abbreviationsDict = new ArrayList<>();
        Scanner s = new Scanner(getClass().getResourceAsStream("/abbreviations.txt"));
        while (s.hasNext()) {
            abbreviationsDict.add(s.next());
        }
        setAbbreviations(abbreviationsDict);

    }

    public List<RegexEntityInterface> getRegexEntities() {
        return regexEntities;
    }

    public void setRegexEntities(List<RegexEntityInterface> regexEntities) {
        this.regexEntities = regexEntities;
    }

    public void addRegexEntities(RegexEntityInterface regexEntity) {
        this.regexEntities.add(regexEntity);
    }

    private void initRegexEntity() {
        List<RegexEntityInterface> registeredRegexEntities = new ArrayList<>();
        registeredRegexEntities.add(new NumericEntity());
        registeredRegexEntities.add(new DateEntity());
        registeredRegexEntities.add(new AgeEntity());
        //registeredRegexEntities.add(new AbbreviationEntity());
        registeredRegexEntities.add(new HostnameEntity());
        registeredRegexEntities.add(new UrlEntity());
        registeredRegexEntities.add(new EmailEntity());
        setRegexEntities(registeredRegexEntities);
    }

    @Override
    public List<String> tokenize(String text) {

        //clean multiple whitespace
        String textInput = text.replaceAll("\\s+", " ");

        List<String> resultTokens = new ArrayList<>();
        String[] tokensWs = textInput.split(" ");
        for (String tokenWs : tokensWs) {

            //jika potongan kata tidak punya punctuation sama sekali 
            if (this.onlyAlphaNumeric(tokenWs) == true) {
                resultTokens.add(tokenWs);

            } else if (this.onlyHasWordBoundaryPunctuation(tokenWs)) {
                char startChar = tokenWs.charAt(0);
                char endChar = tokenWs.charAt(tokenWs.length() - 1);

                if (StringHelper.isPunctuation(startChar) && StringHelper.isPunctuation(endChar)) {
                    String tokenWsCleaned = tokenWs.substring(1, tokenWs.length() - 1);
                    resultTokens.add(String.valueOf(startChar));
                    resultTokens.add(tokenWsCleaned);
                    resultTokens.add(String.valueOf(endChar));
                } else if (StringHelper.isPunctuation(startChar)) {
                    String tokenWsCleaned = tokenWs.substring(1);
                    resultTokens.add(String.valueOf(startChar));
                    resultTokens.add(tokenWsCleaned);
                } else if (StringHelper.isPunctuation(endChar)) {
                    String tokenWsCleaned = tokenWs.substring(0, tokenWs.length() - 1);
                    resultTokens.add(tokenWsCleaned);
                    resultTokens.add(String.valueOf(endChar));

                }

            } //ada dalam abbreviations           
            else if (abbreviations.contains(tokenWs.toLowerCase())) {
                resultTokens.add(tokenWs);
            } //punya pola dalam salah satu rules
            else if (this.hasRegexRules(tokenWs) == true) {
                if (StringHelper.isCommonPunctuationAfterWord(tokenWs.charAt(tokenWs.length() - 1))) {
                    resultTokens.add(tokenWs.substring(0,tokenWs.length() - 1));
                    resultTokens.add(tokenWs.substring(tokenWs.length()-1, tokenWs.length()));
                }
                else{
                    resultTokens.add(tokenWs);
                }
                
            } //default, split menurut punctuation
            else {
                //tambahkan space sebelum & sesudah token 
                String lastToken = tokenWs.replaceAll("\\p{Punct}", " $0 ");
                //split by space
                String[] lastTokenSplit = lastToken.replaceAll("\\s+", " ").split(" ");
                for (String token : lastTokenSplit) {
                    if (!"".equals(token)) {
                        resultTokens.add(token);
                    }
                }
            }

        }
        return resultTokens;

    }

    /**
     * Check jika kata hanya punya alphanumeric
     *
     * @param text
     * @return
     */
    private boolean onlyAlphaNumeric(String text) {
        Pattern p = Pattern.compile("^[A-Za-z0-9]+$");
        Matcher m = p.matcher(text);
        return m.matches();
    }

    /**
     * Check apakah kata memiliki pola entity tertentu
     *
     * @param text
     * @return
     */
    public boolean hasRegexRules(String text) {
        HashMap<String, String> resultMap = new HashMap<>();
        if (StringHelper.isCommonPunctuationAfterWord(text.charAt(text.length() - 1))) {
            String tokenWsCleaned = text.substring(0, text.length() - 1);
            for (RegexEntityInterface regexEntity : regexEntities) {
                if (regexEntity.isValidEntity(tokenWsCleaned)) {
                    return true;
                }
            }
        } else {

            for (RegexEntityInterface regexEntity : regexEntities) {
                if (regexEntity.isValidEntity(text)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Check kata "hanya" punya tanda baca di awal | akhir | awal & akhir kata
     *
     * @param text
     * @return boolean
     */
    private boolean onlyHasWordBoundaryPunctuation(String text) {
        Pattern p = Pattern.compile("[\\p{Punct}]?[A-Za-z]+[\\p{Punct}]?");
        Matcher m = p.matcher(text);
        return m.matches();
    }

}
