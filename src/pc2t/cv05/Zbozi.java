package pc2t.cv05;

public abstract class Zbozi {

    private String name;
    private double price;
    // Zboží s DPH = price + DPH * price = price ( 1 + 0.21)
    private static double DPH = 1.21;

    Zbozi(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // Cena vracená s DPH
    public double getPrice() {
        return price * DPH;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String getJednotka();
}
