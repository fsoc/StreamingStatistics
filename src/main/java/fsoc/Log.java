package fsoc;

public class Log {
  long endTime;
  long duration;
  long bitrate;

  public Log(long endTime, long duration, long bitrate) {
    this.endTime = endTime;
    this.duration = duration;
    this.bitrate = bitrate;
  }
}
