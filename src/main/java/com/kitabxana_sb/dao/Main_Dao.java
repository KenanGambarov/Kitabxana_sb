package com.kitabxana_sb.dao;

import com.kitabxana_sb.tables.Book;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface Main_Dao {

    List<Book> getbookList(HttpServletRequest paramHttpServletRequest);

    List<Book> getbookByAuthor();

    List<Book> getbookByTitle();
}
