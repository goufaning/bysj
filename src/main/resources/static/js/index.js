// 文件上传
var $input = $("#file_upload");
$input.fileinput({
    uploadUrl: 'upload_file',
    language: 'zh',
    uploadAsync: false,//false 同步上传，后台用数组接收，true 异步上传，每次上传一个file,会调用多次接口
    allowedFileExtensions: ['txt'],
    showClose: false,
    showUpload: false, // 隐藏上传按钮
    showRemove: false, // 隐藏移除按钮
    showPreview: false
}).on("filebatchselected", function(event, files) {
    // 选择文件后立即触发上传方法
    $input.fileinput("upload");
});
// 文件列表
$input.on('filebatchuploadsuccess', function(event, data, previewId, index) {
    $("#close").click();
    var filenames = data.filenames;
    for (var i = 0; i < filenames.length; i++) {
        $("#list").append('<li id="' + filenames[i] +'" href="#" class="list-group-item" onclick="ajax(this)">' + filenames[i]+ '</li>');
    }
});
// 删除文件
$("#remove_all").click(function() {
    $.ajax({
        type: "GET",
        url: "delete_all",
        dataType: "json",
        success: function(data){
            $("#list").empty();
        }
    });
});
// 主题抽取
var $run = $("#run");
var $run_gly = $("#run_gly");
$run.click(function() {
    $run.removeClass("btn-warning");
    $run.addClass("btn-success");
    $run_gly.removeClass("glyphicon-play");
    $run_gly.addClass("glyphicon-pause");
    $.ajax({
        type: "GET",
        url: "hdp",
        data: {"times" : $("#times").val()},
        dataType: "json",
        success: function(data){
            $run.removeClass("btn-success");
            $run.addClass("btn-warning");
            $run_gly.removeClass("glyphicon-pause");
            $run_gly.addClass("glyphicon-play");
            $('#perplexity').val(data.perplexity);   //清空
            $("#topics").empty();
            $.each(data.topics, function(i, item) {
                var html = "<tr><td>topic" + i + "</td><td>" + item.join(" ").toString() + "</td></tr>";
                $("#topics").append(html);
            });
        }
    });
});
// 分词结果与词云
function ajax(btn){
    $("#list li").removeClass("active");
    $(btn).addClass("active");
    var  filename = btn.id;
    $.ajax({
        type: "GET",
        url: "file",
        data: {"fileName" : filename},
        dataType: "json",
        success: function(data){
            $('#fenci_result').empty();   //清空
            $('#word_cloud').empty();   //清空
            var array = data.content.split(" ");
            var html = '<span class="label label-warning pull-left">' + array.join('</span><span class="label label-warning pull-left">') + '</span>';
            $('#fenci_result').append(html);
            var word = JSON.parse(data.words);
            $("#word_cloud").jQCloud(word, {shape: "elliptic",delayedMode:true});
        }
    })
};

// 导出结果
$("#save_result").click(function () {
    var file_name = $("#file_name").val();
    var str = "";
    var trList = $("#topics").children("tr");
    for (var i = 0; i < trList.length; i++) {
        var tdArr = trList.eq(i).find("td");
        var topic = tdArr.eq(0).text();
        var words = tdArr.eq(1).text();
        str += topic + " " + words + "\r\n";
    }
    if (file_name == '' || file_name == undefined || file_name == null)
        file_name = "未命名";
    createAndDownloadFile(file_name + ".txt",str);
});

function createAndDownloadFile(fileName, content) {
    var aTag = document.createElement('a');
    var blob = new Blob([content]);
    aTag.download = fileName;
    aTag.href = URL.createObjectURL(blob);
    aTag.click();
    URL.revokeObjectURL(blob);
}

