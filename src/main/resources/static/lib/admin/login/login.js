$('#login').click(function () {
    var adminInfo = {}
    adminInfo.name=$('#username').val()
    adminInfo.password=$('#password').val()
    if($('#username').val().length!=0 && $('#password').val().length!=0){
        $.ajax({
            sync: true,
            type: "post",
            url: baseURL + "/admin/info/adminLogin",
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(adminInfo),
            success: function (obj) {
                if (obj.code==200) {
                    //设置失效时间
                    var exp = new Date();
                    exp.setTime(exp.getTime() + 60 * 1000 * 15);
                    //添加cookie
                    // document.cookie = "phone=" + escape(obj.data.phone) + ";expires=" + exp.toGMTString();
                    // document.cookie = "userName=" + escape(obj.data.clientName) + ";expires=" + exp.toGMTString();
                    // window.location.href=baseWebURL+"/modules/front/index.html";
                    window.location.href=baseURL +"/order/information/queryMeanTwo";
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