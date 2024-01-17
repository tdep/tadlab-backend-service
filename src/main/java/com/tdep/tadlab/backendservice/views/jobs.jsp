<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TadLab Home</title>
    </head>
<body>
    <div align="center">
        <h1>Jobs List</h1>
        <h3><a href="/newJob">New Job</a></h3>
        <table border="1">
            <th>No.</th>
            <th>Name</th>
            <th>Start Date</th>
            <th>End Date</th>

            <c:forEach var="job" items="${jobList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${job.name}</td>
                    <td>${job.startDate}</td>
                    <td>${job.endDate}</td>
                    <td>
                        <a href="/editJob?id=${job.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/deleteJob?id=${job.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>