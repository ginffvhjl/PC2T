package pc2t.cv10;

public class Run {
    public static void main (String[] args) {
        int i = 1;
        Pole array = new Pole(3);

        array.zadejHranol();
        array.vypoctiObjem();
        array.vypoctiObsahPodstavy();

        array.zadejHranol();
        array.vypoctiObjem();
        array.vypoctiObsahPodstavy();

        array.zadejHranol();
        array.vypoctiObjem();
        array.vypoctiObsahPodstavy();

        System.out.println("Nejmenši objem má " + array.najdiNejmensiObjem());
        System.out.println("Počet dřevěných: "+ array.zjistiPocetDrevenych());

        array.zadejHranol();
        array.vypoctiObjem();
        array.vypoctiObsahPodstavy();
    }
}
