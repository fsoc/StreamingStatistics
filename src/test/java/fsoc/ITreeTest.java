package fsoc;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.LinkedList;

public class ITreeTest {

  private ITree createTree() {
    ITree tree = new ITree();
    tree.add(20, 36, 1);
    tree.add(29, 99, 1);
    tree.add(3, 41, 1);
    tree.add(0, 1, 1);
    tree.add(10, 15, 1);
    return tree;
  }

  @Test
  public void testInsert() {
    ITree tree = createTree();
    String ans = "(20,36) 99 #(3,41) 41 (29,99) 99 #(0,1) 1 (10,15) 15 ####";
    assertEquals(ans, ""+tree);
  }

  @Test
  public void testNoIntersection() {
    ITree tree = createTree();
    LinkedList<Node> intersections = tree.getIntersections(100, 101);
    assertEquals(0, intersections.size());
  }

  @Test
  public void testNoIntersectionLow() {
    ITree tree = createTree();
    LinkedList<Node> intersections = tree.getIntersections(-1, 0);
    assertEquals(0, intersections.size());
  }

  @Test
  public void testOneIntersection() {
    ITree tree = createTree();
    LinkedList<Node> intersections = tree.getIntersections(98, 100);
    String strAns = "" + intersections.get(0);
    String correctAns = "(29,99) 99 ";
    assertEquals(1, intersections.size());
    assertEquals(correctAns, strAns);
  }

  @Test
  public void testOneIntersectionSmall() {
    ITree tree = createTree();
    LinkedList<Node> intersections = tree.getIntersections(0, 1);
    String strAns = "" + intersections.get(0);
    String correctAns = "(0,1) 1 ";
    assertEquals(1, intersections.size());
    assertEquals(correctAns, strAns);
  }

}
