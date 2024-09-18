package assignment.controller.threads;

import static assignment.config.DataBaseConstants.BLOCKING_QUEUE;
import static assignment.config.DataBaseConstants.CONNECTION;
import static assignment.config.DataBaseConstants.FETCH_QUERY;
import static assignment.config.SharedData.TERMINATION_ITEM;

import assignment.model.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Producer implements Runnable {

  @Override
  public void run() {
    try {
      PreparedStatement ps = CONNECTION.prepareStatement(FETCH_QUERY);
      ResultSet resultSet = ps.executeQuery();

      while (resultSet.next()) {
        String itemName = resultSet.getString("name");
        String itemType = resultSet.getString("type");
        double itemPrice = resultSet.getDouble("price");
        int itemQuantity = resultSet.getInt("quantity");

        Item newItem = new Item();
        newItem.setItemName(itemName);
        newItem.setItemType(itemType);
        newItem.setItemPrice(itemPrice);
        newItem.setItemQuantity(itemQuantity);

        BLOCKING_QUEUE.put(newItem);
      }
      BLOCKING_QUEUE.put(TERMINATION_ITEM);
    } catch (SQLException e) {
      System.out.println("PRODUCER SIDE ERROR: "
          + "in fetching item from db! " + e);
    } catch (InterruptedException e) {
      System.out.println("PRODUCER SIDE ERROR: "
          + "in appending item to BLOCKING_QUEUE!");
    }
  }
}