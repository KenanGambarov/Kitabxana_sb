package com.kitabxana_sb.rs;

import com.kitabxana_sb.tables.Book;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "booklist")
@XmlAccessorType(XmlAccessType.NONE)
public class ResponseList2 {

    @XmlElement(name = "book")
    private List<Book> list;

    public List<Book> getList() {
        return this.list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}
