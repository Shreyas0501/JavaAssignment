package assignment.controller.taxcalculators;

import assignment.config.Constants;
import assignment.controller.TaxCalculator;

/**
 * Implementation of {@link TaxCalculator} for calculating tax on raw items.
 */
public class RawItemTaxCalculator implements TaxCalculator {

  /**
   * Calculates the tax amount for a raw item based on its price.
   *
   * @param itemPrice The price of the raw item.
   * @return The calculated tax amount.
   */
  @Override
  public double calculateItemTax(final double itemPrice) {
    return Constants.TAX_RATE_ON_RAW_ITEM * itemPrice;
  }

}