package hw12;

/**
 * Created by Yaroslav on 20.09.16.
 */
public interface Context {
    int getCompletedTaskCount();

    int getFailedTaskCount();

    int getInterruptedTaskCount();

    void interrupt();

    boolean isFinished();
}
