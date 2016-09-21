package hw12;

/**
 * Created by Yaroslav on 20.09.16.
 */
public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
