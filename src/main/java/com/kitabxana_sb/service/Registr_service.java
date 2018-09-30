package com.kitabxana_sb.service;

import com.kitabxana_sb.tables.User_info;
import java.util.List;

public abstract interface Registr_service {

    public abstract void insertUser(User_info paramUser_info);

    public abstract List<User_info> getUserList();
}
