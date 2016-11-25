package com.shaik.cassandra.BasicCassandraApp;

public class EnIDAOImpl implements EnIDAO {

    private CassandraConnect cassandra;

    public EnIDAOImpl() {

        cassandra = new CassandraConnect();
        cassandra.connect();

    }

    public void add(String a) {

        cassandra.adder(a);
    }

    public void update(int id, String v) {

        cassandra.updater(id, v);

    }

    public void delete(int id) {
        cassandra.deleter(id);
    }

    public void view() {
        cassandra.ViewTable();
    }

    public void close() {
        cassandra.close();
    }

}
