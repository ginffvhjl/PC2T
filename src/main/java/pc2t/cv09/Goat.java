package pc2t.cv09;

public class Goat extends AbstractAnimal {
    public Goat(byte age) {
        super(age);
    }

    @Override
    public void sound() {
        System.out.println("Meeé");
    }
}
