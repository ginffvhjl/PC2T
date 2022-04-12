package pc2t.cv10;

import java.util.Scanner;

import static java.lang.Float.MAX_VALUE;

public class Pole {
    // Konstruktor s velikosti pole
    Pole(int velikost)
    {
        mojeHranoly = new Hranol[velikost];
        sc = new Scanner(System.in);
    }

    // vlozeni hranolu do pole na prvni volnou pozici
    void zadejHranol() {
        boolean drevena = false;
        float delka = 0;
        float vyska = 0;

        System.out.printf("Zadejte delku podstavy hranolu: ");
        while(!sc.hasNextFloat()) {
            sc.next();
        }
        delka=sc.nextFloat();
        System.out.printf("Zadejte vysku hranolu: ");
        while(!sc.hasNextFloat()) {
            sc.next();
        }
        vyska=sc.nextFloat();
        System.out.println("Je drevena? [true/false]");
        // TODO 6 hasNextFloat nahrazeno hasNextBoolean
        while(!sc.hasNextBoolean()) {
            sc.next();
        }
        drevena=sc.nextBoolean();
        // TODO 11 > nahrazeno >=
        if (Hranol.getPocetHranolu() >= mojeHranoly.length)
        {
            System.out.println("Pole uz je zaplneno");
            return;
        }
        // TODO 7 zápis nového hranolu
        mojeHranoly[Hranol.getPocetHranolu()] = new Hranol(delka, vyska, drevena);
    }

    // vypis objemu vsech hranolu
    void vypoctiObjem() {
        for (int i = 0; i < Hranol.getPocetHranolu(); i++)
            // TODO 8 místo vypostiObjem bylo vypoctiObsah + výpis o kolikátý hranol jde (vypisovalo "i.")
            System.out.println("Objem " + i + ". hranolu je " + mojeHranoly[i].vypoctiObjem());
    }

    // vypis obsahu podstavy vsech hranolu
    void vypoctiObsahPodstavy()
    {
        for (int i=0;i<Hranol.getPocetHranolu();i++)
            // 11. chyba: místo vypoctiObsah bylo vypostiObjem
            System.out.println("Obsah podstavy " + i + ". hranolu je " + mojeHranoly[i].vypoctiObsah());
    }

    // nalezeni indexu nejmensiho hranolu
    int najdiNejmensiObjem()
    {
        // TODO 9 "min = 0"
        float min = MAX_VALUE;
        int idx = 0;
        for (int i=0; i < Hranol.getPocetHranolu(); i++)
        {
            if (mojeHranoly[i].vypoctiObjem()<min){
                min=mojeHranoly[i].vypoctiObjem();
                idx=i;
            }
        }
        return idx;
    }

    // zjisteni celkoveho poctu drevenych kostek
    int zjistiPocetDrevenych(){
        int pocetDrevenych=0;
        // TODO 10 místo "i=1" "i=0"
        for (int i=0; i < mojeHranoly.length; i++)
        {
            // TODO 12 if (mojeHranoly[i].zeDreva = true)
            if (mojeHranoly[i].zeDreva == true) {
                pocetDrevenych++;
            }
        }
        return pocetDrevenych;
    }

    private Scanner sc;
    private Hranol []mojeHranoly;
}
