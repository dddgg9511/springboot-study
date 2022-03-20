package com.example.mongodb;

import com.example.mongodb.account.Account;
import com.example.mongodb.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongoDbApplication {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApplication.class, args);
    }

    @Bean
    public ApplicationRunner repositoryRunner(){
        return args -> {
            Account account = new Account();
            account.setEmail("aaa@bbb");
            account.setUsername("aaa");

            accountRepository.insert(account);
        };
    }

    //@Bean
    public ApplicationRunner applicationRunner(){
        return args-> {
            Account account = new Account();
            account.setEmail("aaa@bbb");
            account.setUsername("aaa");

            mongoTemplate.insert(account);

            System.out.println("finished");
        };
    }

}
