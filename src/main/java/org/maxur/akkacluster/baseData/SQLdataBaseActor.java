package org.maxur.akkacluster.baseData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.maxur.akkacluster.senderMiroService.MailMessage;

import akka.actor.UntypedAbstractActor;

import java.util.Scanner;
import java.util.TreeMap;

public class SQLdataBaseActor extends UntypedAbstractActor {
	
	private IBaseData baseData;
	
	@Override
	public void preStart() {
		baseData = SQLdataBase.create();
	}
	
	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof Pair) {
			final Pair pair = (Pair)message;
			final int mode = pair.getFirst();
			
			switch (mode) {
			case 0: //update list	
				final Map<Integer, Record> records = baseData.getData();
				sender().tell(records, getSelf());
				break;
			case 1: //pop record
				final Integer id = pair.getSecondPair().getFirst();
				baseData.popRecord(id);
				sender().tell("удаления: успешно", getSelf());
				break;
			case 2: //push record
				final Integer id1 = pair.getSecondPair().getFirst();
				final Record record = pair.getSecondPair().getSecond();
				baseData.pushRecord(id1, record);
				sender().tell("добавления: успешно", getSelf());
				break;
			default:
			    throw new Exception("Ошибка! Режим" +  mode + "не существует!");
			}
		}
		
		if (message instanceof MailMessage) {
			final Map<Integer, Record> records = baseData.getData();
			sender().tell(records, getSelf());
		}
		
		unhandled(message);
		
	}

}
