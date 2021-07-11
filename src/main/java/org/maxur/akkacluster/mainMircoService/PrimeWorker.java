package org.maxur.akkacluster.mainMircoService;

import static akka.actor.ActorRef.noSender;

import java.util.Map;

import org.maxur.akkacluster.Users.Client;
import org.maxur.akkacluster.baseData.Pair;
import org.maxur.akkacluster.baseData.Record;
import org.maxur.akkacluster.baseData.SQLdataBaseActor;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

public class PrimeWorker extends UntypedAbstractActor {

	private ActorRef sqlDataBase;
	private ActorRef client;
	
	@Override
	public void preStart() {
		sqlDataBase = getContext().actorOf(Props.create(SQLdataBaseActor.class), "sqlDataBase");
		//client = getContext().actorOf(Props.create(Client.class), "client");
	}
	
	@Override
	public void onReceive(Object message) {
		if (message instanceof Pair) {
			final Pair record = (Pair)message;
			sqlDataBase.tell(record, sender());
		}
		/*
		//сообщение пришло
		if (message instanceof Map<?, ?>) {
			final Map<Integer, Record> records = (Map<Integer, Record>) message;
			client.tell(message, getSelf());
		}
		
		if (message instanceof String) {
			job_id_counter++;
			final String ans = (String) message + job_id_counter;
			//System.out.println(ans);
			client.tell(ans, getSelf());
		}
		*/
		unhandled(message);		
	}

}



