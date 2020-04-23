$(function(){
    var phone = $.cookie('phone');
    var email = $.cookie('email');
    $('#emailType').text(email);
    $('#phoneType').text(phone);
    alert(phone);
    alert(email);
})