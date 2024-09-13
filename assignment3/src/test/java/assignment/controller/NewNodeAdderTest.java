package assignment.controller;

import assignment.model.Node;
import assignment.view.DisplayNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static assignment.config.Constants.NODE_ID_TO_NODE_MAP;
import static org.junit.jupiter.api.Assertions.*;

class NewNodeAdderTest {

  @BeforeEach
  public void setUp() {
    NODE_ID_TO_NODE_MAP.clear();
  }

  @AfterEach
  public void tearDown() {
    NODE_ID_TO_NODE_MAP.clear();
  }

  @Test
  public void testNewNodeAdder() {

    try (var mockedNewNodeAdder = Mockito.mockStatic(NodeInputHandler.class)) {
      mockedNewNodeAdder.when(NodeInputHandler::readNodeId).thenReturn("1234");
      mockedNewNodeAdder.when(NodeInputHandler::readNodeName).thenReturn("node Name");
      mockedNewNodeAdder.when(NodeInputHandler::readAdditionalInfo).thenReturn(new ConcurrentHashMap<>());
      NewNodeAdder.addNewNode();
    }

    DisplayNode.displayNodeDetails(NODE_ID_TO_NODE_MAP.get("1234"));
    assertEquals(NODE_ID_TO_NODE_MAP.size(), 1, "size should be 1");

  }
}
