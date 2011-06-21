<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World!</title>
</head>
<body>
<f:view>
<p>
    The current time is:
    <em>
        <h:outputText value="#{clock.now}"/>
    </em>
    <a href="index.jsp">(reload)</a>
</p>
</f:view>
</body>
</html>