package com.udacity.course1.demo.mapper;

import com.udacity.course1.demo.model.Delivery;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;

@Mapper
public interface DeliveryMapper {
    @Select("SELECT * FROM Delivery WHERE id=#{id}")
    Delivery findDelivery(Integer id);

    @Insert("INSERT INTO Delivery (orderId, time) VALUES(#{orderId}, #{time})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addDelivery(Delivery delivery);

    @Delete("DELETE FROM Delivery WHERE id = #{id}")
    boolean deleteDelivery(Integer id);
}
