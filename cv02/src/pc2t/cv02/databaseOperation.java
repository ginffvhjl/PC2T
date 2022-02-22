package pc2t.cv02;

import java.util.Scanner;

public class databaseOperation {

    public static void main(String[] args) {
        int count = 3;
        Scanner sc = new Scanner(System.in);
        //sc.useDelimiter("\\n"); //nefunguje

        // 1. bod: Pole objektů tupy database o velikosti 3.
        database[] arr = new database[count];

        // 2. bod: Naplnění pole jménem a rokem narození.
        for (int i=0; i < count; i++) {
            System.out.print("\n"+(i+1)+". zaměstnanec \nJméno: ");
            String name = sc.next(); //mohou se vyskytnout problémy se čtením víceslových jmen
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
            arr[i] = new pc2t.cv02.database(name, year, 0);
        }*/

        // 3. bod: Maximální povolená výše ǘvazku
        System.out.print("\nZadejte maximální úvazek: ");
        database.setMax(sc.nextFloat());

        // 4. bod: Nekonečná smyčka - pravděpodobně modifikováno -> zadání.
        while (true) {
            System.out.print("\nZadejte index zaměstnance: "); // Pokaždé se zeptá na nového zaměstnance - v zadání pravděpodobně smyčka jen pro jednoho.
            int index = sc.nextInt() - 1;
            System.out.print("Jméno: " + arr[index].getName() + "\nRok: " + arr[index].getYear() + "\n");
            System.out.print("Zadejte nové úvazky: ");
            float load = sc.nextFloat();

            if (arr[index].AddLoad(load)) {
                System.out.print("Úvazek byl navýšen na " + arr[index].getLoad() + "\n");
            }
            else {
                System.out.print("Úvazek nelze navýšit - byl překročen maximální počet.");
                break; // K zastavení dochází až když u nějakého zaměstnance budeme chtít přesáhnout výši maximálního úvazku.
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
