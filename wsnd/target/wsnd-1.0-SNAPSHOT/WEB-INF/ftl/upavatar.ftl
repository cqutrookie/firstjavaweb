<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改头像</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <style>
        .container{
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
        #updateavatar{
            text-align: center;
            font-size: 24px;
        }
    </style>
</head>
<body>
    <div class="container">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
            <legend>修改头像</legend>
            <form action="/Updateavatar" enctype="multipart/form-data" method="post" autocomplete="off">
                <ul class="layui-form-item">
                    <li>
                        <span>选择图片</span>
                        <span id="change"></span>
                        <input name="updateavatar" id="updateavatar" type="file"
                        style="padding-left: 0px" accept="image/*">
                    </li>
                    <li>
                        <div class="layui-form-item">
                            <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="change">点击确定</button>
                        </div>
                    </li>
                </ul>
            </form>
        </fieldset>
    </div>
</body>
</html>