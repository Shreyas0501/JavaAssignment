package assignment;

import static assignment.config.Constants.SCANNER;

import assignment.controller.CustomException;
import assignment.controller.NewItemCreator;
import assignment.controller.OtherItemHandler;
import assignment.model.Item;
import assignment.view.DisplayItem;

import java.util.ArrayList;
import java.util.List;


/**
 * The Main class serves as the entry point of the application.
 * It handles item creation, validation, and handles user interactions
 * for adding additional items.
 */
public final class Main {

  // Private constructor to prevent instantiation
  private Main() {
    throw new UnsupportedOperationException("Main class cannot be instantiated");
  }

  /**
   * The main method serves as the entry point for the application.
   *
   * @param commandLineItemInputDetails Input for the first item from command line arguments.
   */
  public static void main(final String[] commandLineItemInputDetails) {

    final List<Item> itemList = new ArrayList<>();
    String[] inputItemDetails = commandLineItemInputDetails;

    boolean validFirstItem = false;

    while (!validFirstItem) {
      try {
        final Item firstItem = NewItemCreator.createNewItemFromInput(inputItemDetails);
        itemList.add(firstItem);
        validFirstItem = true;
      } catch (CustomException e) {
        System.out.println(e.getMessage());
        System.out.println("Re-enter first item details following the format: "
            + "-name itemName -type itemType -price itemPrice -quantity itemQuantity.");
        System.out.print("Please enter the details again: ");
        inputItemDetails = SCANNER.nextLine().split(" ");
      } catch (Exception e) {
        System.out.println("Price and Quantity must be a number " + e.getMessage());
      }
    }

    OtherItemHandler.handleAdditionalItemAddAppend(itemList);

    DisplayItem.displayAllItems(itemList);
    SCANNER.close();
  }
}
