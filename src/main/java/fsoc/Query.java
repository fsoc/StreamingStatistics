package fsoc;

public class Query {
  int startTime;
  int endTime;

  public Query(int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public int getLo() {
    return startTime;
  }

  public int getHi() {
    return endTime;
  }
}
