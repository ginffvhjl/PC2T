package pc2t.cv08;

import java.util.Scanner;

/**
 * Třída sloužící k výběru uživatelské volby z konzole
 * 
 * Jiří Přinosil
 * 
 */
public class ConsoleInput {

  public static int readNumberInputFromConsole(Scanner sc) {
    int cislo = 0;
    try {
      cislo = sc.nextInt();
    } catch (Exception e) {
      System.out.println("Nastala vyjimka typu " + e.toString());
      System.out.println("zadejte prosim cele cislo ");
      sc.nextLine();
      cislo = readNumberInputFromConsole(sc);
    }
    return cislo;
  }

}
