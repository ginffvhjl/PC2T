package pc2t.cv08.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pc2t.cv08.DBConnection;

/**
 * 
 * @author Pavel eda (154208)
 *
 */
public class InsertQueries {

  public InsertQueries() {}


  /**
   * Template metoda, do které se dá vkládat libovolný SQL INSERT pøíkaz.
   * 
   * POZN: není vhodné implementovat své metody tímto zpùsobem, daleko vhodnìjí je implementovat
   * konkrétní metody (napø. insertNewUser(String email, char[] password) pomocí PreparedStatements,
   * do kterých vkládáme konkrétní parametry)
   * 
   * @param insertQuery øetìzec pøedstavující pøíkaz INSERT
   */
  public void performInsertQuery(String insertQuery) {
    if (insertQuery == null) {
      throw new NullPointerException("query must not be null!");
    } else if (insertQuery.isEmpty()) {
      throw new IllegalArgumentException("query must not be empty!");
    }
    Connection conn = DBConnection.getDBConnection();
    try (PreparedStatement prStmt = conn.prepareStatement(insertQuery);) {
      int rowsInserted = prStmt.executeUpdate();
      // System.out.println("Bylo vloeno uivatelù: " + rowsInserted);
      System.out.println("Byl vloen uivatel s emailem: " + "myname123@stud.feec.vutbr.cz");
    } catch (SQLException e) {
      System.out.println("Uivatel s emailem: " + "myname123@stud.feec.vutbr.cz "
          + "ji byl vloen nemusíte jej vkládat znovu");
      // e.printStackTrace();
    }
  }

  /**
   * Úkol: Vaím úkolem je pøiøadit INSERT pøíkaz do promìnné insertUser, tak aby se vytvoøil nový
   * uivatel dle zadaných parametrù
   * 
   * HINT: V této metodì jsou vyuity preparedStatements, take se parametr emailu nastaví a
   * pozdìji pøíkazem prStmt.setString(1, email)... Pro pøedstavu, jak se píí prepared statements
   * se podívejte na následující odkaz:
   * https://www.mkyong.com/jdbc/jdbc-preparestatement-example-insert-a-record/
   * 
   * @param email uivatele
   * @param name uivatele
   * @param surname uivatele
   //* @param age uivatele
   //* @param salary uivatele
   */
  public void insertNewUser(String email, String name, String surname) {
    if (email == null || name == null || surname == null)
      throw new NullPointerException("Email, name and surname must be set.");

    Connection conn = DBConnection.getDBConnection();

    String insertUser = "INSERT INTO user" + "(email,name,surname)" + "VALUES(?, ?, ?)";

    try (PreparedStatement prStmt = conn.prepareStatement(insertUser)) {
      prStmt.setString(1, email);
      prStmt.setString(2, name);
      prStmt.setString(3, surname);

      prStmt.executeUpdate();
      System.out.println("Nový uivatel byl vloen do databáze!");
    } catch (SQLException e) {
      System.out.println("Uivatel u byl vloen nebo jste zadali patnì SQL pøíkaz INSERT");
      // e.printStackTrace();
    }
  }


}
