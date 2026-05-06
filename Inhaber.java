/**
 * Klasse um Inhaber zu definieren
 */
public class Inhaber{
    /**
     * Attribute Vorname, Nachname und Adresse
     */
    private String vorname;
    private String nachname;
    private String adresse;
    
    
    /**
     * Konstruktor für Objekte der Klasse Inhaber. Gibt Vorname, 
     * Nachname und Adresse an
     */
    public Inhaber(String vorn, String nachn, String addr){
        this.vorname = vorn;
        this.nachname = nachn;
        this.adresse = addr;
    }

    /**
     *
     * @return Vorname des Inhabers
     */
    public String getVorname() {
        return vorname;
    }

    /**
     *
     * @return  Nachname des Inhabers
     */
    public String getNachname() {
        return nachname;
    }

    /**
     *
     * @return  Adresse des Inhabers
     */
    public String getAdresse() {
        return adresse;
    }
}