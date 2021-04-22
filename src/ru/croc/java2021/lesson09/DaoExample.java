package ru.croc.java2021.lesson09;

import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoExample {
    public static void main(String[] args) throws SQLException {
        JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:mem:testdb", "", "");

        try (Connection conn = cp.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {

            stmt.execute("create table users(id int primary key, name varchar(255))");

            final UserDao userDao = new UserDao(cp);

            final User john = new User(1, "John");
            final User helen = new User(2, "Helen");


            userDao.create(john);
            userDao.create(helen);

            try (ResultSet rs = stmt.executeQuery("select id, name from users")) {
                while (rs.next()) {

                    System.out.print("id = " + rs.getInt("id"));
                    System.out.println(", name = " + rs.getString("name"));
                }
            }
        }







    }
}
