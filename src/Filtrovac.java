import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Trieda nacitava externy subor s udajmi(klienti.csv), vytvara databazu a filtruje v udajoch podla predvolenych
 * argumentov, cim ulahcuje pracu s databazou zakaznikov.
 */

public class Filtrovac {

    public static void main(String[] args) {

        FileReader citac = null;
        try {

            citac = new FileReader("klienti.csv");
        } catch (FileNotFoundException e) {

            System.out.println("Subor Klienti.csv sa nenasiel!");
            System.exit(0);
        }

        Scanner citacSuboru = new Scanner(citac);
        DatabazaZakaznikov databaza = new DatabazaZakaznikov();

        while (citacSuboru.hasNextLine()) {
            String riadokZoSuboru = citacSuboru.nextLine();

            String[] dataOZakaznikovi = riadokZoSuboru.split(",");

            Zakaznik zakaznik = new Zakaznik(
                    dataOZakaznikovi[0],
                    dataOZakaznikovi[1],
                    dataOZakaznikovi[2].equals("hlas"),
                    dataOZakaznikovi[3].equals("internet"),
                    dataOZakaznikovi[4].equals("pausal") ? Platba.PAUSAL : Platba.KREDIT,
                    Double.parseDouble(dataOZakaznikovi[5])
            );

            databaza.pridajZakaznika(zakaznik);
        }

        citacSuboru.close();
        try {
            citac.close();
        } catch (java.io.IOException e) {
            System.out.println("Subor Klienti.csv sa nepodarilo uspesne zavriet!");
        }

        if (args[0].equals("klienti.csv") && args[1].equals("f")) {
            databaza.vypisZakaznikovNaFakturaciu();
        } else if (args[0].equals("klienti.csv") && args[1].equals("m")) {

            databaza.vypisZakaznikovSMobilnymKontaktom();
        } else if (args[0].equals("klienti.csv") && args[1].equals("h")) {

            databaza.vypisZakaznikovSoSluzbouHlas();
        } else if (args[0].equals("klienti.csv") && args[1].equals("i")) {

            databaza.vypisZakaznikovSoSluzbouInternet();
        } else {
            System.out.println("Neznamy typ filtra");
        }

        System.out.println("\n.................... koniec programu .....................");
    }
}


