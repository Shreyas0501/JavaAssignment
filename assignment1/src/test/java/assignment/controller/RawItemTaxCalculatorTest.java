package assignment.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RawItemTaxCalculatorTest {

  @Test
  void calculateRawItemTax(){

    String[] listOfInputDetails = {
        "-name", "rice", "-price", "100", "-quantity", "10", "-type", "raw"
    };

    RawItemTaxCalculator rawItemTaxCalculator = new RawItemTaxCalculator();

    assertEquals(12.5, rawItemTaxCalculator.calculateItemTax(100));

  }

}