package com.kitabxana_sb.rs;

import com.kitabxana_sb.dao.Main_Dao;
import com.kitabxana_sb.dao.Registr_Dao;
import com.kitabxana_sb.tables.Book;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/rs"})
public class KitabxanaRsCont {

    @Autowired
    Registr_Dao rd;
    @Autowired
    Main_Dao md;

    @RequestMapping(value = {"/list"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET}, produces = {"application/xml"})
    public ResponseList2 getList(Book book, HttpServletRequest request) {
        List<Book> list1 = this.md.getbookList(request);

        ResponseList2 rl = new ResponseList2();
        rl.setList(list1);
        return rl;
    }
}
