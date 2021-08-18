package com.github.olenkaqh.p1;

import com.datastax.oss.driver.api.core.CqlSession;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.net.URISyntaxException;

public class App {

    public static void main(String[] args) throws URISyntaxException {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Application starting...");
        System.out.println("Hello World!");
        DatabaseConnection cassandraDB = new DatabaseConnection();
        cassandraDB.connect();
        CqlSession session = cassandraDB.getSession();
//        cassandraDB.close();
        ServerConnection server = new ServerConnection();
        server.Connect();

    }

}
