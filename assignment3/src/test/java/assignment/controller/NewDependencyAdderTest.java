package assignment.controller;

import assignment.model.Node;
import assignment.view.DisplayNode;
import org.junit.jupiter.api.Test;

import static assignment.config.Constants.NODE_ID_TO_NODE_MAP;
import static org.junit.jupiter.api.Assertions.*;
class NewDependencyAdderTest {

  @Test
  void testNewDependencyAdder() {
    Node parentNode = new Node();
    Node childNode = new Node();

    parentNode.setId("parent1");
    childNode.setId("child1");

    NODE_ID_TO_NODE_MAP.put("parent1", parentNode);
    NODE_ID_TO_NODE_MAP.put("child1", childNode);

    NewDependencyAdder.addChildToParentDependency(childNode, parentNode);
    assertTrue(parentNode.getChildren().contains(childNode));
  }

}