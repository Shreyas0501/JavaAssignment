package assignment.controller;

import static assignment.config.Constants.NODE_ID_TO_NODE_MAP;
import static assignment.config.Constants.UTILITY_CLASS_MESSAGE;

import assignment.model.Node;

import java.util.Map;

/**
 * Handles the addition of new nodes to the tree structure.
 */
public final class NewNodeAdder {

  private NewNodeAdder() {
    throw new UnsupportedOperationException(UTILITY_CLASS_MESSAGE);
  }

  /**
   * Prompts user to input details for new node and adds it to tree.
   * Ensures that the node ID is unique before adding.
   */
  public static void addNewNode() {

    System.out.print("\nEnter new node Id: ");
    final String nodeId = NodeInputHandler.readNodeId();

    if (NODE_ID_TO_NODE_MAP.containsKey(nodeId)) {
      throw new CustomException("INVALID NODE ID! node id already exits!");
    }

    final String nodeName = NodeInputHandler.readNodeName();
    final Map<String, String> nodeAdditionInfo = NodeInputHandler.readAdditionalInfo();

    final Node newNode = new Node();
    newNode.setId(nodeId);
    newNode.setName(nodeName);
    newNode.setAdditionalInfo(nodeAdditionInfo);

    NODE_ID_TO_NODE_MAP.put(nodeId, newNode);
    System.out.println("SUCCESSFULLY added!");
  }

}