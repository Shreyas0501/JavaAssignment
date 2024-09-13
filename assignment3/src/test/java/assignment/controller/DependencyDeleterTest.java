package assignment.controller;

import assignment.model.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DependencyDeleterTest {

  @Test
  void testDependencyDeleter() {

    Node parentNode = new Node();
    Node childNode = new Node();

    parentNode.setId("parentId");
    childNode.setId("childId");

    parentNode.getChildren().add(childNode);
    childNode.getParent().add(parentNode);

    DependencyDeleter.deleterChildToParentDependency(childNode, parentNode);

    assertFalse(parentNode.getChildren().contains(childNode));
    assertFalse(childNode.getParent().contains(parentNode));
  }

}