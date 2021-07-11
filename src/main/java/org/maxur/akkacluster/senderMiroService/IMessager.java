package org.maxur.akkacluster.senderMiroService;

import java.util.List;

import org.maxur.akkacluster.Users.IUser;

import akka.actor.UntypedAbstractActor;

public abstract class IMessager extends UntypedAbstractActor {
	protected String name;
	protected String message;
	protected String consignor;
	protected List<IUser> users;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getConsignor() {
		return consignor;
	}
	public void setConsignor(String sender) {
		this.consignor = sender;
	}
	
	public List<IUser> getUsers() {
		return users;
	}
	public void setUsers(List<IUser> users) {
		this.users = users;
	}

	public abstract void sendAll();
}
