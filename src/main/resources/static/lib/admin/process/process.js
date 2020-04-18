layui.use('table', function(){
    var table = layui.table;
    //执行一个 table 实例
    table.render({
        elem: '#demo'
        ,height: 420
        ,url: baseURL+'/admin/order/processing' //数据接口
        ,title: '用户表'
        ,page: true //开启分页
        ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        ,totalRow: true //开启合计行
        ,height:500
        ,cols:  [[ //表头
            {type: 'checkbox', fixed: 'left'},
            {field: 'roomReservationId', title: '编号', width:120, sort: true, fixed: 'left'}
            ,{field: 'reserveName', title: '预定人', width:80}
            ,{field: 'idCard', title: '身份证', width:100}
            ,{field: 'phone', title: '电话', width:150}
            ,{field: 'targetDate', title: '入住日期', width: 100}
            ,{field: 'checkOutDate', title: '退房日期', width: 100}
            ,{field: 'guest', title: '客人人数', width: 120, sort: true}
            ,{field: 'orderDate', title: '订单生成日期', width: 157}
            ,{field: 'roomNumber', title: '预定房间号', width: 135, sort: true},
            ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
        ]]
    });

    //监听头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                layer.msg('添加');
                break;
            case 'update':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else if(data.length > 1){
                    layer.msg('只能同时编辑一个');
                } else {
                    layer.alert('编辑 [id]：'+ checkStatus.data[0].roomReservationId);
                }
                break;
            case 'delete':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    console.log(obj);
                    layer.msg('删除'+checkStatus.data[0].phone);
                }
                break;
        };
    });

    //监听行工具事件
    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'detail'){





        } else if(layEvent === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del(); //删除对应行（tr）的DOM结构
                layer.close(index);
                //向服务端发送删除指令
            });
        } else if(layEvent === 'edit'){
            layer.msg('编辑操作');
        }
    });

});
