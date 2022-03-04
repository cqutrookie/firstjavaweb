<!DOCTYPE html>
<style>
    body {
        background:url("/photo/6.jpg")  no-repeat center center;   /*加载背景图*/   /* 背景图不平铺 */
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
    </style>
</head>
<body>
<form class="layui-form" action="/infosquare" type="get">
    <div class="oa-container">
        <div class="layui-form-item">
            <button class="layui-btn layui-btn-fluid layui-bg-black" lay-submit lay-filter="come">点击进入社区</button>
        </div>
    </div>
</form>

</body>
</html>