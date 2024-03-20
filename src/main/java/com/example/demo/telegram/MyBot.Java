//package com.example.demo.telegram;
//
//public class MyBot extends TelegramLongPollingBot{
//    @Override
//    public void onUpdateReceived(Update update) {
//        if (update.hasMessage() && update.getMessage().hasText()) {
//            SendMessage message = new SendMessage()
//                    .setChatId(update.getMessage().getChatId())
//                    .setText("Hello, " + update.getMessage().getText() + "!");
//            try {
//                execute(message);
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public String getBotUsername() {
//        return "UrsaMaximaBot";
//    }
//
//    @Override
//    public String getBotToken() {
//        return "6253531554:AAE2eILvLq8nKUWvyxZbl0XN3FYhOnwJmI4";
//    }
//}
