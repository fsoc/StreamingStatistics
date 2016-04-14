import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;

public class Generator  {
  public static void main(String[] args) {
    int num = 100000;
    long min = 1325000000000L;
    long max = 1326000000000L;
    long maxd = 30000000L;
    long modulo = max - min;


    System.out.println(num);

    for ( int i = 0; i< num; i++) {
      long rand = ThreadLocalRandom.current().nextLong(min, max);

      long rand2 = rand + ThreadLocalRandom.current().nextLong(0, Math.min(max-rand, maxd));
      long rand3 = ThreadLocalRandom.current().nextLong(64, 320);
      System.out.println(rand+" "+rand2+" "+rand3);
    }

    System.out.println(num);

    for ( int i = 0; i< num; i++) {
      long rand = ThreadLocalRandom.current().nextLong(min, max);
      long rand2 = ThreadLocalRandom.current().nextLong(rand, max);
      System.out.println(rand+" "+rand2);
    }
  }
}
