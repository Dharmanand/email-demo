package com.example.demo.util;

import java.util.Properties;

import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.Store;

public class ReceiveEmail {

	public static void check(String host, String storeType, String user, String password) {

		try {

			Properties prop = new Properties();
			prop.put("mail.pop3.host", host);
			prop.put("mail.pop3.port", "995");
			prop.put("mail.pop3.starttls.enable", "true");

			Session emailSession = Session.getDefaultInstance(prop);

			Store store = emailSession.getStore("pop3s");
			store.connect(host, user, password);

			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			Message[] messages = emailFolder.getMessages();

			int i = messages.length - 1;

			Message message = messages[i];

			System.out.println("Email No : " + (i + 1));
			System.out.println("Subject : " + message.getSubject());
			System.out.println("Email No : " + message.getFrom()[i]);

			emailFolder.close(true);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		System.out.println("----Stating-----");
		String host = "pop.gmail.com";
		String mailStoreType = "pop3";
		String userName = "kumarxxxxx@gmail.com";
		String password = "*************";
		
		check(host, mailStoreType, userName, password);
		
		System.out.println("----End-----");

	}

}
