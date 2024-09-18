package assignment.controller;

import static assignment.config.Constants.RESTRICTED_NAMES;

/**
 * Validator class for item details.
 */
public final class ItemDetailsValidator {

  private static final String RAW_TYPE = "raw";
  private static final String IMPORTED_TYPE = "imported";
  private static final String MANUFACTURED_TYPE = "manufactured";
  private static final char SPECIAL_CHAR = '-';

  // Private constructor to prevent instantiation
  private ItemDetailsValidator() {
    throw new UnsupportedOperationException("Utility class cannot be instantiated");
  }
  /**
   * Validates the item name.
   *
   * @param itemName The name of the item to be validated.
   */

  public static void validateItemName(final String itemName) {

    if (itemName == null) {
      throw new CustomException("INVALID ITEM NAME. Name cannot be null.");
    } else if (itemName.isEmpty()) {
      throw new CustomException("INVALID ITEM NAME. Name cannot be empty.");
    } else if (itemName.charAt(0) == SPECIAL_CHAR) {
      throw new CustomException("INVALID ITEM NAME. Should not contains special characters.");
    } else if (RESTRICTED_NAMES.contains(itemName)) {
      throw new CustomException("INVALID ITEM NAME. It cannot be one of field names: "
          + String.join(", ", RESTRICTED_NAMES));
    }

  }

  /**
   * Validates the item type.
   *
   * @param itemType The type of the item to be validated.
   */
  public static void validateItemType(final String itemType) {
    if (!RAW_TYPE.equals(itemType) && !IMPORTED_TYPE.equals(itemType)
        && !MANUFACTURED_TYPE.equals(itemType)) {
      throw new CustomException("INVALID ITEM TYPE. "
          + "Item Type should be either (raw, imported or manufactured).");
    }
  }

  /**
   * Validates the item price.
   *
   * @param itemPrice The price of the item to be validated.
   */
  public static void validateItemPrice(final Double itemPrice) {
    if (itemPrice == null || itemPrice < 0) {
      throw new CustomException("INVALID ITEM PRICE. Price should be a positive number");
    }
  }

  /**
   * Validates the item quantity.
   *
   * @param itemQuantity The quantity of the item to be validated.
   */
  public static void validateItemQuantity(final Integer itemQuantity) {
    if (itemQuantity == null || itemQuantity < 0) {
      throw new CustomException("INVALID ITEM QUANTITY. Quantity should be a positive number");
    }
  }

}
