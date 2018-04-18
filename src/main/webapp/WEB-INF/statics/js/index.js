$("#file_upload").fileinput({
    uploadUrl: 'upload_file',
    uploadAsync: true,
    language: 'zh',
    browseOnZoneClick:true,
    allowedFileExtensions: ['pdf'],
    showClose: false,
});
