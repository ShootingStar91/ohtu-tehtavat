package laskin;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Komento;
import laskin.Sovelluslogiikka;


/**
 *
 * @author Arttu Kangas
 */
public class Erotus implements Komento {
TextField tulostekentta;
    TextField syotekentta;
    Button nollaa;
    Button undo;
    Sovelluslogiikka sovellus;
    String vanhasyote;
    String vanhatuloste;
    
    public Erotus(TextField tulostekentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.nollaa = nollaa;
        this.tulostekentta = tulostekentta;
        this.syotekentta = syotekentta;
        this.undo = undo;
        this.sovellus = sovellus;
    }
    
    
    public void suorita() {
        if (syotekentta.getText() == null || syotekentta.getText().length() == 0) {
            return;
        }
        vanhasyote = syotekentta.getText();
        vanhatuloste = tulostekentta.getText();
        syotekentta.clear();
        tulostekentta.setText(Integer.toString(Integer.parseInt(vanhatuloste) - Integer.parseInt(vanhasyote)));
    }
    
    public void peru () {
        syotekentta.setText(vanhasyote);
        tulostekentta.setText(vanhatuloste);
    }

    




}
