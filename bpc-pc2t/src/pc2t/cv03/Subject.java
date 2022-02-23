package pc2t.cv03;

// A. bod: vytvoření interface Subject
public interface Subject {

    // 1. bod: Metoda - vrací název předmětu.
    public String nameSubject();
    // 2. bod: Metoda - vrací počet bodů.
    public double pointsSubject(); //int pro celá čísla - nevím, jaké body, double je přesnější než float.
    // 3. bod: Metoda - splnění zápočtu.
    public boolean creditSubject();

    // 4. bod: Konstrukce - udává minimální počet bodů (15).
    final int minPoint = 15; // Jde o proměnnou, která se nikde nebude měnit
}
