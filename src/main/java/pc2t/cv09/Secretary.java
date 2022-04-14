package pc2t.cv09;

public class Secretary extends Employee {
    public Secretary(String nickname, String email, char[] password, int age) {
        super(nickname, email, password);
        this.age = age;

    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
