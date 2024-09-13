package assignment.controller;

import static assignment.config.Constants.FILE_PATH;
import static assignment.config.SharedData.ROLL_NUMBER_TO_USER_MAP;

import assignment.model.User;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utility class for loading saved user details from a file.
 * This class provides a static method to deserialize user objects
 * from a file and populate the user list and roll number map.
 */
public final class SavedUserDetailsLoader {

  // Private constructor to prevent instantiation
  private SavedUserDetailsLoader() {
    throw new UnsupportedOperationException("Utility class cannot be initialised.");
  }

  /**
   * Loads user details from a file and adds them to the user list and roll number map.
   * If the file is not found or an error occurs during loading,
   * an appropriate message is printed.
   */
  public static void loadUserDetails() {

    try (ObjectInputStream objectInputStream =
             new ObjectInputStream(Files.newInputStream(Paths.get(FILE_PATH)))) {

      while (true) {
        try {
          final User user = (User) objectInputStream.readObject();
          ROLL_NUMBER_TO_USER_MAP.put(user.getRollNumber(), user);
        } catch (EOFException e) {
          break;
        } catch (Exception e) {
          System.out.println("Empty file!\n");
          break;
        }
      }
    } catch (Exception e) {
      System.out.println("Empty file!\n");
    }
  }
}
