package org.maxur.akkacluster.baseData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class SQLdataBase implements IBaseData {
	private final Integer MaxSize;
	private Map<Integer, Record> data;
	private Integer sizeBlockUpdate;

	public static SQLdataBase create() {
		return new SQLdataBase();
	}
	
	public SQLdataBase() {
		data = new TreeMap<Integer, Record>();
		MaxSize = 100000;
		sizeBlockUpdate = 0;
		readBase();
	}
	
	@Override
	public Map<Integer, Record> getData() {
		return data;
	}
	
	@Override
	public void readBase() {
		String filePath = "E:\\Загрузки\\akka1\\src\\main\\java"
				+ "\\org\\maxur\\akkacluster\\baseData\\baseData.txt";
		File file = new File(filePath);
		
		try(Scanner scanner = new Scanner(file)) {
			Integer curSize = scanner.nextInt();
			
			for (int i = 0; i < curSize; ++i) {
				Integer key; 
				Record value = new Record();
				
				key = scanner.nextInt();
				value.setName(scanner.next());
				value.setTopic(scanner.next());
				value.setAudienceNumber(scanner.nextInt());
				
				data.put(key, value);
			}
			
		}
		catch(IOException ex){
		    System.out.println(ex.getMessage());
		}
		
	}
	
	@Override
	public void update() {
		
		String filePath = "E:\\Загрузки\\akka1\\src\\main\\java\\"
				+ "org\\maxur\\akkacluster\\baseData\\baseData.txt";
		
		try(FileWriter writer = new FileWriter(filePath, false)) {
			
			Iterator itr = data.entrySet().iterator();
			
			writer.write(data.size() + "\n");
			
			while (itr.hasNext()) {
				Entry entry = (Entry)itr.next();
				
				String key = ((Integer)entry.getKey()).toString();
				Record value = ((Record)entry.getValue());
				
				String textRecord = " " + value.getName() + 
									" " + value.getTopic() + 
							" " + value.getAudienceNumber() + "\n";
				
				writer.write(key);
	            writer.write(textRecord);
	            
	            writer.flush();
			}
			
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        } 
	}
	
	@Override
	public void pushRecord(Integer id, Record record) {
		
		if (data.size() < MaxSize) {
			data.put(id, record);
			
			//update();
			
			sizeBlockUpdate++;
			if (sizeBlockUpdate >= MaxSize / 3) {
				update();
				sizeBlockUpdate = 0;
			}
			
		} else {
			System.out.println("База данных переполнена!!!");
		}
		
		try { Thread.sleep(2); } 
		catch (InterruptedException e) { e.printStackTrace(); }	
		
	}

	@Override
	public void popRecord(Integer id) {
		try {
			data.remove(id);
			//update();
			
			sizeBlockUpdate++;
			if (sizeBlockUpdate >= MaxSize / 3) {
				update();
				sizeBlockUpdate = 0;
			}
		} catch(NullPointerException  e) {
			System.out.println(e.getMessage());
		}
		
		try { Thread.sleep(50); } 
		catch (InterruptedException e) { e.printStackTrace(); }	
	}

	@Override
	public void changeRecord(Integer id, Record record) {
		/*
		try {
			data.remove(id);
			data.put(id, record);
			update();
		} catch(NullPointerException  e) {
			System.out.println(e.getMessage());
		}
		*/
	}
}
