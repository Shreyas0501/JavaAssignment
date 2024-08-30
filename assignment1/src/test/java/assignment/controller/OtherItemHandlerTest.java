package assignment.controller;

import assignment.model.Item;
import assignment.config.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OtherItemHandlerTest {

  private final List<Item> itemList = new ArrayList<>();

  @BeforeEach
  void setUp() {
    itemList.clear();
    // Reset SCANNER before each test
    Constants.SCANNER = new Scanner(System.in);
  }

  @Test
  void testHandleAdditionalItemAddAppend_AddValidItem() {
    // Mock the scanner input for 'y' and then a valid item input
    String userInput = "y\n-name TestItem -type raw -price raw -quantity 100\nn\n";
    System.setIn(new ByteArrayInputStream(userInput.getBytes()));
    Constants.SCANNER = new Scanner(System.in);

    // Mocking the creation of new item to avoid dependence on user input logic
    Item testItem = new Item("TestItem", "raw", 100, 100, 12.5);
    mockStatic(NewItemCreator.class);
    when(NewItemCreator.createNewItemFromInput(any(String[].class))).thenReturn(testItem);

    // Run the method to be tested
    OtherItemHandler.handleAdditionalItemAddAppend(itemList);

    // Verify the item was added
    assertEquals(1, itemList.size());
    assertEquals(testItem, itemList.get(0));
    Constants.SCANNER.close();
  }


}
