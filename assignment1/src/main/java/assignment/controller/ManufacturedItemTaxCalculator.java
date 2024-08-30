package assignment.controller;

import assignment.config.Constants;

/**
 * {@link TaxCalculator} implementation for calculating tax on manufactured items.
 * Applies both base and additional taxes to the item price.
 */
class ManufacturedItemTaxCalculator implements TaxCalculator {

  /**
   * Calculates the tax for a manufactured item based on its price.
   *
   * @param itemPrice the price of the manufactured item before tax.
   * @return the total tax amount for the manufactured item.
   */
  @Override
  public double calculateItemTax(final double itemPrice) {
    return (Constants.TAX_RATE_ON_MANUFACTURED_ITEM * itemPrice)
        + Constants.ADDITIONAL_MANUFACTURED_TAX_RATE
        * (itemPrice + (Constants.TAX_RATE_ON_MANUFACTURED_ITEM * itemPrice));
  }

}