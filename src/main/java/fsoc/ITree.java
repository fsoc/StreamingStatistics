/**
 * A simple implementation of the augmented Interval Tree
 * as seen on https://en.wikipedia.org/wiki/Interval_tree
 */

package fsoc;

import java.util.LinkedList;

public class ITree  {
  private Node root;

  public ITree() {
  }

  /** Adds the node to the tree, we will try to balance it by doing a
   * shuffle on the input before adding
   */
  public void add(int lo, int hi, int bitrate) {

    if (root == null) {
      root = new Node(lo, hi, lo, hi, bitrate);
    } else {
      Node current = root;
      while (current != null) {
        // Keep track of the highest interval in the subtree
        if (current.getMaxHi() < hi) {
          current.setMaxHi(hi);
        }
        // Keep track of the lowest interval in the subtree
        if (current.getMaxLo() > lo) {
          current.setMaxLo(lo);
        }

        if (current.getLo() > lo) {
          if (current.getLeft() == null) {
            current.setLeft(new Node(lo, hi, lo, hi, bitrate));
            return;
          } else {
            current = current.getLeft();
          }
        } else {
          if (current.getRight() == null) {
            current.setRight(new Node(lo, hi, lo, hi, bitrate));
            return;
          } else {
            current = current.getRight();
          }
        }
      }
    }
  }

  /** Returns the Nodes that intersect the range (lo, hi) meaning
   * the query (1,2) does not return the range 0,1.
   */
  public LinkedList<Node> getIntersections(int lo, int hi) {
    LinkedList<Node> ans = new LinkedList<Node>();

    LinkedList<Node> queue = new LinkedList<Node>();
    queue.add(root);

    while (queue.size() > 0) {
      Node current = queue.remove();

      if (intersects(lo, hi, current.getLo(), current.getHi())) {
        ans.add(current);
      }

      if (current.getLeft() != null && current.getLeft().getMaxHi() > lo) {
        queue.add(current.getLeft());
      }
      if (current.getRight() != null && current.getRight().getMaxLo() < hi) {
        queue.add(current.getRight());
      }
    }

    return ans;
  }

  // Returns true if (lo1, hi1) intersect with (lo2, hi2)
  private boolean intersects(int lo1, int hi1, int lo2, int hi2) {
    return lo1 < hi2 && hi1 > lo2;
  }

  // Returns a string representation of this tree
  public String toString() {
    String ans = "";
    LinkedList<Node> queue = new LinkedList<Node>();
    if (root != null) {
      ans += root + "#";
      queue.add(root);
    }

    while (queue.size() > 0) {
      Node current = queue.remove();

      if (current.getLeft() != null) {
        ans += current.getLeft();
        queue.add(current.getLeft());
      }
      if (current.getRight() != null) {
        ans += current.getRight();
        queue.add(current.getRight());
      }
      ans += "#";
    }

    return ans;
  }

}
