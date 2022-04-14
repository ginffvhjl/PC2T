package pc2t.cv05;

public class Potravina extends Zbozi {

    private int expiration;
    // Konstuktor potomka
    public Potravina(String name, double price, int expiration) {
        // Volání konstrutoru rodičovské třídy
        super(name, price);
        this.expiration = expiration;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    @Override
    public String getJednotka() {
        if (expiration == 1) {
            return "den";
        }
        else if (expiration > 1 && expiration < 5) {
            return "dny";
        }
        else {
            return "dnů";
        }
    }
}
