package com.jin.dao;

import com.jin.pogo.Department;
import com.jin.pogo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    //模拟数据库数据

    private static Map<Integer, Employee> employees = null;
    //员工有所属部门
    @Autowired
    private DepartmentDao department;
    static {
        employees = new HashMap<Integer, Employee>();//创建了一个部门表
        employees.put(1001,new Employee(1001,"李四","45968745@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"张三","3465345@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"王五","kjhadsf232@outlock.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"小明","8927363234@gumile.com",1,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"小红","5346567342@126.com",0,new Department(105,"后勤部")));
        employees.put(1006,new Employee(1006,"灰太狼","457456345@126.com",1,new Department(106,"销售部")));

    }

    //主键自增
    private static Integer initId = 1007;

    //增加一个员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(department.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);
    }

    //查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getElementById(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void delete(Integer id){
        employees.remove(id);
    }

}
