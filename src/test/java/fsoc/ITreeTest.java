package fsoc;

import org.junit.*;
import static org.junit.Assert.*;

public class ITreeTest {

  @Test
  public void testInsert() {
    ITree tree = new ITree();
    tree.add(20, 36, 1);
    tree.add(29, 99, 1);
    tree.add(3, 41, 1);
    tree.add(0, 1, 1);
    tree.add(10, 15, 1);

    String ans = "(20,36) 99 #(3,41) 41 (29,99) 99 #(0,1) 1 (10,15) 15 ####";
    assertEquals(ans, ""+tree);
  }
}
