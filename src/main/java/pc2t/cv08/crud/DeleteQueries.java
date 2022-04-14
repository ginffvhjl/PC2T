package pc2t.cv08.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pc2t.cv08.DBConnection;

/**
 * 
 * @author Pavel ?eda (154208)
 *
 */
public class DeleteQueries {

  public DeleteQueries() {}

  /**
   * Template metoda, do které se dá vkládat libovolný SQL DELETE p?íkaz.
   * 
   * POZN: není vhodné implementovat své metody tímto zpùsobem, daleko vhodnìj?í je implementovat
   * konkrétní metody (nap?. deleteUserById(String email) pomocí PreparedStatements, do kterých
   * vkládáme konkrétní parametry)
   * 
   * @param deleteQuery øetìzec pøedstavující pøíkaz DELETE
   */
  public void performDeleteQuery(String deleteQuery) {
    if (deleteQuery == null) {
      throw new NullPointerException("query must not be null!");
    } else if (deleteQuery.isEmpty()) {
      throw new IllegalArgumentException("query must not be empty!");
    }
    Connection conn = DBConnection.getDBConnection();
    try (PreparedStatement prStmt = conn.prepareStatement(deleteQuery);) {
      int rowsDeleted = prStmt.executeUpdate();
      // System.out.println(rowsInserted);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  //@formatter:off
  /**
   * Úkol: Doplòte promìnnou userToDelete pøíkazem DELETE ..., který vymae uivatele podle emailu, který je pøedán v parametru metody
   * 
   * HINT: V této metodì jsou vyuity preparedStatements, take se parametr emailu nastaví a pozdìji pøíkazem prStmt.setString(1, email). 
   * Pro pøedstavu, jak se píí prepared statements se podívejte na následující odkaz: 
   * https://www.mkyong.com/jdbc/jdbc-preparestatement-example-delete-a-record/
   * 
   * @param email na základì, kterého je vymazán daný uivatel
   */
  //@formatter:on
  public void deleteUserByEmail(String email) {
    if (email == null) {
      throw new NullPointerException("email must not be null!");
    } else if (email.isEmpty()) {
      throw new IllegalArgumentException("email must not be empty!");
    }
    Connection conn = DBConnection.getDBConnection();

    String userToDelete = "DELETE FROM user WHERE email = ?";

    try (PreparedStatement prStmt = conn.prepareStatement(userToDelete);) {
      prStmt.setString(1, email);
      int rowsDeleted = prStmt.executeUpdate();
      System.out.println("Vaím pøíkazem byl vymazán následující poèet uivatelù: " + rowsDeleted);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
