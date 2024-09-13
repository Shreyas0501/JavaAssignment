package assignment.view;

import static assignment.config.SharedData.ROLL_NUMBER_TO_USER_MAP;
import static assignment.config.SharedData.SCANNER;

import assignment.controller.CustomException;
import assignment.model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A utility class for displaying users' information.
 * This class provides functionality to sort and display user details
 * based on various criteria such as full name, roll number, age, and address.
 */
public final class DisplayUser {

  // Private constructor to prevent instantiation
  private DisplayUser() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  /**
   * Displays all users in the user list, sorted based on user input.
   * Prompts the user for sorting order and option, then displays user details in a formatted table.
   */
  public static void displayAllUser() {

    final int order = readSortingOrder();
    final int option = readSortingOption();

    final List<User> duplicateUserList = new ArrayList<>(ROLL_NUMBER_TO_USER_MAP.values());
    customSort(duplicateUserList, order == 2, option);

    System.out.println("\n---------------------------------------"
        + "--------------------------------------");
    System.out.printf("%-10s\t%-15s\t%-5s\t%-10s\t%-15s",
        "Full Name", "Roll Number", "Age", "Address", "Courses");
    System.out.println("\n---------------------------------------"
        + "--------------------------------------");
    for (final User user : duplicateUserList) {
      displayUserDetails(user);
    }
    System.out.println();
  }

  private static int readSortingOrder() {
    while (true) {
      System.out.println("\n1: Ascending");
      System.out.println("2: Descending");
      System.out.print("Choose the order of sorting: ");
      try {
        final int order = Integer.parseInt(SCANNER.nextLine());
        if (order >= 1 && order <= 2) {
          return order;
        } else {
          System.out.println("Invalid choice, choose between 1-2.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
      } catch (CustomException e) {
        System.out.println("Exception: " + e.getMessage());
      }
    }
  }

  private static int readSortingOption() {
    while (true) {

      System.out.println("\n1. Full Name");
      System.out.println("2. Roll Number");
      System.out.println("3. Age");
      System.out.println("4. Address");
      System.out.print("Choose the sorting option:");
      try {
        final int option = Integer.parseInt(SCANNER.nextLine());
        if (option >= 1 && option <= 4) {
          return option;
        } else {
          System.out.println("Invalid choice, choose between 1-4.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
      } catch (CustomException e) {
        System.out.println("Exception: " + e.getMessage());
      }
    }
  }

  private static void customSort(final List<User> userList,
                                 final boolean decreasing, final int option) {
    Comparator<User> customComparator = null;
    switch (option) {
      case 1:
        customComparator = Comparator.comparing(User::getFullName);
        break;
      case 2:
        customComparator = Comparator.comparing(User::getRollNumber);
        break;
      case 3:
        customComparator = Comparator.comparing(User::getAge);
        break;
      case 4:
        customComparator = Comparator.comparing(User::getAddress);
        break;
      default:
        System.out.println("Invalid choice!");
    }

    if (decreasing) {
      customComparator = customComparator.reversed();
    }

    userList.sort(customComparator);
  }

  private static void displayUserDetails(final User user) {
    System.out.printf("%-10s\t%-15s\t%-5d\t%-10s\t%-15s\n",
        user.getFullName(), user.getRollNumber(), user.getAge(),
        user.getAddress(), user.getCourses());
  }
}
