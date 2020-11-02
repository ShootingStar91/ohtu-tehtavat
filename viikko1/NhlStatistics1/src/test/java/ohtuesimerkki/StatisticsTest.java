package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }  
    
    @Test
    public void searchEiLoydaMitaan() {
        Player tulos = stats.search("Selanne");
        assertTrue(tulos == null);
    }
    
    @Test
    public void searchLoytaa() {
        Player tulos = stats.search("Yzerman");
        assertTrue(tulos.getName().equals("Yzerman"));
    }
    
    @Test
    public void teamPalauttaaOikeat() {
        List<Player> tiimiLista = stats.team("EDM");
        List<String> tiimi = new ArrayList<>();
        for (Player pelaaja : tiimiLista) {
            tiimi.add(pelaaja.getName());
        }
        assertTrue(tiimi.contains("Semenko"));
        assertTrue(tiimi.contains("Kurri"));
        assertTrue(tiimi.contains("Gretzky"));
        assertTrue(!tiimi.contains("Selanne"));
    }
    
    @Test
    public void topScorersPalauttaaOikeat() {
        List<Player> parhaat = stats.topScorers(2);
        assertTrue(parhaat.get(0).getName().equals("Gretzky"));
        assertTrue(parhaat.get(1).getName().equals("Lemieux"));
        assertTrue(parhaat.size() == 2);
    }
    
}