var baseURL = "http://localhost:8080/hotel"
var baseWebURL = "http://localhost:8080/hotel"
$('#clientRegister').click(function(){
    var logonInfo = {}
    logonInfo.clientName = $('#clientName').val()
    logonInfo.phone = $('#phone').val()
    logonInfo.email = $('#email').val()
    logonInfo.password = $('#password').val()
    console.log(logonInfo);
        $.ajax({
            sync:false,
            type:"post",
            url:baseURL + "/client/infor/clientRegister",
            dataType:'json',
            contentType:'application/json',
            data: JSON.stringify(logonInfo),
            success:function (obj) {
                if (obj.code==200){
                    alert('注册成功');
                    window.location.href=baseWebURL+"/modules/login/login.html#";
                }else{
                    alert("信息填写错误！");
                }

            },error: function(err){
                alert(err.status);
            }
        })

})