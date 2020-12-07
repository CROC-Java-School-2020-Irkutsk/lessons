package ru.croc.java2020.lesson08;

import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {
    public static void main(String[] args) throws SQLException {
        JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:mem:testdb", "", "");

        try (Connection conn = cp.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("create table users(id int primary key, name varchar(255))");
            stmt.execute("insert into users(id, name) values (1, 'John')");
            stmt.execute("insert into users(id, name) values (2, 'Helen')");


            try (final PreparedStatement ps = conn.prepareStatement("select id, name from users where id = ?")) {

                ps.setString(1, "; ");

                final ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    System.out.print("id = " + rs.getInt("id"));
                    System.out.println(", name = " + rs.getString("name"));
                }
            }


            /*try (ResultSet rs = stmt.executeQuery("select id, name from users")) {
                while (rs.next()) {
                    System.out.print("id = " + rs.getInt("id"));
                    System.out.println(", name = " + rs.getString("name"));
                }
            }*/
        }

    }
}
