package com.example.chapter327.mapper;

import com.example.chapter327.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    @Insert("insert into user(name, age) values(#{name}, #{age})")
    int insert (@Param("name") String name, @Param("age") Integer age);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from user where name = #{name}")
    User findByName (@Param("name") String name);
}