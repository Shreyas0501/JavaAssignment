package assignment.controller.taxcalculators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManufacturedItemTaxCalculatorTest {

  @Test
  void calculateManufacturedItemTax(){

    String[] listOfInputDetails = {
        "-name", "rice", "-price", "100", "-quantity", "10", "-type", "manufactured"
    };

    ManufacturedItemTaxCalculator manufacturedItemTaxCalculator = new ManufacturedItemTaxCalculator();

    assertEquals(14.75, manufacturedItemTaxCalculator.calculateItemTax(100));

  }

}