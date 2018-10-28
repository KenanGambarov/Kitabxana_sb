package com.kitabxana_sb.dao;

import com.kitabxana_sb.tables.User_info;
import java.util.List;

public interface Registr_Dao {

    void insertUser(User_info paramUser_info);

    List<User_info> getUserList();
}
