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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/minified/director.min.js"></script>
    <script type="text/javascript" src="<c:url value="/js/student/RequestHandler.js" />"></script>
    <title>Student page</title>
    <script type="text/javascript" id="router_config">
        // when #/list is clicked this function will invoke
        var getStudentList = function () {
            var studentHandler = new StudentHandler();
            studentHandler.listAllStudents()
        };
        var addStudent = function () {
            var studentHandler = new StudentHandler();
            studentHandler.loadRegistrationForm();
        };
        var getIdStudentList = function  () {
            var studentHandler = new StudentHandler();
            studentHandler.listIdStudent()
        };
        var deleteStudent = function() {
            var studentHandler = new StudentHandler();
            studentHandler.deleteStudent()
        }
        var usrRoute = {
            //this is will link the #/list to Js function
            '/list': getStudentList,
            '/add': addStudent,
            '/list_id': getIdStudentList,
            '/delete' : deleteStudent
        };
        var router = Router(usrRoute);
        router.init();
    </script>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<script type="text/x-jquery-tmpl" id="student_list">
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Age</th>
                <th>Course</th>
            </tr>
		</thead>
		<tbody>
		    {{each data}}
                <tr>
                    <td>\${id}</td>
                    <td>\${name}</td>
                    <td>\${age}</td>
                    <td>\${course}</td>
                </tr>
            {{/each}}
		</tbody>
	</table>
</script>
<script type="text/x-jquery-tmpl" id="student_add">
<form id="add_student">
    <label>Student Name:</label> <input type="text" name="name">
    <label>Student Age:</label> <input type="int" name="age">
    <label>Student Course:<label> <input type="text"name="course">
    <button type="submit">Submit</button>
</form>
</script>
<script type="text/x-jquery-tmpl" id="student_id_list_head">
<form id="student_id_list">
        Student id: <input type="number" id="student_id">
        <button class="submit_id">Submit</button>
</form>
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
		<tbody>
		  {{each data}}
		    <tr>
                <td>\${id}</td>
                <td>\${name}</td>
                <td>\${age}</td>
                <td>\${course}</td>
            </tr>
          {{/each}}
		</tbody>
	</table>
</script>
<script type="text/x-jquery-tmpl" id="student_delete">
<form id="delete_student">
      Student id: <input type="number" id="delete_id">
      <button class="submit_id" type="submit">Submit</button>
</form>
</script>

<div align=center>
    <H1>Welcome</H1>
    <!-- look for the router code inside head tag #/list is linked there !-->
    <a href="#/list">List All Student</a>

    <a href="#/add">Add Student</a>

    <a href="#/list_id">List Student By ID</a>

    <a href="#/delete">Delete Student</a>

    <div id="app"></div>
</div>
<script type="text/javascript" src="<c:url value="/js/student/handler.js" />"></script>

</body>
</compress:html>