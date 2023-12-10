import java.util.ArrayList;

/**
 * Trieda uchovava udaje o zakaznikoch
 */

public class DatabazaZakaznikov {

    private ArrayList<Zakaznik> zakaznici;

    /**
     * Konstruktor vytvara kolekciu zakaznikov, kde specifikujeme datovy typ objektov, ktore v nom budu ulozene.
     */

    public DatabazaZakaznikov() {
        zakaznici = new ArrayList<>();
    }

    /**
     * Pridava novych zakaznikov
     *
     * @param zakaznik vyuzivajuci telekomunikacne sluzby
     */

    public void pridajZakaznika(Zakaznik zakaznik) {
        zakaznici.add(zakaznik);

    }

    /**
     * Vypisuje zakaznikov, ktori maju pusalne platby za sluzby, t.j. maju zaporny zostatok na ucte ku koncu fakturacneho
     * obdobia
     */

    public void vypisZakaznikovNaFakturaciu() {

        for (Zakaznik zakaznik : zakaznici) {

            if (zakaznik.getStavUctu() < 0) {
                System.out.println(zakaznik);
            }
        }
    }

    /**
     * Vypisuje zakaznikov, ktori maju uvedeny mobilny kontakt (ich cislo zacina prefixom "09")
     */

    public void vypisZakaznikovSMobilnymKontaktom() {

        for (Zakaznik zakaznik : zakaznici) {

            String telefonnyKontakt = zakaznik.getTelefonnyKontakt();

            if (telefonnyKontakt.startsWith("09")) {
                System.out.println(zakaznik);
            }
        }
    }

    /**
     * Vypisuje zakaznikov, ktori maju aktivovanu sluzbu hlas.
     */

    public void vypisZakaznikovSoSluzbouHlas() {
        for (Zakaznik zakaznik : zakaznici) {

            if (zakaznik.jeAktivnaSluzbaHlas()) {
                System.out.println(zakaznik);
            }
        }
    }

    /**
     * Vypisuje zakaznikov, ktory maju aktivovanu sluzbu internet.
     */

    public void vypisZakaznikovSoSluzbouInternet() {
        for (Zakaznik zakaznik : zakaznici) {

            if (zakaznik.jeAktivnaSluzbaInternet()) {
                System.out.println(zakaznik);
            }
        }
    }
}
