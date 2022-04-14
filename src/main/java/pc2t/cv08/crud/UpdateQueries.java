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
public class UpdateQueries {

  public UpdateQueries() {}

  /**
   * Template metoda, do které se dá vkládat libovolný SQL UPDATE pøíkaz.
   * 
   * POZN: není vhodné implementovat své metody tímto zpùsobem, daleko vhodnìjí je implementovat
   * konkrétní metody (napø. updateUserById() pomocí PreparedStatements, do kterých vkládáme
   * konkrétní parametry)
   * 
   * @param updateQuery øetìzec pøedstavující pøíkaz UPDATE
   */
  public void performUpdateQuery(String updateQuery) {
    if (updateQuery == null) {
      throw new NullPointerException("query must not be null!");
    } else if (updateQuery.isEmpty()) {
      throw new IllegalArgumentException("query must not be empty!");
    }
    Connection conn = DBConnection.getDBConnection();
    try (PreparedStatement prStmt = conn.prepareStatement(updateQuery);) {
      int rowsUpdated = prStmt.executeUpdate();
      // System.out.println(rowsUpdated);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Doplòte pøíkaz update20PercentOfSalary, tak abyste pøidali danému zamìstnanci 20% jeho platu
   * 
   * POZN: Opìt napitì SQL pøíkaz tak, abyste vyuili PreparedStatements (=> pøíkaz musí obsahovat
   * WHERE email = ?)
   * 
   * @param email vstupní parametr, který je pøi volání nastaven na hodnotu:
   *        myname@stud.feec.vutbr.cz (jde pouze o ukázkový pøíklad u uivatele, který je zanesen v
   *        DB a má uveden plat)
   */
  public void increase20PercentOfSalary(String email) {
    if (email == null) {
      throw new NullPointerException("email must not be null!");
    } else if (email.isEmpty()) {
      throw new IllegalArgumentException("email must not be empty!");
    }
    Connection conn = DBConnection.getDBConnection();

    String update20PercentOfSalary = "UPDATE user SET salary = salary*1.2 WHERE email = ?";

    try (PreparedStatement prStmt = conn.prepareStatement(update20PercentOfSalary);) {
      prStmt.setString(1, email);
      int rowsUpdated = prStmt.executeUpdate();
      // System.out.println(rowsUpdated);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
