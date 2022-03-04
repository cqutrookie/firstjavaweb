<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8">
        <title>Layui</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="./layui/css/layui.css"  media="all">
        <title>
            图片上传
        </title>
    </head>

    <body>
    <input type="hidden" name="images" class="image">
    <div class="layui-form-item">
        <label class="layui-form-label ">照片:</label>
        <div class="layui-upload">
            <button type="button" class="layui-btn" id="test1">上传图片</button>
            <div class="layui-upload-list">
                <img class="layui-upload-img" id="demo1">
                <p id="demoText"></p>
            </div>
        </div>
    </div>


    </body>
</html>