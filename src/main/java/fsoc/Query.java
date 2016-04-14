package fsoc;

public class Query {
  long startTime;
  long endTime;

  public Query(long startTime, long endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public long getLo() {
    return startTime;
  }

  public long getHi() {
    return endTime;
  }
}
