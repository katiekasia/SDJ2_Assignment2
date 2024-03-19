import model.Model;
import model.ModelManager;
import model.User;

public class testMain
{
  public static void main(String[] args)
  {try
  {
    Model model = new ModelManager();
    model.login("Saibot", "123qwe123");
model.sendText("Lorem Ipsum", "Saibot");
    System.out.println(model.getLogs("Saibot"));

  }catch (Exception e){e.printStackTrace();
    System.out.println(e.getMessage());}
  }
}
