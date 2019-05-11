package controllers;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import models.UserModel;
import views.MainMenuView;

public class BotController extends TelegramLongPollingBot {

	public void onUpdateReceived(Update update) {

		try {
			processUpdate(update);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
//
//		if (update.hasMessage()) {
//			Message message = update.getMessage();
//
//			if (message.hasText()) {
//				registerUser(update);
//				try {
//					execute(new MainMenuView(getChatIdFromUpdate(update)).getMessage());
//				} catch (TelegramApiException e) {
//					
//					e.printStackTrace();
//				}
//			}
//		}

	}

	public void processUpdate(Update update) throws TelegramApiException {
		switch (getTextMessageFromUpdate(update)) {
		case ("/start"):
			registerUser(update);
			execute(new MainMenuView(getChatIdFromUpdate(update)).getMessage());
			break;
		case ("")
		default:
			execute(new MainMenuView(getChatIdFromUpdate(update)).getMessage());
			break;
		}

	}

	public String getTextMessageFromUpdate(Update update) {
		return update.getMessage().getText();
	}

	public Long getChatIdFromUpdate(Update update) {
		return update.getMessage().getChatId();
	}

	public void registerUser(Update update) {
		if (!UserModel.allRegistratedUsers.containsKey(getUserIdFromUpdate(update))) {
			new UserModel(getUserIdFromUpdate(update), getUserNameFromUpdate(update));
		}
	}

	public String getUserNameFromUpdate(Update update) {
		return update.getMessage().getFrom().getUserName();
	}

	public Integer getUserIdFromUpdate(Update update) {
		return update.getMessage().getFrom().getId();
	}

	public String getBotUsername() {

		return null;
	}

	@Override
	public String getBotToken() {

		return "744010929:AAFpTulxLK-sSw5r-Y4gtOF7_Qx1-ImJTl0";
	}

}