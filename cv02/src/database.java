public class database extends databaseOperation {

    private String name;
    private int year;
    private float load;
    public static float max = 1;

    public database(String name, int year, float load) {
        this.name = name;
        this.year = year;
        this.load = load;
    }

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

    public static float getMax() {
        return max;
    }

    public static void setMax(float max) {
        database.max = max;
    }

    public boolean AddLoad(float load) {
        if ((load+this.load) > max)
            return false;
        else {
            this.load += load;
            return true;
        }
    }
}
