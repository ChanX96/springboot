package com.chanx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class P05DataApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() throws SQLException {
//		查看默认的数据源
		System.out.println(dataSource.getClass());

		Connection connection = dataSource.getConnection();
		System.out.println(connection);

		// 可以使用springboot已经配置好的模板，开箱即用 CRUD

		connection.close();
	}

}
