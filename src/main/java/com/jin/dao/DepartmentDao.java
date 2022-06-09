package com.jin.dao;

import java.util.HashMap;
import java.util.Map;

//部门dao
public class Department {
    //模拟数据库数据

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();//创建了一个部门表
        departments.put(101,new Department(101,"教学部"));

    }

}
