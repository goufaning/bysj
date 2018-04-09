<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap 模板</title>
    <!-- 引入 Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="css/main.css">
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/fileinput.min.js"></script>
    <script type="text/javascript" src="js/locales/zh.js"></script>
    <%--<script type="text/javascript" src="js/main.js"></script>--%>

</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>文献主题抽取
            <small>基于分层Dirichlet过程</small>
        </h1>
    </div>
    <form enctype="multipart/form-data">
        <div class="file-loading">
            <input id="file" class="file" type="file" multiple data-min-file-count="3">
        </div>
    </form>
</div>
</body>
<script>
    $("#file").fileinput({
        uploadUrl: '#', // you must set a valid URL here else you will get an error
        language: 'zh',
        allowedFileExtensions: ['jpg', 'png', 'gif'],
        overwriteInitial: false,
        maxFileSize: 1000,
        maxFilesNum: 10,
        //allowedFileTypes: ['image', 'video', 'flash'],
        slugCallback: function (filename) {
            return filename.replace('(', '_').replace(']', '_');
        },
        elErrorContainer: "#errorBlock"
    });
</script>
</html>
