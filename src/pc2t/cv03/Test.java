package pc2t.cv03;

//import java.util.InputMismatchException;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    //Metoda main.
    public static void main(String[] args) throws IOException {
        //Možnosti menu.
        int index;

        //Nabídky menu (pro switch).
        System.out.print("Menu\n \n<1> BPC1\n<2> BPC2\n<3> BPIS\n<0> Konec\n\nVybráno: ");

        //Vytvoření scanneru.
        Scanner sc = new Scanner(System.in);

        //Menu musí zůstat v loop do ukončení uživatelem.
        boolean menu = true;
        //Tvorba menu.
        while (menu) {
            if (sc.hasNextInt()) {
                //Načtení indexu.
                index = sc.nextInt();

                switch (index) {
                    case 0: {
                        menu = false;
                        break;
                    }
                    case 1: {
                        //Vytvoření objektu
                        BPC1 values = new BPC1();
                        //Zovolání metody name.Subject.
                        System.out.println("\n" + values.nameSubject());

                        System.out.print("Zadejte body za aktivitu na cvičení: ");
                        //Zadání bodů.
                        while (true) {
                            if (sc.hasNextDouble()) {
                                double help = sc.nextDouble();
                                //Kontrola intervalu.
                                if (BPC1.checkRange(help, BPC1.maxActivity)) {
                                    values.setActivity(help);
                                    break;
                                } else {
                                    System.out.print("\nBody byly zadány mimo interval <0,20>\nZadejte znovu: ");
                                }
                            } else {
                                System.out.print("Špatně zadaná hodnota!\nZadejte znovu číselnou hodnotu bodů za aktivitu: ");
                                //Skanner čeká na další imput + vynuluje vstup z klávesnice.
                                sc.next();
                            }
                        }

                        System.out.print("Zadejte body za zkoušku: ");
                        while (true) {
                            if (sc.hasNextDouble()) {
                                double help = sc.nextDouble();
                                if (BPC1.checkRange(help, BPC1.maxExam)) {
                                    values.setExam(help);
                                    break;
                                } else {
                                    System.out.print("\nBody byly zadány mimo interval <0,80>\nZadejte znovu: ");
                                }
                            } else {
                                System.out.print("Špatně zadaná hodnota!\nZadejte znovu číselnou hodnotu bodů za zkoušku: ");
                                sc.next();
                            }
                        }
                        System.out.println("\nDosažené body: " + values.pointsSubject());
                        //Resolve zápočtu.
                        if (values.creditSubject()) {
                            System.out.println("\nZápočet udělen.");
                        } else {
                            System.out.println("\nZápočet neudělen.");
                        }

                        System.out.print("\nStiskněte enter pro pokračování...");
                        try {
                            System.in.read();
                        }
                        catch (Exception e) {
                        }
                        clearScreen();
                        System.out.print("\n\nMenu\n\n<1> BPC1\n<2> BPC2\n<3> BPIS \n<0> Konec\n\nZvolte další akci: ");
                        break;
                        //TODO Smazat obraz, načíst znovu menu.
                    }

                    case 2: {
                        //Vytvoření objektu.
                        BPC2 values = new BPC2();
                        //Zavolání metody name.Subject.
                        System.out.println("\n" + values.nameSubject());

                        System.out.print("Zadejte body za projekt: ");
                        while (true) {
                            if (sc.hasNextDouble()) {
                                double help = sc.nextDouble();
                                //Kontrola intervalu.
                                if (BPC2.checkRange(help, BPC2.maxProject)) {
                                    values.setProject(help);
                                    break;
                                } else {
                                    System.out.print("\nBody zadány mimo interval <0,30>\nZadejte znovu: ");
                                }
                            } else {
                                System.out.print("Špatně zadaná hodnota!\nZadejte znovu číselnou hodnotu bodů za projekt: ");
                                sc.next();
                            }
                        }
                        System.out.print("Zadejte body za půlsemestrální zkoušku: ");
                        while (true) {
                            if (sc.hasNextDouble()) {
                                double help = sc.nextDouble();
                                if (BPC2.checkRange(help, BPC2.maxHalfExam)) {
                                    values.setHalfExam(help);
                                    break;
                                } else {
                                    System.out.print("\nBody zadány mimo interval <0,20>\nZadejte znovu: ");
                                }
                            } else {
                                System.out.print("Špatně zadaná hodnota!\nZadejte znovu číselnou hodnotu bodů za půlsemestrální test: ");
                                sc.next();
                            }
                        }
                        System.out.print("Zadejte body za zkoušku: ");
                        while (true) {
                            if (sc.hasNextDouble()) {
                                double help = sc.nextDouble();
                                if (BPC2.checkRange(help, BPC2.maxExam)) {
                                    values.setExam(help);
                                    break;
                                } else {
                                    System.out.print("Body zadány mimo interval <0,50>\nZadejte znovu: ");
                                }
                            } else {
                                System.out.print("Špatně zadaná hodnota!\nZadejte znovu číselnou hodnotu bodů za zkoušku: ");
                                sc.next();
                            }
                        }

                        System.out.println("\nDosažené body: " + values.pointsSubject());

                        if (values.creditSubject()) {
                            System.out.println("\nZápočet udělen.");
                        } else {
                            System.out.println("\nZápočet neudělen.");
                        }
                        System.out.print("\nStiskněte enter pro pokračování...");
                        try {
                            System.in.read();
                        }
                        catch (Exception e) {
                        }
                        System.out.print("\n\nMenu\n\n<1> BPC1\n<2> BPC2\n<3> BPIS \n<0> Konec\n\nZvolte další akci: ");
                        break;

                        //TODO Smazat obraz, načíst znovu menu.
                    }

                    case 3: {
                        BPIS values = new BPIS();
                        System.out.println("\n" + values.nameSubject());

                        System.out.print("Zápočet udělen: ");
                        sc.nextLine();
                        while (true) {
                            String help = sc.nextLine();
                            if (help.equals("ano") || help.equals("ne")) {
                                if (BPIS.checkString(help)) {
                                    values.setGiveCredit();
                                    break;
                                } else {
                                    values.setDontGiveCredit();
                                    break;
                                }
                            } else {
                                System.out.print("Odpověď zadaná ve špatném tvaru!\nZadejte ano/ne: ");
                            }
                        }

                        if (values.creditSubject()) {
                            System.out.println("\nZápočet udělen.");
                        } else {
                            System.out.println("\nZápočet neudělen.");
                        }
                        System.out.print("\nStiskněte enter pro pokračování...");
                        try {
                            System.in.read();
                        }
                        catch (Exception e) {
                        }
                        System.out.print("\n\nMenu\n\n<1> BPC1\n<2> BPC2\n<3> BPIS \n<0> Konec\n\nZvolte další akci: ");
                        break;

                        //TODO Smazat obraz a načíst znovu menu.
                    }

                    //Opatření při chybě uživatele.
                    default: {
                        System.out.print("Zadejte položku z menu!\nVybráno: ");
                        menu = true;
                    }
                }
                //break;
            }
            else {
                System.out.print("Zadejte položku z menu! <1> <2> <3> <0>\nVybráno: ");
                sc.next();
            }
        }
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
