package com.example.myapplication;

/**
 * Created by 805138185 on 2019/6/8.
 */

public class Test {
    private String id ;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test(String id,String name){
        this.id = id;
        this.name = name;
    }
}
