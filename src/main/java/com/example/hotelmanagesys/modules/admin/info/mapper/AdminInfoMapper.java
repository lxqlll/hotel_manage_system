package com.example.hotelmanagesys.modules.admin.info.mapper;

import com.example.hotelmanagesys.modules.admin.info.entity.AdminInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxq
 * @since 2020-04-16
 */
@Mapper
@Repository
public interface AdminInfoMapper extends BaseMapper<AdminInfo> {

}
