/**
 * An Interval Tree node containing the log entry of a song.
 */

package fsoc;

public class Node  {
  private Node left;
  private Node right;

  // The max of values lo and hi below and on this part of the tree
  private long maxLo;
  private long maxHi;

  // This longerval
  private long lo;
  private long hi;
  private long bitrate;


  /**
   * Creates a new node for interval searching
   * @param bitrate the bitrate in kbps
   */
  public Node(long lo, long hi, long maxLo, long maxHi, long bitrate) {
    this.lo = lo;
    this.hi = hi;
    this.maxLo = maxLo;
    this.maxHi = maxHi;
    this.bitrate = bitrate;
  }

  public long getMaxLo() {
    return maxLo;
  }

  public void setMaxLo(long maxLo) {
    this.maxLo = maxLo;
  }

  public long getMaxHi() {
    return maxHi;
  }

  public void setMaxHi(long maxHi) {
    this.maxHi = maxHi;
  }

  public long getHi() {
    return hi;
  }

  public long getLo() {
    return lo;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node node) {
    this.left = node;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node node) {
    this.right = node;
  }

  public long getBitrate() {
    return bitrate;
  }

  public String toString() {
    return "(" + lo + "," + hi + ") " + maxLo + ";" + maxHi + " ";
  }
}
