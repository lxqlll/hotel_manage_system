package com.example.hotelmanagesys.modules.client.room.mapper;

import com.example.hotelmanagesys.modules.client.room.entity.ClientRoomReservation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 预定客房表 fk 客房信息编号 客户个人信息编号 Mapper 接口
 * </p>
 *
 * @author lxq
 * @since 2020-04-15
 */
@Mapper
@Repository
public interface ClientRoomReservationMapper extends BaseMapper<ClientRoomReservation> {

}
