package pc2t.cv02;

public class database extends databaseOperation {

    // 1. bod: Proměnné Jméno soby, rok narození, výše úvazku (v oboru reálných čísel)
    private String name;
    private int year;
    private float load;
    // 2. bod: Statická proměnná obsahující maximální možný úvazek (zpočátku nastaven na 1)
    public static float max = 1;

    // 3. bod: Konstruktor třídy - nastavení jména, roku narození.
    public database(String name, int year, float load) {
        this.name = name;
        this.year = year;
        this.load = load;
    }

    // 4. bod: Gettery (a settery) pro jednotlivé proměnné ( - settery se nepužívají, jsou zbytečné).
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getLoad() {
        return load;
    }

    public void setLoad(float load) {
        this.load = load;
    }

    // 5. bod: Nastevení setteru (a getteru) statické proměné maximálního úvazku - getter nevyužit.
    public static float getMax() {
        return max;
    }

    public static void setMax(float max) {
        database.max = max;
    }

    // 6. bod: kontrola úvazku (zjednodušeně popsaný bod -> zadání).
    public boolean AddLoad(float load) {
        if ((load+this.load) > max)
            return false;
        else {
            this.load += load;
            return true;
        }
    }
}
