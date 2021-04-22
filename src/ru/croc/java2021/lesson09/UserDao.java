package ru.croc.java2021.lesson09;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    private DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void create(User user) {
        try (
            final Connection connection = dataSource.getConnection();
            final PreparedStatement ps = connection.prepareStatement("insert into users (id, name) values (?, ?)");
        ) {
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());

            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}