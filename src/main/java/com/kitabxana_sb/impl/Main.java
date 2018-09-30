package com.kitabxana_sb.impl;

import com.kitabxana_sb.dao.Main_Dao;
import com.kitabxana_sb.tables.Book;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class Main implements Main_Dao {

    @Autowired
    DataSource dataSource;
    private Main main;
    private String author;
    private String title;

    @Override
    public List<Book> getbookList(HttpServletRequest request) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
        String cond1 = "";
        String cond2 = "";
        String cond3 = "";
        this.author = request.getParameter("author");
        this.title = request.getParameter("title");
        if ((this.author != null) && (!this.author.equals(""))) {
            cond2 = " WHERE ";
            cond1 = cond2 + " author like '%" + this.author.trim() + "%' ";
        }

        if ((this.title != null) && (!this.title.equals(""))) {
            if ((cond1 == null) || (cond1.equals(""))) {
                cond3 = " WHERE ";
            } else {
                cond3 = " AND ";
            }
            cond1 = cond1 + cond3 + " title like '%" + this.title.trim() + "%' ";
        }
        String SQL = "SELECT * FROM kitabxana.book" + cond1;
        System.out.println("SQL = " + SQL);
        return jdbcTemplate.query(SQL, new BookRowMapper());
    }

    @Override
    public List<Book> getbookByAuthor() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
        String SQL = "SELECT author FROM kitabxana.book";
        return jdbcTemplate.query(SQL, new AuthorRowMapper());
    }

    @Override
    public List<Book> getbookByTitle() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
        String SQL = "SELECT title FROM kitabxana.book";
        return jdbcTemplate.query(SQL, new TitleRowMapper());
    }

    private static final class BookRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {
            Book book = new Book();
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));
            return book;
        }
    }

    private static final class AuthorRowMapper
            implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {
            Book book = new Book();
            book.setAuthor(rs.getString("author"));
            return book;
        }
    }

    private static final class TitleRowMapper
            implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {
            Book book = new Book();
            book.setTitle(rs.getString("title"));
            return book;
        }
    }

    public Main getMain() {
        return this.main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
