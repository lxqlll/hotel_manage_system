var guestRoomName = $.cookie('guestRoomName');
var  num = guestRoomName.match(/\d/g).join("");
var guestRoomName2 = guestRoomName.replace(num,"");
alert(guestRoomName2)
$(function(){
    $.ajax({
            sync: false,
            type: "post",
            url: baseURL + "/room/queryRoomReservation/"+guestRoomName2,
            contentType: 'charset=UTF-8',
            success: function (obj) {
                alert(1);
                if (obj.code==200) {

                }else{
                    alert("账号或者密码,请重新登录!");
                }
                /*   //获取cookie
                   var cookies_value = $.cookie("token");
                   alert(cookies_value);*/
            }, error: function (err) {
                alert(err.status);
            }
        })

});

