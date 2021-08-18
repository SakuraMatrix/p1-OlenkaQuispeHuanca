package com.github.olenkaqh.p1.repository;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.github.olenkaqh.p1.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//deals with CRUD functionality
public class UserRepository {

    private CqlSession session;

    //constructor
    public UserRepository(CqlSession session){

        this.session = session;
    }

    //get all users
    public Flux<User> getAll(){
        return Flux.from(session.executeReactive("SELECT * FROM p2plender.user"))
                .map(row -> new User(row.getInt("account_id"), row.getString("account_type"), row.getString("name"), row.getString("date_of_birth"),row.getString("email"), row.getString("phone_num"), row.getString("occupation"), row.getInt("credit_score"), row.getDouble("balance")));
    }

    //get a single user
    public Mono<User> get(int id){
        return Mono.from(session.executeReactive("SELECT * FROM p2plender.user WHERE account_id = " + id))
                .map(row -> new User(row.getInt("account_id"), row.getString("account_type"), row.getString("name"), row.getString("date_of_birth"),row.getString("email"), row.getString("phone_num"), row.getString("occupation"), row.getInt("credit_score"), row.getDouble("balance")));
    }

    //create a new user

    public User create(User user){
        SimpleStatement statement = SimpleStatement.builder("INSERT INTO p2plender.user (account_id, account_type, name, date_of_birth, email, phone_num, occupation, credit_score, balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)")
                .addPositionalValues(user.getAccountID(),user.getAccountType(), user.getName(), user.getDateOfBirth(), user.getEmail(), user.getPhoneNumber(), user.getOccupation(), user.getCreditScore(), user.getBalance())
                .build();
        Flux.from(session.executeReactive(statement)).subscribe();
//        System.out.println(user.getAccountID() + " " +
//                user.getAccountID() + user.getAccountType() +  user.getName() + user.getDateOfBirth()+user.getEmail()+ user.getPhoneNumber()+
//                user.getOccupation()+ user.getCreditScore()+ user.getBalance());
        return user;
    }

}
