package hw12;

import java.util.*;

/**
 * Created by Yaroslav on 21.09.16.
 */
public class ExecutionSet {
    private final List<Runnable> tasks;
    private final List<Runnable> performingTasks;
    private final Runnable callback;
    private volatile boolean tasksCompleted;

    public ExecutionSet(Runnable[] tasks, Runnable callback) {
        performingTasks = new ArrayList<Runnable>();
        this.tasks = new ArrayList<Runnable>();
        for (Runnable task : tasks) {
            this.tasks.add(task);
        }
        this.callback = callback;
        tasksCompleted = false;
    }

    public boolean isTasksCompleted() {
        synchronized (tasks) {
            synchronized (performingTasks) {
                return tasksCompleted;
            }
        }
    }

    public void performTask() {
        synchronized (tasks) {
            synchronized (performingTasks) {
                if (tasks.size() == 0 && performingTasks.size() == 0) {
                    callback.run();
                    tasksCompleted = true;
                    return;
                }
            }
        }

        Runnable task = null;
        synchronized (tasks) {
            if (tasks.size() != 0) {
                synchronized (performingTasks) {
                    task = tasks.remove(0);
                    performingTasks.add(task);
                }
            }
        }

        synchronized (task) {
            task.run();
            synchronized (performingTasks) {
                performingTasks.remove(task);
            }
        }
    }
}
