package com.github.olenkaqh.p1;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.net.URISyntaxException;

public class App {

    public static void main(String[] args) throws URISyntaxException {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Application starting...");
        System.out.println("Hello World!");

        ServerConnection server = new ServerConnection();
        server.Connect();

    }

}
