/**
 * Trieda testuje filtrovanie zakaznikov podla predvolenych parametrov
 */

public class ZakazniciTester {

    public static void main(String[] args) {

        Zakaznik zakaznik1 = new Zakaznik("Karol Nulty", "0901123123", true, false, Platba.PAUSAL, -22.99);
        Zakaznik zakaznik2 = new Zakaznik("Iveta Silna", "0911123123", true, true, Platba.KREDIT, 12.01);
        Zakaznik zakaznik3 = new Zakaznik("Jozef Mak", "0381123123", true, false, Platba.PAUSAL, -62.54);

        Zakaznik[] zakaznici = {zakaznik1, zakaznik2, zakaznik3};

        if (args[0].equals("f")) {
            vypisZakaznikovPreFakturaciu(zakaznici);
        } else if (args[0].equals("m")) {
            vypisZakaznikovSMobilnymKontaktom(zakaznici);
        } else if (args[0].equals("h")) {
            vypisZakaznikovSoSluzbouHlas(zakaznici);
        } else if (args[0].equals("i")) {
            vypisZakaznikovSoSluzbouInternet(zakaznici);
        } else {
            System.out.println("Neznamy typ filtra");
        }
    }

    private static void vypisZakaznikovSMobilnymKontaktom(Zakaznik[] zakaznici) {

        for (Zakaznik zakaznik : zakaznici) {
            String telefonnyKontakt = zakaznik.getTelefonnyKontakt();

            if (telefonnyKontakt.startsWith("09")) {
                System.out.println(zakaznik);
            }
        }
    }

    private static void vypisZakaznikovPreFakturaciu(Zakaznik[] zakaznici) {

        for (Zakaznik zakaznik : zakaznici) {
            if (zakaznik.getStavUctu() < 0) {
                System.out.println(zakaznik);
            }
        }
    }

    private static void vypisZakaznikovSoSluzbouHlas(Zakaznik[] zakaznici) {

        for (Zakaznik zakaznik : zakaznici) {
            if (zakaznik.jeAktivnaSluzbaHlas()) {
                System.out.println(zakaznik);
            }
        }
    }

    private static void vypisZakaznikovSoSluzbouInternet(Zakaznik[] zakaznici) {

        for (Zakaznik zakaznik : zakaznici) {
            if (zakaznik.jeAktivnaSluzbaInternet()) {
                System.out.println(zakaznik);
            }
        }
    }
}