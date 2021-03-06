package com.example.hotelmanagesys.modules.client.room.service;

import com.example.hotelmanagesys.modules.client.room.entity.ClientRoomReservation;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 预定客房表 fk 客房信息编号 客户个人信息编号 服务类
 * </p>
 *
 * @author lxq
 * @since 2020-04-15
 */
@Service
public interface IClientRoomReservationService extends IService<ClientRoomReservation> {

}
