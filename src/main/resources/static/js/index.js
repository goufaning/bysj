$("#file_upload").fileinput({
    uploadUrl: 'upload_file',
    elErrorContainer: '#kartik-file-errors',
    uploadAsync: true,
    language: 'zh',
    browseOnZoneClick:true,
    allowedFileExtensions: ['txt'],
    showClose: false,
});
