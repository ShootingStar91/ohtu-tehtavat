
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] luvut;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        luvut = new int[KAPASITEETTI];
        for (int i = 0; i < luvut.length; i++) {
            luvut[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        luvut = new int[kapasiteetti];
        for (int i = 0; i < luvut.length; i++) {
            luvut[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;

    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        luvut = new int[kapasiteetti];
        for (int i = 0; i < luvut.length; i++) {
            luvut[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            luvut[0] = luku;
            alkioidenLkm++;
            return true;
        }
        if (!kuuluu(luku)) {
            luvut[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % luvut.length == 0) {
                int[] taulukkoOld = luvut;
                kopioiTaulukko(luvut, taulukkoOld);
                luvut = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(taulukkoOld, luvut);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        return etsiLuku(luku) != -1;
    }

    public boolean poista(int luku) {
        int kohta = etsiLuku(luku);
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                int apu = luvut[j];
                luvut[j] = luvut[j + 1];
                luvut[j + 1] = apu;
            }
            alkioidenLkm--;
            return true;
        }
        return false;
    }
    
    private int etsiLuku(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                return i;
            }
        }
        return -1;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + luvut[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += luvut[i];
                tuotos += ", ";
            }
            tuotos += luvut[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = luvut[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        for (int i = 0; i < a.alkioidenLkm; i++) {
            yhdiste.lisaa(a.luvut[i]);
        }
        for (int i = 0; i < b.alkioidenLkm; i++) {
            yhdiste.lisaa(b.luvut[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        for (int i = 0; i < a.alkioidenLkm; i++) {
            if (b.kuuluu(a.luvut[i])) {
                leikkaus.lisaa(a.luvut[i]);
            }
        }
        return leikkaus;
    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        for (int i = 0; i < a.alkioidenLkm; i++) {
            if (!b.kuuluu(a.luvut[i])) {
                erotus.lisaa(a.luvut[i]);
            }
        }
        return erotus;
    }
        
}
