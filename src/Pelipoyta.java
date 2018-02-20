import java.util.*;

public class Pelipoyta extends Korttipakka{

    ArrayList<ArrayList<Kortti>> poyta;
    Korttipakka p;

    public Pelipoyta() {
        luoPelipoyta();
    }

    public void luoPelipoyta() {
        poyta = new ArrayList<ArrayList<Kortti>>();
        this.p = new Korttipakka();
        p.luoUusiPakka();
        for (int i =0; i<9; i++){
            poyta.add(new ArrayList<Kortti>());
        }
        for (int i=0; i<9; i++) {
            poyta.get(i).add(p.annaKortit().get(0));
            p.annaKortit().remove(0);
        }
    }

    public void uusiKortti(int i) {
        poyta.get(i).add(p.annaKortit().get(0));
    }

    public void pelaaKortti() {
        int oikeat = 0;

        Scanner sc = new Scanner(System.in);

        int pino = 0;
        while (!(pino >= 1 && pino <= 9)) {
            System.out.print("Valitse pelattava pino (1-9): ");
            pino = sc.nextInt();
        }

        char merkki = ' ';
        while (merkki != '+' && merkki != '-') {
            System.out.print("Onko seuraava kortti suurempi + vai pienempi - ?: ");
            merkki = sc.next().charAt(0);
        }

        sc.close();

        while (true) {
            if (merkki == '+') {
                if (p.annaKortit().get(0).compareTo(poyta.get(pino-1).get(poyta.get(pino-1).size()-1)) > 0) {
                    oikeat++;
                    System.out.println("Oikein!");
                    break;
                }
                else {
                    System.out.println("Väärin");
                    break;
                }
            } else if (merkki == '-') {
                if (p.annaKortit().get(0).compareTo(poyta.get(pino-1).get(poyta.get(pino-1).size()-1)) < 0) {
                    oikeat++;
                    System.out.println("Oikein!");
                    break;
                }
                else {
                    System.out.println("Väärin");
                    break;
                }
            }
        }

        this.uusiKortti(pino-1);
    }

    //GET
    public ArrayList<ArrayList<Kortti>> annaPoyta() {
        return this.poyta;
    }

}