package pc2t.cv09;

public class Cat extends AbstractAnimal {
    public Cat(byte age) {
        super(age);
    }

    @Override
    public void sound() {
        System.out.println("Mňau");
    }
}
