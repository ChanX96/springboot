package com.chanx.controller;

import com.chanx.dao.DepartmentDao;
import com.chanx.dao.EmployeeDao;
import com.chanx.pojo.Department;
import com.chanx.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "/emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getAll();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        // 保存员工信息
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 去员工的修改页面
     * @param id
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        // 查出修改前数据
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employee);

        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getAll();
        model.addAttribute("departments", departments);

        return "emp/update";
    }

    /**
     * 更新员工信息
     * @param employee
     * @return
     */
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        // 保存员工信息
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
