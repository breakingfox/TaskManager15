package taskmanager.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.ParseException;

public class NotificationThread extends Thread {

    public NotificationThread(){
    }

    public void run() {
        try {
            while (true) {
                Server.controller.notification();
                NotificationThread.sleep(2000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
