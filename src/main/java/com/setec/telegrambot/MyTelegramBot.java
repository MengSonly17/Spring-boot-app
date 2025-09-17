package com.setec.telegrambot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import com.setec.entities.Booked;

import lombok.Data;

@Service
@Data
public class MyTelegramBot {
	
	@Value("${token}")
	private String token;
	@Value("${chat_id}")
	private long chat_id;
	
	private String message;
	
	 private TelegramBot bot;
	 
	  public SendResponse message(Booked booked) {
		    if(bot == null) {
		    	bot = new TelegramBot(token);
		    }
		    
		    message =
		    	    "📌 Booking Details\n\n" +
		    	    "🪪 ID: " + booked.getId().toString() + "\n" +
		    	    "👤 Name: " + booked.getName().toString() + "\n" +
		    	    "📱 Phone: " + booked.getPhoneNumber().toString() + "\n" +
		    	    "📧 Email: " + booked.getEmail().toString() + "\n" +
		    	    "📅 Date: " + booked.getDate().toString() + "\n" +
		    	    "⏱️ Time: " + booked.getTime().toString() + "\n" +
		    	    "🙍 Person: " + booked.getPerson().toString() ;
		    	

		    SendResponse sendMessage = bot.execute(new SendMessage(chat_id, message ));

		    return sendMessage;
	  }
	
}
