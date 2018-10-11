<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8"></meta>
    <title>Insert title here</title>
    <style type="text/css">
        @charset "utf-8";
        body {
            font-family: SimSun;
        }
    </style>
</head>
<body>
<div id="all" style="font-size:15px;">
    <div style="margin:30px;margin-top:50px;">
        尊敬的用户
    </div>
    <div style="margin:30px;">
        您好,
    </div>
    <div style="margin:30px;">
        您的<font>Spring-boot freemarker</font>企业账号已开通
    </div>
    <div style="margin:30px;">
        已可登陆使用。
    </div>
    <div style="margin:30px;">
        用户名：${mail}
    </div>
    <div style="margin:30px;">
        初始密码：${password}
    </div>
    <div style="margin:30px;">
        感谢您
    </div>
    <div style="margin:30px;">
        <font>Corazono</font>
    </div>
    <div>
    ${createTime?string('yyyy-MM-dd')}
    </div>
</div>
</body>
</html>