package com.kitabxana_sb.rsclient;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

public class Result {
    
    private int id;
    private String depart_name;
    private String hosp_name;
    private List<Result>list;

    public Result() {
    }

    public Result(int id, String depart_name, String hosp_name) {
        this.id = id;
        this.depart_name = depart_name;
        this.hosp_name = hosp_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepart_name() {
        return depart_name;
    }

    public void setDepart_name(String depart_name) {
        this.depart_name = depart_name;
    }

    public String getHosp_name() {
        return hosp_name;
    }

    public void setHosp_name(String hosp_name) {
        this.hosp_name = hosp_name;
    }

    public List<Result> getList() {
        return list;
    }

    public void setList(List<Result> list) {
        this.list = list;
    }

    
}
