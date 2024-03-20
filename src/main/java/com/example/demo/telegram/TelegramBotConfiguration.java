// package com.example.demo.telegram;

// import org.telegram.telegrambots.bots.TelegramLongPollingBot;
// import org.telegram.telegrambots.meta.TelegramBotsApi;
// import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
// // import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
// import org.telegram.telegrambots.meta.api.methods.send.*;
// import org.telegram.telegrambots.meta.api.objects.Message;
// import org.telegram.telegrambots.meta.api.objects.Update;
// import org.telegram.telegrambots.meta.generics.LongPollingBot;
// import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class TelegramBotConfiguration {
// @Bean
// public TelegramBotsApi telegramBotsApi() throws TelegramApiException {
// return new TelegramBotsApi(DefaultBotSession.class);
// }

// @Bean
// public TelegramBotsApi telegramBotsApis(MyBot myBot) throws
// TelegramApiException {
// TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
// botsApi.registerBot(myBot);
// return botsApi;
// }

// @Bean
// public TelegramBotConfiguration.MyBot myBot() {
// return new TelegramBotConfiguration.MyBot();
// }

// class MyBot extends TelegramLongPollingBot {
// @Override
// public void onUpdateReceived(Update update) {
// Message messages = update.getMessage();
// String chatId = messages.getChatId().toString();
// String text = update.getMessage().getText();
// if (update.hasMessage() && update.getMessage().hasText()) {
// SendMessage message = new SendMessage();
// message.setChatId(chatId);
// message.setText("Hello, " + text + "!");
// try {
// execute(message);
// } catch (TelegramApiException e) {
// e.printStackTrace();
// }
// }
// }

// @Override
// public String getBotUsername() {
// return "UrsaMaximaBot";
// }

// @Override
// public String getBotToken() {
// return "6253531554:AAE2eILvLq8nKUWvyxZbl0XN3FYhOnwJmI4";
// }
// }

// }
