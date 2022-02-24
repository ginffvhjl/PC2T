package pc2t.cv03;

public class BPC1 implements Subject {

    //Deklarace proměnných, se kterými budeme pracovat.
    private static final String name = "BPC1";
    private double points;
    private static double activity;
    private static double exam;

    public static final int maxActivity = 20;
    public static final int maxExam = 80;

    //Předání jména, bodů, zápočtu - beru ze Subject.java.
    @Override
    public String nameSubject() {
        return name;
    }
    @Override
    public double pointsSubject() {
        points = activity+exam;
        return points;
    }
    @Override
    public boolean creditSubject() {
        if (points >= minPoint) {
            System.out.println("Splněno");
            return true;
        }
        else {
            System.out.println("Nesplněno");
            return false;
        }
    }

    // 1. bod: Metoda pro zadání bodů za aktivitu.
    public void setActivity(double activity) {
        this.activity = activity;
    }

    // 2. bod: Metoda pro zadání bodů za zkoušku.
    public void setExam(double exam) {
        this.exam = exam;
    }

    //Pomocná metoda kontroly intervalu.
    public static boolean checkRange(double checkPoints, double maxRange) {
        if (checkPoints >= 0 && checkPoints <= maxRange) {
            return true;
        }
        return false;
    }


}
