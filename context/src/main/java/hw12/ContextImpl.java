package hw12;

/**
 * Created by Yaroslav on 20.09.16.
 */
public class ContextImpl implements Context {
    private volatile int completedTask;
    private volatile int failedTask;
    private volatile int interruptedTask;
    private volatile boolean finished;

    public int getCompletedTaskCount() {
        return completedTask;
    }

    public int getFailedTaskCount() {
        return failedTask;
    }

    public int getInterruptedTaskCount() {
        return interruptedTask;
    }

    public void interrupt() {

    }

    public boolean isFinished() {
        return finished;
    }
}
