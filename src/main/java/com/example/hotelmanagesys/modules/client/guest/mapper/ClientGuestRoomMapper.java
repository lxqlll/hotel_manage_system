package com.example.hotelmanagesys.modules.client.guest.mapper;

import com.example.hotelmanagesys.modules.client.guest.entity.ClientGuestRoom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 客房信息表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-04-14
 */
@Mapper
@Repository
public interface ClientGuestRoomMapper extends BaseMapper<ClientGuestRoom> {

}
