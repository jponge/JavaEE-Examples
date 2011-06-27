package taskee.servlets;

import taskee.beans.TaskList;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/tasks")
public class TasksServlet extends HttpServlet {

    @Inject
    TaskList taskList;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tasks", taskList.getTasks());
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if ("add".equals(action)) {
                handleAddition(request);
            } else if ("remove".equals(action)) {
                handleRemoval(request);
            }
        }
        response.sendRedirect("tasks");
    }

    private void handleAddition(HttpServletRequest request) throws IOException {
        String item = request.getParameter("item");
        if (item != null && !item.isEmpty()) {
            taskList.add(item);
        }
    }

    private void handleRemoval(HttpServletRequest request) throws IOException {
        String item = request.getParameter("item");
        if (item != null) {
            taskList.remove(item);
        }
    }
}
