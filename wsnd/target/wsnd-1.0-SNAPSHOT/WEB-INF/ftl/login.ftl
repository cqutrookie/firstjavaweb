<!DOCTYPE html>
<style>
    body {
        background:url("/photo/4.jpg")  no-repeat center center;   /*加载背景图*/   /* 背景图不平铺 */
        background-size:cover;  /* 让背景图基于容器大小伸缩 */
        background-attachment:fixed;        /* 当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */    //此条属性必须设置否则可能无效/
    background-color:#CCCCCC;   /* 设置背景颜色，背景图加载过程中会显示背景色 */
    }
</style>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
    <title>WSND后台系统</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <style>
        body{
            background-color: #F2F2F2;
        }
        .oa-container{
            /*background-color: white;*/
            position:absolute;
            width: 400px;
            height: 350px;
            top: 50%;
            left: 50%;
            padding: 20px;
            margin-left: -200px;
            margin-top: -175px;
        }
        #username,#password{
            text-align: center;
            font-size: 24px;
        }
    </style>
</head>
<body>
<div class="oa-container">
    <h1 style="text-align: center;margin-bottom: 20px;color: #F2F2F2" >W $ N D G R O U P
    <form class="layui-form">
        <div class="layui-form-item">
            <input type="text" id="username" lay-verify="required" name="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
        </div>

        <div class="layui-form-item">
            <input type="password" id="password" lay-verify="required" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>

        <div class="layui-form-item">
            <button class="layui-btn layui-btn-fluid layui-bg-gray" lay-submit lay-filter="login"><p style="color: #0C0C0C">点击登录</p></button>
        </div>
    </form>
    </h1>
</div>
<script src="/layui/layui.js"></script>
<script>
       layui.form.on("submit(login)",function (formdata){
          console.log(formdata);
          layui.$.ajax({
              url:"check_login",
              Contenttype:"application/json; charset=UTF-8",
              data:formdata.field,
              type:"post",
              dataType:"json",
              success:function (json){
                  console.log(json);
                  if(json.code=="0") {
                      window.location.href=json.redirect_url;
                      layui.layer.msg("<em style='color:green'>"+ "登陆成功"+ "</em>");
                  }
                  else
                      layui.layer.msg("<em style='color:red'>"+json.message+ "</em>");
              }
          })
          return false;
       })
</script>

</body>
</html>