package com.example.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class PgSQLRunnser implements ApplicationRunner {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try(Connection connection = dataSource.getConnection()){
            System.out.println(dataSource.getClass());
            System.out.println(dataSource.getConnection().getMetaData().getDriverName());
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE account(ID INTEGER NOT NULL, name VARCHAR(256), PRIMARY KEY (id))";
            statement.executeUpdate(sql);
        }

        jdbcTemplate.execute("INSERT INTO account VALUES (1,'choo')");;
    }
}
