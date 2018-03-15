package com.example.chapter327;

import com.example.chapter327.Service.Dom4jBuildXmlDemo;
import com.example.chapter327.mapper.FeedMapper;
import com.example.chapter327.mapper.UserMapper;
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

	@Autowired
	private FeedMapper feedMapper;

	@Autowired
	private Dom4jBuildXmlDemo dom4jBuildXmlDemo;

	@Test
	@Rollback
	public void contextLoads() throws Exception{

//		userMapper.insert("AAA", 20);
//		User user = userMapper.findByName("AAA");
//		Assert.assertEquals("20", user.getAge());
//		System.out.println(user.getAge());

		//List<FeedEntity> feedList = feedMapper.findByReview((short)0);
		//Long id = feedList.get(0).getId();
		//int i = feedList.size();
		//System.out.println(i);
		//System.out.println(id);

		dom4jBuildXmlDemo.buildXml();

	}

}
