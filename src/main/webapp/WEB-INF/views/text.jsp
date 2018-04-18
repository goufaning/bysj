<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>分词</title>
    <!-- 引入 Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/jqcloud.css">
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jqcloud-1.0.4.js"></script>
    <script type="text/javascript">
        var word_list = [
            {text: "Lorem", weight: 13},
            {text: "Ipsum", weight: 10.5},
            {text: "Dolor", weight: 9.4},
            {text: "Sit", weight: 8},
            {text: "Amet", weight: 6.2},
            {text: "Consectetur", weight: 5},
            {text: "Adipiscing", weight: 5},
            {text: "Elit", weight: 5},
            {text: "Nam et", weight: 5},
            {text: "Leo", weight: 4},
            {text: "Sapien", weight: 4},
            {text: "Pellentesque", weight: 3},
            {text: "habitant", weight: 3},
            {text: "morbi", weight: 3},
            {text: "tristisque", weight: 3},
            {text: "senectus", weight: 3},
            {text: "et netus", weight: 3},
            {text: "et malesuada", weight: 3},
            {text: "fames", weight: 2},
            {text: "ac turpis", weight: 2},
            {text: "egestas", weight: 2},
            {text: "Aenean", weight: 2},
            {text: "vestibulum", weight: 2},
            {text: "elit", weight: 2},
            {text: "sit amet", weight: 2},
            {text: "metus", weight: 2},
            {text: "adipiscing", weight: 2},
            {text: "ut ultrices", weight: 2},
            {text: "justo", weight: 1},
            {text: "dictum", weight: 1},
            {text: "Ut et leo", weight: 1},
            {text: "metus", weight: 1},
            {text: "at molestie", weight: 1},
            {text: "purus", weight: 1},
            {text: "Curabitur", weight: 1},
            {text: "diam", weight: 1},
            {text: "dui", weight: 1},
            {text: "ullamcorper", weight: 1},
            {text: "id vuluptate ut", weight: 1},
            {text: "mattis", weight: 1},
            {text: "et nulla", weight: 1},
            {text: "Sed", weight: 1}
        ];
        var jsonStr = '${json}';
        var word = JSON.parse(jsonStr);
        $(function() {
            $("#word_cloud").jQCloud(word, {shape: "elliptic",delayedMode:true});
        });
    </script>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container">
    <div id="word_cloud" style="width: 800px; height: 500px;margin: 100px auto"></div>
</div>
</body>
</html>