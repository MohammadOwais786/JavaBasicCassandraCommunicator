package com.shaik.cassandra.BasicCassandraApp;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

public class EnIDAOImpl implements EnIDAO {

    private Cluster cluster;
    private Session session;

    public EnIDAOImpl() {

        this.cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect("shaik");

    }

    public void add(String a) {
        getSession().execute("INSERT INTO users(id,name,address) VALUES" + "(" + a + ")");
        System.out.println("Successfully Added !");

    }

    public void update(int id, String v) {

        Statement Query = QueryBuilder.update("users").with(QueryBuilder.set("address", v))
                .where(QueryBuilder.eq("id", id));
        session.execute(Query);
        System.out.println("Successfully Updated !");

    }

    public void delete(int id) {

        Statement Query = QueryBuilder.delete().from("users").where(QueryBuilder.eq("id", id));
        session.execute(Query);
        System.out.println("Successfully Deleted !");
    }

    public void view() {
        ResultSet result = getSession().execute("Select * from users");
        for (Row row : result) {
            System.out.format("%d - %s - %s\n", row.getInt("id"), row.getString("name"), row.getString("address"));
        }
    }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        cluster.close();
    }

}
