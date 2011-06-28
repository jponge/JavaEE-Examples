package taskee.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Named
@SessionScoped
public class TaskList implements Serializable {

    private List<String> tasks = new ArrayList<String>() {
        {
            add("Wash the dishes");
            add("Make the next JVM language");
            add("Get a better salary");
        }
    };

    public List<String> getTasks() {
        return unmodifiableList(tasks);
    }

    public void add(String task) {
        tasks.add(task);
    }

    public void remove(String task) {
        tasks.remove(task);
    }
}
