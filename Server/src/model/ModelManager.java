package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;

public class ModelManager implements Model
{
  private PropertyChangeSupport property;
  private UserList users;
  private Log logs;

  public ModelManager() throws IOException
  {
    this.property = new PropertyChangeSupport(this);
    this.users = new UserList();
    logs = Log.getLog();
  }

  @Override public synchronized String login(String username, String password)
      throws IOException, InterruptedException
  {
    User newUser = new User(username, password);
    for (User user : users.getUsers())
    {
      if (user.getUsername().equals(username) && user.getPassword()
          .equals(password))
      {
        property.firePropertyChange("User logged in", null, newUser);
        return user.getUsername();
      }
    }
    if (users.getUsernames().contains(username))
    {
      throw new IllegalArgumentException("Username taken");
    }
    users.addUser(newUser);
    property.firePropertyChange("User logged in", null, newUser);
    return newUser.getUsername();
  }

  @Override public synchronized void sendText(String text, String user)
      throws IOException, InterruptedException
  {
    LogLine line = new LogLine(text,user);
    logs.addLog(text, user);
    property.firePropertyChange("messageSent", null, line);
  }

  @Override public File getLogs(String user)
  {
    property.firePropertyChange("logs requested", null, user);
    return logs.getLogsFile( user);
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
