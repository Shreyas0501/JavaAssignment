package assignment.controller;

import assignment.config.Constants;

/**
 * {@link TaxCalculator} implementation for calculating tax on imported items.
 * This class applies different tax rates based on the final cost of the imported item.
 */
class ImportedItemTaxCalculator implements TaxCalculator {


  /**
   * Calculates the tax for an imported item based on its price.
   *
   * @param itemPrice the price of the imported item before tax.
   * @return the total tax amount for the imported item.
   */
  @Override
  public double calculateItemTax(final double itemPrice) {
    double finalCost = Constants.TAX_RATE_ON_IMPORTED_ITEM * itemPrice;
    if (finalCost <= Constants.IMPORTED_TAX_THRESHOLD_100) {
      finalCost += Constants.ADDITIONAL_TAX_ON_IMPORTED_ITEM_BELOW_100;
    } else if (finalCost <= Constants.IMPORTED_TAX_THRESHOLD_200) {
      finalCost += Constants.ADDITIONAL_TAX_ON_IMPORTED_ITEM_BETWEEN_100_TO_200;
    } else {
      finalCost += (Constants.ADDITIONAL_TAX_RATE_ON_IMPORTED_ITEM_ABOVE_200 * finalCost);
    }
    return finalCost;
  }

}