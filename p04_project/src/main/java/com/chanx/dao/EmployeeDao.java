package com.chanx.dao;

import com.chanx.pojo.Department;
import com.chanx.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 员工Dao
 */
@Repository
public class EmployeeDao {

    // 模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    // 员工所属部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>(); // 创建部门表
        employees.put(1001, new Employee(1001, "AA", "24751255@qq.com", 0, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "BB", "24751256@qq.com", 1, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "CC", "24754255@qq.com", 1, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "DD", "24757255@qq.com", 0, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "EE", "24751265@qq.com", 0, new Department(101, "后勤部")));
    }

    // 逐渐自增
    private static Integer initId = 1006;

    // 增加一员工
    public void save(Employee employee) {
        if(employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    // 查询全部员工信息
    public Collection<Employee> getAll() {
        return employees.values();
    }

    // 通过id查询
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    // 通过id删除员工
    public void delete(Integer id) {
        employees.remove(id);
    }
}
