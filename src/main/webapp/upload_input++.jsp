<%--
  Created by IntelliJ IDEA.
  User: lv
  Date: 2016/4/14
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload file++</title>
    <script>
        window.onload = function () {
            document.getElementById("files").addEventListener('change', onFileSelect, false);
            document.getElementById("uploadButton").addEventListener('click', startUpload, false);
        };

        var totalFileLength, totalUploaded, fileCount, filesUploaded;

        function onFileSelect(e) {
            var files = e.target.files;
            var output = [];
            fileCount = files.length;
            totalFileLength = 0;
            for (var i = 0; i < fileCount; i++) {
                var file = files[i];
                output.push(file.name, "(", file.size + " bytes,", file.lastModifiedDate.toLocaleDateString() + " " + file.lastModifiedDate.toLocaleTimeString(), ")", "<br/>");
                debug("add " + file.size + " bytes");
                totalFileLength += file.size;
            }

            document.getElementById("selectedFiles").innerHTML = output.join(" ");
            debug("totalFileLength:" + totalFileLength + " bytes");
        }

        function debug(s) {
            var debug = document.getElementById("debug");
            if (debug) {
                debug.innerHTML = debug.innerHTML + "<br/>" + s;
            }
        }

        function startUpload(e) {
            totalUploaded = filesUploaded = 0;
            uploadNext();
        }

        function uploadNext() {
            var xhr = new XMLHttpRequest();
            var fd = new FormData();
            var file = document.getElementById("files").files[filesUploaded];
            fd.append("fileToUpload", file);
            xhr.upload.addEventListener("progress", onUploadProgress, false);
            xhr.addEventListener("load", onUploadComplete, false);
            xhr.addEventListener("error", onUploadFail, false);
            xhr.open("POST", "multipleUploads");
            debug("uploading " + file.name);
            xhr.send(fd);
        }

        function onUploadProgress(e) {
            if (e.lengthComputable) {
                var percentComplete = parseInt((e.loaded + totalUploaded) * 100 / totalFileLength);
                var bar = document.getElementById("bar");
                bar.style.width = percentComplete + "%";
                bar.innerHTML = percentComplete + " % complete";
            } else {
                debug("unable to compute")
            }
        }

        function onUploadComplete(e) {
            totalUploaded += document.getElementById("files").files[filesUploaded].size;
            filesUploaded++;
            debug("complete " + filesUploaded + " of " + fileCount);
            debug("totalUploaded" + totalUploaded);
            if (filesUploaded < fileCount) {
                uploadNext();
            } else {
                alert("Finished uploading file(s)")
            }
        }

        function onUploadFail(e) {
            alert("Error uploading file")
        }


    </script>
</head>
<body>
<h1>Multiple files upload with progress bar</h1>
<div id="progressBar" style="height: 20px;border: 2px solid green">
    <div id="bar" style="height: 100%; background: #33dd33;width: 0"></div>
</div>

<form id="form1" action="multipleUploads" enctype="multipart/form-data" method="post">
    <input type="file" id="files" multiple="multiple">
    <hr/>
    <output id="selectedFiles"></output>
    <input id="uploadButton" type="button" value="Upload">
</form>

<div id="debug" style="height: 100px;border: 2px solid green;overflow: auto"></div>
</body>
</html>
