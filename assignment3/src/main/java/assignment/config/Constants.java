package assignment.config;

import assignment.model.Node;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Contains constant values and shared resources for the application.
 */
public class Constants {
  public static final Scanner SCANNER = new Scanner(System.in);
  public static final Map<String, Node> NODE_ID_TO_NODE_MAP = new ConcurrentHashMap<>();
  public static final int EXIT_OPTION = 9;
  public static final String UTILITY_CLASS_MESSAGE =
      "Cannot initialise utility class";
  public static final String EXIT_CONDITION = "exit";
}