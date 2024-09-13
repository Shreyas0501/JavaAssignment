package assignment;

import static assignment.config.SharedData.ADD_USER_OBJ;
import static assignment.config.SharedData.SCANNER;

import assignment.controller.DeleteUser;
import assignment.controller.Menu;
import assignment.controller.SaveUser;
import assignment.controller.SavedUserDetailsLoader;
import assignment.view.DisplayUser;

/**
 * The Main class controls the application flow for adding, displaying,
 * deleting, and saving user details. It continuously processes user
 * input until they choose to exit.
 */
public final class Main {

  private Main() {
    throw new UnsupportedOperationException("Main class cannot be initialised");
  }

  /**
   * Entry point of the application.
   * Loads user details and handles user input to perform operations
   * like adding, displaying, deleting, and saving user details.
   * Runs until the user chooses to exit.
   */
  public static void main(String[] args) {
    SavedUserDetailsLoader.loadUserDetails();
    int inputOption;

    do {
      Menu.displayMenu();
      inputOption = Menu.readOption();
      handleOption(inputOption);
    } while (inputOption != 5);

    SCANNER.close();
  }

  private static void handleOption(final int inputOption) {
    switch (inputOption) {
      case 1:
        ADD_USER_OBJ.addUserDetails();
        break;
      case 2:
        DisplayUser.displayAllUser();
        break;
      case 3:
        DeleteUser.deleteUserDetails();
        break;
      case 4:
        SaveUser.saveUserDetails();
        break;
      case 5:
        Menu.handleExit();
        break;
      default:
        System.out.println("Invalid option: Enter an option between 1-5");
        break;
    }
  }

}
