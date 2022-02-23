package pc2t.cv03;

public class BPC1 implements Subject {

    //Deklarace proměnných, se kterými budeme pracovat.
    private static final String name = "BPC1";
    private double points;
    private static double activity;
    private static double exam;

    private static final int maxActivity = 20;
    private static final int maxExam = 80;

    //Předání jména, bodů, zápočtu Subject do test.java.
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
    public static void setActivity(double Activity) {
        if (Activity <= maxActivity && Activity >= 0)
            activity = Activity;
        else {
            System.out.println("Body za aktivitu zadány mimo interval <0,20>.");
            //TODO Zeptat se znovu.
        }
    }

    // 2. bod: Metoda pro zadání bodů za zkoušku.
    public static void setExam(double Exam) {
        if (Exam <= maxExam && Exam >= 0)
            exam = Exam;
        else {
            System.out.println("Body za zkoušku zadány mimo interval <0,80>.");
            //TODO Zeptat se znovu.
        }
    }


}
