package com.example.hotelmanagesys.modules.admin.order.mapper;

import com.example.hotelmanagesys.modules.admin.order.entity.OrderInformationVo;
import com.example.hotelmanagesys.modules.admin.order.entity.ServiceOrderInformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 订单信息表 fk 预定客房编号 Mapper 接口
 * </p>
 *
 * @author lxq
 * @since 2020-04-19
 */
@Mapper
@Repository
public interface ServiceOrderInformationMapper extends BaseMapper<ServiceOrderInformation> {
    public List<OrderInformationVo> findOrderInformation(int page,int limit);
    public int findOrderInformationCount();
}
