/**
 * An implementation of a dynamic segment tree that keeps track of
 * the sums of its children. Insipired by RagnarGrootKoerkamp's solution.
 */

package fsoc;

import java.lang.Math;

public class DSTree {
  private Node root;

  public DSTree(int n) {
    root = new Node(0, n);
  }

  /**
   * Add nodes into this dynamic binary segment tree.
   * We keep the counters of the totalbitrate up to date in the whole tree
   * and propagate down the bit rates of individual ranges with increment
   * calls.
   */
  public void add(int lo, int hi, long bitrate, Node node) {
    if (node == null) {
      node = root;
    }

    if (hi <= node.lo || lo >= node.hi) {
      // If we are before or after the interval
      return;
    } else if (lo <= node.lo && hi >= node.hi) {
      // If we are equal or swallowed by the interval
      increment(node, bitrate);
      return;
    } else if (node.left == null) {
      // If this node does not have children
      // branch it off, this is the dynamic part
      int middle = (node.lo + node.hi) / 2;
      node.left = new Node(node.lo, middle);
      node.right = new Node(middle, node.hi);
    }

    // Push down previous incrementations
    increment(node);

    add(lo, hi, bitrate, node.left);
    add(lo, hi, bitrate, node.right);

    // Bubble up total sums of bandwidth
    node.totalBitrate = node.left.totalBitrate + node.right.totalBitrate;
  }

  // Bubble down bitrates and empty the propagator value for this node
  // This must be done before insertions and after deletions if any
  private void increment(Node node) {
    increment(node.left, node.bitratePropagator);
    increment(node.right, node.bitratePropagator);
    node.bitratePropagator = 0;
  }

  // Update the totalBitrate and increment the propagator
  private void increment(Node node, long bitrate) {
    node.totalBitrate += (node.hi - node.lo) * bitrate;
    node.bitratePropagator += bitrate;
  }

  /**
   * Query this range and return its total bandwidth sum, using saved
   * data from the nodes as much as possible.
   */
  public long query(int lo, int hi, Node node) {
    if (node == null) {
      node = root;
    }

    if (hi <= node.lo || lo >= node.hi) {
      // If we are before or after the interval
      return 0;
    } else if (lo <= node.lo && hi >= node.hi)  {
      // If we are equal or swallowed by the interval
      // Answer with the precalculated bitrate
      return node.totalBitrate;
    } else if (node.left == null) {
      // If this node does not have children
      // Answer the part of it that intersects
      long interLo = Math.max(node.lo, lo);
      long interHi = Math.min(node.hi, hi);
      return node.totalBitrate / (node.hi - node.lo) * (interHi - interLo);
    }

    // Since our query might go deeper than the last addition we need
    // to keep pushing down the incrementations before us, but in a
    // lazy fashion
    increment(node);
    return query(lo, hi, node.left) + query(lo, hi, node.right);
  }
}
