<!DOCTYPE html>
<style>
    body {
        background:url("/photo/3.jpg")  no-repeat center center;   /*加载背景图*/   /* 背景图不平铺 */
        background-size:cover;  /* 让背景图基于容器大小伸缩 */
        background-attachment:fixed;        /* 当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */    //此条属性必须设置否则可能无效/
    background-color:#CCCCCC;   /* 设置背景颜色，背景图加载过程中会显示背景色 */
    }
</style>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>WSNDCREW</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">W$NDGROUP</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>

            <li class="layui-nav-item layui-hide-xs"><a href="message.ftl">信息段位查询</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="">通知公告</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="">一周记录</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">

                <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                    <a href="javascript:;">
                        <img src="${user.avatar}" class="layui-nav-img">
                            ${user.gameid}
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="personal.ftl">我的主页</a></dd>
                        <dd><a href="update.ftl">个人设置</a></dd>
                        <dd><a href="release.ftl">发布</a></dd>
                    </dl>
                </li>

            <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-more-vertical"></i>
                </a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">高光时刻</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">五杀截图</a></dd>
                        <dd><a href="javascript:;">操作集锦</a></dd>
                        <dd><a href="javascript:;">下饭时刻</a></dd>
                        <dd><a href="image.ftl">上传素材</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">信息广场</a>
                    <dl class="layui-nav-child">
                        <dd><a href="beforeinfo.ftl">信息中心</a></dd>
                        <dd><a href="javascript:;">我的发布</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="version.ftl">版本更新信息</a></li>
                <li class="layui-nav-item"><a href="guess.ftl">比赛竞猜</a></li>
            </ul>
        </div>
    </div>


    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 30px; color: red"> 暂无更新
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        @WSNDGROUP
    </div>
</div>
<script src="./layui/layui.js"></script>
<script>
    //JS
    layui.use(['element', 'layer', 'util'], function(){
        var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.$;

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function(othis){
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            ,menuRight: function(){
                layer.open({
                    type: 1
                    ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    ,area: ['260px', '100%']
                    ,offset: 'rt' //右上角
                    ,anim: 5
                    ,shadeClose: true
                });
            }
        });

    });
</script>
</body>
</html>
