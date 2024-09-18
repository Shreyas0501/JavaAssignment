package assignment.controller;

import static assignment.config.Constants.EXIT_CONDITION;
import static assignment.config.Constants.SCANNER;
import static assignment.config.Constants.UTILITY_CLASS_MESSAGE;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Provides methods for reading input related to nodes from the user,
 * including node IDs, node names, and additional information.
 */
public final class NodeInputHandler {

  private NodeInputHandler() {
    throw new UnsupportedOperationException(UTILITY_CLASS_MESSAGE);
  }

  /**
   * Prompts the user to enter a node ID and validates the input.
   * @return the node ID entered by the user.
   */
  public static String readNodeId() {
    String nodeId = SCANNER.nextLine().trim();
    while (nodeId.isEmpty()) {
      System.out.print("INVALID NODE ID: Re Enter a valid Node ID: ");
      nodeId = SCANNER.nextLine().trim();
    }
    return nodeId;
  }

  /**
   * Prompts the user to enter a node name and validates the input.
   * @return the node name entered by the user.
   */
  public static String readNodeName() {
    System.out.print("\nEnter new node name: ");
    String nodeName = SCANNER.nextLine().trim();
    while (nodeName.isEmpty()) {
      System.out.println("INVALID name: Re Enter a valid name: ");
      nodeName = SCANNER.nextLine().trim();
    }
    return nodeName;
  }

  /**
   * Prompts user to enter additional information as key-value pairs.
   * The user can enter multiple key-value pairs and type 'exit' to finish.
   * @return a map containing the additional information entered by user.
   */
  public static Map<String, String> readAdditionalInfo() {
    final Map<String, String> additionalInfo = new ConcurrentHashMap<>();
    String key;
    String value;

    System.out.println("Enter additional information (key-value pairs). "
        + "Type 'exit' when finished.");

    while (true) {
      System.out.print("Enter key, (or exit to finish): ");
      key = SCANNER.nextLine().trim();

      if (EXIT_CONDITION.equalsIgnoreCase(key)) {
        break;
      }

      System.out.print("Enter value: ");
      value = SCANNER.nextLine().trim();

      additionalInfo.put(key, value);
      System.out.println("Added entry: " + key + " -> " + value);
    }

    return additionalInfo;
  }

}