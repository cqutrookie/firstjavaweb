<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>发布帖子</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
</head>
<body>
<form class="layui-form" action="/Release" enctype="multipart/form-data" method="post" autocomplete="off"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
    <div class="layui-form-item">
        <label class="layui-form-label">标题</label>
        <div class="layui-input-block">
            <input type="text" name="title" id="title" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">内容</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" name="content" id="content" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">上传图片</label>
        <div class="layui-input-block">
            <input type="file" name="photo" id="photo">选择图片
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="*">立即提交</button>

        </div>
    </div>
</form>
</body>
</html>