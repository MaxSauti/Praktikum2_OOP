import java.util.ArrayList;
import java.util.Calendar;
/**
 * Konto Klasse als Bauplan für Bankkonten.
 * 
 * @author Max Sautmann 
 * 
 */
public class Konto
{
    private static int nextkontonummer = 1;
    private final int kontonummer;
    private final Inhaber inhaber;
    private float kontostand;
    private final ArrayList<Kontobewegung> List = new ArrayList<>();
    
    /**
     * Konstruktor für Objekte der Klasse Konto.
     * Gibt Inhaber und Kontonummer an
     */
    public Konto(Inhaber pInhab)
    {
        this.inhaber = pInhab;
        this.kontonummer = nextkontonummer++;
    }
    
    /**
     * Konstruktor für Objekte der Klasse Konto.
     * Gibt Inhaber, Kontonummer und erste Einzahlung an
     */
    public Konto(Inhaber pInhab, float einz)
    {
        this(pInhab);
        einzahlen(einz, Calendar.getInstance());
    
    }
    
    /**
     * Konstruktor für Objekte der Klasse Konto.
     * Gibt Inhaber, Kontonummer und ein Konto des Werbers an 
     * auf welches 60€ überwiesen werden
     */
    public Konto(Inhaber pInhab, Konto werber){
        this(pInhab);
        werber.einzahlen(30, Calendar.getInstance());
        this.einzahlen(30, Calendar.getInstance());
    }
    
    /**
     * @return kontostand
     */
    public float getKontostand(){
        return kontostand;
    }
    
    /**
     * @return inhaber
     */
    public Inhaber getInhaber(){
        return inhaber;
    }
    
    /**
     * @param betrag
     * Kontostand wird um Betrag erhöht
     * @param cal
     * Datum wird übergeben
     */
    public void einzahlen(float betrag, Calendar cal){
        if (betrag < 0) {
            throw new IllegalArgumentException("Betrag darf nicht negativ sein");
        }
        this.kontostand += betrag;
        neueBeweg(betrag, cal);

    }
    
    /**
     * @param betrag      
     * Kontostand wird um Betrag verringert
     * @param cal
     * Datum wird übergeben
     */
    public void abheben(float betrag, Calendar cal){
        if (betrag < 0) {
            throw new IllegalArgumentException("Betrag darf nicht negativ sein");
        }
        this.kontostand -= betrag;
        neueBeweg(-betrag, cal);
    }
    
    /**
     * @param konto
     * Auf dieses Konto wird überwiesen
     * @param betrag
     * Betrag wird von diesem Konto abgehoben und auf anderem Konto eingezahlt
     * @param cal
     * Datum an dem überwiesen wurde
     */
    public void ueberweisen(Konto konto, float betrag, Calendar cal){
        abheben(betrag, cal);
        konto.einzahlen(betrag, cal);
    }

    /**
     * @param betrag
     * Betrag der abgehoben oder überwiesen wurde
     * @param c1
     * Datum der Transaktion
     */
    private void neueBeweg(float betrag, Calendar c1){
        Kontobewegung k1 = new Kontobewegung(c1, betrag);
        List.add(k1);
        
    }

    /**
     * Methode zum Drucken des Kontoauszugs
     * @param date
     * Datum, ab dem die Bewegungen ausgegeben werden
     */
    public void kontoauszug(Calendar date){
        System.out.println("----Kontoauszug für Konto: " + this.kontonummer + "----");
        for (Kontobewegung beweg : List){
            if (date == null || date.compareTo(beweg.getCal()) <= 0) {
                System.out.println(beweg.getCal().getTime() + " " + beweg.getBetrag() + "€");
            }
        }
        System.out.println("------------------------");
        System.out.println("Aktueller Kontostand: " + getKontostand() + "€");
        System.out.println("----Kontoauszug Ende----\n");
    }
/*
    public void kontoauszug(){
        System.out.println("----Kontoauszug für Konto: " + this.kontonummer + "----");
        for (Kontobewegung beweg : List){
                System.out.println(beweg.getBetrag() + "  " + beweg.getCal().getTime());
        }
        System.out.println("----Kontoauszug Ende----\n");
    }

 */


    
}