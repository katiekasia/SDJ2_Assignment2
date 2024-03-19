package model;

import java.io.Serializable;
import java.util.ArrayList;

public class UserList implements Serializable
{
  private static UserList instance;
  private final ArrayList<User> users;
  private final ArrayList<String> usernames;

  public UserList()
  {
    users = new ArrayList<>();
    usernames = new ArrayList<>();
  }

  public synchronized void addUser(User user)
  {
    for (User var : users)
    {
      if (var.equals(user))
      {
        return;
      }
    }
    users.add(user);
    usernames.add(user.getUsername());
  }

  public static synchronized UserList getInstance()
  {
    if (instance == null)
    {
      instance = new UserList();
    }
    return instance;
  }

  public synchronized void changeUser(User user)
  {
    for (User var : users)
    {
      if (var.equals(user))
      {
        users.remove(var);
        users.add(user);
        break;
      }
    }
  }

  public synchronized ArrayList<User> getUsers()
  {
    return users;
  }
public synchronized ArrayList<String> getUsernames(){return usernames;}
  public synchronized String toString()
  {
    String temp = "";
    for (int i = 0; i < users.size(); i++)
    {
      temp += users.get(i) + "\n";
    }
    return temp;
  }
}
