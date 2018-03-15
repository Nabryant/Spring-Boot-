package com.example.chapter327.mapper;

import com.example.chapter327.model.FeedEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author  : Nabryant
 * E-mail  :
 * Time    : 2018/3/12
 * Function:
 */

@Mapper
public interface FeedMapper {

    @Select("select * from feed where review > #{review} order by id desc")
    List<FeedEntity> findByReview (@Param("review") Short review);


}
