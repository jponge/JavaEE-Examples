<%@ page import="java.util.List" %>
<%@ page import="taskee.entities.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>TaskEE</title>
</head>
<body>

<form method="POST" action="tasks">
    <p>
        <label for="item">New task:</label>
        <input id="item" type="text" name="item"/>
        <input type="hidden" name="action" value="add"/>
        <input type="submit" value="add"/>
    </p>
</form>

<table>
    <% for (Task task : (List<Task>) request.getAttribute("tasks")) { %>
    <tr>
        <form method="POST" action="tasks">
            <input type="hidden" name="action" value="remove"/>
            <input type="hidden" name="item" value="<%= task.getDescription() %>"/>
            <td><%= task.getDescription() %></td>
            <td><input type="submit" value="remove"/></td>
        </form>
    </tr>
    <% } %>
</table>

</body>
</html>