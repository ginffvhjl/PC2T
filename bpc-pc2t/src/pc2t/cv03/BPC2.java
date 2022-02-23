package pc2t.cv03;

public class BPC2 implements Subject{
    //Deklarace potřebných proměnných.
    private static final String name = "BPC1";
    private double points;
    private static double project;
    private static double halfExam;
    private static double exam;

    private static final int maxProject = 30;
    private static final int maxHalfExam = 20;
    private static final int maxExam = 50;

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
    public static void setProject(double Project) {
        if (Project <= maxProject && Project >= 0)
            project = Project;
        else {
            System.out.println("Body za projekt zadány mimo interval <0,30>.");
            //TODO Zeptat se znovu.
        }
    }

    // 2. bod: Metoda pro zadání bodů za půlsemestrální zkoušku.
    public static void setHalfExam(double HalfExamPoints) {
        if (HalfExamPoints <= maxHalfExam && HalfExamPoints >= 0)
            halfExam = HalfExamPoints;
        else {
            System.out.println("Body za půlsemestrální test byly zadány mimo interval <0,20>.");
            //TODO Zeptat se znovu.
        }
    }

    // 3. bod: Metoda pro zadání bodů za zkoušku.
    public static void setExam(double Exam) {
        if (Exam <= maxExam && Exam >= 0)
            exam = Exam;
        else {
            System.out.println("Body za zkoušky byly zadány mimo interval <0,50>.");
            //TODO Zeptat se znovu.
        }
    }

}
