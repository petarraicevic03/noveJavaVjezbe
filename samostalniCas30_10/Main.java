package samostalniCas30_10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Unesite informacije o automobilu: ");
        System.out.print("Marka: ");
        String markaA = sc.nextLine();

        System.out.print("Godina proizvodnje: ");
        int godinaA = sc.nextInt();

        System.out.print("Kubikaža (ccm): ");
        int kubikazaA = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Boja: ");
        String bojaA = sc.nextLine();

        System.out.print("Broj vrata: ");
        int vrataA = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Gorivo (benzin/dizel): ");
        String gorivoA = sc.nextLine();

        Automobil auto = new Automobil(markaA, godinaA, kubikazaA, bojaA, vrataA, gorivoA);

        
        System.out.println("Unesite podatke za kamion: ");
        System.out.print("Marka: ");
        String markaK = sc.nextLine();

        System.out.print("Godina proizvodnje: ");
        int godinaK = sc.nextInt();

        System.out.print("Kubikaža (ccm): ");
        int kubikazaK = sc.nextInt();
        sc.nextLine();

        System.out.print("Boja: ");
        String bojaK = sc.nextLine();

        System.out.print("Nosivost (kg): ");
        int nosivostK = sc.nextInt();

        System.out.print("Da li ima prikolicu (true/false): ");
        boolean prikolica = sc.nextBoolean();

        Kamion kamion = new Kamion(markaK, godinaK, kubikazaK, bojaK, nosivostK, prikolica);

        // ---- Unos podataka za kombi ----
        System.out.println("\n=== Unos podataka za kombi ===");
        sc.nextLine(); // čisti buffer
        System.out.print("Marka: ");
        String markaKo = sc.nextLine();

        System.out.print("Godina proizvodnje: ");
        int godinaKo = sc.nextInt();

        System.out.print("Kubikaža (ccm): ");
        int kubikazaKo = sc.nextInt();
        sc.nextLine();

        System.out.print("Boja: ");
        String bojaKo = sc.nextLine();

        System.out.print("Broj sjedišta: ");
        int sjedistaKo = sc.nextInt();

        Kombi kombi = new Kombi(markaKo, godinaKo, kubikazaKo, bojaKo, sjedistaKo);

        // ---- Prikaz informacija ----
        System.out.println("\n-------------------------------");
        auto.prikaziInformacije();
        System.out.println("Cijena registracije za automobil: " + auto.cijenaRegistracije() + " €");

        System.out.println("\n-------------------------------");
        kamion.prikaziInformacije();
        System.out.println("Cijena registracije za kamion: " + kamion.cijenaRegistracije() + " €");

        System.out.println("\n-------------------------------");
        kombi.prikaziInformacije();
        System.out.println("Cijena registracije za kombi: " + kombi.cijenaRegistracije() + " €");

        sc.close();
    }
}
