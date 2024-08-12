package com.niantic.services;

import com.niantic.models.Users;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


import javax.sql.DataSource;
import java.util.ArrayList;

public class UsersDao
{
    private final JdbcTemplate jdbcTemplate;
    private static UsersDao dao = new UsersDao();

    public UsersDao()
    {
        String databaseUrl = "jdbc:mysql://localhost:3306/budget";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource(){{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<Users> getAllUsers() {
        var users = new ArrayList<Users>();

        String sql = """
                SELECT user_id
                    , user_name
                    , first_name
                    , last_name
                    , phone
                    , email
                FROM users;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            int userId = row.getInt("user_id");
            String userName = row.getString("user_name");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");
            String phone = row.getString("phone");
            String email = row.getNString("email");

            var user = new Users(userId, userName, firstName, lastName, phone, email);
            users.add(user);
        }
        return users;
    }

    public void addUser(Users user)
    {
        String sql = """
            INSERT INTO users (user_name
                            , first_name
                            , last_name
                            , phone
                            , email)
            VALUES(?,?,?,?,?,?);
            """;

        jdbcTemplate.update(sql,
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getEmail());

    }


    public Users getUserById(int searchUserId)
    {

        String sql = """
            SELECT user_id
                , user_name
                , first_name
                , last_name
                , phone
                , email
            FROM users
            WHERE user_id = ?;
            """;
        var row = jdbcTemplate.queryForRowSet(sql, searchUserId);
        while(row.next()) {
            int userId = row.getInt("user_id");
            String userName = row.getString("user_name");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");
            String phone = row.getString("phone");
            String email = row.getNString("email");

            return new Users(userId, userName, firstName, lastName, phone, email);
        }

        return null;

    }

    public void deleteUser(int userId)
    {
        String sql = """
                DELETE FROM users
                WHERE user_id = ?;
                """;

        jdbcTemplate.update(sql, userId);
    }








}
