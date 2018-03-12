import java.io.Serializable;
import java.util.*;
public class Korttipakka implements Serializable{

    private String[] maa = {"\u2660", "\u2661", "\u2662", "\u2663"}; //maiden utf tunnukset
    private String[] arvo = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};

    protected ArrayList<Kortti> kortit;


    public Korttipakka(){
        kortit = new ArrayList<Kortti>(); //luodaan tavallinen 52 kortin pakka ja sekoitetaan se
        kortit.clear();
        for (String m : maa){               //käydään järjestyksessä jokaisen maan
            for (String a : arvo){          //jokainen kortti
                Kortti k = new Kortti(m,a); //ja
                kortit.add(k);              //lisätään ne pakkaan
            }
        }
        Collections.shuffle(kortit);        //lopuksi sekoitetaan
    }

    //GET

    public ArrayList<Kortti> annaKortit(){
        return kortit;
    }

    public void poistaKortti(){
        kortit.remove(0);
    } //poistaa pakan päällimmäisen kortin

}