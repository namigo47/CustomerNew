package com.example.customernew.event;

import com.example.customernew.Model.Canteen;
import com.example.customernew.Model.Product;


public interface callBack {
    void addChatFirbase(Canteen canteen);
    void productCallBack(Product product);
}
