/**
 * https://spotify.kattis.com/problems/streamstats
 */

package fsoc;
import java.util.Scanner;
import java.io.InputStream;
import java.io.OutputStream;

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
    Log entries[] = new Log[n];

    for (int i = 0; i < n; i++) {
      entries[i] = new Log(io.getLong(),io.getLong(),io.getLong());

    }

    int q = io.getInt();
    Query queries[] = new Query[q];

    for (int i = 0; i < n; i++) {
      queries[i] = new Query(io.getLong(),io.getLong());
    }

    return "foo";

  }
}

