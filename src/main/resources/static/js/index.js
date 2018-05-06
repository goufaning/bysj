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
});;
$input.on('filebatchuploadsuccess', function(event, data, previewId, index) {
    var filenames = data.filenames;
    $("#close").click();
});
