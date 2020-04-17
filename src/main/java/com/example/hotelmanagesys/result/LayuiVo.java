package com.example.hotelmanagesys.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class LayuiVo {
    private Integer code;
    private String  msg;        //解析提示文本
    private Integer count;      //"count": res.total, //解析数据长度
    private Object data;      //"data": res.data.item //解析数据列表
}
