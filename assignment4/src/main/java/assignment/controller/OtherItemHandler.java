package assignment.controller;

import static assignment.config.Constants.SCANNER;

import assignment.database.DataBaseHandler;
import assignment.model.Item;

import java.util.List;
import java.util.Locale;

/**
 * Handles the addition of more items to the item list.
 */
public final class OtherItemHandler {

  private static final String YES = "y";
  private static final String NO = "n";

  private OtherItemHandler() {
    throw new UnsupportedOperationException(
        "OtherItemHandler is a utility class and cannot be instantiated");
  }

  /**
   * Prompts the user to enter details of additional items and appends them to the item list.
   *
   */
  public static void handleAdditionalItem() {

    while (true) {
      final String userResponse  = promptUserForAnotherItem();
      if (NO.equals(userResponse)) {
        break;
      } else if (YES.equals(userResponse)) {
        final Item newItem = getNextItem();

        DataBaseHandler.saveToDataBase(newItem);
      } else {
        System.out.println("INVALID USER RESPONSE. Please enter 'y' or 'n'.");
      }
    }

  }


  /**
   * Prompts the user to indicate whether they want to add another item.
   *
   *
   * @return User input indicating whether they want to add another item ("y" or "n").
   */
  static String promptUserForAnotherItem() {
    System.out.print("Do you want to enter details of any other item (y/n): ");
    final String userResponse = SCANNER.nextLine().trim();
    System.out.println("response : " + userResponse);
    if (userResponse.isEmpty()) {
      System.out.println("No input received. Exiting...");
      return NO;
    }

    return userResponse.toLowerCase(Locale.US);
  }


  /**
   * Collects item details from the user and returns a valid item.
   *
   * @return A valid Item object created from user input.
   */
  private static Item getNextItem() {

    while (true) {
      try {
        return getNextItemDetails();
      } catch (CustomException e) {
        System.out.println(e.getMessage());
        System.out.println("REENTER Item details");
      } catch (Exception e) {
        System.out.println("Price and Quantity must be a number " + e.getMessage());
        System.out.println("REENTER Item details");
      }
    }

  }

  private static Item getNextItemDetails() {
    System.out.println("Enter Item details in the format"
        + "(-name itemName -type itemType -price itemPrice -quantity itemQuantity);");
    final String[] listOfItemDetails = SCANNER.nextLine().split(" ");
    return NewItemCreator.createNewItemFromInput(listOfItemDetails);
  }

  private static boolean isDuplicateItem(final List<Item> itemList, final Item newItem) {
    for (final Item item : itemList) {
      if (item.equals(newItem)) {
        return true;
      }
    }
    return false;
  }
}