package com.chanx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询对象，由于没有pojo对象封装，故采用Map封装结果
     * @return
     */
    @GetMapping("/userList")
    public List<Map<String, Object>> accountList() {
        String sql = "SELECT * FROM account";
        List<Map<String, Object>> accounts = jdbcTemplate.queryForList(sql);
        return accounts;
    }
}
