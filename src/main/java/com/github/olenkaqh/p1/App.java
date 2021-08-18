package com.github.olenkaqh.p1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.olenkaqh.p1.domain.Loan;
import com.github.olenkaqh.p1.domain.User;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import reactor.netty.DisposableServer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class App {
    static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Application starting...");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        applicationContext.getBean(DisposableServer.class).onDispose().block();
    }

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
