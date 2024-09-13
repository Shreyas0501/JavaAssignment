package assignment;

import assignment.view.DisplayNode;
import assignment.controller.*;

import static assignment.config.Constants.*;

/**
 * The entry point of the app. Displays menu & handles user input
 * to perform various operations on nodes.
 */
public final class Main {

  private Main() {
    throw new UnsupportedOperationException(UTILITY_CLASS_MESSAGE);
  }

  /**
   * The main method that runs the application.
   * @param args command-line arguments.
   */
  public static void main(String[] args) {
    int inputOption;

    do {
      Menu.displayMenu();
      inputOption = Menu.readOption();
      handleOption(inputOption);
    } while (inputOption != EXIT_OPTION);

    SCANNER.close();
    System.out.println("Program exited successfully!");
  }

  /**
   * Handles the user's menu option by invoking appropriate method.
   * @param inputOption the user's selected menu option.
   */
  private static void handleOption(final int inputOption) {
    switch (inputOption) {
      case 1:
        DisplayNode.displayImmediateParent();
        break;
      case 2:
        DisplayNode.displayImmediateChildren();
        break;
      case 3:
        DisplayNode.displayAncestor();
        break;
      case 4:
        DisplayNode.displayDescendant();
        break;
      case 5:
        DependencyDeleter.deleteDependency();
        break;
      case 6:
        NodeDeleter.deleteNode();
        break;
      case 7:
        NewDependencyAdder.addNewDependency();
        break;
      case 8:
        NewNodeAdder.addNewNode();
        break;
      case 9:
        System.out.println("Exiting the menu...");
        break;
      default:
        System.out.println("Invalid option! Enter an option between 1-8.");
        break;
    }
  }

}