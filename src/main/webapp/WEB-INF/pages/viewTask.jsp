<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<!--accepts an array of task from the controller and list on page -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${contextPath}/resources/dist/css/bootstrap.css"
	rel="stylesheet">

<title>Task Management Screen</title>
</head>
<body>
	<div class="container">
<!--This is button that goes to create task screen -->
		<div class="row col-lg-6 col-md-offset-2 custyle">
		<a href="${contextPath}/addTask"
						class="btn btn-primary btn-xs pull-right"><b>+</b> Add a new
						task</a>
					
			<table class="table table-striped custab">		
				<thead>
					<tr>
						<th>Task ID</th>
						<th>Task Description</th>
						<th>Status</th>
						<th>        </th>
						<th>Assigned To</th>
					</tr>
				</thead>
				<!-- This is where we are rendering from the array task and displaying on table with help of spring framework -->
				<c:forEach var="task" items="${taskList}">
				<tr>
				<td>${task.taskID}</td>
				
				<td>${task.description}</td>
				
				<td>${task.status}</td>
				
 <!--   		<td><a href="<c:url value='${contextPath}/workATask/${task.taskID}' />"  -->
                <td><a href="${contextPath}/workATask" 
    			    class="btn btn-success btn-xs btn-block">Work</a></td>	
				   	
				<td>${task.assignedTo}</td>
				
<!--     		<td><a href="<c:url value='${contextPath}/assignTask/${task.taskID}' />"  -->
				<td><a href="${contextPath}/assignTask" 
				    class="btn btn-success btn-xs btn-block">Assign</a></td>
				</tr>				
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>