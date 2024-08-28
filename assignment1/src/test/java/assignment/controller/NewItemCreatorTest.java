package assignment.controller;

import assignment.model.Item;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NewItemCreatorTest {

  @Test
  void doesFunctionReturnsItemObjectFromInput() {
    String[] listOfItemDetails = {
        "-name", "pizza", "-quantity", "120", "-price", "120", "-type", "imported"
    };
    Item item = NewItemCreator.createNewItemFromInput(listOfItemDetails);

    assertEquals("pizza",item.getItemName());
    assertEquals(120,item.getItemQuantity());
    assertEquals(120,item.getItemPrice());
    assertEquals("imported",item.getItemType());
  }

  @Test
  void checkForInvalidNumberOfInputArguments() {
    String[] listOfItemDetails = {
        "-name", "pizza", "-quantity", "120", "-price", "120", "-type"
    };

    CustomException exception = assertThrows( CustomException.class,
        () -> {  NewItemCreator.checkNumberOfInputArguments(listOfItemDetails);  });

    assertEquals("INVALID NUMBER OF INPUT ARGUMENTS", exception.getMessage());
  }

  @Test
  void testParseItemDetails_DuplicateFields() {
    String[] listOfItemDetails = {
        "-name", "pizza", "-quantity", "120", "-price", "120", "-name" , "raw"
    };

    CustomException exception = assertThrows(CustomException.class,
        () -> { NewItemCreator.parseItemDetails(listOfItemDetails); });

    assertEquals("EXCEPTION: Duplicate fields are not allowed.", exception.getMessage());
  }

  @Test
  void testParseItemDetails_InvalidField() {

    String[] listOfItemDetails = {
        "-name", "burger", "-type", "imported", "-invalidField", "123", "price", "100"
    };

    CustomException exception = assertThrows(CustomException.class,
        () -> NewItemCreator.parseItemDetails(listOfItemDetails));

    assertEquals("EXCEPTION: Invalid input field", exception.getMessage());
  }

  @Test
  void testParseItemDetails_NonNumericPrice() {
    // Arrange: set up item details with a non-numeric price value
    String[] listOfItemDetails = {
        "-name", "burger", "-type", "imported", "-price", "twenty", "-quantity", "5"
    };

    // Act & Assert: expect NumberFormatException due to non-numeric price
    NumberFormatException exception = assertThrows(NumberFormatException.class,
        () -> NewItemCreator.parseItemDetails(listOfItemDetails));

    assertEquals("For input string: \"twenty\"", exception.getMessage());
  }

}