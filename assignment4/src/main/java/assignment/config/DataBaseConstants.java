package assignment.config;

import assignment.model.Item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The DataBaseConstants class holds the constant values and configuration
 * required to manage database connections and queries. It also contains blocking
 * queue for {@link Item} objects to handle concurrent operations.
 */
public final class DataBaseConstants {

  public static final BlockingQueue<Item> BLOCKING_QUEUE =
      new LinkedBlockingQueue<>(10);

  public static Connection CONNECTION;

  public static final String FETCH_QUERY = "SELECT * FROM item";
  public static final String INSERT_QUERY = "INSERT INTO item VALUES(?, ?, ?, ?)";

  public static final String PASSWORD = "Shreyas@16";
  public static final String URL = "jdbc:mysql://localhost:3306/temp";
  public static final String USER = "root";

  static {
    try {
      CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
      System.out.println("Connection established successfully");
    } catch (SQLException e) {
      System.out.println("Error in establishing connection! " + e);
    }
  }

  /**
   * Closes the database connection.
   * Prints success message if closed, otherwise an error message.
   */
  public static void closeConnection() {
    try {
      CONNECTION.close();
      System.out.println("Successfully closed the connection");
    } catch (Exception e) {
      System.out.println("Failed to close the connection!" + e);
    }
  }

}