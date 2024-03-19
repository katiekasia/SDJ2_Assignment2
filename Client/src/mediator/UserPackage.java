package mediator;

import java.io.Serializable;

public class UserPackage implements Serializable
{
  private String username;
  private String password;

  public UserPackage(String nickname, String password)
  {
    this.username = nickname;
    this.password = password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getPassword()
  {
    return password;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getUsername()
  {
    return username;
  }

  public String toString()
  {
    return username;
  }

  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != getClass())
    {
      return false;
    }

    UserPackage other = (UserPackage) obj;
    return this.username.equals(other.username);
  }
}