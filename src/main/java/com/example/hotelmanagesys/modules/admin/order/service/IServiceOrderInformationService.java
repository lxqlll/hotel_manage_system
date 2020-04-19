package com.example.hotelmanagesys.modules.admin.order.service;

import com.example.hotelmanagesys.modules.admin.order.entity.ServiceOrderInformation;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单信息表 fk 预定客房编号 服务类
 * </p>
 *
 * @author lxq
 * @since 2020-04-19
 */
@Service
public interface IServiceOrderInformationService extends IService<ServiceOrderInformation> {

}
