package taskmanager.client;

import taskmanager.Message;
import taskmanager.Server;
import taskmanager.TaskLog;
import taskmanager.TaskNode;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientNotificationThread extends Thread {

    ClientNotificationThread() {
    }

    public void run() {
        while (true) {
            ObjectInputStream objectInput = null;

            try {
                objectInput = new ObjectInputStream(Client.in);

                Message message = (Message) objectInput.readObject();

                if (message.getMessage().equals("NOTIFICATION")) {
                    TaskNode node = (TaskNode) objectInput.readObject();
                    JOptionPane.showMessageDialog(Client.getFrame(), "Уведомление!" + node.getTaskName() + node.getTaskDescription());
                }

                ClientNotificationThread.sleep(4000);

            } catch (IOException | InterruptedException | ClassNotFoundException e) {
                e.printStackTrace();


            }
        }
    }
}