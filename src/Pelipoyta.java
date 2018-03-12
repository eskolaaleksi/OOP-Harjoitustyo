import java.io.Serializable;
import java.util.*;

public class Pelipoyta extends Korttipakka implements Serializable{
    ArrayList<ArrayList<Kortti>> poyta;
    Korttipakka p;
    int oikeat = 0;

    public ArrayList<ArrayList<Kortti>> annaPoyta(){
        return poyta;
    }

    public Korttipakka annaKorttipakka(){
        return p;
    }

    public Pelipoyta(){
        luoPelipoyta();
    }

    public void luoPelipoyta() { //alustetaan pelipöytä
        poyta = new ArrayList<ArrayList<Kortti>>(); //poyta arraylist jonka solujen tyyppi on arraylist
        p = new Korttipakka();
        for (int i =0; i<9; i++){ //lisätään pinot pelipöytään
            poyta.add(new ArrayList<Kortti>());
        }
        for (int i=0; i<9; i++) { //jokaiseen yksittäiseen pinoon lisätään ensimmäinen kortti
            Kortti jako = p.annaKortit().get(0);
            poyta.get(i).add(jako);
            p.kortit.remove(0);
        }
    }

    public void pelaaKortti() {
        Scanner sc = new Scanner(System.in);
        int pino = 0;

        if (poyta.size()>1) { //pidetään huolta ettei pinoa tarvitse valita jos pinoja on vain yksi
            while (!(pino >= 1 && pino <= poyta.size())) { //kun valittu pino on välillä 1 ja pinojen määrä niin silmukka jatkuu (eli virheellinen vastaus ei kelpaa)
                System.out.print("Valitse pelattava pino (1-" + poyta.size() + "): ");
                while (!sc.hasNextInt()) { //kunnes syötetään int
                    System.out.print("Valitse pelattava pino (1-" + poyta.size() + "): ");
                    sc.next();
                }
                pino = sc.nextInt();
            }
        }

        else{ //jos jäljellä on vain yksi pino, pelaajan ei tarvitse osoittaa pelattavaa pinoa
            pino = 1;
        }

        char merkki = ' ';
        while (merkki != '+' && merkki != '-') { //jatkuu kunnes syötetään + tai -
            System.out.print("Onko seuraava kortti suurempi + vai pienempi - ?: ");
            merkki = sc.next().charAt(0);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //selkeyden vuoksi lyödään muutama tyhjä rivi ennen seuraavan kierroksen tulostamista
        }

        while (true) { //tarkistetaan onko syötetty vastaus oikein
            if (merkki == '+') {
                if (p.annaKortit().get(0).compareTo(poyta.get(pino-1).get(poyta.get(pino-1).size()-1)) > 0) {
                    oikeat++; //kasvatetaan oikeiden vastauksien määrää yhdellä
                    System.out.println("Oikein!");
                    if (oikeat==3){ //vuoro vaihtuu kun pelaaja on vastannut oikein kolmesti
                        System.out.println("Seuraavan pelaajan vuoro");
                        oikeat=0;
                    }
                    break;
                }
                else {
                    System.out.println("Väärin! Juo " + (poyta.get(pino-1).size()+1));
                    break;
                }
            } else if (merkki == '-') {
                if (p.annaKortit().get(0).compareTo(poyta.get(pino-1).get(poyta.get(pino-1).size()-1)) < 0) {
                    oikeat++;
                    System.out.println("Oikein!");
                    if (oikeat==3){
                        System.out.println("Seuraavan pelaajan vuoro");
                        oikeat=0;
                    }
                    break;
                }
                else {
                    System.out.println("Väärin! Juo " + (poyta.get(pino-1).size()+1));
                    break;
                }
            }
        }
        System.out.println("Oikeita vastauksia: " + oikeat);
        this.uusiKortti(pino-1); //laittaa pakan päällimmäisen kortin valittuun pinoon
    }

    public void uusiKortti(int i) {
        poyta.get(i).add(p.annaKortit().get(0));
        p.poistaKortti(); //huolehtii ettei samaa korttia pelata montaa kertaa
    }
    public void poistaRivi(){ //poistetaan rivi ja sekoitetaan se uudeksi pelipakaksi
        for (int m=0; m<3; m++){
            while(poyta.get(0).size()>0){
                p.kortit.add(poyta.get(0).get(0));
                poyta.get(0).remove(0);
            }
            poyta.remove(0);
        }
        Collections.shuffle(p.kortit);
    }

    public void poistaPino(){ //poistetaan pino ja sekoitetaan se uudeksi pelipakaksi
        while(poyta.get(0).size()>0){
            p.kortit.add(poyta.get(0).get(0));
            poyta.get(0).remove(0);
        }
        poyta.remove(0);
        Collections.shuffle(p.kortit);
    }
}