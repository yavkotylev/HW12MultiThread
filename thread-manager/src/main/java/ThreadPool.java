import hw12.ExecutionSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 21.09.16.
 */
public class ThreadPool {
    private final List<ExecutionSet> sets;
    private final int numberThreads;
    private final List<Thread> threads;
    private final Object lock = new Object();

    public ThreadPool(int numberThreads) {
        this.numberThreads = numberThreads;
        sets = new ArrayList<ExecutionSet>();
        threads = new ArrayList<Thread>();
        start();
    }

    public ThreadPool() {
        numberThreads = 5;
        sets = new ArrayList<ExecutionSet>();
        threads = new ArrayList<Thread>();
        start();
    }

    private void start() {
        for (int i = 0; i < numberThreads; i++) {
            Thread thread = new Thread(new Worker());
            thread.start();
            threads.add(thread);
        }
    }

    private class Worker implements Runnable {
        public void run() {
            synchronized (lock){
                if (sets.size() == 0){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    sets.get(0).performTask();
                }
            }
        }
    }
}
