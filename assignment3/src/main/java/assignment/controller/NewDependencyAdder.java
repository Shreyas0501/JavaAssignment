package assignment.controller;

import assignment.model.Node;

import java.util.HashSet;
import java.util.Set;

import static assignment.config.Constants.NODE_ID_TO_NODE_MAP;
import static assignment.config.Constants.UTILITY_CLASS_MESSAGE;

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

    addChildToParentDependency(childNode, parentNode);
    if(isCyclicTree(parentId)) {
      removeChildToParentDependency(childNode, parentNode);
      System.out.println("Cannot add dependency due to cyclic formation!");
    } else {
      System.out.println("SUCCESSFULLY added new dependency between "
          + parentId + " and " + childId);
    }
  }

  private static String promptForNodeId(final String nodeType) {
    System.out.print("\nEnter " + nodeType + " node Id: ");
    String nodeId = NodeInputHandler.readNodeId();
    while (!NODE_ID_TO_NODE_MAP.containsKey(nodeId)) {
      System.out.println("Node Id does not exits!");
      nodeId = NodeInputHandler.readNodeId();
    }
    return nodeId;
  }

  public static void addChildToParentDependency(final Node childNode,
                                                 final Node parentNode) {
    parentNode.children.add(childNode);
    childNode.parent.add(parentNode);
  }

  private static void removeChildToParentDependency(final Node childNode,
                                                    final Node parentNode) {
    parentNode.children.remove(childNode);
    childNode.parent.remove(parentNode);
  }

  private static boolean isCyclicTree(final String initialNodeId) {
    final Set<String> visited = new HashSet<>();
    final Set<String> path = new HashSet<>();
    for(final Node node : NODE_ID_TO_NODE_MAP.values()) {
      if (!visited.contains(node.getId()) &&
          checkForCycle(visited, path, initialNodeId)) {
        return true;
      }
    }
    return false;
  }

  private static boolean checkForCycle(final Set<String> visited,
                                       final Set<String> currentPath, final String nodeId) {
    visited.add(nodeId);
    currentPath.add(nodeId);

    for(final Node child : NODE_ID_TO_NODE_MAP.get(nodeId).children) {
      if (currentPath.contains(child.getId())) {
        return true;
      } else if (!visited.contains(child.getId()) &&
          checkForCycle(visited, currentPath, child.getId() )) {
        return true;
      }
    }

    currentPath.remove(nodeId);
    return false;
  }
}
