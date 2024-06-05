package project;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Options extends Account {

    Scanner scan = new Scanner(System.in);
    DecimalFormat paraFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> musteriData = new HashMap<>();

    public void login() {
        boolean flag = true;
        do {
            try {

                musteriData.put(12345, 123);
                musteriData.put(23446, 234);
                musteriData.put(34567, 567);
                musteriData.put(45678, 678);
                musteriData.put(56789, 789);

                System.out.println("Lutfen musteri numaranizi giriniz: ");
                setMusteriNo(scan.nextInt());

                System.out.println("Lutfen pin numaranizi giriniz: ");
                setPinNo(scan.nextInt());

            } catch (Exception e) {
                System.out.println("Lutfen gecerli degerler giriniz, cikmak icin 'Q' tusuna basiniz...");
                String cikis = scan.next();
                if (cikis.equalsIgnoreCase("q")) {
                    flag = false;
                }

            }
            Set<Map.Entry<Integer, Integer>> musteriDataSet = musteriData.entrySet();
            int count = 0;
            for (Map.Entry<Integer, Integer> w : musteriDataSet) {
                if (w.getKey() == getMusteriNo() && w.getValue() == getPinNo()) {
                    islemSec();
                    flag = false;
                } else {
                    count++;
                }
            }
            if (count == musteriDataSet.size()) {
                System.out.println("Musteri veya pin numarasi yanlis");
                System.out.println("Tekrar denemek icin herhangibir sayiya basiniz.");
                System.out.println("Cikmak icin 'q' ya basiniz");
                String cikis = scan.next().toLowerCase();
                if (cikis.equals("q")) {
                    flag = false;
                }

            }

        } while (flag);

    }

    public void islemSec() {

        System.out.println("Asagidaki islemlerden birini seciniz: ");
        System.out.println("1:Vadesiz hesap islemleri");
        System.out.println("2:Vadeli hesap islemleri");
        System.out.println("3:Cikis");

        int secim = scan.nextInt();
        switch (secim) {
            case 1:
                vadesizIslemler();
                break;
            case 2:
                vadeliIslemler();
                break;
            case 3:
                System.out.println("Tesekkür eder, tekrar bekleriz...");
                break;
            default:
                System.out.println("Lutfen gecerli bir secim yapiniz...");
                islemSec();
        }
    }

    public void vadesizIslemler() {

        do {

            System.out.println("Yapmak istediginiz islmleri seciniz");
            System.out.println("1:Hesap bakiyesi inceleme");
            System.out.println("2:Para Cekme");
            System.out.println("3:Para Yatirma");
            System.out.println("4:Cikis ");

            int secim = scan.nextInt();
            if (secim == 4) {
                break;
            }
            switch (secim) {
                case 1:
                    System.out.println("Vadesiz hesap bakiyeniz: " + paraFormat.format(getVadesiz()));
                    break;
                case 2:
                    vadesizBakiyeParaCektiktenSonra();
                    break;
                case 3:
                    vadesizBakiyeParaYatirdiktanSonra();
                    break;
                default:
                    System.out.println("Yanlis giris yaptiniz tekrar deneyiniz...");
                    System.out.println("1,2,3,4 den birini seciniz...");

            }
        } while (true);
        islemSec();
    }

    public void vadeliIslemler() {

        do {
            System.out.println("Yapmak istediginiz islmleri seciniz");
            System.out.println("1:Hesap bakiyesi inceleme");
            System.out.println("2:Para Cekme");
            System.out.println("3:Para Yatirma");
            System.out.println("4:Cikis ");

            int secim = scan.nextInt();
            if (secim == 4) {
                break;
            }
            switch (secim) {
                case 1:
                    System.out.println("Vadeli hesap bakiyeniz: " + paraFormat.format(getVadeli()));
                    break;
                case 2:
                    vadeliBakiyeParaCektiktenSonra();
                    break;
                case 3:
                    vadeliBakiyeParaYatirdiktanSonra();
                    break;
                default:
                    System.out.println("Yanlis giris yaptiniz tekrar deneyiniz...");
                    System.out.println("1,2,3,4 den birini seciniz...");

            }


        } while (true);
        islemSec();

    }
}