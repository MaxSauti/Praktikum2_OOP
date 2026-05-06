import java.util.Calendar;

/**
 * Sparkonto erbt von Konto und fügt Funktionalität eines Zinssatzes hinzu
 *
 */
public class Sparkonto extends Konto
{
    private final float zinssatz;

    /**
     * Konstruktor mit übergebenem Inhaber und Zinssatz
     * @param pInhab Inhaber des Kontos
     * @param zins   Zinssatz des Kontos
     */
    public Sparkonto(Inhaber pInhab, float zins){
        super(pInhab);
        this.zinssatz = zins;
    }

    /**
     * Konstruktor mir übergebenem Inhaber, Zinssatz und erster Einzahlung
     * @param pInhab    Inhaber des Kontos
     * @param zins      Zinssatz des Kontos
     * @param einz      Erste Einzahlung
     */
    public Sparkonto(Inhaber pInhab, float zins, float einz){
        super(pInhab, einz);
        this.zinssatz = zins;
    }

    /**
     * Konstruktor mit übergebenem Inhaber, Zinssatz und Werberkonto
     * @param pInhab    Inhaber des Kontos
     * @param zins      Zinssatz des Kontos
     * @param werber    Werberkonto auf welches 60€ überwiesen werden
     */
    public Sparkonto(Inhaber pInhab, float zins, Konto werber){
        super(pInhab, werber);
        this.zinssatz = zins;
    }

    /**
     * Zahlt den zum Zinssatz passenden Betrag auf das Konto ein
     */
    public void zinszahlung(Calendar cal){
        float zinszahlung = (this.zinssatz/100) * getKontostand();
        einzahlen(zinszahlung, cal);
    }
}