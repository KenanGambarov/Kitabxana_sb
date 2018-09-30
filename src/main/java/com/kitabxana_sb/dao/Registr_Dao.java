package com.kitabxana_sb.dao;

import com.kitabxana_sb.tables.User_info;
import java.util.List;

public abstract interface Registr_Dao {

    public abstract void insertUser(User_info paramUser_info);

    public abstract List<User_info> getUserList();
}
