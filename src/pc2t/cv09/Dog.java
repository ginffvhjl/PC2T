package pc2t.cv09;

public class Dog extends AbstractAnimal {
    public Dog(byte age) {
        super(age);
    }

    @Override
    public void sound() {
        System.out.println("Haf");
    }
}
