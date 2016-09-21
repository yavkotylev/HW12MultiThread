package hw12;
import hw12.ThreadPool;

/**
 * Created by Yaroslav on 20.09.16.
 */
public class ExecutionManagerImpl implements ExecutionManager {
    private final
    public ExecutionManagerImpl() {
    }

    public Context execute(Runnable callback, Runnable... tasks) {
        ExecutionSet executionSet = new ExecutionSet(tasks, callback);

        return new ContextImpl();
    }
}
