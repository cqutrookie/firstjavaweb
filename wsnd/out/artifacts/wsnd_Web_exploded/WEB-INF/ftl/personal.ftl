<!DOCTYPE HTML>
<style>
    body {
        background:url("/photo/2.jpg")  no-repeat center center;   /*加载背景图*/   /* 背景图不平铺 */
        background-size:cover;  /* 让背景图基于容器大小伸缩 */
        background-attachment:fixed;        /* 当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */    //此条属性必须设置否则可能无效/
    background-color:#CCCCCC;   /* 设置背景颜色，背景图加载过程中会显示背景色 */
    }
</style>
<html>
<head>
    <style>
        .personal{
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
        <div class="personal">
            <h1 style="text-align: center;margin-bottom: 20px">个人主页
            <div class="left">
                <p id="photo"></p></div>
            <div class="right">
                <p id="person"></p>
            </div>
            <script>
                var xmlhttp;
                if (window.XMLHttpRequest)
                {
                    xmlhttp=new XMLHttpRequest();
                }
                else{
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.open("POST","Personal",true);
                xmlhttp.send();
                xmlhttp.onreadystatechange=function (){

                        var responseText = xmlhttp.responseText;
                        var json = JSON.parse(responseText);
                        document.getElementById("photo").innerHTML="<img src="+json.avatar+" "+"width=418px height=317px>"
                        document.getElementById("person").innerHTML="游戏名称:"+json.gameid+"<br>"+"段位:"+json.level+"<br>"+"剩余金额:"+json.money+"<br>"+"剩余积分:"+json.mark+"<br>"+"周均KDA:"+"暂未进行对局"+"<br>";

                }
            </script>
            </h1>
        </div>
</body>
</html>
