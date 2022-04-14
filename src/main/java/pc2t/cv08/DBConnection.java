package pc2t.cv08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Double checked singleton class (singleton means that only one instance of this class could be
 * created) getting database connection.
 * 
 * @author Pavel Šeda (154208)
 *
 */
public class DBConnection {

  private static volatile Connection dbConnection;

  private DBConnection() {}

  /**
   * Metoda, která vytváří "jedináčka" čili maximálně jednu instanci připojení k databázi.
   * 
   * POZN: Není vhodné vytvářet mnoho instancí připojení k databázi, aby se databáze nezahltila
   * 
   * @return vrací instanci, připojení k databázi
   */
  public static Connection getDBConnection() {
    if (dbConnection == null) {
      synchronized (DBConnection.class) {
        if (dbConnection == null) {
          try {
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:src/main/java/pc2t/cv08/db/user.db");
          } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // log it
          }
        }
      }
    }
    return dbConnection;
  }

  /**
   * metoda uzavírající spojení s databází POZN. vhodné volat tuto metodu až po vykonání všech
   * dotazů nad databází
   */
  public static void closeConnection() {
    try {
      dbConnection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
