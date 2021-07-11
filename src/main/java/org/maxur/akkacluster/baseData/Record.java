package org.maxur.akkacluster.baseData;

public class Record {
	private String name; //имя
	private String topic; //тема
	private Integer audienceNumber; //номер аудитории
	
	public Record() {}

	public Record(String name, String topic, Integer audienceNumber) {
		super();
		this.name = name;
		this.topic = topic;
		this.audienceNumber = audienceNumber;
	}

	public Record(Record obj) {
		this.name = obj.getName();
		this.topic = obj.getTopic();
		this.audienceNumber = obj.getAudienceNumber();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Integer getAudienceNumber() {
		return audienceNumber;
	}

	public void setAudienceNumber(Integer audienceNumber) {
		this.audienceNumber = audienceNumber;
	}

	@Override
	public String toString() {
		return "Record [name=" + name + ", topic=" + topic + ", audienceNumber=" + audienceNumber + "]";
	}
	
	
	
}
