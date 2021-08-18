package com.github.olenkaqh.p1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.olenkaqh.p1.App;
import com.github.olenkaqh.p1.service.UserService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufOutputStream;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ServerConnection {
    //creates the server connection
    public void Connect() throws URISyntaxException {
//          Path fileHTML = Paths.get(Objects.requireNonNull(App.class.getResource("/test.html")).toURI());
//
//          UserService userService = new UserService();
//          DisposableServer server = HttpServer.create()
//                  .port(8080)
//                  .route(routes ->
//                          routes.get("/test",(request, response) ->
//                                  response.sendFile(fileHTML)))
//                                  .get("/users/{param}", (request, response) ->
//                                          response.send(userService.getAll()))
//                  .bindNow();
//
//          server.onDispose()
//                .block();
    }

}
