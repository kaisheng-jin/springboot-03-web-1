package com.jin.controller;

import com.jin.dao.DepartmentDao;
import com.jin.dao.EmployeeDao;
import com.jin.pogo.Department;
import com.jin.pogo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;


    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model){
//        查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //添加到数据库
        employeeDao.save(employee);
        System.out.println(employee);
        //不是直接转发到列表，因为重新查了一遍数据
        //因为是到一个servlet，所以重定向
        return "redirect:/emps";
    }


    public String toUpdateEmp(){
        //查出原来数据
        return "emp/update";
    }
}
