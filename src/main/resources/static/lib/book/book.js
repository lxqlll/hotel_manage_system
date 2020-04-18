var guestRoomName = $.cookie('guestRoomName');
var  num = guestRoomName.match(/\d/g).join("");
var guestRoomNames = guestRoomName.replace(num,"");

var now = new Date();

var year = now.getFullYear();       //年
var month = now.getMonth() + 1;     //月
var day = now.getDate();            //日

var hh = now.getHours();            //时
var mm = now.getMinutes();          //分
var ss = now.getSeconds();

var clock = year + "-";
if(month < 10)
    clock += "0";
clock += month + "-";
if(day < 10)
    clock += "0";
clock += day + " ";
if(hh < 10)
    clock += "0";
clock += hh + ":";
if (mm < 10) clock += '0';
clock += mm+ ":";
if (ss < 10) clock += '0';
clock += ss ;




$(function(){
    $.ajax({
            sync: false,
            type: "post",
            url: baseURL + "/guest/room/queryGuestRoomName/"+guestRoomNames,
            contentType: 'charset=UTF-8',
            success: function (obj) {
                if (obj.code==200) {
                    let data = obj.data;
                    if(data.length!=0&&data!=null) {
                        for (let i = 0; i < data.length; i++) {
                            $('#getRoom').append("" +
                                "<option value=" + data[i].guestRoomName + ">" + data[i].guestRoomName + "</option>" +
                                "");
                        }
                    }
                }else{
                    $('#getRoom').remove();
                    $('#noSelect').append("<input id='noRoom' class=\"form-control\" readonly=\"readonly\" id=\"checkOutDate\"  value='当前无房间' >");
                }
                /*   //获取cookie
                   var cookies_value = $.cookie("token");
                   alert(cookies_value);*/
            }, error: function (err) {
                alert(err.status);
            }
        })
})

$('#reserve').click(function () {
    if($('#noRoom').val()!='当前无房间'){
        var num = $('#getRoom').val()
        var  roomNumber = num.match(/\d/g).join("");
        let ClientRoomReservation = {}
        ClientRoomReservation.IDCard=$('#IDCard').val()
        ClientRoomReservation.reserveName=$('#reserveName').val()
        ClientRoomReservation.phone=$('#phone').val()
        ClientRoomReservation.targetDate=$('#targetDate').val()
        ClientRoomReservation.checkOutDate=$('#checkOutDate').val()
        ClientRoomReservation.guest=$('#guest').val()
        ClientRoomReservation.orderDate=clock
        ClientRoomReservation.roomNumber=roomNumber
        ClientRoomReservation.remark=$('#remark').val()
        ClientRoomReservation.mail=$('#mail').val()
        ClientRoomReservation.guestRoomName=$('#getRoom').val()
        if($('#getRoom').val()!=null && $('#IDCard').val()!=null &&
            $('#reserveName').val()){
            $.ajax({
                sync: false,
                type: "post",
                url: baseURL + "/room/addRoomReservation",
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(ClientRoomReservation),
                success: function (obj) {
                    if (obj.code==200) {
                        layer.alert('预定成功！');
                    }else{
                        layer.alert('预定失败！');
                    }
                }, error: function (err) {
                    alert('服务器错误');
                }
            })
        }
    }else {
        layer.alert('别点了，没房间了！');
    }
})



