package assignment.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class contains constants used throughout the application.
 */
public class Constants {

  public static final int MINIMUM_NUMBER_OF_COURSES = 4;
  public static final Set<String> VALID_COURSES =
      new HashSet<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
  public static final String FILE_PATH = "userDetails.ser";

}