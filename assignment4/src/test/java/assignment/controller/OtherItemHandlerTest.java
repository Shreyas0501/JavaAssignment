package assignment.controller;

import assignment.config.Constants;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


class OtherItemHandlerTest {

  private void setStaticScanner(String input) {
    try {
      Field field = Constants.class.getDeclaredField("SCANNER");
      field.setAccessible(true);
      field.set(null, new Scanner(new ByteArrayInputStream(input.getBytes())));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void testPromptUserForAnotherItem_Yes() {
    setStaticScanner("y\n");

    String result = OtherItemHandler.promptUserForAnotherItem();
    assertEquals("y", result, "Expected input was 'y'.");
  }

}