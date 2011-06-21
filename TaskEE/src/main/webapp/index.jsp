<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
    <title>TaskEE</title>
</head>
<body>
<f:view>
    <h:form>
        <p>
            <h:outputText value="New task: "/>
            <h:inputText value="#{taskList.currentTask}"/>
            <h:commandButton value="add" action="#{taskList.add}"/>
        </p>

        <h:dataTable value="#{taskList.tasks}" var="task">
            <h:column>
                <h:outputText value="#{task}"/>
            </h:column>
            <h:column>
                <h:commandButton value="remove" action="#{taskList.remove}">
                    <f:setPropertyActionListener value="#{task}" target="#{taskList.currentTask}"/>
                </h:commandButton>
            </h:column>
        </h:dataTable>
    </h:form>
</f:view>
</body>
</html>