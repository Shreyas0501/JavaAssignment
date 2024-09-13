package assignment.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Represents a node in the graph with a unique ID, name, additional information,
 * and relationships to parent and child nodes.
 */
public class Node {

  public String id;
  public String name;
  public Map<String, String> additionalInfo;

  public Set<Node> parent;
  public Set<Node> children;

  /**
   * Constructs a new Node with empty parent and child sets.
   */
  public Node() {
    parent = new HashSet<>();
    children = new HashSet<>();
    id = "";
    name = "";
  }

  public void setId(final String id) {
    this.id = id;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public void setAdditionalInfo(final Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Map<String, String> getAdditionalInfo() {
    return additionalInfo;
  }

  public Set<Node> getParent() {
    return parent;
  }

  public Set<Node> getChildren() {
    return children;
  }

}