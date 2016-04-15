import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;

public class Generator  {
  public static void main(String[] args) {
    print3();
  }

  private static void print3() {
    int num = 100000;
    long min = 1325000000000L;
    long maxd = 30000000L;

    System.out.println(num);

    for ( int i = 0; i< num; i++) {
      System.out.println(min+" "+maxd+" "+64);
    }

    System.out.println(num);

    for ( int i = 0; i< num; i++) {
      System.out.println(min+" "+(min + (maxd-1)));
    }
  }

  private static void print2() {
    int num = 100000;
    long min = 1325000000000L;

    System.out.println(num);

    long tempMin = min;
    for ( int i = 0; i< num; i++) {
      long a = tempMin;
      long b = 3;
      tempMin += 4;
      System.out.println(a+" "+b+" "+64);
    }

    System.out.println(num);

    tempMin = min;
    for ( int i = 0; i< num; i++) {
      long a = tempMin + 1;
      long b = tempMin + 2;
      tempMin += 4;
      System.out.println(a+" "+b);
    }
  }

  private static void print1() {
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
