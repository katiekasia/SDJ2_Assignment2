package model;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.io.File;
import java.io.IOException;

public interface Model extends UnnamedPropertyChangeSubject
{
String login(String username, String password) throws IOException, InterruptedException;
void sendText(String text, String user) throws  IOException, InterruptedException;
File getLogs(String user);
}
