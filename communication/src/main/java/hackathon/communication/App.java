package hackathon.communication;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import controllers.BotController;

public class App {
	public static void main(String[] args) {
		ApiContextInitializer.init();
		BotController b = new BotController();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(b);
		} catch (TelegramApiException e) {

		}
		b = new BotController();
	}
}
