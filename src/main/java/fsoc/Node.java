/**
 * An Interval Tree node containing the log entry of a song.
 */

package fsoc;

public class Node  {
  private Node left;
  private Node right;

  // The max of values lo and hi below and on this part of the tree
  private int maxLo;
  private int maxHi;

  // This interval
  private int lo;
  private int hi;
  private int bitrate;


  public Node(int lo, int hi, int maxLo, int maxHi, int bitrate) {
    this.lo = lo;
    this.hi = hi;
    this.maxLo = maxLo;
    this.maxHi = maxHi;
    this.bitrate = bitrate;
  }

  public int getMaxLo() {
    return maxLo;
  }

  public void setMaxLo(int maxLo) {
    this.maxLo = maxLo;
  }

  public int getMaxHi() {
    return maxHi;
  }

  public void setMaxHi(int maxHi) {
    this.maxHi = maxHi;
  }

  public int getHi() {
    return hi;
  }

  public int getLo() {
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

  public String toString() {
    return "(" + lo + "," + hi + ") " + maxLo + ";" + maxHi + " ";
  }
}
