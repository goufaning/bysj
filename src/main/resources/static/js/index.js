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
$input.on('filebatchuploadsuccess', function(event, data, previewId, index) {
    $("#close").click();
    var filenames = data.filenames;
    for (var i = 0; i < filenames.length; i++) {
        $("#list").append('<li id="' + filenames[i] +'" href="#" class="list-group-item" onclick="ajax(this)">' + filenames[i]+ '</li>');
    }
});
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

$("#run").click(function() {
    $("#run").removeClass("btn-warning");
    $("#run").addClass("btn-success");
    $("#run_gly").removeClass("glyphicon-play");
    $("#run_gly").addClass("glyphicon-pause");
    $.ajax({
        type: "GET",
        url: "hdp",
        data: {"times" : $("#times").val()},
        dataType: "json",
        success: function(data){
            $("#run").removeClass("btn-success");
            $("#run").addClass("btn-warning");
            $("#run_gly").removeClass("glyphicon-pause");
            $("#run_gly").addClass("glyphicon-play");
            $('#perplexity').val(data.perplexity);   //清空
            $("#topics").empty();
            $.each(data.topics, function(i, item) {
                var html = "<tr><td>topic" + i + "</td><td>" + item.join(" ").toString() + "</td></tr>"
                $("#topics").append(html);
            });
        }
    });
});
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
            $('#fenci_result').append(data.content);
            var word = JSON.parse(data.words);
            $("#word_cloud").jQCloud(word, {shape: "elliptic",delayedMode:true});
        }
    })
};

function del(){
    $.ajax({
        type: "GET",
        url: "del",
        data: {"fileName" : $(this).parent('li').id},
        dataType: "json",
        success: function(data){
            $(this).parent('li').remove();
        }
    })
};

