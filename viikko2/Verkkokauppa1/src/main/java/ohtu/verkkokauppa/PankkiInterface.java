package ohtu.verkkokauppa;

/**
 *
 * @author Arttu Kangas
 */
public interface PankkiInterface {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
