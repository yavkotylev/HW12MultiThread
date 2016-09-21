package hw12;

import junit.framework.TestCase;

/**
 * Created by Yaroslav on 21.09.16.
 */
public class TestExecutionManager extends TestCase {
    public void test() throws InterruptedException {
        ExecutionManager executionManager = new ExecutionManagerImpl();
        Runnable callback = new SimpleTask(1, "CallBack test1");
        Runnable[] tasks = new Runnable[5];
        for (int i = 0; i < 5; i++){
            tasks[i] = new SimpleTask(i, "task test1 number = " + i);
        }
        executionManager.execute(callback, tasks);
    }
}
