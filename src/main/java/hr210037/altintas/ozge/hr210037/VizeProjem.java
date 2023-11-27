package hr210037.altintas.ozge.hr210037;

import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

@RestController
public class VizeProjem {

   @GetMapping("/") //kök adreste
   public String koksayfa()
   {
       return "HR210037 / Özge Altıntaş";
   }
    @GetMapping("/Soru1/ Ortak Kelimeler")
    public Set<String> OrtakKelimeleriGetir(@RequestParam("1.Metin") String girilenmetin1, @RequestParam("2.Metin") String girilnemetin2) {
        Set<String> ortakKelimeler = new HashSet<>();

        String[] kelimeler1 = girilenmetin1.split("\\s+");
        String[] kelimeler2 = girilnemetin2.split("\\s+");

        for (String kelime1 : kelimeler1) {
            for (String kelime2 : kelimeler2) {
                if (kelime1.equalsIgnoreCase(kelime2)) {
                    ortakKelimeler.add(kelime1.toLowerCase());
                }
            }
        }
        return ortakKelimeler;
    }
    @GetMapping("/Soru2/ Metin Büyütme")
    public String metnigetir(@RequestParam("Metin Giriniz") String girilenmetin)
    {
        girilenmetin = girilenmetin.trim().toUpperCase();
        return girilenmetin;
    }
    @GetMapping("/Soru3/ Alan ve Çevre Hesabı")
    public String Elipsalanvecevrehesabı(@RequestParam("Kısa Yarıçap") int kisayaricap, @RequestParam("Uzun Yarıçap") int uzunyaricap) {
        double pi = Math.PI;
        double alan = pi * kisayaricap * uzunyaricap;
        double cevrehesabi1 = pi * (kisayaricap + uzunyaricap);
        double cevrehesabi2 = pi * Math.sqrt(2 * (kisayaricap*kisayaricap + uzunyaricap*uzunyaricap));
        double cevrehesabi3 = pi * ((3/2.0) * (kisayaricap + uzunyaricap) - Math.sqrt(kisayaricap*uzunyaricap));

        return "Alan: " + alan + ", Cevre1: " + cevrehesabi1 + ", Cevre2: " + cevrehesabi2 + ", Cevre3: " + cevrehesabi3;
    }

    @GetMapping("/Soru4/ Karekök Bulma")
    public String karekokleriYazdir(@RequestParam("Sayı Giriniz") int i) {
        try {
            PrintWriter yazdır = new PrintWriter("karekokler_" + i + ".txt", "UTF-8");
            for (int j = 0; j <= i; j++) {
                double karekok = Math.sqrt(j);
                yazdır.println(karekok + "\n");
            }
            yazdır.close();
            return "İşleminiz başarılı. Dosya yolunuz: " + new File("karekokler_" + i + ".txt").getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return "İşleminiz başarısız.";
        }
    }

    }




