import java.util.*;

public class Pelipoyta extends Korttipakka{
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

    public void luoPelipoyta() {
        poyta = new ArrayList<ArrayList<Kortti>>();
        p = new Korttipakka();
        for (int i =0; i<9; i++){
            poyta.add(new ArrayList<Kortti>());
        }
        for (int i=0; i<9; i++) {
            Kortti jako = p.annaKortit().get(0);
            poyta.get(i).add(jako);
            p.kortit.remove(0);
        }
    }

    public void pelaaKortti() {
        Scanner sc = new Scanner(System.in);
        int pino = 0;

        if (poyta.size()>1) {
            while (!(pino >= 1 && pino <= poyta.size())) {
                System.out.print("Valitse pelattava pino (1-" + poyta.size() + "): ");
                while (!sc.hasNextInt()) {
                    System.out.print("Valitse pelattava pino (1-" + poyta.size() + "): ");
                    sc.next();
                }
                pino = sc.nextInt();
            }
        }

        else{
            pino = 1;
        }

        char merkki = ' ';
        while (merkki != '+' && merkki != '-') {
            System.out.print("Onko seuraava kortti suurempi + vai pienempi - ?: ");
            merkki = sc.next().charAt(0);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }

        while (true) {
            if (merkki == '+') {
                if (p.annaKortit().get(0).compareTo(poyta.get(pino-1).get(poyta.get(pino-1).size()-1)) > 0) {
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
        this.uusiKortti(pino-1);
    }

    public void uusiKortti(int i) {
        poyta.get(i).add(p.annaKortit().get(0));
        p.poistaKortti();
    }
    public void poistaRivi(){
        for (int m=0; m<3; m++){
            while(poyta.get(0).size()>0){
                p.kortit.add(poyta.get(0).get(0));
                poyta.get(0).remove(0);
            }
            poyta.remove(0);
        }
    }

    public void poistaPino(){
        while(poyta.get(0).size()>0){
            p.kortit.add(poyta.get(0).get(0));
            poyta.get(0).remove(0);
        }
        poyta.remove(0);
    }
}
