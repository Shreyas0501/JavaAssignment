package assignment.view;

import static assignment.config.SharedData.PROCESSED_ITEM_LIST;

import assignment.model.Item;

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
   */
  public static void displayAllItems() {
    for (final Item item : PROCESSED_ITEM_LIST) {
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
