<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>Bootstrap 模板</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>文献主题抽取
            <small>基于分层Dirichlet过程</small>
        </h1>
    </div>
    <ul id="myTab" class="nav nav-tabs">
        <li class="active"><a href="#home" data-toggle="tab">
            文件上传</a>
        </li>
        <li><a href="#ios" data-toggle="tab">结果查询</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
        <div class="tab-pane fade in active" id="home" style="height:400px">
            <div class="file-loading">
                <input id="import_file" type="file" class="file" name="file" multiple data-overwrite-initial="false" data-min-file-count="1">
            </div>
        </div>
        <div class="tab-pane fade" id="ios">
            <a href="/"></a>
        </div>
    </div>

</div>
<script>
    $(function () {
        $('#myTab li:eq(1) a').tab('show');
    });
</script>

<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script type="text/javascript" src="js/fileinput.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/locales/zh.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>
