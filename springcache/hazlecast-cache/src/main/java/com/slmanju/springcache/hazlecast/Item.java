package com.slmanju.springcache.hazlecast;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Item implements Serializable {

    private static final long serialVersionUID = -7513654302182051690L;
    
    private int id;
    private String code;
    
    public Item() {
        
    }
    
    public Item(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}
