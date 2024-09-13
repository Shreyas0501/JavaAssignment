package assignment.controller;

import static assignment.config.Constants.SCANNER;
import static assignment.config.Constants.UTILITY_CLASS_MESSAGE;

/**
 * Handles the display and input of menu options for the application.
 */
public final class Menu {

  private Menu() {
    throw new UnsupportedOperationException(UTILITY_CLASS_MESSAGE);
  }
  /**
   * Displays the menu options to the user.
   */
  public static void displayMenu() {
    System.out.println("\n1. Display the immediate parents of a node.\n"
        + "2. Display the immediate children of a node.\n"
        + "3. Display the ancestors of a node.\n"
        + "4. Display the descendants of a node,\n"
        + "5. Delete dependency from a tree.\n"
        + "6. Delete a node from a tree.\n"
        + "7. Add a new dependency to a tree.\n"
        + "8. Add a new node to tree.");
    System.out.print("Enter an option: ");
  }

  /**
   * Reads and returns the user's menu option.
   * Re-prompts if the input is not a valid number.
   * @return The user's selected option.
   */
  public static int readOption() {
    while (true) {
      try {
        return Integer.parseInt(SCANNER.nextLine());
      } catch (Exception e) {
        System.out.println("Option must be a number \n"
        + "Re enter an option: ");
      }
    }
  }
}