package assignment.controller;

import static assignment.config.SharedData.ROLL_NUMBER_TO_USER_MAP;
import static assignment.config.SharedData.SCANNER;


/**
 * Handles the process of deleting user details from the system based on roll number.
 */
public final class DeleteUser {

  private DeleteUser() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  /**
   * Deletes a user based on the roll number entered by the user.
   * Displays a success message if deletion is successful or an error message
   * if the roll number does not exist.
   */
  public static void deleteUserDetails() {
    final String rollNumber = readRollNumber();
    if (!ROLL_NUMBER_TO_USER_MAP.containsKey(rollNumber)) {
      System.out.println("Exception: " + rollNumber + " roll number does not exist.\n");
      return;
    }

    ROLL_NUMBER_TO_USER_MAP.remove(rollNumber);
    System.out.println("Deletion SUCCESS!\n");
  }

  /**
   * Prompts for and returns a roll number from user input.
   * Throws an exception if the input is empty or null.
   *
   * @return The roll number entered by the user.
   * @throws CustomException If the input is empty or null.
   */
  public static String readRollNumber() {
    while (true) {
      try {
        System.out.print("Enter rollNumber of the user to be deleted: ");
        final String rollNumber = SCANNER.nextLine();
        if (rollNumber != null && !rollNumber.isEmpty()) {
          return rollNumber;
        }
        System.out.println("Roll number cannot be empty or null!");
      } catch (CustomException e) {
        System.out.println("Exception: " + e.getMessage());
      }
    }
  }
}
