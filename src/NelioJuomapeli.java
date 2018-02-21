import java.util.ArrayList;

public class NelioJuomapeli{

    public static void main(String[] args) {
        Pelipoyta p = new Pelipoyta();

        while (p.p.annaKortit().size() > 0) {
            for (int i = 0; i <= 8; i += 1) {
                if (i == 2 || i == 5 || i == 8) {
                    System.out.print("|  " + p.annaPoyta().get(i).get(p.annaPoyta().get(i).size() - 1).annaArvo());
                    System.out.print(p.annaPoyta().get(i).get(p.annaPoyta().get(i).size() - 1).annaMaa() + " ");
                    System.out.println(p.annaPoyta().get(i).size() >= 10 ? "(" + p.annaPoyta().get(i).size() + ") |" : "(0" + p.annaPoyta().get(i).size() + ") |");
                } else {
                    System.out.print("|  " + p.annaPoyta().get(i).get(p.annaPoyta().get(i).size() - 1).annaArvo());
                    System.out.print(p.annaPoyta().get(i).get(p.annaPoyta().get(i).size() - 1).annaMaa() + " ");
                    System.out.print(p.annaPoyta().get(i).size() >= 10 ? "(" + p.annaPoyta().get(i).size() + ") " : "(0" + p.annaPoyta().get(i).size() + ") ");
                }
            }
            System.out.println("Kortteja jäljellä: " + p.p.annaKortit().size());

            if (p.p.annaKortit().size() > 0) {
                p.pelaaKortti();
            }
        }



        System.out.println("Kurkku kävi oksentaa!");
        System.exit(0);
    }
}