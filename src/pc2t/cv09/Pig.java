package pc2t.cv09;

public class Pig extends AbstractAnimal{
    public Pig(byte age) {
        super(age);
    }

    @Override
    public void sound() {
        System.out.println("Chro chro");
    }
}
