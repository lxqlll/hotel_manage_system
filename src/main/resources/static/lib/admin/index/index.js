$(function(){
    $.ajax({
        sync: false,
        type: "post",
        url: baseURL + "admin/permission/adminPermission/liaocaizhi",
        /*dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(inforMation),*/
        success: function (obj) {
            if (obj.code==200) {
                let data = obj.data
                for (let i = 0; i < data.length; i++) {
                    $("#side-nav").append("");
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
    document.cookie = "guestRoomName=" + escape(name) + ";expires=" + exp.toGMTString();
    window.location.href=baseWebURL+"/modules/front/book.html#";
})





