package pc2t.cv09;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CatImpl implements Animal {

    private byte age;

    public CatImpl(byte age) {
        super();
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public void sound() {
        System.out.println("miaow");
    }

    @Override
    public String toString() {
        return "CatImpl: Age: " + age;
    }

    @Override
    public void save() {
        try {
            FileWriter fileWriter = new FileWriter("animals.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("miaow");
            printWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
