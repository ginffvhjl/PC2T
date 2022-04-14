package pc2t.cv03;

public class BPIS implements Subject{
    //deklerace používaných promenných
    private static final String name = "BPIS";
    private static double points;
    //private static boolean credit;

    //převedení do test.java
    @Override
    public String nameSubject() {
        return name;
    }
    @Override
    public double pointsSubject() {
        return points;
    }
    @Override
    public boolean creditSubject() {
        if (points >= minPoint)
            return true;
        else
            return false;
    }

    // 1. bod: Metoda pro udělení zápočtu.
    public void setGiveCredit(){
        this.points = 100;
    }

    public  void setDontGiveCredit() {
        this.points = 0;
    }

    //Pomocná metoda kontroly Stringu.
    public static boolean checkString(String checkText) {
        if (checkText.equals("ano")) {
            return true;
        }
        return false;
    }
}
