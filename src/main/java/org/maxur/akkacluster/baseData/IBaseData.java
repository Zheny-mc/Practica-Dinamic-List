package org.maxur.akkacluster.baseData;

import java.util.Map;

public interface IBaseData {
	public void pushRecord(Integer id, Record record);
	public void popRecord(Integer id);
	public void changeRecord(Integer id, Record record);
	public void readBase();
	public void update();
	public Map<Integer, Record> getData();
}
