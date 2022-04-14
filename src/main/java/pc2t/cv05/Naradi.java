package pc2t.cv05;

public class Naradi extends Zbozi {

    private int warranty;
    // Konstruktor potomka
    public Naradi(String name, double price, int warranty) {
        // super volání konstruktoru rodičovské třídy
        super(name, price);
        this.warranty = warranty;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    @Override public String getJednotka() {
        if (warranty == 1) {
            return "měsíc";
        }
        else if (warranty > 1 && warranty < 5) {
            return "měsíce";
        }
        else {
            return "měsíců";
        }
    }
}
