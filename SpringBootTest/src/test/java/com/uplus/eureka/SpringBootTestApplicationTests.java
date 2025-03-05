package com.uplus.eureka;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;


@SpringBootTest(
		properties = {"spring.config.location=classpath:application.properties"}
)

@ComponentScan(basePackages = {"com.uplus.eureka"})
class SpringBootTestApplicationTests {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void dsTest() {
		//null인지 체크하는 단정 함수
		assertNotNull(ds);
	}
	
	@Test
	void contextLoads() {
		
	}

}
