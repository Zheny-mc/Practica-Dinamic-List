package org.maxur.akkacluster.Users;

import java.util.HashMap;

import org.maxur.akkacluster.baseData.Record;

public class UnRegisteredUser extends IUser {

	public UnRegisteredUser() {
		name = "Имя гостя";
		this.surname = "Фамилия гостя";
		records = new HashMap<Integer, Record>();
	}
	
	@Override
	public void pushRecord(Integer id, Record record) {
		System.out.println("ошибка доступа, зарегестрируйтесь!");
	}

	@Override
	public void popRecord(Integer id) {
		System.out.println("ошибка доступа, зарегестрируйтесь!");
	}

	@Override
	public void changeRecord(Integer oldId, Integer newId, Record record) {
		System.out.println("ошибка доступа, зарегестрируйтесь!");
	}

}
