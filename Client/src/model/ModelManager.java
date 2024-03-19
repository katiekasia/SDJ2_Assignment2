package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;

public class ModelManager implements Model
{
  private PropertyChangeSupport property;
  @Override public String login(String username, String password)
      throws IOException, InterruptedException
  {
    //return TextListClient.login(username, password);
    return null;
  }

  @Override public void sendText(String text, String user)
      throws IOException, InterruptedException
  {
//TextListClient.sendText(String text, user);
  }

  @Override public File getLogs(String user)
  {
    //return TextListClient.getLogs(user);
    return null;
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
property.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
property.removePropertyChangeListener(listener);
  }
}
