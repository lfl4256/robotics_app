package com.example.lewis.jqr;

/**
 * Created by lewis on 2018/6/18.
 */

public class MesBean {
    private String mes;
    private int type;

    public MesBean(String mes, int type) {
        this.mes = mes;
        this.type = type;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
