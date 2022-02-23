package pc2t.cv03;

import java.util.Scanner;

public class Test {
    //Metoda main.
    public static void main(String[] args) {
        //Možnosti menu.
        int index;

        //Nabídky menu (pro switch).
        System.out.print("Menu\n \n1 BPC1\n2 BPC2\n3 BPIS\n0 Ukončit program\n\nVybráno: ");

        //Vytvoření scanneru.
        Scanner sc = new Scanner(System.in);

        //Menu musí zůstat v loop do ukončení uživatelem.
        boolean menu = true;
        //Tvorba menu.
        while (menu) {
            //Načtení indexu.
            index = sc.nextInt();

            switch (index) {
                case 0: {
                    menu = false;
                    break;
                }
                case 1: {
                    //Vytvoření hodnot předmětu.
                    Subject values = new BPC1();
                    //Zovolání metody na vypsání jména.
                    System.out.println("\n"+values.nameSubject());

                    //Zadání bodů.
                    System.out.print("Zadejte body za aktivitu na cvičení: ");
                    BPC1.setActivity(sc.nextDouble());
                    System.out.print("Zadejte body za zkoušku:");
                    BPC1.setExam(sc.nextDouble());

                    System.out.println("\nDosažené body: "+values.pointsSubject());

                    //Resolve zápočtu.
                    if (values.creditSubject())
                        System.out.println("Zápočet udělen.");
                    else
                        System.out.println("Zápočet neudělen.");
                    break;

                    //TODO Smazat obrazovku a načíst znovu menu.
                }
                case 2: {
                    Subject values = new BPC2();
                    System.out.println("\n"+values.nameSubject());

                    System.out.print("Zadejte body za projekt: ");
                    BPC2.setProject(sc.nextDouble());
                    System.out.print("Zadejte body za půlsemestrální zkoušku: ");
                    BPC2.setHalfExam(sc.nextDouble());
                    System.out.print("Zadejte body za zkoušku: ");
                    BPC2.setExam(sc.nextDouble());

                    System.out.println("\nDosažené body: "+values.pointsSubject());

                    if (values.creditSubject() == true)
                        System.out.println("Zápočet udělen.");
                    else
                        System.out.println("Zápočet neudělen.");
                    break;

                    //TODO Smazat a načíst znovu menu.
                }
                case 3: {
                    Subject values = new BPIS();
                    System.out.println("\n"+values.nameSubject());

                    System.out.print("Zápočet udělen: ");
                    sc.nextLine();
                    BPIS.setCredit(sc.nextLine());

                    if (values.creditSubject() == true)
                        System.out.println("Zápočet udělen.");
                    else
                        System.out.println("Zápočet neudělen.");
                    break;

                    //TODO Smazat a znovu načíst menu.
                }
                //Opatření při chybě uživatele.
                default:
                    menu = true;
            }
        }
    }
}
