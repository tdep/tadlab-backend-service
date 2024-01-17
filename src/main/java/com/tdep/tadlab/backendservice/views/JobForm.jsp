<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit Job</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Job</h1>
        <form:form action="saveJob" method="post" modelAttribute="job">
            <table>
                <form:hidden path="id"/>
                <tr>
                    <td>Name:</td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td>Start Date:</td>
                    <td><form:input path="startDate" /></td>
                </tr>
                <tr>
                    <td>End Date:</td>
                    <td><form:input path="endDate" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Save"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>