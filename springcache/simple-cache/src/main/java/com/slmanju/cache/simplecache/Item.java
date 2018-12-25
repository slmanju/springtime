package com.slmanju.cache.simplecache;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Item {

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
