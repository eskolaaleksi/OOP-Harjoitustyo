import java.io.Serializable;

public class Kortti implements Comparable<Kortti>, Serializable{
    protected String maa;
    protected String arvo;

    public Kortti(String maa, String arvo){
        this.maa = maa;
        this.arvo = arvo;
    }

    public String annaMaa(){
        return this.maa;
    }

    public String annaArvo(){
        return this.arvo;
    }

    private int muutaIntArvoksi(String a) { //peli käsittelee int tyyppisiä muuttujia mutta näyttää pelaajalle
                                            //string tyyppisen nimen jokaiselle kortille
        int arvoInt = 0;                    //esim. 6 ja Q eivät ole vertailukelpoisia keskenään ilman tätä toimenpidettä
        switch (a) {
            case "A": arvoInt = 1;
                break;
            case "2": arvoInt = 2;
                break;
            case "3": arvoInt = 3;
                break;
            case "4": arvoInt = 4;
                break;
            case "5": arvoInt = 5;
                break;
            case "6": arvoInt = 6;
                break;
            case "7": arvoInt = 7;
                break;
            case "8": arvoInt = 8;
                break;
            case "9": arvoInt = 9;
                break;
            case "T": arvoInt = 10;
                break;
            case "J": arvoInt = 11;
                break;
            case "Q": arvoInt = 12;
                break;
            case "K": arvoInt = 13;
                break;
        }
        return arvoInt;
    }

    public int compareTo(Kortti k) { //vertaillaan pelattujen korttien suuruuksia keskenään
        if (muutaIntArvoksi(this.arvo) > muutaIntArvoksi(k.arvo)) {
            return 1;
        }
        else if (muutaIntArvoksi(this.arvo) < muutaIntArvoksi(k.arvo)) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
