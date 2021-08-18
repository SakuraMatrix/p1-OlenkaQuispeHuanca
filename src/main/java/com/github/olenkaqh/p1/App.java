package com.github.olenkaqh.p1;

import com.datastax.oss.driver.api.core.CqlSession;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.olenkaqh.p1.domain.Loan;
import com.github.olenkaqh.p1.domain.User;
import com.github.olenkaqh.p1.repository.LoanRepository;
import com.github.olenkaqh.p1.repository.UserRepository;
import com.github.olenkaqh.p1.service.LoanService;
import com.github.olenkaqh.p1.service.UserService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

public class App {

    public static void main(String[] args) throws URISyntaxException {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Application starting...");
        System.out.println("Hello World!");
        DatabaseConnection cassandraDB = new DatabaseConnection();
        cassandraDB.connect();
        CqlSession session = cassandraDB.getSession();
//        cassandraDB.close();
//        ServerConnection server = new ServerConnection();
//        server.Connect();
        Path fileHTML = Paths.get(Objects.requireNonNull(App.class.getResource("/test.html")).toURI());
        Path indexHTML = Paths.get(Objects.requireNonNull(App.class.getResource("/index.html")).toURI());
        Path loanApplicationHTML = Paths.get(Objects.requireNonNull(App.class.getResource("/loanForm.html")).toURI());

        UserRepository  userRepository = new UserRepository(session);
        UserService userService = new UserService(userRepository);
        LoanRepository loanRepository = new LoanRepository(session);
        LoanService loanService = new LoanService(loanRepository);

        DisposableServer server = HttpServer.create()
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
//                                .get(("/users/{param}/loans" ), (request, response) ->
//                                        response.send(loanService.getBorrowerLoans(request.param("param")).map(App::toByteBuf)
//                                                .log("http server")))
                                        .get("/loans", (request, response) ->
                                                response.send(loanService.getAll().map(App::toByteBuf)
                                                        .log("http server")))
                                        .post("/loans", (request, response)->
                                                response.send(request.receive().asString()
                                                        .map(App::parseLoan)
                                                        .map(loanService::addLoan)
                                                        .map(App::toByteBuf)))
                                        .get(("/loans/{param}" ), (request, response) ->
                                                response.send(loanService.get(request.param("param")).map(App::toByteBuf)
                                                        .log("http server")))
                                        .get("/", (request, response) ->
                                                response.sendFile(indexHTML))
                                        .get("/application", (request, response) ->
                                                response.sendFile(loanApplicationHTML))



                )
                .bindNow();

        server.onDispose()
                .block();
    }
    static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static ByteBuf toByteBuf(Object o){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            OBJECT_MAPPER.writeValue(out, o);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return ByteBufAllocator.DEFAULT.buffer().writeBytes(out.toByteArray());
    }

    static User parseUser (String str) {
        User user = null;
        try {
            user = OBJECT_MAPPER.readValue(str, User.class);
        } catch (JsonProcessingException e) {
            String[] params = str.split("&");
            int accountID = Integer.parseInt((params[0].split("=")[1]));
            String accountType = params[1].split("=")[1];
            String name = params[2].split("=")[1];
            String dateOfBirth = params[3].split("=")[1];
            String email = params[4].split("=")[1];
            String phoneNumber = params[5].split("=")[1];
            String occupation = params[6].split("=")[1];
            int creditScore = Integer.parseInt(params[7].split("=")[1]);
            double balance = Double.parseDouble(params[8].split("=")[1]);
            //creates new user object
            user = new User(accountID, accountType, name, dateOfBirth, email, phoneNumber,occupation, creditScore, balance);
        }
        return user;
    }
    static Loan parseLoan (String str) {
        Loan loan = null;
        try {
            loan = OBJECT_MAPPER.readValue(str, Loan.class);
        } catch (JsonProcessingException e) {
            String[] params = str.split("&");
            int loanID= Integer.parseInt(params[0].split("=")[1]);
            int lenderID = Integer.parseInt(params[1].split("=")[1]);
            int borrowerID = Integer.parseInt(params[2].split("=")[1]);
            Double interestRate =Double.parseDouble( params[3].split("=")[1]);
            Double loanAmount = Double.parseDouble(params[4].split("=")[1]);
            String loanDuration= params[5].split("=")[1];

            //creates new loan object
            loan = new Loan(loanID,lenderID,borrowerID,interestRate,loanAmount,loanDuration);
        }
        return loan;
    }
}
