package cas0611;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<EProizvodi> lista = new ArrayList<>();
        int izbor;
        do {
            System.out.println("\n1. Unos uređaja");
            System.out.println("2. Prikaz svih");
            System.out.println("3. Prikaz po tipu");
            System.out.println("0. Izlaz");
            System.out.print("Izbor: ");
            izbor = sc.nextInt(); sc.nextLine();

            if (izbor == 1) {
                System.out.print("Tip (RA/TE/TV): ");
                String tip = sc.nextLine().toUpperCase();
                System.out.print("Opis: ");
                String opis = sc.nextLine();
                System.out.print("Šifra: ");
                String sifra = sc.nextLine();
                System.out.print("Uvozna cijena: ");
                double cijena = sc.nextDouble(); sc.nextLine();

                if (tip.equals("RA")) {
                    System.out.print("Procesor: ");
                    String proc = sc.nextLine();
                    System.out.print("Memorija: ");
                    int mem = sc.nextInt();
                    lista.add(new Racunari(opis, sifra, cijena, proc, mem));
                } else if (tip.equals("TE")) {
                    System.out.print("Sistem: ");
                    String sys = sc.nextLine();
                    System.out.print("Ekran: ");
                    double ekr = sc.nextDouble();
                    lista.add(new Telefon(opis, sifra, cijena, sys, ekr));
                } else if (tip.equals("TV")) {
                    System.out.print("Ekran: ");
                    double ekr = sc.nextDouble();
                    lista.add(new TvUredjaji(opis, sifra, cijena, ekr));
                }

            } else if (izbor == 2) {
                for (EProizvodi p : lista)
                    System.out.println(p + " | Maloprodajna: " + p.Cijena() + "€");

            } else if (izbor == 3) {
                System.out.print("Tip (RA/TE/TV): ");
                String tip = sc.nextLine().toUpperCase();
                for (EProizvodi p : lista) {
                    if ((tip.equals("RA") && p instanceof Racunari) ||
                        (tip.equals("TE") && p instanceof Telefon) ||
                        (tip.equals("TV") && p instanceof TvUredjaji))
                        System.out.println(p);
                }
            }

        } while (izbor != 0);

        System.out.println("Kraj programa.");
        sc.close();
    }
}
