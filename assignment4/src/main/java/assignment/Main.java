package assignment;

import static assignment.config.Constants.SCANNER;

import assignment.config.DataBaseConstants;
import assignment.controller.CustomException;
import assignment.controller.ItemFetcherAndTaxCalculator;
import assignment.controller.NewItemCreator;
import assignment.controller.OtherItemHandler;
import assignment.database.DataBaseHandler;
import assignment.model.Item;
import assignment.view.DisplayItem;

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

    String[] inputItemDetails = commandLineItemInputDetails;

    boolean validFirstItem = false;
    Item firstItem = null;

    while (!validFirstItem) {
      try {
        firstItem = NewItemCreator.createNewItemFromInput(inputItemDetails);
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

    try {
      DataBaseHandler.saveToDataBase(firstItem);
      OtherItemHandler.handleAdditionalItem();
    } catch (Exception e) {
      System.out.println("Error in sql handling!");
    }

    ItemFetcherAndTaxCalculator.fetchItemFromDataBaseAndCalculateTax();

    DisplayItem.displayAllItems();
    SCANNER.close();
    DataBaseConstants.closeConnection();
  }
}
