package assignment.database;

import static assignment.config.DataBaseConstants.CONNECTION;
import static assignment.config.DataBaseConstants.INSERT_QUERY;

import assignment.model.Item;

import java.sql.PreparedStatement;

/**
 * Handles database operations such as saving Item objects to the database.
 */
public class DataBaseHandler {

  /**
   * Saves the provided Item to the database.
   * @param item The item to be stored in the database.
   */
  public static void saveToDataBase(Item item) {
    try {
      PreparedStatement ps = CONNECTION.prepareStatement(INSERT_QUERY);

      ps.setString(1, item.getItemName());
      ps.setString(2, item.getItemType());
      ps.setDouble(3, item.getItemPrice());
      ps.setInt(4, item.getItemQuantity());

      int result = ps.executeUpdate();
      if (result > 0) {
        System.out.println("Successfully stored!");
      } else {
        System.out.println("Failed to store!");
      }

    } catch (Exception e) {
      System.out.println("Error in Storing Item to DB! " + e);
    }


  }

}