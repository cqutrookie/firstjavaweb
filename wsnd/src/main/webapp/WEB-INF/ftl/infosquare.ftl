<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>帖子中心</title>
    <style type="text/css">
        /*对网页进行第二次修饰*/
        body{font-size: 12px;}
        /*对整个标签,和表格 设置宽度为990像素*/
        #discuss,#discuss-datas{
            width: 990px;
        }
        #discuss div.mt{
            /*高度,边框,背景*/
            height: 30px;
            border: 1px solid #DDDDDD;
            border-top: 2px solid #999999;
            background: #f7f7f7;
        }
        #discuss-content{
            border-bottom: 1px solid #DDDDDD;
        }
        #discuss-datas tr.header td{
            /*加粗 上下内边距 下边框*/
            font-weight: bold;
            padding: 5px 0;
            border-bottom: 1px solid #DDDDDD;
            color: #666666;
        }
        #discuss-datas td{
            /*内容水平居中对齐*/
            text-align: center;
        }
        #discuss-datas td.col1{
            /*宽度,文本左对齐*/
            width: 620px;
            text-align: left;
        }
        #discuss-datas tbody td{
            /*文本颜色*/
            color: #9c9c9c;
        }
        #discuss a{
            /*改链接颜色 去掉下划线*/
            text-decoration: none;
            color: #005aa0;
        }
        #discuss a:hover{
            text-decoration: underline;
        }
        #discuss-datas tbody td{
            /*上下内边距 下边框*/
            padding: 5px 0px;
            border-bottom: 1px dotted #DDDDDD;
        }
        /*给论坛内容加标签 加图标*/
        #discuss i{
            /*左内边距 下内边距高度 背景图*/
            padding-left: 21px;
            padding-bottom: 5px;
            background-size: 100%;
        }
        #discuss div.mt a{
            float:left;
            width: 100px;
            height: 30px;
            text-align: center;
            line-height: 30px;
        }
        #discuss div.mt a:hover{
            text-decoration: none;
            color: #E4393C;
        }
        #discuss div.mt a.current{
            border: 1px solid #DDDDDD;
            border-top: 2px solid #E4393C;
            border-bottom: 0;
            background: #ffffff;
            margin-top: -6px;
            height: 35px;
            line-height: 35px;
            color: #E4393C;
        }
    </style>
</head>
<body>
<!--论坛div-->

    <div id="discuss">
        <!--页签菜单栏-->
        <!--讨论内容-->
        <div id="discuss-content">
            <!--表格内容-->
            <table id="discuss-datas">
                <!--标题栏-->
                <tr class="header">
                    <td class="col1">标题</td>
                    <td>是否允许评论</td>
                    <td>发布者</td>
                    <td>时间</td>
                </tr>
                <!--内容栏-->
                <tbody>
                <#list release_list as release>
                <tr>
                    <td class="col1">
                        <i class="sheng"></i>
                        <a href="/Post?post_id=${release.releaseid}">${release.title}</a>
                    </td>
                    <td>12/60</td>
                    <td><a href="/Homepage?userid=${release.userid}">${release.gameid}</a></td>
                    <td>${release.releasetime1}</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>

    </div>


</body>
</html>
