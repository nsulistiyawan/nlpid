/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlpid;

import com.nlp.sentenceDetector.SentenceDetectorFactory;
import com.nlp.sentenceDetector.SentenceDetectorInterface;
import com.nlpid.tokenizer.TokenizerFactory;
import java.util.List;

/**
 *
 * @author n
 */
public class Example {

    public static void main(String[] args) {

        String s = "Seorang ibu rumah tangga di Kampung Rawabugel RT 02/10, Kelurahan Harapan Mulya, Kecamatan Medansatria, Kota Bekasi ditembak kawanan perampok pada Kamis (14/5) dini hari.\n"
                + "Samini (38) harus dirawat di rumah sakit, akibat luka tembak di bagian paha kirinya oleh kawanan perampok.\n"
                + "Kepala Unit Reserse Kriminal Polsek Medansatria, Inspektur Satu Sugiyantono, mengatakan kasus pencurian dengan kekerasan ini bermula saat korban mendengar suara gaduh di halaman depan rumahnya.\n"
                + "Merasa ada yang tidak beres, lalu korban beranjak dari tidurnya untuk mengecek ke lokasi. Tak disangka, seorang perampok tengah menggasak sepeda motor Honda Scoopy bernomor polisi B 3238 KPM miliknya.";
        List<String> sentences = SentenceDetectorFactory.getRuleBasedSentenceList(s);
        for (String sentence : sentences) {
            System.out.println(sentence);
        }

        List<String> tokens = TokenizerFactory.getRuleBasedTokenList(s);
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}
