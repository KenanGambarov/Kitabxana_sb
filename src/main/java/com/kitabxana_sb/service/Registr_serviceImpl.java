package com.kitabxana_sb.service;

import com.kitabxana_sb.dao.Registr_Dao;
import com.kitabxana_sb.tables.User_info;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Registr_serviceImpl implements Registr_service {

    @Autowired
    private Registr_Dao registr_Dao;

    @Override
    public void insertUser(User_info u) {
        this.registr_Dao.insertUser(u);
    }

    @Override
    public List<User_info> getUserList() {
        return this.registr_Dao.getUserList();
    }
}
