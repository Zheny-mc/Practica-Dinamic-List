package org.maxur.akkacluster.Users;

import java.util.HashMap;

import org.maxur.akkacluster.baseData.Record;

public class RegisteredUser extends IUser {
	
	public RegisteredUser(String name, String surname) {
		this.name = name;
		this.surname = surname;
		records = new HashMap<Integer, Record>();
	}
	
	@Override
	public void pushRecord(Integer id, Record record) {
		records.put(id, record);
	}
	
	@Override
	public void popRecord(Integer id) {
		try {
			records.remove(id);
		} catch(NullPointerException  e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public void changeRecord(Integer oldId, Integer newId, Record record) {
		/*
		try {
			records.remove(id);
			records.put(id, record);
		} catch(NullPointerException  e) {
			System.out.println(e.getMessage());
		}
		*/
	}
}
