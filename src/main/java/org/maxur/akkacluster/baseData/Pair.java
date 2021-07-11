package org.maxur.akkacluster.baseData;

public class Pair {
	private Integer first;
	private Record second;
	private Pair secondPair;
	
	public static Pair create(Integer first) {
		return new Pair(first, new Pair(0, new Record()));
	}
	
	public static Pair create(Integer first, Record second) {
		return new Pair(first, second);
	}
	
	public static Pair create(Integer first, Pair secondPair) {
		return new Pair(first, secondPair);
	}
		
	public Pair() {
		super();
	}
	
	public Pair(Integer first) {
		super();
		this.first = first;
	}
	
	public Pair(Integer first, Record second) {
		super();
		this.first = first;
		this.second = second;
	}

	public Pair(Pair obj) {
		super();
		first = obj.getFirst();
		second = obj.getSecond();
	}
	
	public Pair(Integer first, Pair secondPair) {
		super();
		this.first = first;
		this.secondPair = secondPair;
	}

	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}


	public Record getSecond() {
		return second;
	}
	public void setRecord(Record second) {
		this.second = second;
	}
	
	public Pair getSecondPair() {
		return secondPair;
	}

	public void setSecondPair(Pair secondPair) {
		this.secondPair = secondPair;
	}
}
