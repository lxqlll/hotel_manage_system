package com.example.hotelmanagesys.modules.client.infor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hotelmanagesys.modules.client.infor.entity.InforPastOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface InforPastOrderMapper extends BaseMapper<InforPastOrder> {

}
