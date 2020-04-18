
var guestRoomName = $.cookie('userName');
if (guestRoomName!=null){
    alert(1)
    $('#personalCenter').append("<li><a href=\"front/personal.html\" id='myCenter' class=\"active\">个人中心</a></li>")
    $('#personalCenter').append("<li><a id='outIn'  class=\"active\">退出登录</a></li>")
}else{
    alert(2)
    $('#personalCenter').append("<li><a href=\"login/login.html\" class=\"active\">登录</a></li>")
}

$('#outIn').click(function(){
    $.cookie("userName",null);
    //$.cookie(name, null, {path : "/",expires : -1});

   window.location.href=baseWebURL+"/modules/login/login.html";
})

$(function(){
    $.ajax({
        sync: false,
        type: "post",
        url: baseURL + "/guest/room/queryRoom",
        dataType: 'json',
        contentType: 'application/json',
        /*data: JSON.stringify(inforMation),*/
        success: function (obj) {
            if (obj.code==200) {
                let data = obj.data
                for (let i = 0; i < data.length; i++) {
                    $("#show").append("<div class=\"col-lg-4 price-mobamus\">\n" +
                        "\t\t\t\t\t<div class=\"price-top\">\n" +
                        "\t\t\t\t\t\t<a href=\"single.html\">\n" +
                        "\t\t\t\t\t\t\t<img src=\"../foregroundcss/images/price1.jpg\" alt=\"\" class=\"img-fluid\" />\n" +
                        "\t\t\t\t\t\t</a>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div class=\"price-w3ls-bottom p-4\">\n" +
                        "\t\t\t\t\t\t<h4 class=\"my-2\" ><a class='guestRoomName' >"+data[i].guestRoomName+"</a></h4>\n" +
                        "\t\t\t\t\t\t<div class=\"lm-item-price\">\n" +
                        "\t\t\t\t\t\t\t<h6>\n" +
                        "\t\t\t\t\t\t\t\t<span class=\"price-top-head\">￥</span>\n" +
                        "\t\t\t\t\t\t\t\t<span class=\"price-midd-head\">"+data[i].price+"</span>\n" +
                        "\t\t\t\t\t\t\t\t<span class=\"price-right-head\">/天</span>\n" +
                        "\t\t\t\t\t\t\t</h6>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t<ul class=\"style-lists\">\n" +
                        "\t\t\t\t\t\t\t<li>"+data[i].note+"</li>\n" +
                        "\t\t\t\t\t\t\t<li>"+data[i].noteTwo+"</li>\n" +
                        "\t\t\t\t\t\t\t<li>"+data[i].noteThree+"</li>\n" +
                        "\t\t\t\t\t\t</ul>\n" +
                        "\t\t\t\t\t\t<a   class=\"btn button-style-2 mt-sm-5 mt-4\"><p id='zhi' style='display: none'>"+data[i].guestRoomName+"</p><p class='bookNow'>现在预定</p></a>\n" +
                        "\t\t\t\t\t</div>");
                }
                $("#show").trigger("create");
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
    document.cookie = "guestRoomName=" + unescape(name) + ";expires=" + exp.toGMTString();
    window.location.href=baseWebURL+"/modules/front/book.html#";
})

$('#myCenter').click(function () {
    $.ajax({
        sync:false,
        type: 'post',
        url: baseURL + "/client/infor/clientLogin",
        dataType: 'json',
        contentType: 'application/json',
        success:function (obj) {
            if (obj.code==200){
                let data = obj.data;
                $("#fieldsetOne").append("<ul>\n" +
                    "                    <li><label class=\"fieldset-email\">邮箱*</label>\n" +
                    "                        <div class=\"box\"><input id=\"\" type=\"text\" value="+data[i].email+" name=\"\"></div>\n" +
                    "                        </li>\n" +
                    "                        <li><label class=\"fieldset-email2\">电话*</label>\n" +
                    "                        <div class=\"box2\"><input readonly=\"readonly\" class=\"fieldset-phone\" type=\"text\" value="+data[i].phone+" name=\"\" /></div>\n" +
                    "                        </li>\n" +
                    "                        <li><label class=\"fieldset-email3\">旧密码</label>\n" +
                    "                        <div class=\"box3\"><input id=\"password1\" type=\"text\" value=\"123\" name=\"\"></div>\n" +
                    "                        </li>\n" +
                    "                        <li><label class=\"fieldset-email4\">新密码</label>\n" +
                    "                        <div class=\"box4\"><input id=\"password2\" type=\"text\" value=\"123\" name=\"\"></div>\n" +
                    "                        </li>\n" +
                    "                        </ul>\n"+"<button type=\"button\" id=\"reserve\" style=\"background: #0C0C0C;color: white\" class=\"btn submit mt-3\">确认保存</button>")
            }
        }
    })
})





