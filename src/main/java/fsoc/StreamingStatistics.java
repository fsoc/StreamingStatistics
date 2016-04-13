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
    return "foo";
  }
}
