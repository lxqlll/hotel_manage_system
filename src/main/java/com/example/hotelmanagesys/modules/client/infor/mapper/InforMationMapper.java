package com.example.hotelmanagesys.modules.client.infor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hotelmanagesys.modules.client.infor.entity.InforMation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 客户个人信息表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-04-13
 */
@Mapper
@Repository
public interface InforMationMapper extends BaseMapper<InforMation> {
    public List<InforMation> selectUserNameRoom();
}
