package assignment.view;

import assignment.model.Item;

import java.util.List;

/**
 * Provides methods to display item details.
 */
public final class DisplayItem {

  private DisplayItem() {
    throw new UnsupportedOperationException(
        "DisplayItem is a utility class cannot be instantiated.");
  }


  /**
   * Displays the details of all the items in the itemList.
   *
   * @param itemList is the list of items to be display.
   */
  public static void displayAllItems(final List<Item> itemList) {
    for (final Item item : itemList) {
      displayItemDetails(item);
      System.out.println();
    }
  }

  /**
   * Displays the details of the single item.
   *
   * @param item The item whose details are to be displayed.
   */
  public static void displayItemDetails(final Item item) {
    System.out.println("\n------- Item Details -------");
    System.out.println("Name: " + item.getItemName());
    System.out.println("Price: " + item.getItemPrice());
    System.out.println("Sales tax per item : " + item.getItemTax());
    System.out.println("Final Price : " + item.getItemFinalPrice());
    System.out.println("----------------------------");
  }
}
