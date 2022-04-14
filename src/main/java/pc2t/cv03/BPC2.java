package pc2t.cv03;

public class BPC2 implements Subject{
    //Deklarace potřebných proměnných.
    private static final String name = "BPC1";
    private double points;
    private static double project;
    private static double halfExam;
    private static double exam;

    public static final int maxProject = 30;
    public static final int maxHalfExam = 20;
    public static final int maxExam = 50;

    //Převedení do test.java.
    @Override
    public String nameSubject() {
        return name;
    }
    @Override
    public double pointsSubject() {
        points = project+halfExam+exam;
        return points;
    }
    @Override
    public boolean creditSubject() {
        if (points >= minPoint) {
            return true;
        }
        else
            return false;
    }

    // 1. bod: Metoda pro zadání bodů za projekt.
    public void setProject(double project) {
        this.project = project;
    }

    // 2. bod: Metoda pro zadání bodů za půlsemestrální zkoušku.
    public void setHalfExam(double halfExam) {
        this.halfExam = halfExam;
    }

    // 3. bod: Metoda pro zadání bodů za zkoušku.
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
