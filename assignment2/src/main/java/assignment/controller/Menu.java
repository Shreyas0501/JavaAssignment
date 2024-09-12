package assignment.controller;

import static assignment.config.SharedData.SCANNER;

/**
 * Handles menu-related operations for user management.
 */
public final class Menu {

  private static final String YES_RESPONSE = "y";
  private static final String NO_RESPONSE = "n";


  private Menu() {
    throw new UnsupportedOperationException("Cannot initialise object of utility class!");
  }

  /**
   * Displays the menu options for user management.
   */
  public static void displayMenu() {
    System.out.println("1. Add User details.\n"
        + "2. Display User details.\n"
        + "3. Delete User details\n"
        + "4. Save User details.\n"
        + "5. Exit");
    System.out.print("Enter an option: ");
  }

  /**
   * Reads the user's menu option input.
   * @return the selected option as an integer.
   */
  public static int readOption() {
    while (true) {
      try {
        final int userResponse = SCANNER.nextInt();
        SCANNER.nextLine();
        return userResponse;
      } catch (Exception e) {
        SCANNER.nextLine();
        System.out.println("Option must be a number");
        System.out.print("Re enter an option: ");
      }
    }
  }

  /**
   * Handles exit prompt and optional saving of changes.
   */
  public static void handleExit() {
    while (true) {
      System.out.print("Do you want to save the last "
          + "changes(addition, deletion of users) to disk? (y/n): ");
      final String userResponse = SCANNER.nextLine();
      if (YES_RESPONSE.equalsIgnoreCase(userResponse)) {
        SaveUser.saveUserDetails();
        break;
      } else if (NO_RESPONSE.equalsIgnoreCase(userResponse)) {
        break;
      } else {
        System.out.println("Please enter either yes or no, (y/n): ");
      }
    }
  }
}