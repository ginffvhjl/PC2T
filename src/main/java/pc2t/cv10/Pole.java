package pc2t.cv10;

import java.util.Scanner;

import static java.lang.Float.MAX_VALUE;

public class Pole {
    // Konstruktor s velikosti pole
    Pole(int velikost) {
        mojeHranoly = new Hranol[velikost];
    }

    // vlozeni hranolu do pole na prvni volnou pozici
    void zadejHranol() {
        // TODO zbytečně iniciovné
        boolean drevena;
        float delka;
        float vyska;

        Scanner sc = new Scanner(System.in);

        System.out.printf("Zadejte delku podstavy hranolu: ");
        while (!sc.hasNextFloat()) {
            sc.next();
        }
        delka = sc.nextFloat();
        System.out.printf("Zadejte vysku hranolu: ");
        while (!sc.hasNextFloat()) {
            sc.next();
        }
        vyska = sc.nextFloat();
        System.out.println("Je drevena? [true/false]");
        // TODO 5 hasNextFloat nahrazeno hasNextBoolean
        while (!sc.hasNextBoolean()) {
            sc.next();
        }
        drevena = sc.nextBoolean();
        // TODO 12 > nahrazeno >=
        if (Hranol.getPocetHranolu() >= mojeHranoly.length) {
            System.out.println("Pole uz je zaplneno");
            return;
        }
        // TODO 6 zápis nového hranolu
        mojeHranoly[Hranol.getPocetHranolu()] = new Hranol(delka, vyska, drevena);
    }

    // vypis objemu vsech hranolu
    void vypoctiObjem() {
        for (int i = 0; i < Hranol.getPocetHranolu(); i++)
            // TODO 8 místo vypostiObjem bylo vypoctiObsah + výpis o kolikátý hranol jde (vypisovalo "i.")
            System.out.println("Objem " + (i + 1) + ". hranolu je " + mojeHranoly[i].vypoctiObjem());
    }

    // vypis obsahu podstavy vsech hranolu
    void vypoctiObsahPodstavy() {
        for (int i = 0; i < Hranol.getPocetHranolu(); i++)
            // TODO 9: místo vypoctiObsah bylo vypoctiObjem
            System.out.println("Obsah podstavy " + (i + 1) + ". hranolu je " + mojeHranoly[i].vypoctiObsah());
    }

    // nalezeni indexu nejmensiho hranolu
    int najdiNejmensiObjem() {
        // TODO 10 "min = 0"
        float min = MAX_VALUE;
        //float min = mojeHranoly[0].vypoctiObjem(); // ve for cyklu se musí začínat porovnávat první hranol s druhým hranolem -> i = 1)
        int idx = 0;
        for (int i = 0; i < Hranol.getPocetHranolu(); i++) {
            if (mojeHranoly[i].vypoctiObjem() < min) {
                min = mojeHranoly[i].vypoctiObjem();
                idx = i + 1;
            }
        }
        return idx;
    }

    // zjisteni celkoveho poctu drevenych kostek
    int zjistiPocetDrevenych() {
        int pocetDrevenych = 0;
        // TODO 11 místo "i = 1" "i = 0"
        for (int i = 0; i < mojeHranoly.length; i++) {
            // TODO 13 if (mojeHranoly[i].zeDreva = true)
            if (mojeHranoly[i].zeDreva == true) {
                pocetDrevenych++;
            }
        }
        return pocetDrevenych;
    }

    private Hranol[] mojeHranoly;
}
