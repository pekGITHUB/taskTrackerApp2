<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
<link href="${contextPath}/resources/dist/css/bootstrap.css"
	rel="stylesheet">
<link href="${contextPath}/resources/dist/css/login.css"
	rel="stylesheet">
<title>Add Task Screen</title>
</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="main-login main-center">
				<!-- form is a spring tag for creating a  form in this example login form for user to submit form to corresponding spring MVC method  -->
				<!-- action is an attribute that maps the url to the corresponding spring mvc method  -->
				<!-- in this case by saying action="login" spring looks for a method whose @RequestMapping() is "/login" -->
				<!-- method is an attribute that specifies what kind of http request(get,post,put,delete, update) we are making -->
				<!-- in this case we are posting the form the a method by mapping it to a url that we specified in action attribute -->
				<!-- modelAttribute attribute specifies what model object we are dealing with -->

				<form:form action="addTask" class="form-horizontal" method="post"
					modelAttribute="task">
					
					<div class="form-group">
						<label for="literalAddTask" class="cols-sm-2 control-label">Add Task</label>
					</div>
	
					<div class="form-group">
						<label for="LiteralTaskID" class="cols-sm-2 control-label">Task ID</label>
						<div class="cols-sm-10">
							<div class="input-group">
					<!--	<span class="input-group-addon"><i class="fa fa-users fa"  -->
					<!-- 			aria-hidden="true"></i></span>                     -->
								<!-- mapping taskID entered by the user to the instance variable name in Task pojo(object) in model package by saying path="taskID"  -->
								<form:input path="taskID" placeholder="Task ID" type="number"
									class="form-control" />

							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label for="Literaldescription" class="cols-sm-2 control-label">Description</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-users fa"
									aria-hidden="true"></i></span>
								<!-- mapping description entered by the user to the instance variable name in Task pojo(object) in model package by saying path="description"  -->
								<form:input path="description" placeholder="description" type="text"
									class="form-control" />

							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="Literalassignee" class="cols-sm-2 control-label">Assignee</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
								<!-- mapping Assignee entered by the user to the instance variable assignedTo in Task pojo(object) in model package by saying path="assignedTo"  -->
								<form:input path="assignedTo" type="text" class="form-control"
									placeholder="assignedTo" />
							</div>
						</div>
					</div>
					<br />
					<br />

					<!-- Button -->

					<input type="submit" value="Add"
						class="btn btn-success btn-block">


				</form:form>
			</div>
		</div>

	</div>
</html>