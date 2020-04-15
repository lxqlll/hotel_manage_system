package com.example.hotelmanagesys.modules.client.room.service.impl;

import com.example.hotelmanagesys.modules.client.room.entity.ClientRoomReservation;
import com.example.hotelmanagesys.modules.client.room.mapper.ClientRoomReservationMapper;
import com.example.hotelmanagesys.modules.client.room.service.IClientRoomReservationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 预定客房表 fk 客房信息编号 客户个人信息编号 服务实现类
 * </p>
 *
 * @author lxq
 * @since 2020-04-15
 */
@Service
public class ClientRoomReservationServiceImpl extends ServiceImpl<ClientRoomReservationMapper, ClientRoomReservation> implements IClientRoomReservationService {

}
