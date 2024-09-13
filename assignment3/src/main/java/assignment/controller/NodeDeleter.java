package assignment.controller;

import assignment.model.Node;

import java.util.Set;

import static assignment.config.Constants.NODE_ID_TO_NODE_MAP;
import static assignment.config.Constants.UTILITY_CLASS_MESSAGE;

/**
 * Handles the deletion of nodes from the tree structure.
 */
public final class NodeDeleter {

  private NodeDeleter() {
    throw new UnsupportedOperationException(UTILITY_CLASS_MESSAGE);
  }
  /**
   * Deletes node from tree removes node from its parent's & children's
   * sets and clears its own parent and children sets.
   * It also removes the node from the global node map.
   */
  public static void deleteNode() {
    System.out.print("\nEnter the node Id: ");
    final String nodeId = NodeInputHandler.readNodeId();

    if (NODE_ID_TO_NODE_MAP.containsKey(nodeId)) {
      final Node curNode = NODE_ID_TO_NODE_MAP.get(nodeId);
      final Set<Node> parentNodes = curNode.getParent();

      for (final Node parent : parentNodes) {
        parent.getChildren().remove(curNode);
      }

      curNode.getParent().clear();
      curNode.getChildren().clear();
      NODE_ID_TO_NODE_MAP.remove(nodeId);

      System.out.println("Node with ID " + nodeId + " has been deleted.");
    } else {
      System.out.println("Node Id doesn't exist!");
    }
  }
}
