




// $("#import_file").fileinput({
//     uploadUrl: "/upload_file", //设置上传的地址
//     allowedFileExtensions: ['pdf','doc','docx','txt','jpg'], //设置允许上传的文件格式
//     language: 'zh', //设置语言
//     maxFileSize: 6000,
//     removeFromPreviewOnError:true,
//     maxFilesNum: 5, //允许上传的最大文件数
//     uploadAsync: true, //默认异步上传
//     browseOnZoneClick: true,
//     previewFileIconSettings: { // configure your icon file extensions
//         'doc': '<i class="fa fa-file-word-o text-primary"></i>',
//         'xls': '<i class="fa fa-file-excel-o text-success"></i>',
//         'ppt': '<i class="fa fa-file-powerpoint-o text-danger"></i>',
//         'pdf': '<i class="fa fa-file-pdf-o text-danger"></i>',
//         'zip': '<i class="fa fa-file-archive-o text-muted"></i>',
//         'htm': '<i class="fa fa-file-code-o text-info"></i>',
//         'txt': '<i class="fa fa-file-text-o text-info"></i>',
//         'mov': '<i class="fa fa-file-movie-o text-warning"></i>',
//         'mp3': '<i class="fa fa-file-audio-o text-warning"></i>',
//         // note for these file types below no extension determination logic
//         // has been configured (the keys itself will be used as extensions)
//         'jpg': '<i class="fa fa-file-photo-o text-danger"></i>',
//         'gif': '<i class="fa fa-file-photo-o text-warning"></i>',
//         'png': '<i class="fa fa-file-photo-o text-primary"></i>'
//     },
//     previewFileExtSettings: { // configure the logic for determining icon file extensions
//         'doc': function(ext) {
//             return ext.match(/(doc|docx)$/i);
//         },
//         'xls': function(ext) {
//             return ext.match(/(xls|xlsx)$/i);
//         },
//         'ppt': function(ext) {
//             return ext.match(/(ppt|pptx)$/i);
//         },
//         'zip': function(ext) {
//             return ext.match(/(zip|rar|tar|gzip|gz|7z)$/i);
//         },
//         'htm': function(ext) {
//             return ext.match(/(htm|html)$/i);
//         },
//         'txt': function(ext) {
//             return ext.match(/(txt|ini|csv|java|php|js|css)$/i);
//         },
//         'mov': function(ext) {
//             return ext.match(/(avi|mpg|mkv|mov|mp4|3gp|webm|wmv)$/i);
//         },
//         'mp3': function(ext) {
//             return ext.match(/(mp3|wav)$/i);
//         },
//     }
// });