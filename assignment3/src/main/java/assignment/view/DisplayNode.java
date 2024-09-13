package assignment.view;

import assignment.controller.NodeInputHandler;
import assignment.model.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static assignment.config.Constants.NODE_ID_TO_NODE_MAP;
import static assignment.config.Constants.UTILITY_CLASS_MESSAGE;

/**
 * Provides methods to display information about nodes,
 * including their immediate parents, children, ancestors, and descendants.
 */
public final class DisplayNode {

  private DisplayNode() {
    throw new UnsupportedOperationException(UTILITY_CLASS_MESSAGE);
  }

  /**
   * Displays immediate parent nodes of a specified node.
   */
  public static void displayImmediateParent() {
    final String nodeId = promptForNodeId();
    if (nodeId == null) {
      return;
    }

    final Node currentNode = NODE_ID_TO_NODE_MAP.get(nodeId);
    if (currentNode.getParent() == null || currentNode.getParent().isEmpty()) {
      System.out.println("No parent node!");
      return;
    }

    System.out.println("Parent node: ");
    for (final Node parentNode : currentNode.getParent()) {
      displayNodeDetails(parentNode);
    }
  }

  /**
   * Displays immediate child nodes of a specified node.
   */
  public static void displayImmediateChildren() {
    final String nodeId = promptForNodeId();
    if (nodeId == null) {
      return;
    }

    final Node currentNode = NODE_ID_TO_NODE_MAP.get(nodeId);
    if (currentNode.getChildren() == null || currentNode.getChildren().isEmpty()) {
      System.out.println("No children node!");
      return;
    }

    System.out.println("Children node: ");
    for (final Node childNode : currentNode.getChildren()) {
      displayNodeDetails(childNode);
    }
  }

  /**
   * Displays all ancestor nodes of a specified node.
   */
  public static void displayAncestor() {
    final String nodeId = promptForNodeId();
    if (nodeId == null) {
      return;
    }

    final Queue<String> queue = new LinkedList<>();
    queue.add(nodeId);
    final Set<String> visited = new HashSet<>();
    visited.add(nodeId);

    System.out.println("Ancestors: ");
    while (!queue.isEmpty()) {
      final String currentNodeId = queue.poll();
      for (final Node parentNode : NODE_ID_TO_NODE_MAP.get(currentNodeId).getParent()) {
        final String parentNodeId = parentNode.getId();
        if (!visited.contains(parentNodeId)) {
          queue.add(parentNodeId);
          visited.add(parentNodeId);
          displayNodeDetails(parentNode);
        }
      }
    }
  }

  /**
   * Displays all descendant nodes of a specified node.
   */
  public static void displayDescendant() {
    System.out.print("\nEnter node id: ");
    final String nodeId = NodeInputHandler.readNodeId();
    if (!isNodeIdPresent(nodeId)) {
      return;
    }

    final Queue<String> queue = new LinkedList<>();
    queue.add(nodeId);
    final Set<String> visited = new HashSet<>();
    visited.add(nodeId);

    System.out.println("Descendants: ");
    while (!queue.isEmpty()) {
      final String curNodeId = queue.poll();
      for (final Node childNode : NODE_ID_TO_NODE_MAP.get(curNodeId).getChildren()) {
        final String childNodeId = childNode.getId();
        if (!visited.contains(childNodeId)) {
          queue.add(childNodeId);
          visited.add(childNodeId);
          displayNodeDetails(childNode);
        }
      }
    }
  }

  /**
   * Prompts the user for a node ID and validates its existence.
   * @return the node ID if it exists; null otherwise.
   */
  private static String promptForNodeId() {
    System.out.print("\nEnter node Id: ");
    final String nodeId = NodeInputHandler.readNodeId();
    if (!isNodeIdPresent(nodeId)) {
      return null;
    }
    return nodeId;
  }

  private static boolean isNodeIdPresent(final String nodeId) {
    if (!NODE_ID_TO_NODE_MAP.containsKey(nodeId)) {
      System.out.println("Node Id " + nodeId + " doesn't exist!");
      return false;
    }
    return true;
  }

  /**
   * Displays the details of a given node.
   * @param node the node to display.
   */
  public static void displayNodeDetails(final Node node) {
    System.out.println("\nNODE ID    : " + node.getId());
    System.out.println("NODE NAME  : " + node.getName());
    System.out.print("CHILDREN'S : ");
    for(Node childNode : node.getChildren()) {
      System.out.print(childNode.getId() + ", ");
    }

    System.out.print("\nPARENT'S : ");
    for(Node parentNode : node.getParent()) {
      System.out.print(parentNode.getId() + ", ");
    }
  }
}
