package hw12;

import java.util.concurrent.Callable;

/**
 * Created by Yaroslav on 20.09.16.
 */
public class Task<T> {
    private final Callable<? extends T> task;
    private T resultTask;
    private RuntimeException exception;

    public Task(Callable<? extends T> callable) {
        task = callable;
        resultTask = null;
        exception = null;
    }

    public T get() {
        if (exception != null) throw exception;
        if (resultTask != null) return resultTask;
        synchronized (this) {
            if (exception != null) throw exception;
            if (resultTask == null) {
                try {
                    resultTask = task.call();
                } catch (Exception e) {
                    exception = new RuntimeException("Expected exception");
                    throw exception;
                }
            }
            return resultTask;
        }
    }
}