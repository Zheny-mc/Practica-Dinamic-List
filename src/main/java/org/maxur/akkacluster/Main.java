package org.maxur.akkacluster;

import static akka.actor.ActorRef.noSender;

import org.maxur.akkacluster.Users.Client;
import org.maxur.akkacluster.baseData.Pair;
import org.maxur.akkacluster.baseData.Record;
import org.maxur.akkacluster.senderMiroService.Email;
import org.maxur.akkacluster.senderMiroService.MailMessage;
import org.maxur.akkacluster.senderMiroService.Telegram;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import akka.actor.Props;
import akka.actor.TypedActor.PreStart;

public class Main {
	
	public static ActorSystem system = ActorSystem.create("learning");
	public static ActorRef client = system.actorOf(Props.create(Client.class), "client");
	//public static ActorRef telegram = system.actorOf(Props.create(Telegram.class), "telegram");
	//public static ActorRef email = system.actorOf(Props.create(Email.class), "email");
	
	public static void main(String[] args) {
		client.tell(Pair.create(0), ActorRef.noSender());
		
		for (int i = 0; i < 900; ++i) {
			final Record record = new Record("vanga", "pistolet", 7777);
			
			client.tell(Pair.create(2, Pair.create(record.hashCode(), record)), ActorRef.noSender());
			//client.tell(Pair.create(1, Pair.create(record.hashCode(), record)), ActorRef.noSender());
			//telegram.tell(MailMessage.create("update"), ActorRef.noSender());
			//email.tell(MailMessage.create("update"), ActorRef.noSender());
		}
		
		client.tell(Pair.create(0), ActorRef.noSender());
		
		try { Thread.sleep(1000L); } 
		catch (InterruptedException e) { e.printStackTrace(); }
		
		system.terminate();
		
	}

	
}
