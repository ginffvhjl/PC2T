package pc2t.cv10;

public class Ctverec {
    private float hrana;
    // vypocet obsahu ctverce
    int vypoctiObsah(){
        return (int)(hrana*hrana);
    }
    // zjisteni delky hrany ctverce
    float getHrana(){
        return hrana;
    }
    // nastaveni delky hrany ctverce
    void setHrana(float delka){
        hrana=delka;
    }
    // konstruktor se zadanim delky hrany ctverce
    Ctverec(float hrana){
        // TODO 5 chybělo this.
        this.hrana=hrana;
    }
}
