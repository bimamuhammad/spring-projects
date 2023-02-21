package com.udacity.c1.review.mapper;

import com.udacity.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> getMessages();

    @Insert("INSERT INTO MESSAGES (username, messageText) VALUES (#{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int registerMessage(ChatMessage chatMessage);

    @Delete("DELETE FROM MESSAGES WHERE messageid = #{messageid}")
    boolean removeUser(Integer messageid);
}