$(function(){
    $.ajax({
        sync: false,
        type: "post",
        url: baseURL + "/admin/permission/adminPermission/liaocaizhi",
        /*dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(inforMation),*/
        success: function (obj) {
            if (obj.code==200) {


                console.log(show1);
                $('#nav').append(show);

    /*<ul id="nav">
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="会员管理">&#xe6b8;</i>
                            <cite>会员管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>

                            <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('统计页面','welcome1.html')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>统计页面</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('会员列表(静态表格)','member-list.html')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>会员列表(静态表格)</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('会员列表(动态表格)','member-list1.html',true)">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>会员列表(动态表格)</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('会员删除','member-del.html')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>会员删除</cite></a>
                            </li>
                            <li>
                                <a href="javascript:;">
                                    <i class="iconfont">&#xe70b;</i>
                                    <cite>会员管理</cite>
                                    <i class="iconfont nav_right">&#xe697;</i></a>
                            </li>
                        </ul>





                    </li>
                </ul>*/


            }else{
                alert("服务器错误");
            }
            /*   //获取cookie
               var cookies_value = $.cookie("token");
               alert(cookies_value);*/
        }, error: function (err) {
            alert(err.status);
        }
    })
})

$('#show').on('click','.bookNow',function(){
    var name = $(this).siblings('#zhi').text()
    //设置失效时间
    var exp = new Date();
    exp.setTime(exp.getTime() + 60 * 1000 * 15);
    document.cookie = "guestRoomName=" + escape(name) + ";expires=" + exp.toGMTString();
    window.location.href=baseWebURL+"/modules/front/book.html#";
})





