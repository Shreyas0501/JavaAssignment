package assignment.model;

import java.util.Locale;

/**
 * Represents an item with its attributes and tax calculation.
 */
public class Item {
  private final String itemName;
  private final String itemType;
  private final double itemPrice;
  private final int itemQuantity;
  private final double itemTax;

  /**
   * Constructs an Item with the given details.
   *
   * @param itemName The name of the item.
   * @param itemType The type of the item.
   * @param itemPrice The price of the item.
   * @param itemQuantity The quantity of the item.
   * @param itemTax The tax applicable to the item.
   */
  public Item(final String itemName, final String itemType,
              final double itemPrice, final int itemQuantity, final double itemTax) {
    this.itemName = itemName;
    this.itemType = itemType;
    this.itemPrice = itemPrice;
    this.itemQuantity = itemQuantity;
    this.itemTax = itemTax;
  }

  @Override
  public boolean equals(final Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    final Item o = (Item) obj;
    return this.itemName.equalsIgnoreCase(o.getItemName())
        && this.itemType.equalsIgnoreCase(o.getItemType())
        && this.itemPrice == o.getItemPrice()
        && this.itemQuantity == o.getItemQuantity();

  }

  @Override
  public int hashCode() {
    int result = itemName != null ? itemName.toLowerCase(Locale.US).hashCode() : 0;
    result = 31 * result + (itemType != null ? itemType.toLowerCase(Locale.US).hashCode() : 0);
    result = 31 * result + Double.hashCode(itemPrice);
    result = 31 * result + Integer.hashCode(itemQuantity);
    return result;
  }


  public String getItemName() {
    return itemName;
  }

  public String getItemType() {
    return itemType;
  }

  public double getItemPrice() {
    return itemPrice;
  }

  public int getItemQuantity() {
    return itemQuantity;
  }

  public double getItemTax() {
    return itemTax;
  }

  /**
   * Calculates the final price of the item including tax.
   *
   * @return The final price of the item.
   */
  public double getItemFinalPrice() {
    return itemTax + itemPrice;
  }
}