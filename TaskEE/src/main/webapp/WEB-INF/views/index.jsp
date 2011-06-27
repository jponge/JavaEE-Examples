<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>TaskEE</title>
</head>
<body>

<form method="POST" action="tasks">
    <p>
        <label for="item">New tasks:</label>
        <input id="item" type="text" name="item"/>
        <input type="hidden" name="action" value="add"/>
        <input type="submit" value="add"/>
    </p>
</form>

<table>
    <% for (String task : (List<String>) request.getAttribute("tasks")) { %>
    <tr>
        <form method="POST" action="tasks">
            <input type="hidden" name="action" value="remove"/>
            <input type="hidden" name="item" value="<%= task %>"/>
            <td><%= task %></td>
            <td><input type="submit" value="remove"/></td>
        </form>
    </tr>
    <% } %>
</table>

</body>
</html>