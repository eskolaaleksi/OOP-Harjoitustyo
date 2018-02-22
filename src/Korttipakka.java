import java.util.*;
public class Korttipakka{

    private String[] maa = {"\u2660", "\u2661", "\u2662", "\u2663"};
    private String[] arvo = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};

    protected ArrayList<Kortti> kortit;

    public Korttipakka(){
        kortit = new ArrayList<Kortti>();
        kortit.clear();
        for (String m : maa){
            for (String a : arvo){
                Kortti k = new Kortti(m,a);
                kortit.add(k);
            }
        }
        Collections.shuffle(kortit);
    }

    public ArrayList<Kortti> annaKortit(){
        return kortit;
    }

    public void poistaKortti(){
        kortit.remove(0);
    }
}
