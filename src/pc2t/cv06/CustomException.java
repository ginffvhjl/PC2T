package pc2t.cv06;

public class CustomException extends Exception {
    // Výjimka bez vstupu
    public CustomException() {
        // super volá dědičný konstruktor
        super("Nebyl zadán průměr.");
    }
    // Kontrola, že je zadaný průměr ve správném intervalu
    public CustomException(double average) {
        super("Průměr nebyl zadán v intervalu <1,5>, zadali jste: "+average);
    }
}





