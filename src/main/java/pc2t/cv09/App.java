package pc2t.cv09;

public class App {
    public static void main(String[] args) {
        char [] password = {'a','h','o','j'};

        Employee e1 = new Employee("e1", "e1mail", password);
        Employee e2 = new Employee("e2", "e2mail", password);
        Employee e3 = new Employee("e3", "e4mail", password);
        Employee e4 = new Employee("e4", "e3mail", password);
        Employee e5 = new Employee("e5", "e5mail", password);

        Manager m1 = new Manager("m1", "m1email", password);

        Secretary s1 = new Secretary("s1", "s1email", password, 20);
        Secretary s2 = new Secretary("s2", "s2email", password, 25);

        m1.addRelation(s1);

        m1.addEmployee(e1);
        m1.addEmployee(e2);
        m1.addEmployee(e3);
        m1.addEmployee(e4);
        m1.addEmployee(e5);

        m1.writeEmployees();
        System.out.println();
        // TODO "vypiš managera" v bodě 4
        m1.writeRelationships();

        System.out.println();

        byte a = 1;

        Cat cat1 = new Cat(a);
        Dog dog1 = new Dog(a);
        Pig pig1 = new Pig(a);
        Cow cow1 = new Cow(a);
        Goat goat1 = new Goat(a);

        cat1.sound();
        dog1.sound();
        pig1.sound();
        cow1.sound();
        goat1.sound();

        System.out.println();

        CatImpl cat2 = new CatImpl(a);
        DogImpl dog2 = new DogImpl(a);
        PigImpl pig2 = new PigImpl(a);
        CowImpl cow2 = new CowImpl(a);
        GoatImpl goat2 = new GoatImpl(a);

        cat2.sound();
        cat2.save();

        dog2.sound();
        dog2.save();

        pig2.sound();
        pig2.save();

        cow2.sound();
        cow2.save();

        goat2.sound();
        goat2.save();
    }
}
