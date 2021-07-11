package org.maxur.akkacluster.Users;


import java.util.Map;

import org.maxur.akkacluster.baseData.Pair;
import org.maxur.akkacluster.baseData.Record;
import org.maxur.akkacluster.mainMircoService.PrimeWorker;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

public class Client extends UntypedAbstractActor {		
	
	private ActorRef worker;
	private IUser user;
	
	private int job_id_counter = 0;
	
	@Override
	public void preStart() {
		worker = getContext().actorOf(Props.create(PrimeWorker.class), "worker");
		user = new RegisteredUser("Evgeny", "Bubnov");
	}
	
	@Override
	public void onReceive(Object message) {
		//сообщение отправлено 
		if (message instanceof Pair) {	
			final Pair record = (Pair)message;
			worker.tell(record, getSelf());		
		}
		
		//сообщение пришло
		if (message instanceof Map<?, ?>) {
			Map<Integer, Record> records = (Map<Integer, Record>)message;
			user.setRecords(records);
			System.out.println("Обновление списка: " + records.size());
		}
		
		if (message instanceof String) {
			final String ans = (String) message;			
			System.out.println("Операция " + ans);
			System.out.printf("work%d: \n", ++job_id_counter);
		}
		
		unhandled(message);		
	}
	
}

