package pc2t.cv10;

// TODO 1 typo - Cetverec instead of Ctverec
public class Hranol extends Ctverec {

    // konstruktor se zadanim delky hrany, vysky a materialu
    Hranol(float podstava,float vyska, boolean drevena) {
        // TODO 2 podstava nevyužita - přidán super(podstava)
        super(podstava);
        hrana = vyska;
        zeDreva = drevena;
        pocetHranolu++;
    }

    // vypocet objemu hranolu
    float vypoctiObjem() {
        // TODO 7 hrana přepsána na výšku -> hrana*hrana nahrazeno vypoctiObsah
        return this.hrana*vypoctiObsah();
    }

    // nastaveni materialu
    void setDreveny(boolean dreveny) {
        zeDreva=dreveny;
    }

    // zjisteni materialu
    boolean jeDreveny(){
        return zeDreva;
    }

    // zjisteni celkoveho poctu existujicich kostek
    static int getPocetHranolu() {
        return pocetHranolu;
    }

    // zjisteni vysky hranolu
    float getHrana(){
        return hrana;
    }
    // nastaveni vysky hranolu
    void setHrana(float delka) {
        hrana = delka;
    }

    private float hrana;
    boolean zeDreva;
    // TODO 3 z final přepsáno na static (přiřazujeme jí novou hodnotu, což s final nelze dělat
    static int pocetHranolu=0;
}
