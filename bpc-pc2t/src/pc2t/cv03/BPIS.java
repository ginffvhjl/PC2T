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
    public static void setCredit(String Credit){
        if (Credit.equals("ano"))
            points = 100;
        else if (Credit.equals("ne"))
            points = 0;
        else {
            System.out.println("Zadejte ano / ne.");
            //TODO Zeptat se znovu.
        }
    }
}
