package com.study.mapper;

import com.study.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author: Rrow
 * @date: 2024/3/17 21:21
 * Description:
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User findById(Integer id);

}
