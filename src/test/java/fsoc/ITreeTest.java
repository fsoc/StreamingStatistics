package fsoc;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Iterator;

public class ITreeTest {

  private ITree createTree() {
    ITree tree = new ITree();
    tree.add(20, 36, 6);
    tree.add(29, 99, 2);
    tree.add(3, 41, 3);
    tree.add(0, 1, 12);
    tree.add(10, 15, 11);
    tree.add(7, 8, 39);
    return tree;
  }

  @Test
  public void testInsert() {
    ITree tree = createTree();
    String ans = "(20,36) 0;99 #(3,41) 0;41 (29,99) 29;99 #(0,1) 0;1 (10,15) 7;15 ###(7,8) 7;8 ##";
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
    assertEquals(1, intersections.size());
    assertEquals("(29,99) 29;99 ", getIntersections(intersections));
  }

  @Test
  public void testOneIntersectionSmall() {
    ITree tree = createTree();
    LinkedList<Node> intersections = tree.getIntersections(0, 1);
    assertEquals(1, intersections.size());
    assertEquals("(0,1) 0;1 ", getIntersections(intersections));
  }

  @Test
  public void test3Intersections() {
    ITree tree = createTree();
    LinkedList<Node> intersections = tree.getIntersections(0, 9);
    assertEquals(3, intersections.size());
    assertEquals("(7,8) 7;8 (0,1) 0;1 (3,41) 0;41 ", getIntersections(intersections));
  }

  @Test
  public void testDuplicates() {
    ITree tree = createTree();
    tree.add(7, 8, 9);
    LinkedList<Node> intersections = tree.getIntersections(0, 9);
    assertEquals(4, intersections.size());
    assertEquals("(7,8) 7;8 (7,8) 7;8 (0,1) 0;1 (3,41) 0;41 ", getIntersections(intersections));
  }

  @Test
  public void testEmpty() {
    ITree tree = new ITree();
    assertEquals(0, tree.getIntersections(0,99).size());
  }


  private String getIntersections(LinkedList<Node> intersections) {
    Iterator<Node> it = intersections.descendingIterator();
    String ans ="";

    while (it.hasNext()) {
      ans += it.next();
    }
    return ans;
  }

}
