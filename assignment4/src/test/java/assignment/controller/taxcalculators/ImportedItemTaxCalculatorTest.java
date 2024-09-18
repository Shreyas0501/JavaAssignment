package assignment.controller.taxcalculators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImportedItemTaxCalculatorTest {

  @Test
  void calculateImportedItemTax(){

    String[] listOfInputDetails = {
        "-name", "rice", "-price", "100", "-quantity", "10", "-type", "manufactured"
    };

    ImportedItemTaxCalculator importedItemTaxCalculator = new ImportedItemTaxCalculator();

    assertEquals(20.00, importedItemTaxCalculator.calculateItemTax(100));

  }

}