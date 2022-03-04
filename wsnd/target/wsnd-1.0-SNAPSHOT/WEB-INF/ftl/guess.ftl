<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/layui/css/layui.css">
    <title>lpl竞猜</title>
    <style>
        body{
            background-color: #F2F2F2;
        }
        .oa-container{
            /*background-color: white;*/
            position:absolute;
            width: 400px;
            height: 350px;
            top: 80%;
            left: 50%;
            padding: 20px;
            margin-left: -200px;
            margin-top: -175px;
        }
        #money,#housemoney{
            text-align: center;
            font-size: 24px;
        }
        img{
            position: relative;
            left: 30%;
            top: 30px;
            margin: -70px 0 0 -70px;
        }
    </style>
</head>
<body>
<div >
        <a href="reference.ftl"><img src="photo/vs.jpg"></a>
</div>
<div class="oa-container">
    <form class="layui-form">
    <div class="layui-form-item">
        点击图片查看信息以及赔率
    </div>
    <div class="layui-form-item">
        <input type="text" id="housemoney" name="housemoney" placeholder="请输入押注主队金额" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-form-item">
        <input type="text" id="money" name="money" placeholder="请输入押注客队金额" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid layui-bg-red lay-submit lay-filter="guess">点击确认提交</button>
    </div>
    </form>
    <div id="allmoney" class="layui-form-item"></div>
    <script>
        var xmlhttp;
        if (window.XMLHttpRequest)
        {
            xmlhttp=new XMLHttpRequest();
        }
        else{
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.open("POST","Guess",true);
        xmlhttp.send();
        xmlhttp.onreadystatechange=function (){

                var responseText = xmlhttp.responseText;
                var json = JSON.parse(responseText);
                var html="";
                html=html+"你现有的余额是"+json.money+"  "+"你现有的积分是"+json.mark
                document.getElementById("allmoney").innerHTML=html;

        }
    </script>
</div>
<script src="/layui/layui.js"></script>
<script>
    layui.form.on("submit(guess)",function (formdata){
        console.log(formdata);
        layui.$.ajax({
            url:"Guess",
            Contenttype:"application/json; charset=UTF-8",
            data:formdata.field,
            type:"post",
            dataType:"json",
            success:function (json){
                console.log("success");
                var hm=parseInt(formdata.field.housemoney);
                var m=parseInt(formdata.field.money)
                console.log((hm+m));
                console.log(json.money);
                if((hm+m)>json.money)
                {
                    layui.layer.msg("<em style='color:red'>余额不足</em>");
                }
                else{
                    layui.layer.msg("<em style='color:green'>投注成功</em>");
                }

            }
        })
        return false;
    })
</script>



</body>
</html>