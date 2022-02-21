
import java.util.Scanner;

public class databaseOperation {

    public static void main(String[] args) {
        int count = 3;
        Scanner sc = new Scanner(System.in);
        //sc.useDelimiter("\\n");
        database[] arr = new database[count];

        for (int i=0; i < count; i++) {
            System.out.print("\n"+(i+1)+". zaměstnanec \nJméno: ");
            String name = sc.next();
            sc.nextLine();
            System.out.print("Rok narození: ");
            int year = sc.nextInt();

            arr[i] = new database(name, year,0);
        }

        /*for (int i=0; i<count;i++) {
            System.out.print("\n "+(i+1)+". zaměstnanec \nJméno: ");
            String name = sc.next();

            while (true) {
                System.out.print("Rok narození: ");
                if (sc.hasNextInt())
                    break;
                else
                    System.out.print("Neplatná hodnota!");
                sc.close();
            }
            int year = sc.nextInt();
            arr[i] = new database(name, year, 0);
        }*/

        System.out.print("\nZadejte maximální úvazek: ");
        database.setMax(sc.nextFloat());

        while (true) {
            System.out.print("\nZadejte index zaměstnance: ");
            int index = sc.nextInt() - 1;
            System.out.print("Jméno: " + arr[index].getName() + "\nRok: " + arr[index].getYear() + "\n");
            System.out.print("Zadejte nové úvazky: ");
            float load = sc.nextFloat();

            if (arr[index].AddLoad(load)) {
                System.out.print("Úvazek byl navýšen na " + arr[index].getLoad() + "\n");
            }
            else {
                System.out.print("Úvazek nelze navýšit - byl překročen maximální počet.");
                break;
            }
            /*if (index<count && index >= 0) {
                System.out.print("Jméno: "+arr[index].getName()+"\nRok: "+arr[index].getYear()+"\nÚvazek: "+arr[index].getLoad()+"\n");
                System.out.print("Zadejte nové úvazky: ");
                float tempLoad = sc.nextFloat();

                if (arr[index].AddLoad(tempLoad)) {
                    System.out.print("Nový úvazek je: "+arr[index].getLoad()+"\n");
                }
                else {
                    System.out.print("Úvazek nelze navýšit - byl překročen maximální počet.");
                    break;
                }*/

        }
    }
}
