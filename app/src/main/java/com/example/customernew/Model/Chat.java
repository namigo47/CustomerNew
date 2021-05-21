package com.example.customernew.Model;

import java.util.ArrayList;

public class Chat {
    private String tokenCustomer, tokenUser,nameCus,urlCus,key;
    private ArrayList<Message> listMes;

    public Chat(String tokenCustomer, String tokenUser, ArrayList<Message> listMes,String nameCus, String urlCus,String key) {
        this.tokenCustomer = tokenCustomer;
        this.tokenUser = tokenUser;
        this.listMes = listMes;
        this.nameCus = nameCus;
        this.urlCus = urlCus;
        this.key = key;

    }

    public Chat() {
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getUrlCus() {
        return urlCus;
    }

    public void setUrlCus(String urlCus) {
        this.urlCus = urlCus;
    }

    public ArrayList<Message> getListMes() {
        return listMes;
    }

    public void setListMes(ArrayList<Message> listMes) {
        this.listMes = listMes;
    }

    public String getTokenCustomer() {
        return tokenCustomer;
    }

    public void setTokenCustomer(String tokenCustomer) {
        this.tokenCustomer = tokenCustomer;
    }

    public String getTokenUser() {
        return tokenUser;
    }

    public void setTokenUser(String tokenUser) {
        this.tokenUser = tokenUser;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
