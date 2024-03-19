package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Log
{
  private ArrayList<LogLine> list;
  private static Log log;
  private String directory;
  private static Object lock = new Object();

  private Log()
  {
    list=new ArrayList<>();
    directory = "Logs/";
  }
  public static Log getLog(){
    if(log == null){
      synchronized (lock)
      {
        if (log == null){
          log = new Log();
        }
      }
    }
    return log;
  }
public void addLog(String text, String user){
    LogLine logLine = new LogLine(text, user);
    list.add(logLine);
    addToFile(logLine);
  System.out.println(logLine.toString());
}
  private void addToFile(LogLine log)
  {
    if (log == null)
    {
      return;
    }
    BufferedWriter out = null;
    try
    {
      String filename = "Log-" + log.getDateTime().getSortableDate() + ".txt";
      out = new BufferedWriter(new FileWriter(filename, true));
      out.write(log + "\n");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        out.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
  public File getLogsFile(String user) {
    LogLine log = new LogLine("//GET LOGS//", user);
    String filename = "Log-" + log.getDateTime().getSortableDate() + ".txt";
    File logsFile = new File(filename);
    BufferedWriter writer = null;

    try {
      if (!logsFile.exists()) {
        logsFile.createNewFile();
      }

      writer = new BufferedWriter(new FileWriter(logsFile));

      for (LogLine logLine : list) {
        writer.write(logLine.toString());
        writer.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (writer != null) {
          writer.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return logsFile;
  }


  public ArrayList<LogLine> getAll()
  {
    return list;
  }

  public String toString()
  {
    String string = "";
    for (LogLine line : list){
      string += line.toString() + "\n";
    }
    return string;
  }

}
