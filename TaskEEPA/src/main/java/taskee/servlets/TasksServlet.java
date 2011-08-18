package taskee.servlets;

import taskee.entities.Task;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/tasks")
public class TasksServlet extends HttpServlet {

    @PersistenceContext(unitName = "tasks-pu")
    private EntityManager entityManager;

    @Resource
    private UserTransaction transaction;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Query query = entityManager.createQuery("select t from Task t");
        request.setAttribute("tasks", query.getResultList());
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if ("add".equals(action)) {
                try {
                    handleAddition(request);
                } catch (Throwable t) {
                    throw new RuntimeException(t);
                }
            } else if ("remove".equals(action)) {
                try {
                     handleRemoval(request);
                } catch (Throwable t) {
                    throw new RuntimeException(t);
                }
            }
        }
        response.sendRedirect("tasks");
    }

    private void handleAddition(HttpServletRequest request) throws SystemException, NotSupportedException, RollbackException, HeuristicRollbackException, HeuristicMixedException {
        String item = request.getParameter("item");
        if (item != null && !item.isEmpty()) {
            transaction.begin();
            entityManager.persist(new Task(item));
            transaction.commit();
        }
    }

    private void handleRemoval(HttpServletRequest request) throws IOException, SystemException, NotSupportedException, RollbackException, HeuristicRollbackException, HeuristicMixedException {
        Long item = Long.valueOf(request.getParameter("item"));
        if (item != null) {
            transaction.begin();
            Task task = entityManager.find(Task.class, item);
            if (task != null) {
                entityManager.remove(task);
                transaction.commit();
            }
        }
    }
}
