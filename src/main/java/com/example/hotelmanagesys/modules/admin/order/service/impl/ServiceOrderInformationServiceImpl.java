package com.example.hotelmanagesys.modules.admin.order.service.impl;

import com.example.hotelmanagesys.modules.admin.order.entity.OrderInformationVo;
import com.example.hotelmanagesys.modules.admin.order.entity.ServiceOrderInformation;
import com.example.hotelmanagesys.modules.admin.order.mapper.ServiceOrderInformationMapper;
import com.example.hotelmanagesys.modules.admin.order.service.IServiceOrderInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单信息表 fk 预定客房编号 服务实现类
 * </p>
 *
 * @author lxq
 * @since 2020-04-19
 */
@Service
public class ServiceOrderInformationServiceImpl extends ServiceImpl<ServiceOrderInformationMapper, ServiceOrderInformation> implements IServiceOrderInformationService {

    @Autowired
    private ServiceOrderInformationMapper serviceOrderInformationMapper;

    @Override
    public List<OrderInformationVo> findOrderInformation(int page, int limit) {
        return serviceOrderInformationMapper.findOrderInformation(page, limit);
    }

    @Override
    public int findOrderInformationCount() {
        return serviceOrderInformationMapper.findOrderInformationCount();
    }
}
