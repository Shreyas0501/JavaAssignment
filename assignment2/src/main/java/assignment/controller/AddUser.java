package assignment.controller;

import static assignment.config.Constants.MINIMUM_NUMBER_OF_COURSES;
import static assignment.config.SharedData.ROLL_NUMBER_TO_USER_MAP;
import static assignment.config.SharedData.SCANNER;

import assignment.model.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Handles collecting, validating, and adding user details to the system.
 */
public final class AddUser {

  private static final String EXCEPTION_PREFIX = "Exception: ";

  /**
   * Collects user details and adds the user to the system.
   */
  public void addUserDetails() {
    System.out.println("\nEnter user details:");

    final String fullName = readFullName();
    final int age = readAge();
    final String rollNumber = readRollNumber();
    final String address = readAddress();
    final Set<String> courses = readCourses();

    final User newUser = new User();
    newUser.setFullName(fullName);
    newUser.setAge(age);
    newUser.setRollNumber(rollNumber);
    newUser.setAddress(address);
    newUser.setCourses(courses);

    System.out.println("Successfully added!\n");
    ROLL_NUMBER_TO_USER_MAP.put(rollNumber, newUser);
  }

  /**
   * Reads and validates the user's full name.
   * @return User's full name.
   */
  public static String readFullName() {
    while (true) {
      try {
        System.out.print("Enter user full name: ");
        final String fullName = SCANNER.nextLine().trim();
        ValidateUser.validateFullName(fullName);
        return fullName;
      } catch (CustomException e) {
        System.out.println(EXCEPTION_PREFIX + e.getMessage());
      }
    }
  }

  /**
   * Reads and validates the user's age.
   * @return User's age.
   */
  public static int readAge() {
    while (true) {
      try {
        System.out.print("Enter age: ");
        final String age = SCANNER.nextLine().trim();
        ValidateUser.validateAge(age);
        return Integer.parseInt(age);
      } catch (CustomException e) {
        System.out.println(EXCEPTION_PREFIX + e.getMessage());
      } catch (NumberFormatException e) {
        System.out.println(EXCEPTION_PREFIX + "user age should be an Integer " + e.getMessage());
      }
    }
  }

  /**
   * Reads and validates the user's roll number.
   * @return User's roll number.
   */
  public static String readRollNumber() {
    while (true) {
      try {
        System.out.print("Enter rollNumber: ");
        final String rollNumber = SCANNER.nextLine().trim();
        ValidateUser.validateRollNumber(rollNumber);
        return rollNumber;
      } catch (CustomException e) {
        System.out.println(EXCEPTION_PREFIX + e.getMessage());
      }
    }
  }

  /**
   * Reads and validates the user's address.
   * @return User's address.
   */
  public static String readAddress() {
    while (true) {
      try {
        System.out.print("Enter Address: ");
        final String address = SCANNER.nextLine().trim();
        ValidateUser.validateAddress(address);
        return address;
      } catch (CustomException e) {
        System.out.println(EXCEPTION_PREFIX + e.getMessage());
      }
    }
  }

  /**
   * Reads and validates the user's selected courses.
   * @return Set of user's selected courses.
   */
  public static Set<String> readCourses() {
    while (true) {
      try {
        System.out.println("Enter courses among [A B C D E F], "
            + "choose at least " + MINIMUM_NUMBER_OF_COURSES + ": ");
        System.out.print("Enter courses separated by space: ");
        final String[] courseList = SCANNER.nextLine().trim().split(" ");
        ValidateUser.validateCourses(courseList);
        return new HashSet<>(Arrays.asList(courseList));
      } catch (CustomException e) {
        System.out.println(EXCEPTION_PREFIX + e.getMessage());
      }
    }
  }
}
