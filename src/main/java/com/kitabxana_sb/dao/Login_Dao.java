package com.kitabxana_sb.dao;

import com.kitabxana_sb.tables.User_info;
import java.util.List;

public abstract interface Login_Dao {

    public abstract List<User_info> getUserList();
}
