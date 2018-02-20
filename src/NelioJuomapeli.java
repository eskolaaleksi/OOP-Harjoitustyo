public class NelioJuomapeli{

    public static void main(String[] args) {
        Pelipoyta p = new Pelipoyta();
        p.luoPelipoyta();
        /*for (int i=1; i<=52; i++) {
            System.out.print("" + i + ". " + p.annaKortit().get(i-1).annaMaa() + " ");
            System.out.println(p.annaKortit().get(i-1).annaArvo());
        }*/

        //tulostetaan pelipöytä

        for (int i=0; i<=8; i+=1) {
            if (i==2 || i==5 || i==8) {
                System.out.print("|  " + p.annaPoyta().get(i).get(p.annaPoyta().get(i).size()-1).annaArvo());
                System.out.print(p.annaPoyta().get(i).get(p.annaPoyta().get(i).size()-1).annaMaa() + " ");
                System.out.println(p.annaPoyta().get(i).size() >= 10 ? "(" + p.annaPoyta().get(i).size() + ") |" : "(0" + p.annaPoyta().get(i).size() + ") |" );
            }
            else {
                System.out.print("|  " + p.annaPoyta().get(i).get(p.annaPoyta().get(i).size()-1).annaArvo());
                System.out.print(p.annaPoyta().get(i).get(p.annaPoyta().get(i).size()-1).annaMaa() + " ");
                System.out.print(p.annaPoyta().get(i).size() >= 10 ? "(" + p.annaPoyta().get(i).size() + ") " :  "(0" + p.annaPoyta().get(i).size() + ") " );
            }
        }
        p.pelaaKortti();
        for (int i=0; i<=8; i+=1) {
            if (i==2 || i==5 || i==8) {
                System.out.print("|  " + p.annaPoyta().get(i).get(p.annaPoyta().get(i).size()-1).annaArvo());
                System.out.print(p.annaPoyta().get(i).get(p.annaPoyta().get(i).size()-1).annaMaa() + " ");
                System.out.println(p.annaPoyta().get(i).size() >= 10 ? "(" + p.annaPoyta().get(i).size() + ") |" : "(0" + p.annaPoyta().get(i).size() + ") |" );
            }
            else {
                System.out.print("|  " + p.annaPoyta().get(i).get(p.annaPoyta().get(i).size()-1).annaArvo());
                System.out.print(p.annaPoyta().get(i).get(p.annaPoyta().get(i).size()-1).annaMaa() + " ");
                System.out.print(p.annaPoyta().get(i).size() >= 10 ? "(" + p.annaPoyta().get(i).size() + ") " :  "(0" + p.annaPoyta().get(i).size() + ") " );
            }
        }
        /* System.out.println();
        p.uusiKortti(4);
        System.out.print(p.annaPoyta().get(4).get(p.annaPoyta().get(4).size()-1).annaMaa() + " ");
        System.out.println(p.annaPoyta().get(4).get(p.annaPoyta().get(4).size()-1).annaArvo()); */
    }
}