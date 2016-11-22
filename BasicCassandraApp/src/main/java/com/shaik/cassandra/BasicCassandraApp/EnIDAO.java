package com.shaik.cassandra.BasicCassandraApp;

public interface EnIDAO {
	
	void add(String a);
	void update(int id,String v);
	void delete(int id);
	void view();

}
