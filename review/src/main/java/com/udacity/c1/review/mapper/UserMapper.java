package com.udacity.c1.review.mapper;

import com.udacity.c1.review.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;


@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User getUser(String username);

    @Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) VALUES (#{username}, #{salt}, #{password}, #{firstname}, #{lastname})")
    @Options(useGeneratedKeys = true, keyProperty = "userid")
    int createUser(User user);

    @Delete("DELETE FROM USERS WHERE userid = #{userid}")
    boolean removeUser(Integer userid);
}
