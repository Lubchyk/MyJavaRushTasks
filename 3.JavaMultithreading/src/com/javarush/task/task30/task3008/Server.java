package com.javarush.task.task30.task3008;

import com.sun.media.jfxmedia.locator.ConnectionHolder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message receive = connection.receive();
                if (receive != null && receive.getType() == (MessageType.TEXT)) {

                    Message message = new Message( MessageType.TEXT,userName + ": " + receive.getData());
                    sendBroadcastMessage(message);

                } else ConsoleHelper.writeMessage("ошибка");
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();

                if (answer.getType() == MessageType.USER_NAME) {

                    if (!answer.getData().isEmpty()) {
                        if (!connectionMap.containsKey(answer.getData())) {
                            connectionMap.put(answer.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return answer.getData();
                        }
                    }
                }
            }
        }
       private void sendListOfUsers(Connection connection, String userName) throws IOException {
           try {
               Iterator<Map.Entry<String, Connection>> iterator = connectionMap.entrySet().iterator();
               while (iterator.hasNext()) {
                   Map.Entry<String, Connection> next = iterator.next();
                   String name = next.getKey();
                   if (!name.equals(userName)) {
                       connection.send(new Message(MessageType.USER_ADDED, name));
                   }
               }
           } catch (IOException e) {
               System.out.println("не смогли отправить сообщение");
           }
        }

        public void run() {
            ConsoleHelper.writeMessage("установлено новое соединение с удаленным адресом " + socket.getRemoteSocketAddress());
            Connection connection = null;
            String name = null;
            try {
                connection = new Connection(socket);
                name = serverHandshake(connection);
                sendBroadcastMessage( new Message(MessageType.USER_ADDED, name));
                sendListOfUsers(connection, name);
                serverMainLoop(connection, name);
                connectionMap.remove(name);
                ConsoleHelper.writeMessage("соединение с удаленным адресом закрыто");

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("An exchange of data error to a remote socket address");
            } finally {
                if (name != null) {
                    connectionMap.remove(name);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
                }
                ConsoleHelper.writeMessage("Closed connection to a remote socket address: "); // + socketAddress);
            }
        }

    }
    public static void sendBroadcastMessage(Message message) {
        try {
            Iterator<Map.Entry<String, Connection>> iterator = connectionMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Connection> next = iterator.next();
                next.getValue().send(message);
            }
        } catch (IOException e) {
            System.out.println("не смогли отправить сообщение");
        }
    }


}

