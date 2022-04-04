package pc2t.cv09;

public abstract class AbstractAnimal {
    public void sound() {

    }

    private byte age;

    public AbstractAnimal(byte age) {
        super();
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }


}
