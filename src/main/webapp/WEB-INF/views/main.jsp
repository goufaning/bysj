<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试文件上传</title>
    <!-- 引入 Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
    <link href="css/index.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/fileinput.min.js"></script>
    <script type="text/javascript" src="js/locales/zh.js"></script>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container" style="margin-top: 80px;">
    <div class="file-loading">
        <input id="file_upload" class="file" name="file" type="file" multiple>
    </div>
</div>
</body>
<script type="text/javascript" src="js/index.js"></script>
</html>
