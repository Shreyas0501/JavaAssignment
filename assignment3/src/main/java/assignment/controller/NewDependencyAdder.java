package assignment.controller;

import static assignment.config.Constants.NODE_ID_TO_NODE_MAP;
import static assignment.config.Constants.UTILITY_CLASS_MESSAGE;

import assignment.model.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages the addition of new dependencies
 * between nodes in the tree structure.
 */
public final class NewDependencyAdder {

  private NewDependencyAdder() {
    throw new UnsupportedOperationException(UTILITY_CLASS_MESSAGE);
  }

  /**
   * Adds new dependency between two nodes and checks for cyclic
   * dependencies. If a cycle is detected, the dependency is not added.
   */
  public static void addNewDependency() {
    final String parentId = promptForNodeId("Parent");
    final String childId = promptForNodeId("Child");

    final Node parentNode = NODE_ID_TO_NODE_MAP.get(parentId);
    final Node childNode = NODE_ID_TO_NODE_MAP.get(childId);

    if (!checkForCycle(parentNode, childNode)) {
      addChildToParentDependency(parentNode, childNode);
      System.out.println("SUCCESSFULLY added new dependency between "
          + parentId + " and " + childId);
    } else {
      throw new CustomException("Cannot add dependence due to cycle formation!");
    }

  }

  private static String promptForNodeId(final String nodeType) {
    System.out.print("\nEnter " + nodeType + " node Id: ");
    String nodeId = NodeInputHandler.readNodeId();
    if (!NODE_ID_TO_NODE_MAP.containsKey(nodeId)) {
      throw new CustomException("Node Id does not exits!");
    }
    return nodeId;
  }

  public static void addChildToParentDependency(final Node parentNode,
                                                 final Node childNode) {
    parentNode.children.add(childNode);
    childNode.parent.add(parentNode);
  }

  private static boolean checkForCycle(final Node parentNode, final Node childNode) {

    Queue<Node> queue = new LinkedList<>();
    queue.add(childNode);

    while (!queue.isEmpty()) {
      var curNode = queue.poll();
      for (Node child : curNode.getChildren()) {
        if (parentNode == child) {
          return true;
        }
        queue.add(child);
      }
    }
    return false;
  }

}
