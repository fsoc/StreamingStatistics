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
    processStats(System.in, System.out);
  }

  public static void processStats(InputStream in, OutputStream out) {
    long offset = 1325000000000L;
    int max = 1000000000; // the maximum song range possible
    Kattio io = new Kattio(in, out);

    int n = io.getInt();

    DSTree tree = new DSTree(max + 1);

    for (int i = 0; i < n; i++) {
      int hi = (int)(io.getLong() - offset);
      int lo = hi - io.getInt();
      int bitrate = io.getInt();
      tree.add(lo, hi, bitrate, null);
    }

    // Get the queries
    int q = io.getInt();

    for (int i = 0; i < q; i++) {
      int lo = (int)(io.getLong()-offset);
      int hi = (int)(io.getLong()-offset);
      double bandwidth = (double)tree.query(lo, hi, null) / 1000.0;

      io.println(String.format("%.3f", bandwidth));
    }

    io.flush();
    io.close();
  }
}
