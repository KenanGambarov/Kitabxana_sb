package com.kitabxana_sb.dao;

import com.kitabxana_sb.tables.Book;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public abstract interface Main_Dao {

    public abstract List<Book> getbookList(HttpServletRequest paramHttpServletRequest);

    public abstract List<Book> getbookByAuthor();

    public abstract List<Book> getbookByTitle();
}
