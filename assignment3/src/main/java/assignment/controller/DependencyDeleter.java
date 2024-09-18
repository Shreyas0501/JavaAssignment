package assignment.controller;

import static assignment.config.Constants.NODE_ID_TO_NODE_MAP;
import static assignment.config.Constants.UTILITY_CLASS_MESSAGE;

import assignment.model.Node;

/**
 * Handles the deletion of dependencies between nodes in the tree.
 */
public final class DependencyDeleter {

  private DependencyDeleter() {
    throw new UnsupportedOperationException(UTILITY_CLASS_MESSAGE);
  }

  /**
   * Prompts the user to enter parent and child node IDs
   * and deletes the dependency between them.
   */
  public static void deleteDependency() {

    System.out.print("Enter parent node id: ");
    final String parentId = NodeInputHandler.readNodeId();

    System.out.print("Enter child node id: ");
    final String childId = NodeInputHandler.readNodeId();

    if (isParentAndChildExist(parentId, childId)) {
      final Node parentNode = NODE_ID_TO_NODE_MAP.get(parentId);
      final Node childNode = NODE_ID_TO_NODE_MAP.get(childId);
      System.out.println("Dependency removed between "
          + parentId + " and " + childId);
    }

  }

  public static void deleterChildToParentDependency(Node childNode, Node parentNode) {
    parentNode.children.remove(childNode);
    childNode.parent.remove(parentNode);
  }

  private static boolean isParentAndChildExist(final String parentId, final String childId) {
    if (!NODE_ID_TO_NODE_MAP.containsKey(parentId)) {
      throw new CustomException("\nParent node ID " + parentId + " doesn't exist!");
    }
    if (!NODE_ID_TO_NODE_MAP.containsKey(childId)) {
      throw new CustomException("\nChild node ID " + childId + " doesn't exist!");
    }
    return true;
  }

}