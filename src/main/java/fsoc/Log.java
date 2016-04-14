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

  public long getHi() {
    return endTime;
  }

  public long getLo() {
    return endTime - duration;
  }

  public long getBitrate() {
    return bitrate;
  }
}
