package pc2t.cv08;

import java.util.Scanner;
import pc2t.cv08.crud.*;

/**
 * POZN. V úkolech je časté doimplementovat příkaz nebo celou metodu, proto pokud se z této třídy
 * chcete dostat k implementaci metody zmáčkněte tlačítko Control a pravým najeďte na metodu, kterou
 * máte implementovat a klikněte na Open Implementation.
 * 
 * @author Pavel Šeda (154208)
 *
 */
public class RunApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int choice = 0;
    boolean run = true;
    int iteration = 0;

    while (run) {
      if (iteration == 0)
        iteration++;
      else
        System.out.println(System.lineSeparator());
      System.out.println("Vyberte požadovanou činnost:");
      System.out.println("1 .. vložení uživatele s emailem myname123@stud.feec.vutbr.cz");
      System.out.println("2 .. vložení libovolného zadaného uživatele");
      System.out.println("3 .. výpis emailu, jména a příjmení o všech uživatelích");
      System.out.println("4 .. výpis všech uživatelů s rolí USER");
      System.out.println("5 .. zvýšení platu uživatele s emailem: myname@stud.feec.vutbr.cz o 20%");
      System.out.println("6 .. smazání uživatele");
      System.out.println("7 .. výpis všech rolí v systému");
      System.out.println("8 .. ukonceni aplikace");
      choice = ConsoleInput.readNumberInputFromConsole(sc);
      switch (choice) {
        case 1:
          // tento příklad znázorňuje vložení uživatele s emailem: myname123@stud.feec.vutbr.cz,
          // jménem Jon, přijmením Doe, věkem 30 let a výší platu 10 000
          InsertQueries i = new InsertQueries();
          i.performInsertQuery("INSERT INTO user " + "(email,name,surname,age,salary)"
              + "VALUES('myname123@stud.feec.vutbr.cz', 'Jon','Doe', 30, 10000)");
          break;
        case 2:
          System.out.println("Zadejte email uživatele");
          String email = sc.next();
          SelectQueries testUserExistence = new SelectQueries();
          if (testUserExistence.testIfUserExists(email)) {
            String userEmailToCreate = "";
            do {
              System.out.println(
                  "Uživatel s takovýmto emailem již existuje prosím zadejte email znovu: ");
              userEmailToCreate = sc.next();
            } while (testUserExistence.testIfUserExists(userEmailToCreate));
          }

          System.out.println("Zadejte jméno uživatele");
          String name = sc.next();
          System.out.println("Zadejte příjmení uživatele");
          String surname = sc.next();

          InsertQueries i2 = new InsertQueries();
          i2.insertNewUser(email, name, surname);
          break;
        case 3:
          SelectQueries se = new SelectQueries();
          // doplňtě tuto metodu dle zadání v metodě
          se.getAllUserEmailAndNameAndSurname();
          break;
        case 4:
          SelectQueries selectUserRoles = new SelectQueries();
          // prostudujte si tuto metodu a zjistěte, jak funguje JOIN tabulek
          selectUserRoles.getAllUsersWithRoleUser();
          break;
        case 5:
          SelectQueries selectUser = new SelectQueries();
          System.out.println("Email a plat uživatele před zvýšením platu o 20%");
          selectUser.printUserEmailAndSalary("myname@stud.feec.vutbr.cz");
          UpdateQueries updateQuery = new UpdateQueries();

          // doplňte tuto metodu, tak abyste tomuto uživateli zvýšili plat o 20%
          updateQuery.increase20PercentOfSalary("myname@stud.feec.vutbr.cz");

          System.out.println("Email a plat uživatele po zvýšením platu o 20%");
          selectUser.printUserEmailAndSalary("myname@stud.feec.vutbr.cz");
          break;
        case 6:
          System.out.println(
              "Zadejte email uživatele, kterého chcete vymazat z databáze (např. myname123@stud.feec.vutbr.cz)");
          String userName = sc.next();
          SelectQueries s = new SelectQueries();
          if (s.testIfUserExists(userName)) {
            DeleteQueries d = new DeleteQueries();

            // doplňte metodu na vymazání uživatele dle emailu
            d.deleteUserByEmail(userName);
          } else {
            System.out
                .println("Uživatel se zadaným emailem neexistuje, zkuste zadat email správně.");
            break;
          }
          break;
        case 7:
          SelectQueries roles = new SelectQueries();
          // implementuje celou metodu printAllRolesInDB, tak aby vypsala všechny role v DB
          roles.printAllRolesInDB();
          break;
        case 8:
          run = false;
          DBConnection.closeConnection();
          break;
        default:
          run = false;
          DBConnection.closeConnection();
          break;
      }
    }
  }
}
