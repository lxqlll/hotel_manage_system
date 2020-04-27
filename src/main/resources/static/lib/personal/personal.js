var clientId1 = $.cookie('clientId');

$(function(){
    var phone1 = $.cookie('phone');
    var email1 = $.cookie('email');
    var clientName1 = $.cookie('userName');
    $('#nameOne').text(clientName1);
    $('#emailType1').val(email1);
    $('#phoneType').val(phone1);
})


function dmo() {
    $.ajax({
        sync: true,
        type: "post",
        url: baseURL + "/infor/queryInforPastOrder?inforId="+clientId1,
        dataType: 'json',
        contentType: 'application/json',
        success:function (obj) {
            if(obj.code== 200){
                let data = obj.data
                for (let i=0;i<data.length;i++){
                    $("#orderRow").append("<table class=\"previous-price\">\n" +
                        "                                        <tr>\n" +
                        "                                            <th>订单编号</th>\n" +
                        "                                            <th>入住日期</th>\n" +
                        "                                            <th>退房日期</th>\n" +
                        "                                            <th>住房名字</th>\n" +
                        "                                            <th>结算金额</th>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr>\n" +
                        "                                            <td>"+data[i].roomReservationId+"</td>\n" +
                        "                                            <td>"+data[i].targetDate+"</td>\n" +
                        "                                            <td>"+data[i].checkOutDate+"</td>\n" +
                        "                                            <td>"+data[i].roomNumber+"</td>\n" +
                        "                                            <td>"+data[i].roomPrice+"</td>\n" +
                        "                                        </tr>\n" +
                        "                                    </table>")
                }
                $("#orderRow").trigger("create");
            }else{
                alert("服务器错误");
            }
        }, error: function (err) {
            alert(err.status);
        }
    })
}

/*


$("#orderPast").click(function () {

})*/
