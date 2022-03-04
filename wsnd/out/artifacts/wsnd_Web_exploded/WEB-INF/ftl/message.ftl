<!DOCTYPE html>
<style>
    body {
        background:url("/photo/5.jpg")  no-repeat center center;   /*加载背景图*/   /* 背景图不平铺 */
        background-size:cover;  /* 让背景图基于容器大小伸缩 */
        background-attachment:fixed;        /* 当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */    //此条属性必须设置否则可能无效/
    background-color:#CCCCCC;   /* 设置背景颜色，背景图加载过程中会显示背景色 */
    }
</style>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>段位信息</title>
</head>

<body>
<div id="divcontent"></div>
<script>
    var xmlhttp;
    if (window.XMLHttpRequest)
    {
        xmlhttp=new XMLHttpRequest();
    }
    else{
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","Message",true);
    xmlhttp.send();
    xmlhttp.onreadystatechange=function (){
        if(xmlhttp.readyState==4&&xmlhttp.status==200)
        {
            var responseText = xmlhttp.responseText;
            document.getElementById("divcontent").innerHTML=responseText;
        }
    }
</script>
</body>
</html>