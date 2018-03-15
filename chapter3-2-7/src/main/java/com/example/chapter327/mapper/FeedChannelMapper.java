package com.example.chapter327.mapper;

import com.example.chapter327.model.FeedChannelEntity;
import com.example.chapter327.model.FeedEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author  : Nabryant
 * E-mail  :
 * Time    : 2018/3/13
 * Function:
 */

@Mapper
public interface FeedChannelMapper {

    @Select("select * from feed_channel where status > #{status} order by id desc")
    List<FeedChannelEntity> findByStatus (@Param("status") Short status);

}
