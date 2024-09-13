package assignment.controller;

import static assignment.config.Constants.FILE_PATH;
import static assignment.config.SharedData.ROLL_NUMBER_TO_USER_MAP;

import assignment.model.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utility class for saving user details to a file.
 * The class provides a static method to serialize and save
 * user objects from the user list to a specified file path.
 */
public final class SaveUser {

  // Private constructor to prevent instantiation
  private SaveUser() {
    throw new UnsupportedOperationException("This utility class cannot be initialised!");
  }

  /**
   * Saves user details from the user list to a file.
   * Prints a success message if the operation is successful,
   * or an error message if the file is not found or an I/O error occurs.
   */
  public static void saveUserDetails() {
    try (ObjectOutputStream objectOutputStream =
             new ObjectOutputStream(Files.newOutputStream(Paths.get(FILE_PATH)))) {
      for (final User user : ROLL_NUMBER_TO_USER_MAP.values()) {
        objectOutputStream.writeObject(user);
      }
      System.out.println("SUCCESSFULLY Saved the user details.\n");
    } catch (FileNotFoundException e) {
      System.out.println("File not found!");
    } catch (IOException e) {
      System.out.println("Error in input output operation!");
    }
  }
}
