package com.uplus.eureka;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.uplus.eureka.book.model.dao.BookDao;
import com.uplus.eureka.member.model.dao.MemberDao;
import com.uplus.eureka.member.model.dto.Member;


@SpringBootTest(
		properties = {"spring.config.location=classpath:application.properties"}
)

@ComponentScan(basePackages = {"com.uplus.eureka"})
class SpringBootTestApplicationMemberTests {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private MemberDao memDao;

	
	@Test
	public void memberDaoTest() {
		//null인지 체크하는 단정 함수
		assertNotNull(memDao);
	}
	

	
	@Test
	public void searchTest() throws Exception {
		Member member =  memDao.search("eureka");
		assertNotNull(member);
		log.debug("member : {}", member);
	}
	
	@Test
	public void registTest() throws Exception {
		Member member = new Member();
		member.setId("pes");
		member.setPassword("1111");
		member.setName("박은서");
		memDao.regist(member);
		
		assertNotNull(memDao.search("pes"));
	}
	
	@Test
	public void dsTest() {
		//null인지 체크하는 단정 함수
		assertNotNull(ds);
	}
	

}
