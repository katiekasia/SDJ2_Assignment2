package model;

public class LogLine
{
  private String text;
  private String user;
  private DateTime dateTime;

  public LogLine(String text, String user)
  {
    this.user = user;
    this.text = text;
    this.dateTime = new DateTime();
  }

  public String getText()
  {
    return text;
  }

  public DateTime getDateTime()
  {
    return dateTime;
  }

  public String toString()
  {
    return dateTime.getTimestamp() + ": " + user +"> " + text;
  }
}
