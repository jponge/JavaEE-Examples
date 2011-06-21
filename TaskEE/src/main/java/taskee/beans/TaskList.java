package taskee.beans;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Local
@Named
@Stateful
@SessionScoped
public class TaskList {

    private String currentTask;
    private final List<String> tasks = new ArrayList<String>();

    {
        tasks.add("Wash");
        tasks.add("It");
        tasks.add("Now");
    }

    public List<String> getTasks() {
        return unmodifiableList(tasks);
    }

    public String getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(String currentTask) {
        this.currentTask = currentTask;
    }

    public void add() {
        tasks.add(currentTask);
        currentTask = null;
    }

    public void remove() {
        tasks.remove(currentTask);
        currentTask = null;
    }
}
