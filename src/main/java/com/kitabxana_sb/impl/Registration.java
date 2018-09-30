package com.kitabxana_sb.impl;

import com.kitabxana_sb.dao.Registr_Dao;
import com.kitabxana_sb.tables.User_info;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class Registration
        implements Registr_Dao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String email;
    private String password;

    @Override
    public void insertUser(User_info u) {
        String SQL = "INSERT INTO kitabxana.user_info (full_name,email,password) VALUES (?,?,?)";
        if ((u.getFull_name() != null) && (u.getEmail() != null) && (u.getPassword() != null) && (!u.getFull_name().equals("")) && (!u.getEmail().equals("")) && (!u.getPassword().equals(""))) {
            this.jdbcTemplate.update(SQL, new Object[]{u.getFull_name(), u.getEmail(), u.getPassword()});
        }
    }

    @Override
    public List<User_info> getUserList() {
        String SQL = "SELECT email,password FROM kitabxana.user_info";
        return this.jdbcTemplate.query(SQL, new UserRowMapper());
    }

    private static final class UserRowMapper implements RowMapper<User_info> {

        @Override
        public User_info mapRow(ResultSet rs, int i) throws SQLException {
            User_info user = new User_info();
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
