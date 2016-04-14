/**
 * https://spotify.kattis.com/problems/streamstats
 */

package fsoc;
import java.util.Scanner;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.lang.Math;

public class StreamingStatistics  {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    io.println(processStats(System.in));
    io.flush();
    io.close();
  }

  public static String processStats(InputStream in) {
    Kattio io = new Kattio(in, System.out);

    int n = io.getInt();
    ArrayList<Log> entries = new ArrayList<Log>(n);

    for (int i = 0; i < n; i++) {
      entries.add(new Log(io.getLong(),io.getLong(),io.getLong()));
    }

    // Shuffle the input in order to balance the binary tree
    Collections.shuffle(entries);

    // Get the queries
    int q = io.getInt();
    Query queries[] = new Query[q];

    for (int i = 0; i < n; i++) {
      queries[i] = new Query(io.getLong(),io.getLong());
    }

    return calculateStats(entries, queries);

  }

  private static String calculateStats(ArrayList<Log> entries, Query[] queries) {

    ITree tree = new ITree(entries);
    String answer = "";

    for (Query q : queries) {
      if (answer.length() > 0) {
        answer += "\n";
      }
      String sum = "" + sumBandwidth(tree.getIntersections(q.getLo(), q.getHi()), q);
      answer += sum.substring(0, sum.length() -3) + "." + sum.substring(sum.length() - 3);
    }

    return answer;
  }

  private static long sumBandwidth(LinkedList<Node> intersections, Query q) {
    Iterator<Node> it = intersections.listIterator();

    long sum = 0;
    while (it.hasNext()) {
      Node current = it.next();
      sum += getBandwidth(current, q);
    }
    return sum;
  }

  /**
   * Gets how much bandwidth the song given its kbps has taken for
  * the interval of this query.
  * @return the amount of bits played
  */
  public static long getBandwidth(Node current, Query q) {
    long sharedLo = Math.max(current.getLo(), q.getLo());
    long sharedHi = Math.min(current.getHi(), q.getHi());

    // The amount of intersection in ms of the song and query
    long matchedMillis = sharedHi - sharedLo;
    if (matchedMillis < 1) {
      throw new NumberFormatException("matchedMillis is <1");
    }

    // The amount of bits per ms equals kbits per s
    long bpms = current.getBitrate();

    return matchedMillis * bpms;
  }

}

