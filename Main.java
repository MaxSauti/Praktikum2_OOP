import java.util.Calendar;

public class Main {

    public static void main (String[] args){
        Inhaber i1 = new Inhaber(" ", " ", "");
        Konto k1 = new Konto(i1, 20);
        Sparkonto s1 = new Sparkonto(i1, 5);


        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.MONTH, 3);
        k1.abheben(10, c1);
        s1.einzahlen(20, c1);
        s1.zinszahlung(c1);

        Calendar c2 = Calendar.getInstance();
        c2.set(Calendar.MONTH, 7);
        k1.ueberweisen(s1, 30, c2);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 5);
        s1.kontoauszug(cal);
        cal.set(Calendar.MONTH, 1);
        k1.kontoauszug(cal);
        s1.kontoauszug(null);
    }

}
