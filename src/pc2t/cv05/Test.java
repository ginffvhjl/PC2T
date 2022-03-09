package pc2t.cv05;

public class Test {

    public static void main(String[] args) {
        Zbozi[] goods = new Zbozi[4];
        // Naplnění pole
        goods[0] = new Potravina("Rohlík", 1.5, 1);
        goods[1] = new Naradi("Kleště", 278.0, 24);
        goods[2] = new Potravina("Chleba", 20.8, 6);
        goods[3] = new Potravina("Jablko", 51.0, 20);

        for (int i = 0; i < goods.length; i++ ) {
            // Kam položka náleží (potravina/nářadí)
            if (goods[i] instanceof Potravina) {
                Potravina expiration = (Potravina) goods[i];
                System.out.println(goods[i].getName()+", cena: "+goods[i].getPrice()+", trvanlivost: "+expiration.getExpiration()+" "+expiration.getJednotka());
            }
            else {
                Naradi warranty = (Naradi) goods[i];
                System.out.println(goods[i].getName()+", cena: "+goods[i].getPrice()+", záruka: "+warranty.getWarranty()+" "+warranty.getJednotka());
            }
        }
    }
}
