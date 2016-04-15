package fsoc;

public class Log {
  int endTime;
  int duration;
  int bitrate;

  public Log(int endTime, int duration, int bitrate) {
    this.endTime = endTime;
    this.duration = duration;
    this.bitrate = bitrate;
  }

  public int getHi() {
    return endTime;
  }

  public int getLo() {
    return endTime - duration;
  }

  public int getBitrate() {
    return bitrate;
  }
}
