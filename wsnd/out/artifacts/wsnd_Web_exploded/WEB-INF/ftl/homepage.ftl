<!DOCTYPE HTML>
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
      <p id="photo"><img src=${user.avatar} height="200px" width="200px"></p></div>
    <div class="right">
      <p id="person">游戏id:${user.gameid}<br>段位:${user.level}<br>周均kda:***</p>
    </div>
  </h1>
</div>

</body>
</html>