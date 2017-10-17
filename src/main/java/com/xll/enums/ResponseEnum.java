package com.xll.enums;

/**
 * Created by lonely.xia on 2017/10/17.
 */
public enum ResponseEnum {

    INSERT_SUCCESS("插入成功" , 200) ,
    INSERT_FAIL("插入失败" , -101) ,
    INSERT_ROLE_NAME_DUPLICATION("插入重复角色名" , -102) ,
    UPDATE_SUCCESS("更新成功" , 200) ,
    UPDATE_FAIL("更新失败" , -201);

    private String name;
    private int code;


    private ResponseEnum(String name , int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

}
