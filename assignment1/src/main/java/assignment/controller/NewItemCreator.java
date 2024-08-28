package assignment.controller;

import assignment.model.Item;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;


/**
 * Class responsible for creating new items from input details.
 */
public final class NewItemCreator {

  private NewItemCreator() {
    throw new UnsupportedOperationException(
        "ItemValidator is a utility class and cannot be instantiated.");
  }

  /**
   * Creates a new item when the provided item details are valid.
   *
   * @param listOfItemDetails Array of strings containing item details.
   * @return An Item object if the details are valid;
   */
  public static Item createNewItemFromInput(final String... listOfItemDetails) {

    checkNumberOfInputArguments(listOfItemDetails);
    final ItemDetails parsedItemDetails = parseItemDetails(listOfItemDetails);
    validateParsedItemDetails(parsedItemDetails);

    return createItem(parsedItemDetails);
  }


  /**
   * Checks if the number of input arguments is valid.
   *
   * @param listOfItemDetails the input arguments to validate.
   * @throws CustomException if the number of input arguments is invalid.
   */
  static void checkNumberOfInputArguments(final String... listOfItemDetails) {
    if (!NumberOfInputValidator.isValidNumberOfInputItemDetails(listOfItemDetails)) {
      throw new CustomException("INVALID NUMBER OF INPUT ARGUMENTS");
    }
  }

  /**
   * Parses the item details from the provided array.
   *
   * @param listOfItemDetails Array of strings containing item details.
   * @return An array of parsed item details.
   */
  static ItemDetails parseItemDetails(final String... listOfItemDetails) {

    validateInitialArgument(listOfItemDetails);

    String itemName = null;
    String itemType = null;
    double itemPrice = -1.0;
    int itemQuantity = -1;

    final Set<String> seenKeys = new HashSet<>();

    for (int i = 0; i < listOfItemDetails.length; i += 2) {

      final String key = listOfItemDetails[i];
      final String value = listOfItemDetails[i + 1].toLowerCase(Locale.US);

      if (seenKeys.contains(key)) {
        throw new CustomException("EXCEPTION: Duplicate fields are not allowed.");
      }
      seenKeys.add(key);

      switch (key) {
        case "-name":
          itemName = value;
          break;
        case "-type":
          itemType = value;
          break;
        case "-price":
          itemPrice = Double.parseDouble(value);
          break;
        case "-quantity":
          itemQuantity = Integer.parseInt(value);
          break;
        default:
          throw new CustomException("EXCEPTION: Invalid input field");
      }

    }

    return new ItemDetails(itemName, itemType, itemPrice, itemQuantity);
  }


  /**
   * Validates that the initial argument is "-name".
   *
   * @param listOfItemDetails Array of strings containing item details.
   * @throws CustomException if the initial argument is invalid.
   */
  private static void validateInitialArgument(final String... listOfItemDetails) {
    if (!"-name".equalsIgnoreCase(listOfItemDetails[0])) {
      throw new CustomException("EXCEPTION: First input argument should be name.");
    }
  }


  private static void validateParsedItemDetails(final ItemDetails parsedItemDetails) {
    ItemDetailsValidator.validateItemName(parsedItemDetails.itemName);
    ItemDetailsValidator.validateItemType(parsedItemDetails.itemType);
    ItemDetailsValidator.validateItemPrice(parsedItemDetails.itemPrice);
    ItemDetailsValidator.validateItemQuantity(parsedItemDetails.itemQuantity);
  }

  /**
   * Creates an item with the given details.
   *
   * @return The created Item object.
   */
  private static Item createItem(final ItemDetails itemDetails) {
    final TaxCalculator taxCalculator = TaxCalculatorFactory.getTaxCalculator(itemDetails.itemType);
    final double itemTax = taxCalculator.calculateItemTax(itemDetails.itemPrice);
    return new Item(itemDetails.itemName, itemDetails.itemType,
        itemDetails.itemPrice, itemDetails.itemQuantity, itemTax);
  }

  /**
   * Represents the intermediate details of an item.
   */
  private static class ItemDetails {
    private final String itemName;
    private final String itemType;
    private final double itemPrice;
    private final int itemQuantity;

    /**
     * Constructs an ItemDetails object with the specified attributes.
     *
     * @param itemName The name of the item.
     * @param itemType The type of the item.
     * @param itemPrice The price of the item.
     * @param itemQuantity The quantity of the item.
     */
    public ItemDetails(final String itemName, final String itemType,
                final double itemPrice, final int itemQuantity) {
      this.itemName = itemName;
      this.itemType = itemType;
      this.itemPrice = itemPrice;
      this.itemQuantity = itemQuantity;
    }
  }
}