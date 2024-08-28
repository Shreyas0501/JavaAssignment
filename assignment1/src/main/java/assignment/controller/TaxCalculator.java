package assignment.controller;

/**
 * Interface for calculating the tax on an item.
 */
public interface TaxCalculator {

  /**
   * Calculates the tax amount for a given item price.
   *
   * @param itemPrice The price of the item for which tax needs to be calculated.
   * @return The calculated tax amount.
   */
  double calculateItemTax(double itemPrice);
}