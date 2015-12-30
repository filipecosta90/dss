/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_fase2.data;

import java.sql.DriverManager;
import java.util.Properties;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author grupo19
 */


public class DataBaseAccess {

  private static Connection Conn;


  public DataBaseAccess() {
    try {
      init( "localhost" , "dss" , "root" , "" );
    } catch (SQLException ex) {

      Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static void init(String hostname, String bd, String user, String password) throws SQLException {

    String url = "jdbc:mysql://" + hostname + "/" + bd + "?";
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Properties props = new Properties();
      props.put("user", user);
      props.put("password", password);
      Conn = DriverManager.getConnection(url, props);
      Conn.setAutoCommit(true);
    } catch (ClassNotFoundException | SQLException ex) {
      throw new NullPointerException(ex.getMessage());
    }
  }

  public static ResultSet executeQuery(String SQLQuery) throws SQLException {
    ResultSet rset = null;
    Statement stmt = null;
    stmt = Conn.createStatement();
    rset = stmt.executeQuery(SQLQuery);
    return rset;
  }

  public static int executeUpdate(String SQLQuery) throws SQLException {
    int result;
    Statement stmt;
    stmt = Conn.createStatement();
    result = stmt.executeUpdate(SQLQuery);
    return result;
  }

  public static boolean close() throws SQLException {
    Boolean result = false;

    Conn.commit();
    Conn.close();
    result = true;

    return result;
  }

  public static boolean executeStatement(String SQLStatement) throws SQLException {
    Boolean result = false;
    Statement stmt;
    stmt = Conn.createStatement();
    stmt.execute(SQLStatement);
    stmt.close();
    Conn.commit();

    return result;
  }

}
