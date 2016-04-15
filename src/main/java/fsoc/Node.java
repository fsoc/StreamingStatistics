/**
 * An Interval Tree node containing the log entry of a song.
 * It keeps track of the summarized bandwidth values of its children.
 */

package fsoc;

public class Node  {
  public Node left;
  public Node right;

  // This interval
  public int lo;
  public int hi;

  public long bitratePropagator;
  public long totalBitrate;

  /**
   * Creates a new node for interval searching
   * @param bitrate the bitrate in kbps
   */
  public Node(int lo, int hi) {
    this.lo = lo;
    this.hi = hi;
  }
}
