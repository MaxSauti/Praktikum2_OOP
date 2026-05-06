import java.util.Calendar;
/**
 * Klasse, um die Transaktionen darzustellen
 */
public class Kontobewegung{
 
    private Calendar cal;
    private float betrag;

    /**
     * @param pDate
     * Datum der Transaktion
     * @param pBetrag
     * Betrag der Transaktion
     */
    public Kontobewegung(Calendar pDate, float pBetrag){
        this.cal = pDate;
        this.betrag = pBetrag;
    }

    /**
     * @return Datum der Transaktion
     */
    public Calendar getCal() {
        return cal;
    }

    /**
     *
     * @return Betrag der Transaktion
     */
    public float getBetrag() {
        return betrag;
    }
}