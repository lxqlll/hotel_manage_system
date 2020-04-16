$('#clientLogin').click(function () {
    var inforMation = {}
    inforMation.phone=$('#username').val()
    inforMation.password=$('#password').val()
    if($('#username').val().length!=0 && $('#password').val().length!=0){
        $.ajax({
            sync: true,
            type: "post",
            url: baseURL + "/client/infor/clientLogin",
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(inforMation),
            success: function (obj) {
                if (obj.code==200) {
                    //设置失效时间
                    var exp = new Date();
                    exp.setTime(exp.getTime() + 60 * 1000 * 15);
                    //添加cookie
                     document.cookie = "phone=" + unescape(obj.data.phone) + ";expires=" + exp.toGMTString();
                     document.cookie = "userName=" + unescape(obj.data.clientName) + ";expires=" + exp.toGMTString();
                    window.location.href=baseWebURL+"/modules/index.html";
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
    }else{
        alert('输入不能为空')
    }
});