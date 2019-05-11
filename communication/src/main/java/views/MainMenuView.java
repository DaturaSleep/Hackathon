package views;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

public class MainMenuView {
	private SendMessage message;
	private ReplyKeyboardMarkup keyboardMarkup;
	private KeyboardRow row;
	private List<KeyboardRow> keyboard;

	public MainMenuView(Long chatId) {
		message = new SendMessage();
		message.setChatId(chatId);
		message.setText("Choose your option:");
		keyboard = new ArrayList<>();
		keyboardMarkup = new ReplyKeyboardMarkup();
		
		row = new KeyboardRow();
		row.add("List Of Projects");
	    keyboard.add(row);
	    
	    row = new KeyboardRow();
	    row.add("Create Project");
	    keyboard.add(row);
	    
	    keyboardMarkup.setKeyboard(keyboard);
	    message.setReplyMarkup(keyboardMarkup);
	}
	
	public SendMessage getMessage() {
		return this.message;
	}
}
