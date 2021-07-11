package org.maxur.akkacluster.Users;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.maxur.akkacluster.baseData.Pair;
import org.maxur.akkacluster.baseData.Record;

public abstract class IUser {
	protected String name;
	protected String surname;
	protected Map<Integer, Record> records;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Pair getRecord(Integer num) {
		
		Entry entry = null;
		Integer id = null;
		Record record = null;
		
		Iterator itr = records.entrySet().iterator();
		for (int i = 1; i <= num && itr.hasNext(); ++i) {
			entry = (Entry)itr.next();
			
			id = (Integer)entry.getKey();
			record = (Record)entry.getValue();
		}
			
		return new Pair(id, record);
	}
	
	public Map<Integer, Record> getRecords() {
		return records;
	}
	
	public void setRecords(Map<Integer, Record> records) {
		this.records = records;
	}
	
	public abstract void pushRecord(Integer id, Record record);
	public abstract void popRecord(Integer id);
	public abstract void changeRecord(Integer oldId, Integer newId, Record record);
}
