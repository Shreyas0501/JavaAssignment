package assignment.controller;

import java.util.Locale;

/**
 * Factory for creating {@link TaxCalculator} instances based on item type.
 */
public final class TaxCalculatorFactory {

  private TaxCalculatorFactory() {
    throw new UnsupportedOperationException(
        "TaxCalculatorFactory is a utility class and cannot be instantiated");
  }

  /**
   * Returns a {@link TaxCalculator} for the specified item type.
   *
   * @param itemType the type of the item (e.g., "raw", "manufactured", "imported").
   * @return a {@link TaxCalculator} for the given item type.
   * @throws CustomException if the item type is invalid.
   */
  public static TaxCalculator getTaxCalculator(final String itemType) {
    final TaxCalculator taxCalculator;
    switch (itemType.toLowerCase(Locale.US)) {
      case "raw":
        taxCalculator = new RawItemTaxCalculator();
        break;
      case "manufactured":
        taxCalculator = new ManufacturedItemTaxCalculator();
        break;
      case "imported":
        taxCalculator = new ImportedItemTaxCalculator();
        break;
      default:
        throw new CustomException("EXCEPTION: Invalid item type: " + itemType);
    }
    return taxCalculator;
  }
}







