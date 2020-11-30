package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;


/**
 *
 * @author Arttu Kangas
 */
public class Nollaa implements Komento {
    TextField tulostekentta;
    TextField syotekentta;
    String vanhasyote;
    String vanhatuloste;
    Button nollaa;
    Button undo;
    Sovelluslogiikka sovellus;
    
    public Nollaa(TextField tulostekentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.nollaa = nollaa;
        this.tulostekentta = tulostekentta;
        this.syotekentta = syotekentta;
        this.undo = undo;
        this.sovellus = sovellus;
    }
    
    public void suorita() {
        
        vanhasyote = syotekentta.getText();
        vanhatuloste = tulostekentta.getText();
        syotekentta.clear();
        tulostekentta.setText("0");
    }
    
    public void peru () {
        if (vanhasyote == null || vanhatuloste == null) {
            return;
        }
        syotekentta.setText(vanhasyote);
        tulostekentta.setText(vanhatuloste);
    }

    

}
