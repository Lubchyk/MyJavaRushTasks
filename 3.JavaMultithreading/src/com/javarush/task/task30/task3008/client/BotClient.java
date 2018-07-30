package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {

            if (message != null) {
                ConsoleHelper.writeMessage(message);
                SimpleDateFormat simpleDateFormat = null;
                if (message.contains(": ")) {
                    String[] split = message.split(": ");
                    if (split.length == 2 && split[1] != null) {
                        if (split[1].equalsIgnoreCase("дата")) simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                        else if (split[1].equalsIgnoreCase("день")) simpleDateFormat = new SimpleDateFormat("d");
                        else if (split[1].equalsIgnoreCase("месяц")) simpleDateFormat = new SimpleDateFormat("MMMM");
                        else if (split[1].equalsIgnoreCase("год")) simpleDateFormat = new SimpleDateFormat("YYYY");
                        else if (split[1].equalsIgnoreCase("время")) simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                        else if (split[1].equalsIgnoreCase("час")) simpleDateFormat = new SimpleDateFormat("H");
                        else if (split[1].equalsIgnoreCase("минуты")) simpleDateFormat = new SimpleDateFormat("m");
                        else if (split[1].equalsIgnoreCase("секунды")) simpleDateFormat = new SimpleDateFormat("s");

//                        String format = simpleDateFormat.format(Calendar.getInstance().getTime());
                        if (simpleDateFormat != null)  sendTextMessage(String.format("Информация для %s: %s", split[0], simpleDateFormat.format(Calendar.getInstance().getTime())));
                    }
                }
            }

        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        String botName = "date_bot_" + ((int) (Math.random() * 100));
        return botName;
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
