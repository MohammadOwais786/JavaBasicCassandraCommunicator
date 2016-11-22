package com.shaik.cassandra.BasicCassandraApp;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraConnect {

	private Cluster cluster;
	 public Session session;

	public void connect() {
		this.cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect("shaik");
	}

	public Session getSession() {
		return this.session;
	}

	/** Close cluster. */
	public void close() {
		cluster.close();
	}

}
