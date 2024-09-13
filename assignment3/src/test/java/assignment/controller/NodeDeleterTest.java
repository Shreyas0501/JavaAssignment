package assignment.controller;

import assignment.model.Node;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static assignment.config.Constants.NODE_ID_TO_NODE_MAP;
import static org.junit.jupiter.api.Assertions.*;

class NodeDeleterTest {

  @Test
  public void testNodeDeleter() {
    NODE_ID_TO_NODE_MAP.put("1234", new Node());
    assertEquals(NODE_ID_TO_NODE_MAP.size(), 1);
    try (var mockedNodeInputHandler = Mockito.mockStatic(NodeInputHandler.class)) {
      mockedNodeInputHandler.when(NodeInputHandler::readNodeId).thenReturn("1234");
    }
    assertEquals(NODE_ID_TO_NODE_MAP.size(), 1);
  }

}