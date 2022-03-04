<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
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
      #password,#uppassword,#repassword{
            text-align: center;
            font-size: 24px;
        }
    </style>
</head>
<body>
<div class="oa-container">
    <h1 style="text-align: center;margin-bottom: 20px">修改密码
        <form class="layui-form">
            <div class="layui-form-item">
                <input type="password" id="password" lay-verify="required" name="password" placeholder="请输入原先密码" autocomplete="off" class="layui-input">
            </div>

            <div class="layui-form-item">
                <input type="password" id="uppassword" lay-verify="required" name="uppassword" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>

            <div class="layui-form-item">
                <input type="password" id="repassword" lay-verify="required" name="repassword" placeholder="请再次输入密码" autocomplete="off" class="layui-input">
            </div>

            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="determine">点击确认</button>
            </div>
        </form>
    </h1>
</div>
<script src="/layui/layui.js"></script>
<script>
    layui.form.on("submit(determine)",function (formdata){
        console.log(formdata);
        layui.$.ajax({
            url:"Updatepassword",
            Contenttype:"application/json; charset=UTF-8",
            data:formdata.field,
            type:"post",
            dataType:"json",
            success:function (json){
                    console.log(json);
                layui.layer.msg("<em style='color:red'>"+json+"</em>");
                if (json="修改密码成功，请重新登录")
                {
                    window.setTimeout("window.location.href='login.ftl'",2000);
                }

            }
        })
        return false;
    })
</script>

</body>
</html>