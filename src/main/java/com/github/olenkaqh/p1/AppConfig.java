package com.github.olenkaqh.p1;

import com.datastax.oss.driver.api.core.CqlSession;
import com.github.olenkaqh.p1.service.LoanService;
import com.github.olenkaqh.p1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Configuration
@ComponentScan
public class AppConfig {
    @Autowired
    UserService userService;
    @Autowired
    LoanService loanService;

    @Bean
    public CqlSession session() {
        return CqlSession.builder().build();
    }
    @Bean
    public DisposableServer server() throws URISyntaxException {
        Path fileHTML = Paths.get(Objects.requireNonNull(App.class.getResource("/test.html")).toURI());
        Path indexHTML = Paths.get(Objects.requireNonNull(App.class.getResource("/index.html")).toURI());
        Path loanApplicationHTML = Paths.get(Objects.requireNonNull(App.class.getResource("/loanForm.html")).toURI());

        return HttpServer.create()
                .port(8080)
                .route(routes ->
                                routes.get("/test",(request, response) ->
                                                response.sendFile(fileHTML))

                                        .get("/users", (request, response) ->
                                                response.send(userService.getAll().map(App::toByteBuf)
                                                        .log("http server")))
                                        .post("/users",(request,response) ->
                                                response.send(request.receive().asString()
                                                        .map(App::parseUser)
                                                        .map(userService::addUser)
                                                        .map(App::toByteBuf)
                                                        .log("http-server")))
                                        .get("/users/{param}" , (request, response) ->
                                                response.send(userService.get(request.param("param")).map(App::toByteBuf)
                                                        .log("http server")))
                                        .get("/users/{param}/loans" , (request, response) ->
                                                response.send(loanService.getUserLoans(request.param("param")).map(App::toByteBuf)
                                                        .log("http server")))
                                        .delete("/users/{param}", (request, response) ->
                                                response.send(userService.remove(request.param("param")).map(App::toByteBuf)
                                                                .log("http server")))
                                        .get("/loans", (request, response) ->
                                                response.send(loanService.getAll().map(App::toByteBuf)
                                                        .log("http server")))
                                        .post("/loans", (request, response)->
                                                response.send(request.receive().asString()
                                                        .map(App::parseLoan)
                                                        .map(loanService::addLoan)
                                                        .map(App::toByteBuf)))
                                        .get("/loans/{param}" , (request, response) ->
                                                response.send(loanService.get(request.param("param")).map(App::toByteBuf)
                                                        .log("http server")))
                                        .delete("/loans/{param}" , (request, response) ->
                                                response.send(loanService.remove(request.param("param")).map(App::toByteBuf)
                                                        .log("http server")))
                                        .get("/", (request, response) ->
                                                response.sendFile(indexHTML))
                                        .get("/application", (request, response) ->
                                                response.sendFile(loanApplicationHTML))

                )
                .bindNow();
    }

}
