package com.example.chapter327;

import com.example.chapter327.mapper.UserMapper;
import com.example.chapter327.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class Chapter327ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback
	public void contextLoads() throws Exception{

		userMapper.insert("AAA", 20);
		User user = userMapper.findByName("AAA");
		Assert.assertEquals("20", user.getAge());
		System.out.println(user.getAge());

	}

}
