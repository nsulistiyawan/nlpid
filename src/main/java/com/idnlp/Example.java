/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idnlp;

import com.idnlp.regexentity.AgeEntity;
import com.idnlp.regexentity.DateEntity;
import com.idnlp.tokenizer.TokenizerFactory;
import java.util.List;

/**
 *
 * @author n
 */
public class Example {
    
    public static void main(String[] args) {
        
        
        
        String s = "Seorang karyawati sebuah toko tas di Jalan Raya Tajur, Kecamatan Bogor Timur, Kota Bogor berinisial FY (19) diduga diperkosa tiga pemuda yang baru dikenalnya.\n" +
"Remaja yang tinggal di daerah Caringin, Kabupaten Bogor itu diperkosa secara bergiliran di semak-semak pinggir tol Jagorawi, Kecamatan Sukaraja, Kabupaten Bogor. Usai memperkosa FY, tiga pelaku meninggalkan korban tanpa busana.\n" +
"Kemudian korban berjalan ke perkampungan untuk mencari pertolongan dari warga. Kasus perkosaan yang dialami pegawai toko itu kemudian dilaporkan ke Polsek Sukaraja.\n" +
"Dalam laporannya, Selasa (17/3) pagi, FY warga Kampung Nyenang Jaya Bawah, Desa Muara Jaya, Kecamatan Caringin, Kabupaten Bogor menjelaskan, kejadian yang dialami berawal saat dia hendak pulang ke rumahnya Senin (16/3) malam sekitar pukul 22.00 WIB.\n" +
"Saat menunggu angkot untuk pulang, dia didatangi seorang pria yang mengaku tukang ojek yang menawarkan jasa mengantar korban ke rumahnya.\n" +
"Tidak curiga dengan ajakan tukang ojek itu, FY naik motor pelaku. Namun korban bukannya diantar pulang, tapi malah dibawa berputar-putar dan berhenti di tempat sepi di pinggir tol Jogorawi tepatnya di Kampung Ciangsana, Desa Cibanon, Kecamatan Sukaraja, Kabupaten Bogor.\n" +
"\"Kepada pelaku Korban sempat bertanya jalur yang dilalui. Tapi pria yang mengaku tukang ojek ini berdalih mengambil jalur pintas,\" ujar Kapolsek Sukaraja, Kompol Hida Tjahyono, Rabu (18/3/2015). Seorang karyawati sebuah toko tas di Jalan Raya Tajur, Kecamatan Bogor Timur, Kota Bogor berinisial FY (19) diduga diperkosa tiga pemuda yang baru dikenalnya.\n" +
"Remaja yang tinggal di daerah Caringin, Kabupaten Bogor itu diperkosa secara bergiliran di semak-semak pinggir tol Jagorawi, Kecamatan Sukaraja, Kabupaten Bogor. Usai memperkosa FY, tiga pelaku meninggalkan korban tanpa busana.\n" +
"Kemudian korban berjalan ke perkampungan untuk mencari pertolongan dari warga. Kasus perkosaan yang dialami pegawai toko itu kemudian dilaporkan ke Polsek Sukaraja.\n" +
"Dalam laporannya, Selasa (17/3) pagi, FY warga Kampung Nyenang Jaya Bawah, Desa Muara Jaya, Kecamatan Caringin, Kabupaten Bogor menjelaskan, kejadian yang dialami berawal saat dia hendak pulang ke rumahnya Senin (16/3) malam sekitar pukul 22.00 WIB.\n" +
"Saat menunggu angkot untuk pulang, dia didatangi seorang pria yang mengaku tukang ojek yang menawarkan jasa mengantar korban ke rumahnya.\n" +
"Tidak curiga dengan ajakan tukang ojek itu, FY naik motor pelaku. Namun korban bukannya diantar pulang, tapi malah dibawa berputar-putar dan berhenti di tempat sepi di pinggir tol Jogorawi tepatnya di Kampung Ciangsana, Desa Cibanon, Kecamatan Sukaraja, Kabupaten Bogor.\n" +
"\"Kepada pelaku Korban sempat bertanya jalur yang dilalui. Tapi pria yang mengaku tukang ojek ini berdalih mengambil jalur pintas,\" ujar Kapolsek Sukaraja, Kompol Hida Tjahyono, Rabu (18/3/2015). Setibanya di lokasi, wanita berambut ikal ini lalu dipaksa melayani nafsu bejat pelaku. Sambil diancam akan dibunuh, korban dipaksa membuka seluruh pakaiannya.\n" +
"Saat diperkosa, dua pemuda lain yang jadi teman pelaku muncul dan ikut memperkosa korban. Aksi perkosaan baru berakhir Selasa dinihari.\n" +
"\"Setelah diperkosa korban ditinggalkan begitu saja. Pakaian korban dibuang pelaku ke semak-semak,\" ujar AKP Faisal Pasaribu, Kasat Reskrim Polres Bogor.\n" +
"AKP Faisal menambahkan, tiga pelaku pemerkosaan kini dalam pengejaran petugas Polsek Sukaraja dan Polres Bogor.\"Karena menyangkut asusila, kasusnya ditangani Polres Bogor,\" katanya.\n" +
"Selain memperkosa, pelaku juga mengambil barang berharga milik korban seperti, handphone, tas serta dompet berisi uang tunai Rp 200 ribu.";
        List<String> tokens = TokenizerFactory.createDefaultTokenizer(s);
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}
