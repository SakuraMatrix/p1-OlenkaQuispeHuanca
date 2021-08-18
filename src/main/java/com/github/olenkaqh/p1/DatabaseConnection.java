package com.github.olenkaqh.p1;

import com.datastax.oss.driver.api.core.CqlSession;

public class DatabaseConnection {

    /* main connection point of the driver
    holds the known state of the cassandra cluster */
    private CqlSession session;

    public void connect() {
        /* setting up the driver
        defaults to 127.0.0.1:9042 for contact point*/
        session = CqlSession.builder().build();
    }

    public CqlSession getSession() {
        return this.session;
    }

    public void close() {
        session.close();
    }
}
