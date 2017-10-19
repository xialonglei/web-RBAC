package com.xll.enums;

/**
 * Created by lonely.xia on 2017/10/17.
 */
public enum ResponseEnum {

    INSERT_SUCCESS("插入成功" , 200) ,
    INSERT_FAIL("插入失败" , -101) ,
    INSERT_OR_UPDATE_ROLE_NAME_DUPLICATION("插入或更新重复角色名" , -102) ,
    UPDATE_SUCCESS("更新成功" , 200) ,
    UPDATE_FAIL("更新失败" , -201) ,
    SELECT_SUCCESS("查询成功" , 200) ,
    SELECT_FAIL("查询失败" , -301) ,
    DELETE_SUCCESS("删除成功" , 200) ,
    DELETE_FAIL("删除失败" , -401) ,
    INSERT_NAME_OR_EMAIL_DUPLICATION("插入重复用户名或邮箱" , -501) ,
    OK("成功" , 200);

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
