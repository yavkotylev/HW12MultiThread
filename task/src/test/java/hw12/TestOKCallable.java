package hw12;

import java.util.concurrent.Callable;

/**
 * Created by Yaroslav on 20.09.16.
 */
class TestOKCallable implements Callable<String> {
    private final int WAIT_SECONDS;

    public TestOKCallable(int WAIT_SECONDS) {
        this.WAIT_SECONDS = WAIT_SECONDS;
    }

    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " wait " + WAIT_SECONDS / 1000 + " seconds");
        Thread.sleep(WAIT_SECONDS);
        System.out.println(Thread.currentThread().getName() + " calculate get()");
        return "OK";
    }
}
