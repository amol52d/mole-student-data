<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><spring:eval expression="@environment.getProperty('cdn.url')" var="cdnUrl" /><%@ taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %><compress:html enabled="true" removeComments="true" compressJavaScript="true" compressCss="true" yuiJsDisableOptimizations="false"><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Netweet - Marketing Management Platform">
    <meta name="author" content="Netweet">
    <meta name="_csrf" content="${_csrf.token}"/>
        <!-- default header name is X-CSRF-TOKEN -->
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta name="google-signin-client_id" content="1051784865067-ghcnjtkb5svl2jjdaoh1u4nj3l39k7ej.apps.googleusercontent.com">
    <link href="https://dewey.tailorbrands.com/production/brand_version_mockup_image/466/2681317466_3ca9c937-bdba-4ee6-bf8a-f6822ba2b88c.png?cb=1582267132" rel="icon" type="image/x-icon" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/minified/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/minified/jquery.tmpl.min.js"></script>
    <title>Student page</title>
</head>
<body>
<script type="text/x-jquery-tmpl" id="student_list_head">
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Age</th>
                <th>Course</th>
            </tr>
		</thead>
		<tbody id="table_data"></tbody>
	</table>
</script>
<script type="text/x-jquery-tmpl" id="student_list_data">
    <tr>
        <td>\${id}</td>
        <td>\${name}</td>
        <td>\${age}</td>
        <td>\${course}</td>
    </tr>
</script>
<script type="text/x-jquery-tmpl" id="student_add">
  <form id="addStudent">
    Student Name: <input type="text" name="name">
    Student Age: <input type="int" name="age">
    Student Course: <input type="text"name="course">
    <button onclick="formToJson()">Submit</button>
  </form>
</script>
<script type="text/x-jquery-tmpl" id="student_id_list_head">

        Student id: <input type="number" id="student_id">
        <button class="submit_id" onclick="retrieveId();">Submit</button>
</script>
<script type="text/x-jquery-tmpl" id="student_id_list_data">
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Age</th>
                <th>Course</th>
            </tr>
		</thead>
		<tbody id="table_id_data">
		    <tr>
                <td>\${id}</td>
                <td>\${name}</td>
                <td>\${age}</td>
                <td>\${course}</td>
            </tr>
		</tbody>
	</table>
</script>
<script type="text/x-jquery-tmpl" id="student_delete">
      Student id: <input type="number" id="delete_id">
      <button class="submit_id" onclick="deleteId();">Submit</button>
</script>

<div align=center>
<H1>Welcome</H1>
    <button onclick="new StudentHandler().init()">List All Student</button>
    <br><br>
    <div id="result"></div>

    <button onclick="new StudentAddHandler().init()">Add Student</button>
    <br><br>
    <div id="add"></div>

    <button onclick="new StudentIdHandler().init()">List Student</button>
    <br><br>
    <div id="id_result"></div>

    <button onclick="new StudentDeleteHandler().init()">Delete Student</button>
    <br><br>
    <div id="id_delete"></div>
</div>
<script type="text/javascript" src="<c:url value="/js/student/handler.js" />"></script>
</body>
</compress:html>