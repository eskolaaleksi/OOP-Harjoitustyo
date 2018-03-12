import java.io.*;
import java.util.Scanner;

public class NelioJuomapeli implements Serializable{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pelipoyta p = new Pelipoyta(); //luodaan uusi pelipöytä
        boolean lataus = false; //oletusarvoisesti peli alustetaan alusta

        System.out.print("Ladataanko edellinen peli? Kyllä/Ei ");

        while (!(sc.hasNext("Kyllä") || sc.hasNext("Ei"))){
            System.out.print("Ladataanko edellinen peli? Kyllä/Ei ");
        }

        if (sc.hasNext("Kyllä")){
            lataus = true; //jos halutaan ladata vanha peli
        }

        if (lataus) { //käytetään input streamia pelin lataamiseen (false/true)
            try {
                FileInputStream fis = new FileInputStream("Nelio.ser"); //luodaan tallennustiedosto
                ObjectInputStream ois = new ObjectInputStream(fis);
                p = (Pelipoyta) ois.readObject();
                ois.close();
            }
            catch (FileNotFoundException e) {}  //tarkistetaan kaikki poikkeukset
            catch (IOException e) {}            // -ii-
            catch (ClassNotFoundException e) {} // -ii-
        }

        for (int k=0; k<=3; k++) { //luodaan rivit
            for (int j = 0; j < 2; j++) { //luodaan sarakkeet
                while (p.p.annaKortit().size() > 0) { //käsitellään vain tyhjiä pinoja
                    for (int i = 0; i <= p.annaPoyta().size() - 1; i += 1) { //käydään läpi kaikki pinot ja tulostetaan ne, muotoillaan myös erikoismerkeillä
                        if (i == 2 || i == 5 || i == 8) {
                            System.out.print("|  " + p.annaPoyta().get(i).get(p.annaPoyta().get(i).size() - 1).annaArvo());
                            System.out.print(p.annaPoyta().get(i).get(p.annaPoyta().get(i).size() - 1).annaMaa() + " ");
                            System.out.println(p.annaPoyta().get(i).size() >= 10 ? "(" + p.annaPoyta().get(i).size() + ") |" : "(0" + p.annaPoyta().get(i).size() + ") |");
                        } else {
                            System.out.print("|  " + p.annaPoyta().get(i).get(p.annaPoyta().get(i).size() - 1).annaArvo());
                            System.out.print(p.annaPoyta().get(i).get(p.annaPoyta().get(i).size() - 1).annaMaa() + " ");
                            System.out.print(p.annaPoyta().get(i).size() >= 10 ? "(" + p.annaPoyta().get(i).size() + ") " : "(0" + p.annaPoyta().get(i).size() + ") ");
                            if (k>=2 && i==3-k ){
                                System.out.println(" |");
                            }
                        }
                    }
                    System.out.println("Kortteja jäljellä: " + p.p.annaKortit().size()); //tarkistaa pakassa olevien korttien määrän

                    if (p.p.annaKortit().size() > 0) { //niin kauan kun kortteja on jäljellä, niitä pelataan
                        p.pelaaKortti();
                    }
                    try { //tallennus joka vuoron jälkeen
                        FileOutputStream fos = new FileOutputStream("Nelio.ser");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(p);
                        oos.close();
                    }

                    catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                if (k==0) { // kun pakka on tyhjä, poistetaan ristikon ylin rivi
                    p.poistaRivi();
                }
            }
            if (k>0) { //kun rivejä on enää yksi ja pakka on tyhjä, poistetaan pino kerrallaan
                p.poistaPino();
            }
        }
        System.out.println("\n\n");
        System.out.println("Kurkku kävi oksentaa!");
        p = new Pelipoyta(); //pelin loppuessa alustetaan uusi pelipöytä ja tallennetaan se, ettei voida vahingossa ladata peliä joka on jo loppunut

        try {
            FileOutputStream fos = new FileOutputStream("Nelio.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p);
            oos.close();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}