<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><spring:eval expression="@environment.getProperty('cdn.url')" var="cdnUrl" /><%@ taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %><compress:html enabled="true" removeComments="true" compressJavaScript="true" compressCss="true" yuiJsDisableOptimizations="false"><!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Netweet - Marketing Management Platform">
    <meta name="author" content="Netweet">
    <meta name="google-signin-client_id" content="1051784865067-ghcnjtkb5svl2jjdaoh1u4nj3l39k7ej.apps.googleusercontent.com">
    <link href="https://dewey.tailorbrands.com/production/brand_version_mockup_image/466/2681317466_3ca9c937-bdba-4ee6-bf8a-f6822ba2b88c.png?cb=1582267132" rel="icon" type="image/x-icon" />

    <title>Student page</title>
    <script type="text/javascript">
        function validate() {
            if(document.getElementById("addStudent").checked) {
                window.alert("add")
            }
            else if(document.getElementById("retrieveAll").checked) {
                            window.alert("retrieveAll")
            }
        }
    </script>
</head>

<body>
<div align=center>
<H1>Welcome</H1>
<hr>
What do you want to do?<br>
<form method="get" action="process-input">
<input type="radio" value="addStudent" name="whatToDo">Add Student<br>
<input type="radio" value="retrieveAll" name="whatToDo">Retrieve All Students<br>
<input type="radio" value="retrieveOne" name="whatToDo">Retrieve one student<br>
<input type="radio" value="deleteStudent" name="whatToDo">Delete Student<br>
<input type="radio" value="exit" name="whatToDo">Exit<br>
<input type="submit">
</form>
</div>
</body>
</compress:html>